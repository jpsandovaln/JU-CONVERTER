pipeline {
    agent any
    stages {
        stage ('Execution') {
             steps {
                 dir('spring-boot-hello-world') {
                    sh 'chmod +x gradlew'
                    sh 'chmod +x gradle'
                 }
             }
        }
        stage('Assemble') {
            steps {
                script {
                    sh 'spring-boot-hello-world/./gradlew assemble'
                }
            }
        }
        stage('Test') {
             steps {
                 script {
                     sh 'spring-boot-hello-world/./gradlew test'
                  }
              }
         }
    }
}