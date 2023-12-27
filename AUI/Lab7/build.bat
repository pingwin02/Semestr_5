cd module-ng && call npm i && call npm run build && cd ..
set "JAVA_HOME=%USERPROFILE%\.jdks\temurin-17.0.9"
cd module-config && call mvn clean verify && cd ..
cd module-eureka && call mvn clean verify && cd ..
cd module-product && call mvn clean verify && cd ..
cd module-warehouse && call mvn clean verify && cd ..
cd module-gateway && call mvn clean verify && cd ..