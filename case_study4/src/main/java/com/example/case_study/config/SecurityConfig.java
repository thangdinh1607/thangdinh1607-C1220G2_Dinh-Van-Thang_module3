//package com.example.case_study.config;
//
//import com.example.case_study.service.user_dertail.UserDetailServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailServiceImpl();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        return authenticationProvider;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/delete/**").hasAuthority("ADMIN")
//                .antMatchers("/edit/**").hasAnyAuthority("ADMIN","EDITOR")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll()
//                .loginPage("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
////               .failureUrl("/login?error=true")
//                .and().logout().permitAll()
//                .and().exceptionHandling().accessDeniedPage("/403");
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//}
