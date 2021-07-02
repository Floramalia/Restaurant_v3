package SDA.Restaurant_v3.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/clientRegistration",
                        "/addUser" ,"/", "/getCarts/{clientId}", "/addProductToCart/{clientId}/{productId}"
                        ,"/searchOffer")
                .permitAll()
                .anyRequest().authenticated();
//                .and()
//                .formLogin().loginPage("/login").
//                permitAll()
//                .and().logout().permitAll();
    }

}
