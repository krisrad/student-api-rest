pipeline {
    agent any
    scm checkout
    tools {
        maven "M3"
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
            }
        }
    }
}