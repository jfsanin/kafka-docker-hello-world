This is a toy project for running kafka with docker, please do not use it for any production environment

## How to run it with only docker and a custom image (not docker compose)

For learning purposes I created a docker file from scratch, it is called `dummy-easy-kafka-setup.DockerFile`.
for running a container based on this docker file, you first need to build the image, for doing that run:

`docker build -f dummy-easy-kafka-setup.Dockerfile -t kafka_hello_world .`

then you can run the container:

`docker run -it -p 9092:9092 kafka_hello_world`

then you can run the main function in the Producer class for starting to send messages and the main function in the
Consumer class for starting to retrieve those messages.

### Run producer

`mvn compile exec:java -Dexec.mainClass="Producer"`

### Run consumer

`mvn compile exec:java -Dexec.mainClass="Consumer"`




