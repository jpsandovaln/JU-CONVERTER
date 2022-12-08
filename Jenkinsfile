pipeline {
    agent any
    stages {
       stage ('Change Directory') {
            steps {
                script{
                      sh "pwd"
                      dir('spring-boot-hello-world') {
                         sh "pwd"
                        }
                      sh "pwd"
                      }
                 }
            }
        stage ('Execution') {
             steps {
                 script{
                    sh "ls -l"
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