job('NodeJS_Docker_example') {
    scm {
        git('git://github.com/naray89k/Jenkins.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('naray89k')
            node / gitConfigEmail('narayanan.k.1985@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell(readFileFromWorkspace('build.sh'))
        dockerBuildAndPublish {
            repositoryName('naray89k/docker-nodejs-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('dockerhub')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
