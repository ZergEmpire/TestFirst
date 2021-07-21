pipeline {
    agent any
    tools {
        maven 'maven'
        allure 'allure'
    }
    stages {
        stage('clone repository') {
            steps {
                deleteDir()
                git branch: 'master', credentialsId: 'gitlab_new', url: 'https://github.com/ZergEmpire/TestFirst.git'
            }
        }
        stage('run tests') {
            steps {
                sh "mvn test -Dselenide.browser=chrome -Dselenide.remote=http://192.168.1.17:8080/wd/hub"
            }
        }
        stage('generate allure report') {
            steps {


                script {
                    $path = '/allure-report'
                    dir ($path){
                        sh "ls"
                    }
                    echo $path
                    allure([
                            includeProperties: false,
                            jdk: '',
                            properties: [],
                            reportBuildPolicy: 'ALWAYS',
                            results: [[path: $path]],
                    ])
                }

               // allure includeProperties: false, jdk: '', results: [[path: 'allure-results']]
            }
        }
    }
}