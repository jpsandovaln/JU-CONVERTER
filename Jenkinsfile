pipeline {
    agent any
    stages {
        stage('Assemble') {
            steps {
                script{
                    sh "./gradlew assemble"
                }
            }
        }
        stage('Test') {
             steps {
                 script{
                      sh "./gradlew test"
                  }
              }
          }
    }
}