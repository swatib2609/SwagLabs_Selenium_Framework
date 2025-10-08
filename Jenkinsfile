pipeline {
    agent any

    environment {
        REPORT_DIR = "reports"
        SCREENSHOT_DIR = "screenshots"
        LOG_DIR = "logs"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/swatib2609/SwagLabs_Selenium_Framework.git'
            }
        }

        stage('Build & Test') {
            steps {
                echo "Running Selenium + TestNG Tests..."
                sh 'mvn clean test'
            }
        }

        stage('Archive Results') {
            steps {
                archiveArtifacts artifacts: "${REPORT_DIR}/ExtentReport.html, ${SCREENSHOT_DIR}/*.png, ${LOG_DIR}/*.log", allowEmptyArchive: true
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: "${REPORT_DIR}",
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent HTML Report'
                ])
            }
        }
    }

    post {
        always {
            echo "Cleaning up workspace..."
            cleanWs()
        }
    }
}
