FROM openjdk:11-jre-slim
VOLUME /tmp
COPY config/* /config/
COPY target/config-0.0.1-SNAPSHOT.jar config.jar
ENTRYPOINT ["java", "-jar", "config.jar"]
