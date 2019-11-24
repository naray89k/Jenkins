job('NodeJS_DSL_example') {
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
        shell("rm -rf customapi-integration")
		shell("rm -rf docker-compose")
		shell("rm -rf email-notifications")
		shell("rm -rf jenkins-slave")
		shell("rm -rf jfrog-integration")
		shell("rm -rf job-dsl")
		shell("rm -rf node_modules")
		shell("rm -rf pipeline_script")
		shell("rm -rf scripts")
		shell("rm -rf slack-notifications")
		shell("rm -rf sonarqube")
		shell("rm -rf ssh-agent")
		shell("rm -rf jenkins-docker")
		shell("cp -Rv docker-demo/* .")
		shell("rm -rf docker-demo")
        shell("npm install")
    }
}
