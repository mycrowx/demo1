FROM openjdk:11-jre-slim
COPY target/category.jar category.jar
# RUN apt-get update; apt-get install -y curl netcat
# ADD entrypoint.sh entrypoint.sh
ADD wait-for-it.sh wait-for-it.sh
# ENTRYPOINT [ "java", "-jar", "category.jar" ]
# CMD [ "entrypoint.sh" ]
# ENTRYPOINT ["sh"]
