package com.example.demo.app.Controller;

import com.example.demo.app.model.User;
import com.example.demo.app.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;



@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){

      User cretedUser =   userService.creteUser(user);

        return new ResponseEntity<>(user , HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updatedUser = userService.updateUser(user);
         if(updatedUser == null)
           //return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            throw new IllegalArgumentException("User Does not Found With User ID : "+user.getId());
         return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        boolean isDeleted = userService.deleteUser(id);
        if(!isDeleted)
            return new ResponseEntity<>("User Not Found With User ID: "+id,HttpStatus.NOT_FOUND);
        return  new ResponseEntity<>("User Deleted :"+id,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers(){

        List<User> userList = userService.getUsers();
        if(userList == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userList,HttpStatus.OK);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<User> getSingleUser(@PathVariable("userid") int id){
        User singleUser = userService.getSingleUser(id);
        if(singleUser == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(singleUser,HttpStatus.OK);
    }

  @GetMapping("/search")
  public ResponseEntity<List<User>> searchUser(@RequestParam String name){
      System.out.println(name);

      List<User> user = userService.searchUser(name);

      return ResponseEntity.ok(user);
  }



}
