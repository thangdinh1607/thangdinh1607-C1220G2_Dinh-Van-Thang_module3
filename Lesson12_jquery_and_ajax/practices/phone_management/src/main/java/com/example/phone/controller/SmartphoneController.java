package com.example.phone.controller;

import com.example.phone.model.Smartphone;
import com.example.phone.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    SmartphoneService smartphoneService;

    @GetMapping("/list")
    public ModelAndView getAllSmartphone(){
        return new ModelAndView("/list","smartphones",smartphoneService.findAll());
    }

    @GetMapping
    public ResponseEntity<List<Smartphone>> showAllSmartphone(){
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Smartphone> createSmartphone(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(smartphoneService.save(smartphone),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartphone(@PathVariable int id) {
       Smartphone smartphones = smartphoneService.findById(id);
        if (smartphones==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphones, HttpStatus.NO_CONTENT);
    }
}
