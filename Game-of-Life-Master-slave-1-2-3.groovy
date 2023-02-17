pipeline{
    agent {
        label {
            label "built-in" 
            customWorkspace "/mnt/pipeline-jobs/" 
        }
    }
        stages {
            stage ('clone-project'){
                steps{
                   sh "rm -rf *"
                    sh "git clone https://github.com/Lucifer7669/game-of-life.git" 
                }

            }
            stage ('builing-phase'){
                steps {
                     sh "cd game-of-life && mvn install" 
                }
            }
            stage ('deploy-war'){
                steps{
                    sh "chmod 400 Jenkins-Installation-script/my-linux.pem"
                    sh "scp -i Jenkins-Installation-script/my-linux.pem game-of-life/gameoflife-web/target/gameoflife.war ec2-user@172.31.6.96:/mnt/tomcat-server/apache-tomcat-9.0.71/webapps"
                }
            }
           
        }

    
}