package com.myschool.project.webservice.ui.controller;

import com.myschool.project.webservice.ui.model.request.UserDetailsRequestModel;
import com.myschool.project.webservice.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users") //https://localhost:8080/users/#
public class UserController{

    @GetMapping()
    public String getUsers(@RequestParam(value="page") int page,@RequestParam(value="limit") int limit){
        return "get users was called with page = " + page + " and limit = " + limit;
    }
    @GetMapping(path="/{userId}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getUser(@PathVariable String userId){
        UserRest user = new UserRest();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("test@gmail.com");
        user.setUserId(userId);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserRest user = new UserRest();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
//        user.getUserId(userDetails.getUserId());
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser(){
        return "update user was called";
    }
    @DeleteMapping
    public String deleteUser(){
        return "delete user was called";
    }
}