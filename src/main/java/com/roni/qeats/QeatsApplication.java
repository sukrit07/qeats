package com.roni.qeats;

import com.roni.qeats.configs.AppConstants;
import com.roni.qeats.models.Roles;
import com.roni.qeats.repositories.RoleRepository;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class QeatsApplication implements CommandLineRunner {


  @Autowired
  private RoleRepository roleRepo;

  @Bean
  public ModelMapper modelMapper()
  {
    return new ModelMapper();
  }

  public static void main(String[] args) {
    SpringApplication.run(QeatsApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

//		System.out.println(this.passwordEncoder.encode("12345"));

    // Creating 2 roles at the start of application
    try {

      Roles role = new Roles();
      role.setId(AppConstants.ADMIN_USER);
      role.setName("ROLE_ADMIN");

      Roles role1 = new Roles();
      role1.setId(AppConstants.NORMAL_USER);
      role1.setName("ROLE_NORMAL");

      List<Roles> roles = List.of(role,role1);

      List<Roles> result = this.roleRepo.saveAll(roles);

      result.forEach(r -> {
        System.out.println(r.getName());
      });

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
