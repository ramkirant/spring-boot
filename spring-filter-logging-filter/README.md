# Filters

Filters are spring boot are components that intercept the http requests and responses, which allows us to perform 
operations before or after a request is processed by the controller.

## Key Features of Filters

* Interception

    Filters intercept requests and responses, enabling us to perform operations at various points in the request 
processing lifecycle.


* Order of execution

    Filters can be custom ordered which provides us greater control in their execution.


* Access to Request and Response

    Filters have access to HttpServletRequest and HttpServletResponse objects enabling us to read request parameters, 
headers, and response. 
  * We can use filters to modify the request body. This is very helpful to 
    * Validate the request
    * Transform data formats
    * Add or remove fields
  * We can use filters to add or modify the request headers. This is very helpful to 
    * Add authentication tokens
    * Set custom headers for specific requests
    * Modify existing headers.
  * We can use filters to modify the response body. This is very helpful to
    * Add or remove fields
    * Transform data formats
    * Customize error response
  * We can use filters to modify the response headers. This is very helpful to
    * Set caching headers
    * Add custom headers for specific responses
    * Modify existing headers

## Configure a Spring Boot Filter

There are three ways in which we can configure a Spring Boot Filter

* Using Java configuration by implementing the Filter interface. Here, we create a filter and register it in our 
configuration class. 
* Using Servlet annotations like @WebFilter
* Registering filters in application.properties or application.yml files. 

## Overhead introduced by Filters

Yes. Filters in Spring Boot do introduce an overhead but generally, they have less overhead compared to other mechanisms 
like Spring AOP. This is because they operate at the Servlet container level. However, the extent of this overhead 
depends on multiple factors including the complexity of the filter logic and the number of filters applied. 

Factors contributing to the overhead

* Processing Time 

    If the filter performs heavy computations or I/O operations, it can significantly increase the overhead. 


* Filter Logic

    Overhead also increases with the complexity of the filter logic. We need to keep the filter logic as simple as 
possible to reduce the overhead.


* Number of Filters
    Every additional filter adds to the overhead. 

### Methods to reduce the Filter Overhead

* Optimize Filter Logic
* Reduce the number of filters
* Use conditional logic
* Asynchronous Processing
* Profile and Monitor

## Filter Execution Order

We can specify the order of execution of filters by using the @Order annotation. If no order is specified, filters get
executed in the order they are registered. Usually, pre-defined filters get executed before the custom filters we 
introduce.

### Does creating a custom filter with order 1 execute it before the pre-defined filters?
It is not guaranteed for a custom filter with an order of 1 to be executed before the pre-defined filters. Spring Boot 
autoconfiguration might assign higher priorities to pre-defined filters even if we set our custom filter's order to 1. 

To ensure our custom filter gets executed before the pre-defined filters, we need to create the custom filter with 
HIGHEST_PRECEDENCE order

```java
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MyCustomFilter implements Filter {
    // Filter Logic
}
```
