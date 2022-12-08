pipeline {
    agent any
    stages {
        stage ('Execution') {
             steps {
                 script{
                    sh "chmod +x spring-boot-hello-world/gradlew"
                  }
             }
        }
        stage('Assemble') {
            steps {
                script{
                    sh "spring-boot-hello-world/gradlew assemble"
                }
            }
        }
        stage('Test') {
             steps {
                 script{
                     sh "spring-boot-hello-world/gradlew test"
                  }
              }
         }
    }
}