pipeline{
    agent {
        label {
            label "host-1"
            customWorkspace "/mnt/tomcat-server"
        }
    }
        stages {
            stage ('install-tomcat'){
                steps{
                    sh "sudo rm -rf *"
                    sh "sudo wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.71/bin/apache-tomcat-9.0.71.zip"
                    sh "sudo unzip apache-tomcat-9.0.71.zip"
                    sh "sudo chmod 777 apache-tomcat-9.0.71/bin/*"
                }
            }
            stage ('start-tomcat-server'){
                steps{
                    sh "sudo bash apache-tomcat-9.0.71/bin/startup.sh"
                }
            }
        }
    
}