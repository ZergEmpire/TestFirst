pipeline {
    agent any
    tools
            {
                maven 'maven'
            }
    stages {
        stage("Git Checkout")
                {
                    steps{
                        git branch: 'master',
                                url: 'https://github.com/MessirVoland/TestFirst'
                    }

                }

        stage('Build')
                {
                    steps {
                        sh 'mvn compile'
                    }
                }

        stage('run tests') {
            steps {
                sh "mvn -Dtest=First test"
            }
        }

        stage('generate allure report') {
            steps {
                script {
                    allure([
                            includeProperties: false, jdk: '', results: [[path: 'target/target/allure-results/']],
                    ])
                }
            }
        }
    }
}