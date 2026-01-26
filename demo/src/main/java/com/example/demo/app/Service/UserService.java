package com.example.demo.app.Service;

import com.example.demo.app.Exception.UserNotFoundException;
import com.example.demo.app.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    Map<Integer, User> userDb = new HashMap<>();


    public User creteUser(User user) {
        userDb.put(user.getId(), user);
    return user;
    }

    public User updateUser(User user) {
        if(!userDb.containsKey(user.getId())) {
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body();
            return null;
        }
        userDb.put(user.getId(),user);
        return user;
    }

    public boolean deleteUser(int id) {
        if(!userDb.containsKey(id))
            throw new UserNotFoundException("User Not Found for This ID :" +id);
        userDb.remove(id);
        return true;
    }


    public List<User> getUsers() {
          if(userDb.isEmpty())
             return null;

        return new ArrayList<>(userDb.values());
    }

    public User getSingleUser(int id) {
        if(!userDb.containsKey(id))
            return null;
        return userDb.get(id);


    }

    public List<User> searchUser(String name) {
        List<User> user = userDb.values().stream()
                .filter(u -> u.getName().equalsIgnoreCase(name))
                .toList();
        return user;
    }
}
