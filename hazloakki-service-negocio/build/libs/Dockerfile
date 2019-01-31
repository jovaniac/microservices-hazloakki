FROM openjdk:8u171-jre-slim
MAINTAINER jovaniac@gmail.com"
COPY start.sh /start.sh
COPY wait-for-it.sh /wait-for-it.sh
COPY negocio-microservice.jar /opt/negocio-microservice.jar
RUN sh -c 'chmod +x *.sh'
EXPOSE 8086
ENTRYPOINT ["/start.sh"]
