In this repo, we disable the default spring security settings and configure our own. 

```declarative
@EnableWebSecurity
@Configuration
public class SecurityConfig
```
We can enable our own customized security configurations by defining them in a config class. We need to annotate this config class with @EnableWebSecurity to inform the security filter to use the customized security configurations.

### How to make your authentication stateless
```declarative
    @Bean
    public SecurityFilterChain
    customizedSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request ->
                        request.anyRequest().authenticated())
                //.formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(
                        session ->
                                session.sessionCreationPolicy(
                                        SessionCreationPolicy.STATELESS));

        return httpSecurity.build();
    }
```

#### httpSecurity.csrf(AbstractHttConfigurer::disable)
The above will disable CSRF. We don't need CSRF if we make our session
stateless as we have to pass username and password with every request.

#### httpSecurity.authorizeHttpRequests(request ->request.anyRequest().authenticated()
The above will authenticate all the requests. Without the above,
requests will not get authenticated.

#### httpSecurity.formLogin(Customizer.withDefaults());
The above will enable form login. This is not needed for production
ready applications.

#### httpSecurity.httpBasic(Customizer.withDefaults());
The above will enable authentication from Postman.

#### httpSecurity.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
The above will make the authentication stateless. Once it is made
stateless, it expects the username and password to be sent in all
requests. Once we make the session as stateless, we cannot use
browser (form login) to login. If we try to use browser, it will
always give the login page and will never give the output of the
request.
