FROM openjdk:17-alpine

ARG version

COPY wagepage-${version}.jar /wagepage.jar

CMD java -jar wagepage.jar