pipeline {
    agent any
    stages {
        stage('docker compose') {
            steps {
                script{
                    sh "docker-compose up"
                }
            }
        }
    }
}