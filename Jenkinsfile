pipeline {
    agent any
    stages {
        stage ('Execution') {
             steps {
                 script {
                    sh 'springboot-hello-world/chmod +x gradlew'
                    sh 'springboot-hello-world/chmod +x gradle'
                 }
             }
        }
        stage('Assemble') {
            steps {
                script {
                    sh 'springboot-hello-world/./gradlew assemble'
                }
            }
        }
        stage('Test') {
             steps {
                 script {
                     sh 'springboot-hello-world/./gradlew test'
                  }
              }
         }
    }
}