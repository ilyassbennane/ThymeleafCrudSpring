package com.bennane.ilyass.repositories;


import com.bennane.ilyass.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

}
