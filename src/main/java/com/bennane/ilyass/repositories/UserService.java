package com.bennane.ilyass.repositories;

import com.bennane.ilyass.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

    public List<User> listAll(){
        return(List<User>) repo.findAll();
    }

    public void save(User user){
        repo.save(user);
    }


    public void delete(Integer id) {
        repo.deleteById(id);
    }
    public User findById(Integer id) {
        return repo.findById(id).orElse(null);
    }



}
