pipeline{
    agent {
        label "host-1"
        customWorkspace "/mnt/pipeline-jobs"
    }

    stages{
        stage ('mkdir'){
            steps {
                sh "mkdir jenkins-jobs"
            }
        }
    }
}