def call() {
    sh 'trivy image ketan4docker/youtube:latest > trivyimage.txt'
}
