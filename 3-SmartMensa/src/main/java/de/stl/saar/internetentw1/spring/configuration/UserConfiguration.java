package de.stl.saar.internetentw1.spring.configuration;

import de.stl.saar.internetentw1.session.CurrentUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {

    @Bean(name = "currentUser")
    public CurrentUser createCurrentUser () {
        return new CurrentUser();
    }


}
