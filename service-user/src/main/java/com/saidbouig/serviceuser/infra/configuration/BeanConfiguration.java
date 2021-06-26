package com.saidbouig.serviceuser.infra.configuration;

import com.saidbouig.serviceuser.ServiceUserApplication;
import com.saidbouig.serviceuser.domain.repository.UsersRepository;
import com.saidbouig.serviceuser.domain.service.DomainUserService;
import com.saidbouig.serviceuser.domain.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = ServiceUserApplication.class)
public class BeanConfiguration {
    @Bean
    UserService userService(final UsersRepository usersRepository){
        return new DomainUserService(usersRepository);
    }
}
