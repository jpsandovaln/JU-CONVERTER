pipeline {
    agent any
    stages {
        stage ('Execution') {
             steps {
                 script {
                    sh 'spring-gboot-hello-world/chmod +x gradlew'
                    sh 'spring-boot-hello-world/chmod +x gradle'
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