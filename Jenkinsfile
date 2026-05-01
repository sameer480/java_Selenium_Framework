pipeline {
    agent any

    environment {
        IMAGE = "java-selenium-framework"
        JOB = "selenium-test-job"
    }

    stages {

        stage('Build Docker Image') {
            steps {
                bat "docker build -t %IMAGE% ."
            }
        }

        stage('Run Kubernetes Job') {
            steps {
                bat """
                kubectl delete job %JOB% --ignore-not-found=true
                kubectl apply -f job.yaml
                """
            }
        }

        stage('Wait for Pod') {
            steps {
                bat """
                echo Waiting for pod to be ready...

                kubectl wait --for=condition=Ready pod -l job-name=%JOB% --timeout=180s || echo Pod not ready

                echo Current Pods:
                kubectl get pods
                """
            }
        }

        stage('Fetch Logs') {
            steps {
                bat """
                echo Fetching logs...

                kubectl logs job/%JOB% || echo Logs not available
                """
            }
        }
    }

    post {
        always {
            bat """
            echo ================= DEBUG INFO =================
            kubectl get pods
            kubectl describe pods
            kubectl get events --sort-by=.metadata.creationTimestamp
            """
        }

        failure {
            echo "Build failed. Check logs above."
        }

        success {
            echo "Tests executed successfully!"
        }
    }
}