FROM openjdk:11-jre-slim
COPY target/user-0.0.1-SNAPSHOT.jar user.jar
RUN apt-get update
ADD entrypoint.sh entrypoint.sh
CMD [ "entrypoint.sh" ]
ENTRYPOINT ["sh"]
