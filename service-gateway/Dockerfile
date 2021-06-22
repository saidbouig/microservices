FROM openjdk:14 as builder

WORKDIR /app

COPY target/service-gateway-*.jar app.jar

RUN java -Djarmode=layertools -jar app.jar extract

FROM openjdk:14

WORKDIR /app

COPY --from=builder /app/dependencies/ ./
COPY --from=builder /app/snapshot-dependencies/ ./
COPY --from=builder /app/spring-boot-loader/ ./
COPY --from=builder /app/application/ ./

EXPOSE 8080
CMD ["java", "org.springframework.boot.loader.JarLauncher"]


