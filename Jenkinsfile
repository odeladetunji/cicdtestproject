
     def remote = [:]
     remote.name = 'test'
     remote.host = '172.30.1.180'
     remote.user = 'ec2-user'
     remote.password = ''
     remote.allowAnyHosts = true

     node {
           withCredentials([sshUserPrivateKey(credentialsId: 'app_server_dev', keyFileVariable: 'identity', passphraseVariable: '', usernameVariable: 'ec2-user')]) {

               stage('Create Project Directory'){
                 sshCommand remote: remote, command: "mkdir cicdprojecttest"
                 sshCommand remote: remote, command: "cd cicdprojecttest"
               }

               stage('Clone Directory and change directory'){
                 sshCommand remote: remote, command: "sudo git clone http://github.com/odeladetunji/cicdtestproject.git"
                 sshCommand remote: remote, command: "cd cicdtestprojectdev"
               }

               stage('Build and Start the server') {
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

