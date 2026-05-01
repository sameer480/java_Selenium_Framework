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
                timeout /t 15
                kubectl get pods
                kubectl logs job/%JOB%
                '''
            }
        }
    }
}