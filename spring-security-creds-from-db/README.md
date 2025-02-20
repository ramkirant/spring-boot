### UserDetailsService

UserDetailsService is responsible for retrieving the user information from your application datasource and it is passed to spring security for authentication. 

We can fetch the security credentials from database by customizing UserDetailsService. 

We can achieve this by creating a bean (method) in our configuration class which returns UserDetailsService.

UserDetailsService is an interface. So to return UserDetailsService in config, we have to either use some predefined implementations of it or create our own implementation of it.

We can use InMemoryUserDetailsManager which is a pre-defined implementation of UserDetailsService. 

### Authentication Provider

Whenever we implement Spring Security, the incoming request with authentication details like username and password is called an unauthenticated object. This request even though it contains the authentication details in it, it is not yet authenticated.

This unauthenticated object is sent to an authentication provider which will authenticate the request. Once authenticated, the request will become an authenticated object.

Most common Authentication Providers in Spring Security are the below 

1. DaoAuthenticationProvider

   DaoAuthenticationProvider is the default authentication provider provided by Spring. It can be used to authenticate the users stored in the database. It implements the AuthenticationProvider interface and can be used with any database that provides a database driver.
   
   DaoAuthenticationProvider authenticates by comparing the username and password that is sent as a part of the request with the username and password fetched from the database.

   DaoAuthenticationProvider uses UserDetailsService to retrive the username and password from the database and authenticate it with the incoming request. 


2. LdapAuthenticationProvider

   
3. OpenIDAuthenticationProvider
4. JwtAuthenticationProvider
5. RememberMeAuthenticationProvider

We can set the authentication provider by creating a bean that returns authentication provider in our Security Config