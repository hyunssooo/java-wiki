node {
    stage('Git CheckOut', {
        println "Git CheckOut Started"
        checkout(
                [
                        $class: 'GitSCM',
                        branches: [[name: '*/develop'], [name: '*/deploy_test']],
                        doGenerateSubmoduleConfigurations: false,
                        extensions: [],
                        submoduleCfg: [],
                        userRemoteConfigs: [[url: 'https://github.com/oeeen/wiki.git']]
                ]
        )
        println "Git CheckOut End"
    })

    stage('Test/Build') {
        println "Test/Build Started"

        try {
            withCredentials(
                    [
                            file(credentialsId: 'APPLICATION_CONFIG', variable: 'config')
                    ]) {
                sh "cp -f \$github $JENKINS_HOME/workspace/WoowaCrew/src/main/resources/github.yml"
                sh "cp -f \$kakao $JENKINS_HOME/workspace/WoowaCrew/src/main/resources/kakao.yml"
                sh "cp -f \$config $JENKINS_HOME/workspace/WoowaCrew/src/main/resources/application.yml"
            }
            sh "./gradlew clean build -x test"
        } finally {
            junit allowEmptyResults: true, keepLongStdio: true, testResults: 'build/test-results/*.xml'
        }
        println "Test/Build End"
    }

    stage('Coverage Report', {
//        TODO: Do Something
    })

    stage('Push Dockerhub', {
        println "Push Dockerhub"

        withCredentials([usernamePassword( credentialsId: 'dockerhub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
            docker.withRegistry('https://index.docker.io/v1', 'dockerhub') {
                sh "docker login -u ${USERNAME} -p ${PASSWORD}"
                def dockerImage = docker.build("oeeen/wiki:lts")
                dockerImage.push()
            }
        }
        println "Backend done"

        // TODO: Deploy FrontEnd

        println "Deploy End"
    })

    stage('Remove Unused docker image') {
        sh "docker rmi oeeen/wiki:lts"
    }
}