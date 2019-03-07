FROM java:8
VOLUME /home/container
ADD eureka-0.0.1-SNAPSHOT.jar eureka.jar
#RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka.jar"]
EXPOSE 8761