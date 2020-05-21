#!/bin/sh
mvn clean package && docker build -t org.example/HelloTodo .
docker rm -f HelloTodo || true && docker run -d -p 8080:8080 -p 4848:4848 --name HelloTodo org.example/HelloTodo 
