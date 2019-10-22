FROM openjdk:8

LABEL maintainer = "Vítor Norberto"

COPY . /home

WORKDIR home

CMD ["./mvnw package && java -jar target/gs-spring-boot-docker-0.1.0.jar"]

EXPOSE 8081
