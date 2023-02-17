// This is basic packages installation pipeline on multiple node eg. master,slave at a time
pipeline{
    agent {
        node {
            label "built-in"
        }

    }

    stages {
        stage ('installation-packages-master'){ //here installating pakages on master
      steps {
           sh "yum install tree -y"
           sh "yum update git -y"
      }
        }

        stage ('installation-packages-slaves'){
            agent {
                node {
                    label "slave-1"      //here i have mentioned slave name
                }
            }
            steps {
                sh "sudo yum install tree -y"
                sh "sudo yum update git -y"
            }
        } //here installation packages on slaves
    }
}