pipeline {
    agent {
        label {
            label "slave-1"
            customWorkspace "/mnt/tools"
        }
    }

    stages{
        stage ('create-maven-directory'){
            steps {
                sh "sudo wget https://dlcdn.apache.org/maven/maven-3/3.9.0/binaries/apache-maven-3.9.0-bin.zip"
                sh "sudo unzip apache-maven-3.9.0-bin.zip"
            }
        }
    }
}