package com.magnus.futbot.controllers;

import javax.servlet.annotation.HttpConstraint;

import com.magnus.futbot.services.ProfilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.magnus.futbot.dtos.ProfileDTO;

@RestController()
public class ProfilesController {

    @Autowired
    private ProfilesService profilesService;

    @GetMapping("/profiles/get-all")
    @HttpConstraint
    public ResponseEntity<String> Get(@RequestParam String userId) {
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }


    @PostMapping("/profiles/add-profile")
    @HttpConstraint
    public ResponseEntity<ProfileDTO> AddProfile(@RequestBody ProfileDTO profileDTO) {
        return new ResponseEntity<>(profilesService.add(profileDTO), HttpStatus.OK);
    }
}
