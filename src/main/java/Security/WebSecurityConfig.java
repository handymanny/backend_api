package Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthEntryPoint jwtAuthEntryPoint;

    @Autowired
    private UserDetailsService jwtUserDetailsService;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Configure AuthenticationManager so it knows where to load user matching creds
        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
    }

    // Create our password encoder bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/departments/**").permitAll()
                    .and()
                .authorizeRequests()
                    .antMatchers("/categories/**").permitAll()
                    .and()
                .authorizeRequests()
                    .antMatchers("/attributes/**").permitAll()
                    .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET,"/products/**").permitAll()
                    .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/products/**").authenticated()
                    .and()
                .authorizeRequests()
                    .antMatchers("/customer/**").authenticated()
                    .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/customers/**").permitAll()
                    .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.PUT, "/customers").authenticated()
                    .and()
                .authorizeRequests()
                    .antMatchers("/orders/**").authenticated()
                    .and()
                .authorizeRequests()
                    .antMatchers("/shoppingcart/**").permitAll()
                    .and()
                .authorizeRequests()
                    .antMatchers("/tax/**").permitAll()
                    .and()
                .authorizeRequests()
                    .antMatchers("/shipping/**").permitAll()
                    .and()
                .exceptionHandling()
                    .authenticationEntryPoint(jwtAuthEntryPoint)
                    .and()
                    .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
