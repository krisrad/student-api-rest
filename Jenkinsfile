pipeline {
    agent any
    tools {
        maven "jenkins-maven"
    }
    stages {
        stage ('Compile java project') {
            steps {
                bat "mvn compile"
            }
        }
        stage ('Package jar file') {
            steps {
                bat "mvn -DskipTests clean package"
            }
        }
        stage ('docker build and push to dockerhub') {
            steps {
                sh 'echo pushing to dockerhub'
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
                        docker.build("rmeiappan/student-api-rest", '.').push()
                    }
                }

            }
        }
    }
}