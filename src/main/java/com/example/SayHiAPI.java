package com.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.net.InetSocketAddress;
import java.io.OutputStream;
import java.io.IOException;

public class SayHiAPI {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/sayhi", new SayHiHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started at http://localhost:8080/sayhi");
    }

    static class SayHiHandler implements HttpHandler {
        public void handle(HttpExchange exchange) throws IOException {
            String name = "there";
            if ("GET".equals(exchange.getRequestMethod())) {
                String query = exchange.getRequestURI().getQuery();
                if (query != null && query.startsWith("name=")) {
                    name = query.substring(5);
                }
                String response = "Hi " + name;
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                exchange.sendResponseHeaders(405, -1); // Method Not Allowed
            }
        }
    }
}
