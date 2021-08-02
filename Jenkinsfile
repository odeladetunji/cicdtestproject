
     def remote = [:]
     remote.name = 'ec2-user'
     remote.host = '172.30.1.180'
     remote.password = ''
     remote.allowAnyHosts = true

     node {
           withCredentials([sshUserPrivateKey(credentialsId: 'dev_appserver.pem', keyFileVariable: 'identity', passphraseVariable: '', usernameVariable: 'ec2-user')]) {
               remote.user = "ec2-user"
               remote.identityFile = identity

               stage('Create Project Directory'){
                 sshCommand remote: remote, command: "cd"
                 sshCommand remote: remote, command: "sudo rm -R cicdprojecttest"
                 sshCommand remote: remote, command: "sudo mkdir cicdprojecttest"
                 sshCommand remote: remote, command: "cd cicdprojecttest"
               }

               stage('Clone Directory and change directory'){
                 sshCommand remote: remote, command: "sudo rm -R cicdtestproject"
                 sshCommand remote: remote, command: "sudo git clone http://github.com/odeladetunji/cicdtestproject.git"
               }

               stage('Build and Start the server') {
                 sshCommand remote: remote, command: "cd cicdtestproject/cicdtestprojectdev; ls -l; sudo mvn clean install;"
                 sshCommand remote: remote, command: "cd cicdtestproject/cicdtestprojectdev; sudo chmod -R 777 target"
                  sshCommand remote: remote, command: "sudo fuser -k 8086/tcp"
                 sshCommand remote: remote, command: "cd cicdtestproject/cicdtestprojectdev/target; sudo nohup java -jar cicdtestprojectdev-0.0.1-SNAPSHOT.jar &"
                 sshCommand remote: remote, command: "echo successfully deployed"
               }

           }
     }

