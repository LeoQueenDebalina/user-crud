package com.myhotel.userservice.controller;

import com.myhotel.userservice.entity.UserDatabase;
import com.myhotel.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
   @Autowired
   private UserService userService;
   @GetMapping("/users")
   public List<UserDatabase> getUsers(){
//      return this.userService.getUsers();
      return null;
   }

   @GetMapping("/users/{mnumber}")
   public UserDatabase getUser(@PathVariable String mnumber){
      return this.userService.getUserByMNumber(mnumber);
   }

   @PostMapping("/users")
   public UserDatabase addUser(@RequestBody UserDatabase userDatabase){
      return this.userService.addUser(userDatabase);
   }
   @PutMapping("/users")
   public UserDatabase updateUser(@RequestBody UserDatabase userDatabase){
      return this.userService.updateUser(userDatabase);
   }
   @DeleteMapping("/users/{mnumber}")
   public ResponseEntity<HttpStatus> deleteUser(@PathVariable String mnumber){
      try{
         this.userService.deleteUser(mnumber);
         return new ResponseEntity<>(HttpStatus.OK);
      }catch (Exception e){
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }

   }

}
