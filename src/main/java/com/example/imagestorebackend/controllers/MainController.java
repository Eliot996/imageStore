package com.example.imagestorebackend.controllers;

import com.example.imagestorebackend.models.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/images")
public class MainController {

    ArrayList<Image> list = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Image>> getAll() {
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public void app( @RequestBody Image image){
        list.add(image);
    }
}
