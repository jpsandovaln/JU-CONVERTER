pipeline {
    agent any

    stages {
        stage('Permisitions') {
	    steps {
                sh 'chmod +x spring-boot-hello-word/gradlew'
	    }
	}

	stage('Build') {
            steps {
                sh 'spring-boot-hello-word/./gradlew assemble'
	    }
	}
    }
}
