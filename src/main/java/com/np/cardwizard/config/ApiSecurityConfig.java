package com.np.cardwizard.config;

import com.np.cardwizard.model.user.UserRole;
import com.np.cardwizard.security.CustomTokenBasedRememberMeService;
import com.np.cardwizard.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@Order(1)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

  private String tokenKey = "8E90BE60-0CFC-11E4-9191-0800200C9A66";

  @Autowired
  private UserDetailsServiceImpl userDetailsServiceImpl;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .antMatcher("/rest/**")
        .csrf()
        .disable()
        .authorizeRequests().anyRequest().authenticated().and()
        .authorizeRequests()
        .antMatchers("/rest/admin").hasRole(UserRole.ADMIN.name()).anyRequest().hasRole(UserRole.ADMIN.name()).and()
        .addFilterBefore(rememberMeAuthenticationFilter(), BasicAuthenticationFilter.class)
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint());
  }


  @Bean
  public RememberMeAuthenticationFilter rememberMeAuthenticationFilter() throws Exception {
    return new RememberMeAuthenticationFilter(authenticationManager(), tokenBasedRememberMeService());
  }

  @Bean
  public CustomTokenBasedRememberMeService tokenBasedRememberMeService() {
    CustomTokenBasedRememberMeService service = new CustomTokenBasedRememberMeService(tokenKey, userDetailsServiceImpl);
    service.setAlwaysRemember(true);
    service.setCookieName("at");
    return service;
  }

  @Bean
  RememberMeAuthenticationProvider rememberMeAuthenticationProvider() {
    return new RememberMeAuthenticationProvider(tokenKey);
  }
}
