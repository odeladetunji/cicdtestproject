 pipeline {
     agent any

     stages {
         stage('Build') {
             steps {
                 //ssh into the remote machine.
//                  sh "sudo ssh -i ~/.ssh/dev_appserver.pem ec2-user@172.30.1.180"

                 //Create a new Directory
                 sh "sudo mkdir cicdprojecttest"

                 //Move into the new Directory.
                 sh "cd cicdprojecttest"

                 //Clone the cicdtestproject
                 sh "sudo git clone http://github.com/odeladetunji/cicdtestproject.git"

                 //Move into cicdtestprojectdev directory
                 sh "cd cicdtestprojectdev";

                 //Install the dependencies
                 sh "mvn clean install";

                 //Set change permission of the target directory;
                 sh "sudo chmod -R 777 target"

                 //Move into the target directory
                 sh "cd target"

                 //Remove nohup.out file;
                 sh "sudo rm nohup.out"

                 //Kill Java application listening on
                 sh "sudo kill ${(lsof -t -i:9999)}"

                 //Start the Java Application
                 sh "sudo nohup java -jar cicdtestprojectdev-0.0.1-SNAPSHOT.jar &"

             }
         }
     }
 }
