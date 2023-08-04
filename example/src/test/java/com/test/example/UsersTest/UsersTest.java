package com.test.example.UsersTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.test.example.repository.UsersRepository;
import com.test.example.repository.entity.UsersScore;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsersTest {
  
  @Autowired
  private UsersRepository usersRepository;

  @Test
  public void testConnectionAndInsert() {
      UsersScore user = UsersScore.builder()
              .name("John Doe")
              .number(123456L)
              .userId("john")
              .deposit(1000L)
              .score(42)
              .build();

      UsersScore savedUser = usersRepository.save(user);
      assertNotNull(savedUser);
  }
}
