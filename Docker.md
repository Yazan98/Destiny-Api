gradle clean build
gradle bootJar
gradle docker --info
docker images
docker login
docker push yt98/destiny_api:latest