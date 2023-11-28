pipeline {
  agent any
  stages {
    stage('mvn version') {
      parallel {
        stage('mvn version') {
          steps {
            sh '''mvn --version
'''
          }
        }

        stage('run the test') {
          steps {
            sh 'mvn clean test'
          }
        }

      }
    }

    stage('build') {
      steps {
        sh '''mvn compile test package
'''
      }
    }

  }
}