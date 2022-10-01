FROM openjdk:17
ARG JAR_FILE=build/libs/Lab1_Tingeso-2-2022-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} Lab1_Tingeso-2-2022-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/Lab1_Tingeso-2-2022-0.0.1-SNAPSHOT.jar"]
