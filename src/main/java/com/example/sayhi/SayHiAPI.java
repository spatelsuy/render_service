package com.example.sayhi;

import static spark.Spark.*;

public class SayHiAPI {
    public static void main(String[] args) {
        port(8080);

        get("/sayhi", (req, res) -> {
            String name = req.queryParams("name");
            if (name == null || name.trim().isEmpty()) {
                return "Hi there!";
            }
            return "Hi " + name;
        });
    }
}
