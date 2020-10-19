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
        stage ('docker build and push to ecr') {
            steps {
                sh 'echo pushing to dockerhub'
                script {
                    docker.withRegistry('404522240888.dkr.ecr.us-east-1.amazonaws.com/student-api-rest', 'ecr:us-east-1:aws_administrator') {
                        docker.build("student-api-rest", '.').push('latest')
                    }
                }
            }
        }
    }
}