pipeline {
    agent {
        label {
            label "host-1"   //this is the slave which is connected to master and "host-1" is slave-name(label)
            customWorkspace "/mnt/pipeline-jobs" //this is custome WS creted in host-1 
        }
    }

        stages{
            stage ('clone-repository'){   // step-1: clone your project into your CW
                steps{
                    sh "sudo rm -rf *" //clean your WS
                    sh "sudo yum install git -y" //install git first
                    sh "sudo git clone https://github.com/Lucifer7669/Folio.git" // ihave cloned project into my CW
                }
            }

            stage ('copy-build-files'){  //step-2: copy build files into httpd server
                steps{
                    sh "sudo cp -r Folio/dist/Folio/* /var/www/html/"
                    sh "sudo rm -rf /var/www/html/3rdpartylicenses.txt"
                }
            }
            stage ('start-httpd-server'){ //step-3: start httpd server
                steps{
                    sh "sudo service httpd start" //started httpd server
                }
            }

        }
    
}