package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.User;

import java.util.*;

@Service
public class UserService {
    
    public List<User> list = new ArrayList<>();
    public Integer id = 1;

    public void initUsers() {
        User user1 = new User();
        user1.setName("user1");
        user1.setEmail("mail@test.com");
        user1.setId(this.id++);

        User user2 = new User();
        user2.setName("user2");
        user2.setEmail("mail2@test.com");
        user2.setId(this.id++);

        this.list.add(user1);
        this.list.add(user2);
    }

    public List<User> getAllUsers() {
        if (this.list.isEmpty()) {
            this.initUsers();
        }
        return this.list;
    }

    public User getUserById(Integer id) {

        for (User user : this.list) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User createUser(User givenUser) {
        if (givenUser.getName() != null && givenUser.getEmail() != null) {
            givenUser.setId(this.id++);
            this.list.add(givenUser);
            return givenUser;
        }
        return null;

    }

    public void deleteUser(User givenUser) {
        this.list.remove(givenUser);
        
        
    }
}
