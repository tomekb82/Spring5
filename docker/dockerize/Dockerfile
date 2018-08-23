FROM java:8-jre-alpine

WORKDIR /spring-app

COPY dependencies/* dependencies/
#COPY snapshot-dependencies/* dependencies/
COPY spring-app.jar spring-app.jar

ENV _JAVA_OPTIONS -Xmx64M

ENTRYPOINT ["java", "-jar", "spring-app.jar"]
