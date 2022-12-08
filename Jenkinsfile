pipeline {
    agent any
    stages {
       stage ('Change Directory') {
            steps {
                script{
                       sh "cd spring-boot-hello-world"
                      }
                 }
            }
        stage ('Execution') {
             steps {
                 script{
                    sh "chmod +x gradlew"
                    sh "chmod +x gradle"
                  }
             }
        }
        stage('Assemble') {
            steps {
                script{
                    sh "gradle assemble"
                }
            }
        }
        stage('Test') {
             steps {
                 script{
                     sh "gradle test"
                  }
              }
         }
    }
}