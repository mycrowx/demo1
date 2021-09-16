FROM openjdk:11-jre-slim
COPY target/discovery.jar discovery.jar
# RUN apt-get update; apt-get install -y curl netcat
# ADD entrypoint.sh entrypoint.sh
ADD wait-for-it.sh wait-for-it.sh
# ENTRYPOINT [ "java", "-jar", "discovery.jar" ]
# ENTRYPOINT ["sh"]
