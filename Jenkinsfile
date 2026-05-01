pipeline {
    agent any

    environment {
        IMAGE = "java-selenium-framework"
        JOB = "selenium-test-job"
    }

    stages {

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE% .'
            }
        }

        stage('Run Kubernetes Job') {
            steps {
                bat '''
                kubectl delete job %JOB% || echo not exist
                kubectl apply -f job.yaml
                '''
            }
        }

        stage('Wait & Get Logs') {
            steps {
                bat '''
                echo Waiting for pod to be ready...

                kubectl wait --for=condition=Ready pod -l job-name=selenium-test-job --timeout=120s

                kubectl get pods

                kubectl logs job/selenium-test-job
                '''
            }
        }

        }
    }
}