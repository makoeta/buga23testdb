package de.hhn.se.labswp.bugaMap.security.auth;

import de.hhn.se.labswp.bugaMap.crudRepos.AdminRepository;
import de.hhn.se.labswp.bugaMap.jpa.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.*;

// Tests are not done yet!
@DataJpaTest
@Import(SecurityTestConfig.class)
class AuthenticationControllerTest {

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private AdminRepository adminRepository;

  @Test
  void register() {
    //given
    Admin admin = Admin.builder()
        .firstname("Frank")
        .lastname("Bauer")
        .emailadress("frank.bauer@buga23.de")
        .password(passwordEncoder.encode("supersecure"))
        .build();

    adminRepository.save(admin);

    //when
    Admin expected  = adminRepository.findByEmailadress("frank.bauer@buga23.de").get();

    //then
    assertThat(expected).isEqualTo(admin);

  }

  @Test
  void authenticate() {
  }
}