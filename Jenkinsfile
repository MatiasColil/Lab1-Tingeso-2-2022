pipeline {
    agent any
    tools {
        gradle 'gradle'
    }
    stages{
        stage('Build JAR File'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MatiasColil/Lab1-Tingeso-2-2022/']]])
                sh './gradlew clean'
                sh './gradlew build'
            }
        }
        stage('Test'){
            steps{
                sh './gradlew test'
                sh './gradlew sonarqube'
            }
        }
        stage('Build Docker Image'){
            steps{
                sh 'docker build -t matiadres/applaboraotrio:latest .'
            }
        }

        stage('Push Docker Image'){
            steps{
                withCredentials([string(credentialsId: 'docker-pass', variable: 'dckpass')]) {
                    sh 'docker login -u matiadres -p ${dckpass}'
                }
                sh 'docker push matiadres/applab'
            }
        }
    }
    post {
        always{
            sh 'docker logout'
        }
    }
}