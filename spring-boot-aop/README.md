# Aspect Oriented Programming

Aspect Oriented Programming is a programming paradigm where the cross-cutting concerns are separated from the business logic. 

1. Aspect Oriented Programming allows us to code business logic and cross-cutting concerns separately. 
2. We can link the cross-cutting concerns to the business logic either through xml files or through annotations. 

## AOP Terminologies

* Aspect
Aspect is the specification containing rules and guidelines to implement the non functional services.

* Advice
The actual non functional service whose implementation is controlled by the Aspect is called an Advice.

* Join point
Possible positions in the business methods where advices can be applied.

* Pointcut
The XML or annotation based entry that linked advice with joinpoint.

* Advisor
Advice + Pointcut together is called the Advisor.

* wiring
Configuring bean properties for dependency injection is called wiring.

* Weaving
Applying non functional requirements on spring bean class through aspect oriented programming is called weaving. Spring AOP, AspectJ supports only method level weaving. They do not support field level weaving. 

* Target object
Spring Bean class object on which we are planning to apply advices are called Target Object or Target beans.

* Proxy object
Spring Bean class objects on which advices are already applied are called Proxy objects. Proxy Object gets created when a business method is mixed with advice.

## Types of advices
There are four types of advices. 

* Before Advice:
Executes at the beginning of a method execution

* After Advice:
Executes at the end of the business method.

* Throws Advice:
Executes when exception is raised in the business method.

* Around Advice:
Executes at both the beginning and end of the business method. This advice gets executed in two parts. One part gets executed at the start of the business method and another part gets executed at the end of the business method.

## Dependencies to be added for AOP in spring boot
```
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```


