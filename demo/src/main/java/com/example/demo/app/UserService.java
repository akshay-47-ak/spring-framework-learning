package com.example.demo.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    Map<Integer,User> userDb = new HashMap<>();


    public User creteUser(User user) {
        userDb.put(user.getId(), user);
    return user;
    }

    public User updateUser(User user) {
        if(!userDb.containsKey(user.getId()))
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body();
            return null;
        userDb.put(user.getId(),user);
        return user;
    }

    public boolean deleteUser(int id) {
        if(!userDb.containsKey(id))
            return false;
        userDb.remove(id);
        return true;
    }


    public List<User> getUsers() {
          if(userDb.isEmpty())
             return null;

        return new ArrayList<>(userDb.values());
    }
}
