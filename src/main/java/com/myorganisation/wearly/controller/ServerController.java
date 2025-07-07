package com.myorganisation.wearly.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ServerController {

    @GetMapping
    public ResponseEntity<String> serverStatus() {
        return new ResponseEntity<>("Wearly is live", HttpStatusCode.valueOf(200));
    }

}
