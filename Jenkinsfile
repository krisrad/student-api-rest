pipeline {
    agent any
    scm checkout
    tools {
        maven "M3"
    }
    stages {
        stage ('Compile java project') {
            steps {
                mvn compile
            }
        }
        stage ('Package jar file') {
            steps {
                mvn -DskipTests clean package
            }
        }
        stage ('docker build and push to dockerhub') {
            steps {
                sh 'echo pushing to dockerhub'
            }
        }
    }
}