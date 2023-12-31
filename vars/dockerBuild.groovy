def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=984f3eff36mshdb3a551e63c1d64p1a3c9ajsn9c29532abea1 -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'Docker']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}
