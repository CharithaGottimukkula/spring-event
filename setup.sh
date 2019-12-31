#Start Docker


./gradlew clean build

#Remove all running containers
docker rm -f $(docker ps -aq)

#Remove all images
docker rmi -f $(docker images -a)

#Start Mongo and Event grid Spring Boot App
docker-compose -f docker-compose.yml up -d


