pipeline {
    agent any
    tools {
        gradle 'gradle'
    }
    stages{
        stage('Build JAR File'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MatiasColil/Lab1-Tingeso-2-2022/tree/main/LAB1']]])
                sh './gradlew clean'
                sh './gradlew assemble'
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
                sh 'docker build -t matiadres/applab .'
            }
        }
    }
}