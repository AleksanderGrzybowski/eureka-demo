FROM openjdk:8-jre

COPY build/libs/eureka-demo-0.0.1-SNAPSHOT.jar /app.jar
COPY docker-entrypoint.sh /

CMD ["/docker-entrypoint.sh"]
