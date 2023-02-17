pipeline{
    agent {
        node {
            label "built-in"
            customWorkspace "/mnt/key-pair"
        }
    }

    stages{
        stage ('clone-key-pair'){
            steps {
                sh "git clone https://github.com/Lucifer7669/Jenkins-Installation-script.git"
                sh "chmod 777 Jenkins-Installation-script/my-linux.pem"
            }
        }
    }
}