pipeline {
    agent {
        label "Slave"
    }
    stages {
        stage ('oner'){
            steps {
                echo "new"
            }
        }
        stage ('two'){
            steps {
                echo "two"
            }
        }
        stage ('three'){
            steps {
                echo "vnvjf"
            }
        }
        stage ('four'){
            steps {
                echo "defsufbd"
            }
        }
        stage ('five'){
            steps {
                echo "nsdfds"
            }
        }
        stage ('six'){
            steps {
                echo "asfkmsdf"
            }
        }
    }
}