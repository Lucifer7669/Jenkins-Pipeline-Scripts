//This is http deployment on multi node pipeline
pipeline{
    agent {
        node {
            label "built-in"
            customWorkspace "/mnt/http-deployment"
        }
    }

    stages {
        // Master-Phase-starts
        stage ('cloneing-phase-1-master') {
            steps {
                sh "rm -rf *"
                sh "git clone https://github.com/Lucifer7669/Folio.git"
            }
        }
        stage ('installation-httpd-server-phase-2-master'){
            steps {
                sh "yum install httpd -y"
            }
        }
        stage ('deployment-phase-3-master'){
            steps {
                sh "rm -rf /var/www/html/*"
                sh "rm -rf Folio/dist/Folio/3rdpartylicenses.txt"
                sh "cp -r Folio/dist/Folio/* /var/www/html/"
                sh "chmod -R 777 /var/www/html/*"
                sh "service httpd start"
            }
        }
         // Master-Phase-Ends

         // slave-1-Phase-starts
         stage ('cloning-phase-1-slave-1'){  // This is phase-1-slave-1 Cloning git project
            agent {
                node {
                    label "slave-1"
                    customWorkspace "/mnt/slave-1-httpd-deployment"
                }
            }

            steps {
                sh "sudo rm -rf *"
                sh "sudo git clone https://github.com/Lucifer7669/Folio.git"

            }
         }
         stage ('installation-httpd-server-phase-2-slave-1'){ // This is phase-2-slave-1 install httpd server
             agent {
                node {
                    label "slave-1"
                    customWorkspace "/mnt/slave-1-httpd-deployment"
                }
            }
            steps {
                sh "sudo yum install httpd -y"
            }
         }
         stage ('deployment-pahse-3-slave-1'){   // This is phase-3-slave-1 deployment
            agent {
                node {
                    label "slave-1"
                    customWorkspace "/mnt/slave-1-httpd-deployment"
                }
            }
            steps {
                sh "sudo rm -rf /var/www/html/*"
                sh "sudo rm -rf Folio/dist/Folio/3rdpartylicenses.txt"
                sh "sudo cp -r Folio/dist/Folio/* /var/www/html/"
                sh "sudo chmod -R 777 /var/www/html/*"
                sh "sudo service httpd start"
            }
         }
    }
}