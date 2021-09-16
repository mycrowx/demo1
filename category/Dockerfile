FROM openjdk:11-jre-slim
COPY target/category-0.0.1-SNAPSHOT.jar user.jar
# RUN apt-get update; apt-get install -y curl netcat
# ADD entrypoint.sh entrypoint.sh
ADD wait-for-it.sh wait-for-it.sh
# CMD [ "entrypoint.sh" ]
# ENTRYPOINT ["sh"]
