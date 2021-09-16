FROM openjdk:11-jre-slim
COPY target/movie.jar movie.jar
# RUN apt-get update; apt-get install -y curl netcat
# ADD entrypoint.sh entrypoint.sh
ADD wait-for-it.sh wait-for-it.sh
# ENTRYPOINT [ "java", "-jar", "movie.jar" ]
# CMD [ "entrypoint.sh" ]
# ENTRYPOINT ["sh"]
