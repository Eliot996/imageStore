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
    public ResponseEntity<Image> add(@RequestBody Image image){
        image.setId((int) Math.floor(Math.random() * 10000));
        list.add(image);
        return ResponseEntity.ok().body(image);
    }

    @DeleteMapping("/{image}")
    public ResponseEntity<Image> delete(@PathVariable int image) {
        boolean foundImage = false;
        Image found = new Image();

        for (int i = 0; i < list.size(); i++) {
            found = list.get(i);
            if (found.getId() == image) {
                list.remove(found);
                foundImage = true;
            }
        }
        return foundImage ? ResponseEntity.ok().body(found) : ResponseEntity.badRequest().body(null);
    }
}
