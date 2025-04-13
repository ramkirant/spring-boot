# Aspect Oriented Programming

Aspect Oriented Programming is a programming paradigm where the cross-cutting concerns are separated from the business logic. 

1. Aspect Oriented Programming allows us to code business logic and cross-cutting concerns separately. 
2. We can link the cross-cutting concerns to the business logic either through XML files or through annotations. 

## AOP Terminologies

* Aspect

    Aspect is the specification containing rules and guidelines to implement the non-functional services.


* Advice

    The actual non-functional service whose implementation is controlled by the Aspect is called Advice.


* Join point

    Possible positions in the business methods where advices can be applied.


* Pointcut

    The XML or annotation based entry that linked advice with joinpoint.


* Advisor

    Advice + Pointcut together is called the Advisor.


* wiring

    Configuring bean properties for dependency injection is called wiring.


* Weaving

    Applying non-functional requirements on spring bean class through aspect oriented programming is called weaving. 
  Spring AOP, AspectJ supports only method level weaving. 
  They do not support field level weaving. 


* Target object

    Target objects are Spring Bean class objects on which we are planning to apply advices are called Target Object or 
  Target beans.


* Proxy object

    Proxy objects are Spring Bean class objects on which advices are already applied are called Proxy objects.
  Proxy Object gets created when a business method is mixed with advice.

## Types of advices
There are four types of advices. 

* Before Advice:

  Before Advice executes at the beginning of a method execution

* After Returning Advice:

  This advice gets executed after the method gets executed normally without throwing any exceptions. 

* After Throwing Advice:

  This advice gets executed after the method exits by throwing an exception. 

* After Finally Advice: 

  This advice gets executed regardless of the method getting executed normally or by throwing an exception. 

* Around Advice: @Around

  Around Advice gets executed at both the beginning and end of the business method. 
This advice gets executed in two parts. 
One part gets executed at the start of the business method, and another part 
gets executed at the end of the business method.

## Dependencies to be added for AOP in spring boot
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```

## Pointcut expressions

| Description                                                             | Expression                                |
|-------------------------------------------------------------------------|-------------------------------------------|
| Execution of any public method                                          | execution(public * *(..))                 |
| Execution of any method with the name beginning with set                | execution(* set*(..))                     |
| Execution of any method defined by the AccountService interface         | execution(* com.xyz.AccountService.*(..)) |
| Execution of any method defined in the service package                  | execution(* com.xyz.service.*.*(..))      |
| Execution of any method defined in the service package or a sub package | execution(* com.xyz.service..*.*(..))     |

## Spring AOP is Proxy Based
Spring AOP is proxy-based. It means that Spring uses proxy objects to implement aspect-oriented programming features.

What is a proxy?
A Proxy is an object that acts as a substitute to another object. 
In the context of Spring AOP, the proxy intercepts the 
calls to the target object (the actual object on whose methods we want to implement AOP).

This proxy creation may happen in two ways:

* JDK Dynamic Proxies
  
  These are used when the target object implements one or more interfaces. 
The proxy will implement the same interfaces 
and delegate the calls to the actual object.

* CGLIB Proxy

  CGLIB proxies are used if our target object doesn't implement any interfaces. 
Spring uses CGLIB to create a subclass of the target object. 
This allows the proxy to override the methods of the target class.   

## Limitations of Spring AOP
* Spring AOP relies on proxies. 
It cannot intercept calls to private methods or calls made within the same class. 
This is because the proxy only intercepts calls made through the interface or the public methods of the class.

* Spring AOP may introduce an overhead due to proxy creations and method interceptions.

* Spring AOP supports only method execution join points for Spring beans. 
