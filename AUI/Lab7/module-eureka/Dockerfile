FROM eclipse-temurin:17.0.6_10-jre
ENV SERVER_PORT=8080
ENV EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://localhost:8080/eureka

EXPOSE 8080
COPY target/module-eureka-0.0.1-SNAPSHOT.jar /opt/module-eureka.jar
CMD ["java", "-jar", "/opt/module-eureka.jar"]