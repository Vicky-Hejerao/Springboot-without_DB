pipeline {
    agent any

    tools {
        // Use the defined Maven tool installation
        maven 'MAVAN_HOME'
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/Vicky-Hejerao/Springboot-without_DB'

                // Run Maven on a Windows agent
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
    }

    post {
        always {
            emailext body: 'A Test EMail', to: 'hejerao.vicky@gmail.com', subject: 'Test'
        }
    }
}
