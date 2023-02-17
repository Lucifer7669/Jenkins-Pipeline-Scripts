pipeline{
    agent {
        label {
            label "built-in" 
            customWorkspace "/srv/pipeline-jobs/" 
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
                     sh "cd game-of-life && mvn clean install" 
                }
            }
            stage ('deploy-war'){
                steps{
                    sh "cp -r game-of-life/gameoflife-web/target/gameoflife.war /mnt/server/apache-tomcat-9.0.71/webapps"
                }
            }
           
        }

    
}