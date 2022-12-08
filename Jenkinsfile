pipeline {
    agent any
    stages {
        stage ('Execution') {
             steps {
                 dir("./spring-boot-hello-world") {
                    sh "chmod +x gradlew"
                    sh "chmod +x gradle"
                 }
             }
        }
        stage('Assemble') {
            steps {
                dir("./spring-boot-hello-world") {
                    sh "gradle assemble"
                }
            }
        }
        stage('Test') {
             steps {
                 dir("./spring-boot-hello-world") {
                     sh "gradle test"
                  }
              }
         }
    }
}