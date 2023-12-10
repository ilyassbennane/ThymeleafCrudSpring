package com.bennane.ilyass;

import com.bennane.ilyass.entities.User;
import com.bennane.ilyass.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;
    @Test
    public void testAddNew(){
        User user=new User();
        user.setEmail("ilyassbennane123@gmail.com");
        user.setPassword("123456");
        user.setFirstName("ilyass");
        user.setLastName("bennane");
        User savedUser=repo.save(user);
    }

}
