package ru.vitasoft.pilipenko.MIAC_Tables.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



    @Override
    protected void configure(HttpSecurity http) throws Exception {



        http.authorizeRequests().antMatchers("/**").hasAnyRole("ADMIN","USER").
                and().formLogin();

        http.csrf().disable();
        //http.authorizeRequests().anyRequest().permitAll();
    }

    private static final String ENCODED_PASSWORD_A = "$2a$10$AIUufK8g6EFhBcumRRV2L.AQNz3Bjp7oDQVFiO5JJMBFZQ6x2/R/2";
    private static final String ENCODED_PASSWORD_V = "$2a$10$h.p1FBohTDsNDLGyIuQ2ZOZiWhHLXpZNpFl4sCo1lmCLR.L2lSR5q";
    private static final String ENCODED_PASSWORD_D = "$2a$10$BkA0syVhzOfVldGpJUA2l.8ATXdnSSekO3JSc0K6W1Jdkx7wEDVhy";
    private static final String ENCODED_PASSWORD = "$2a$10$xdvxe/RpyfgZIJAEn.sTteJvAgqk7Icoh.BFtsVdylfRi9/w.bBwm";

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("user").password(ENCODED_PASSWORD).roles("USER");
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("elizaveta.vasilenko").password(ENCODED_PASSWORD_V).roles("USER");
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("anna.dadalova").password(ENCODED_PASSWORD_D).roles("USER");
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("root").password(ENCODED_PASSWORD_A).roles("ADMIN");
        auth.inMemoryAuthentication()
                .withUser("jerry").password("1234").roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
