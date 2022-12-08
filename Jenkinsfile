pipeline {
    agent any
    stages {
        stage ('Execution') {
             steps {
                 script {
                    sh 'chmod +x gradlew'
                    sh 'chmod +x gradle'
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