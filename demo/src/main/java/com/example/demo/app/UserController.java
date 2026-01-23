package com.example.demo.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    Map<Integer,User> userDb = new HashMap<>();

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){

        System.out.println(user.getProject());
        userDb.putIfAbsent(user.getId(),user);
        // return ResponseEntity.status(HttpStatus.CREATED).body(user);
        return new ResponseEntity<>(user , HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        if(!userDb.containsKey(user.getId()))
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        userDb.put(user.getId(),user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        if(!userDb.containsKey(id))
            return new ResponseEntity<>("User Not Found : "+id,HttpStatus.NOT_FOUND);

        userDb.remove(id);
        return  new ResponseEntity<>("User Deleted :"+id,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        if(userDb.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new ArrayList<>(userDb.values()),HttpStatus.OK);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<User> getSingleUser(@PathVariable("userid") int id){
        if(!userDb.containsKey(id))
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userDb.get(id),HttpStatus.OK);
    }

  @GetMapping("/search")
  public ResponseEntity<List<User>> searchUser(@RequestParam String name){
      System.out.println(name);
      List<User> user = userDb.values().stream()
                      .filter(u -> u.getName().equalsIgnoreCase(name))
                       .toList();

      return ResponseEntity.ok(user);
  }


}
