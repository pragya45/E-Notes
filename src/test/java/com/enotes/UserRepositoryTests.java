package com.enotes;

import com.enotes.entity.UserDtls;
import com.enotes.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveUserTest(){
               UserDtls userDtls= new UserDtls();
               userDtls.setName("priti");
               userDtls.setEmail("preeti@gmail.com");
               userDtls.setPassword("preeti123");
               userDtls.setAbout("student");

        userRepository.save(userDtls);

        Assertions.assertThat(userDtls.getId());
    }

    @Test
    @Order(2)
    public void getUserTest(){
        UserDtls userGet= userRepository.findById(1).get();
        Assertions.assertThat(userGet.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getListOfUserTest(){
        List<UserDtls> userDtls= userRepository.findAll();
        Assertions.assertThat(userDtls.size()).isGreaterThan(110);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateUserTest(){
        UserDtls userDtls= userRepository.findById(1).get();
        userDtls.setName("praju");
        UserDtls userUpdated =userRepository.save(userDtls);

        Assertions.assertThat(userUpdated.getName()).isEqualTo("praju");
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteUserTest(){
        UserDtls userDtls= userRepository.findById(1).get();
        userRepository.delete(userDtls);
        UserDtls userDtls1=null;
        Optional<UserDtls> optionalUserDtls=userRepository.findUserDtlsByName("praju");
        if (optionalUserDtls.isPresent()){
            userDtls1= optionalUserDtls.get();
        }
        Assertions.assertThat(userDtls1).isNull();
    }






}
