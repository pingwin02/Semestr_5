FROM eclipse-temurin:17.0.6_10-jre
ENV SERVER_PORT=8080
EXPOSE 8080
COPY target/module-gateway-0.0.1-SNAPSHOT.jar /opt/module-gateway.jar
CMD ["java", "-jar", "/opt/module-gateway.jar"]