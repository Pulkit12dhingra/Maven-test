pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "maven3"
        jdk 'java'
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git credentialsId: 'gitlab', url:'https://git.nagarro.com/freshertraining2022/pulkitdhingra01.git'

                // Run Maven on a Unix agent.
                sh "mvn -f java_test_1/java_test_1/pom.xml -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'java_test_1/java_test_1/target/*.war'
                }
            }
        }
         stage("sonar") {
             tools {
                 jdk 'jdk11'
             }
             environment {
                 scannerHome = tool 'sonar1' 
             }
             steps {
                 //none
                 withSonarQubeEnv("sonar"){
                     sh 'mvn -f java_test_1/java_test_1/pom.xml sonar:sonar -Dsonar.projectKey=test-pulkit' 
                     //-Dsonar.host.url=http://localhost:9000 -Dsonar.login=9d0725afe4308efd1ce647696f9558f710602a06'
                         echo 'sonar'
                 }
             }
         }
        stage('Server'){
            steps{
                rtServer(
                   id: "Artifactory",
                    url: 'http://192.168.56.102:8082/artifactory',
                    username: 'admin',
                     password: '123456789',
                     bypassProxy: true,
                     timeout: 300
               )
            }
        }
         stage('Upload'){
            steps{
                rtUpload(
                    serverId: "Artifactory",
                    spec: {
                        "files": [
                            {
                                "pattern": "*.war",
                               "target": "libs-snapshot-local"
                            }
                        ]
                    }
                )
            }
        }
        stage('Publish Build Info'){
            steps{
                rtPublishBuildInfo(
                    serverId: "Artifactory"
                )
            }
        }
        stage('Docker Build') {
           steps {
             
                sh 'docker build -t calculator_java java_test_1/java_test_1/'             
          }
        }
    }
}
