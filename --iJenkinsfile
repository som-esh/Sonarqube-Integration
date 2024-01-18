pipeline {
    agent any
    triggers {
        pollSCM('H H/1 * * *')
    }
    environment {
        DEV_PORT = 8090
        PROD_PORT = 9090
    }
    parameters {
        choice(name: 'ENVIRONMENT',
        choices: ['dev', 'prod'],
        description: 'Select the environment to deploy')
    }
    tools {
        maven "M3"
    }
    stages {
        stage('Pull') {
            steps {
                git branch: "${params.ENVIRONMENT}", url:'https://github.com/som-esh/Sonarqube-Integration.git'
            }
        }
        stage('Build') {
            steps {
                sh "mvn clean test package"
            }
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts '**/target/*.war'
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonar') {
                    sh "mvn clean verify sonar:sonar \
                        -Dsonar.projectKey=miniAssignment \
                        -Dsonar.projectName='miniAssignment' \
                        -Dsonar.host.url=http://192.168.56.103:9000 \
                        -Dsonar.token=sqp_9722785200bdcec79e12883f26805ec877d2b4fd"
                }
            }
        }
        stage('Upload to Artifactory'){
            steps{
                rtMavenResolver(
                    id:'MavenResolver',
                    serverId:"artifactory-server",
                    releaseRepo:"assignment-release",
                    snapshotRepo:"assignment-snapshot"
                )
                rtMavenDeployer(
                    id:"MavenDeployer",
                    serverId: 'artifactory-server',
                    releaseRepo:"assignment-release",
                    snapshotRepo:"assignment-snapshot",
                    deployArtifacts : true,
                )
                rtMavenRun(
                    tool: "M3",
                    useWrapper: false,
                    pom:"pom.xml",
                    goals:"clean install",
                    deployerId:"MavenDeployer"
                )
                rtPublishBuildInfo(
                    serverId:"artifactory-server"
                )
            }
        }
        stage ('Build docker image') {
            steps {
                script {
                    def TAG = 'development'
                    if (params.ENVIRONMENT == "prod") {
                        TAG = 'production'
                    }
                    sh "docker build -t someshsingh/ma:'${TAG}' ."
                }
            }
        }
        stage('Run image') {
            steps {
                script {
                    def TAG = 'development'
                    if (params.ENVIRONMENT == "prod") {
                        TAG = 'production'
                    }
                    def PORT = 0000
                    if (params.ENVIRONMENT == 'dev') {
                        PORT = env.DEV_PORT
                    }
                    else {
                        PORT = env.PROD_PORT
                    }
                    // Check if Port is occupied
                    def portId = sh(returnStdout: true, script: "docker ps -aq --filter publish='${PORT}'").trim()
                        if(portId) {
                            sh "docker stop ${portId}"
                            sh "docker rm ${portId}"
                        }
                    // Check if container is already running
                    def containerId = sh(returnStdout: true, script: "docker ps -aq --filter name=container_'${TAG}'").trim()
                        if(containerId) {
                            sh "docker stop ${containerId}"
                            sh "docker rm ${containerId}"
                        }
                        sh "docker run -d -p '${PORT}':8080 --name=container_'${TAG}' someshsingh/ma:'${TAG}'"
                }
            }
        }
    }
    post {
        always {
            emailext body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}", subject: "jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}", to: 'somesh.singh@nagarro.com', attachLog: true
        }
    }
}
