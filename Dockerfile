FROM openjdk:17
WORKDIR /app
COPY src /app/src
RUN mkdir -p target/classes
RUN javac -d target/classes src/main/java/com/example/SayHiAPI.java
CMD ["java", "-cp", "target/classes", "com.example.SayHiAPI"]
