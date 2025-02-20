# Spring Security Basic Authentication

Spring enables basic authentication by default when we include Spring Security jars in dependencies. This basic authentication is achieved using username and passssword. 

When we start the application with spring security, spring security would generate a default password to be used for authentication. This default password is to be used only for development purposes. The default username is user.

This default username and password can be customized in application.properties as below.

```declarative
spring.security.user.name=user
spring.security.user.password=password
```

### Session Management
Spring by default enables stateful session. Whenever a user authenticates, spring generates a session and associates it with session id. For further interactions, it would be enough for the client to send this generated session id and not the credentials. This session will be active till

1. The user logs out using the logout screen.
2. The session times out. Spring security as such don't have a default timeout. It inherits the timeout from the underlying container. For Tomcat and Jetty, this timeout would be 30 mins.

#### How can we configure this session timeout parameter?
Session timeout can be configured using the property server.servlet.session.timeout. This property captures the timeout in seconds.

### CSRF
CSRF stands for Cross Site Request Forgery. CSRF is a web security vulnerability where an attacker would trick the user to perform actions that he has not intended to do. Attackers achieve this by sending a malicious link to the user and by tricking him to click it. 

Whenever a user logs in, spring security would generate a session id and this session id would be stored on the browser in the form of a cookie. Attackers would gain access to this cookie when the user clicks on the malicious link and would perform update (POST / PUT) operations using this cookie.