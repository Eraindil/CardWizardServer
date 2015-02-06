package com.np.cardwizard.config;

import com.np.cardwizard.security.CustomTokenBasedRememberMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.RememberMeAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@Order(2)
class SecurityConfig extends WebSecurityConfigurerAdapter {


  @Autowired
  private UserDetailsService userDetailsService;
  @Autowired
  private CustomTokenBasedRememberMeService tokenBasedRememberMeService;
  @Autowired
  private RememberMeAuthenticationProvider rememberMeAuthenticationProvider;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(ajaxAuthenticationEntryPoint())
        .and()
        .formLogin()
        .successHandler(ajaxAuthenticationSuccessHandler())
        .failureHandler(ajaxAuthenticationFailureHandler())
        .loginProcessingUrl("/process-login")
        .permitAll().and()
        .logout()
        .logoutUrl("/process-logout")
        .logoutSuccessHandler(ajaxLogoutSuccessHandler())
        .permitAll()
        .and()
        .rememberMe().rememberMeServices(tokenBasedRememberMeService);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // @formatter:off
    auth
      .userDetailsService(userDetailsService)
      .passwordEncoder(passwordEncoder());
    // @formatter:on
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

  @Bean
  public AuthenticationEntryPoint ajaxAuthenticationEntryPoint() {
    return (request, response, authException) ->
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
  }

  @Bean
  public AuthenticationSuccessHandler ajaxAuthenticationSuccessHandler() {
    return new SimpleUrlAuthenticationSuccessHandler() {
      private RequestCache requestCache = new HttpSessionRequestCache();

      @Override
      public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                          Authentication authentication) throws ServletException, IOException {

        if (requestCache.getRequest(request, response) != null) {
          requestCache.removeRequest(request, response);
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.flushBuffer();

        clearAuthenticationAttributes(request);
      }

      @SuppressWarnings("UnusedDeclaration")
      public void setRequestCache(RequestCache requestCache) {
        this.requestCache = requestCache;
      }
    };
  }

  @Bean
  public AuthenticationFailureHandler ajaxAuthenticationFailureHandler() {
    return (request, response, exception) ->
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed: " + exception.getMessage());
  }

  @Bean
  public LogoutSuccessHandler ajaxLogoutSuccessHandler() {
    return (request, response, authentication) -> {
      response.setStatus(HttpServletResponse.SC_OK);
      response.flushBuffer();
    };
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
