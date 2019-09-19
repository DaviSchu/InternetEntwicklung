package de.stl.saar.internetentw1.spring.configuration;

import de.stl.saar.internetentw1.session.UserSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean(name = "userSession")
    public UserSession createUserSession () {
        return new UserSession();
    }


}
