package com.example;

import com.example.controller.UserController;
import com.example.entity.User;
import com.example.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class UserActionControllerTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void run() {
        try {
            UserController commandLineRunner
                    = new UserController();
//            commandLineRunner.run(new String[0]);
            Iterable<User> users = userRepository.findAll();
            int i = 0;
            final List<User> userData = (List<User>) commandLineRunner.getUsers();
            for (User user : users) {
                Assert.assertTrue(user.getName().equals(userData.get(i).getName()));
                Assert.assertFalse(user.getCity().equals(userData.get(i++).getCity()));
            }
            Assert.assertTrue("No data saved in repository",i == 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}