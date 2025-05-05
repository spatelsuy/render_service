FROM openjdk:17
WORKDIR /app
COPY . /app
RUN mkdir -p target/classes
RUN javac -cp ".:spark-core-2.9.3.jar" -d target/classes src/main/java/com/example/SayHiAPI.java
CMD ["java", "-cp", "spark-core-2.9.3.jar:target/classes", "com.example.SayHiAPI"]
