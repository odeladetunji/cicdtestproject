 pipeline {
     agent any

     stages {
         stage('Build And Deploy') {
             steps {
                 //ssh into the remote machine.
//                  sh "sudo ssh -i ~/.ssh/dev_appserver.pem ec2-user@172.30.1.180"

                 //Create a new Directory
//                  sh "sudo mkdir cicdprojecttest"

                 node {
                       withCredentials([sshUserPrivateKey(credentialsId: 'app_server_dev', keyFileVariable: 'identity', passphraseVariable: '', usernameVariable: 'ec2-user')]) {
                         def remote = [:]
                           remote.name = ''
                           remote.host = '172.30.1.180'
                           remote.user = 'ec2-user'
                           remote.password = ''
                           remote.allowAnyHosts = true
                           stage('Remote SSH') {
                             sshCommand remote: remote, command: "sudo mkdir cicdprojecttest"
                             sshCommand remote: remote, command: "cd cicdprojecttest"
                             sshCommand remote: remote, command: "sudo git clone http://github.com/odeladetunji/cicdtestproject.git"
                             sshCommand remote: remote, command: "cd cicdtestprojectdev"
                             sshCommand remote: remote, command: "mvn clean install"
                             sshCommand remote: remote, command: "sudo chmod -R 777 target"
                             sshCommand remote: remote, command: "cd target"
                             sshCommand remote: remote, command: "sudo rm nohup.out"
                             sshCommand remote: remote, command: "sudo fuser -k 8086/tcp"
                             sshCommand remote: remote, command: "sudo nohup java -jar cicdtestprojectdev-0.0.1-SNAPSHOT.jar &"
                             sshCommand remote: remote, command: "echo successfully deployed"
                           }
                       }
                 }

             }
         }
     }
 }
