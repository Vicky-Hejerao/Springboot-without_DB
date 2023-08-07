pipeline {
    agent any

   /* tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_HOME"
    }*/
    tools {
    // Install the Maven version configured as "M3" and add it to the path.
    maven name: 'MAVEN_HOME'
}


    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/Vicky-Hejerao/Springboot-without_DB.git'
                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                 bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                always {
            emailext body: 'A Test EMail',to:'hejerao.vicky@gmail.com', subject: 'Test'
        }
            }
        }
    }
}
