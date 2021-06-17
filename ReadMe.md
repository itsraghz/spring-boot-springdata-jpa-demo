# Spring Data JPA Demo using Spring Boot

This is a sample project to demonstrate the friendly and insightful
tutorial by the Intellij IDEA Team - *Dalia*. 

URL: https://www.jetbrains.com/idea/guide/tutorials/getting-started-spring-data-jpa/introduction/

# V2 - Multiple Instances with different Orders

Used 3 different instances of `CommandLineRunner` as follows, 
with a mutual exclusive combination of `Order` Annotation OR the `Ordered` Interface
to verify the orderly execution of the Runners.

* `CheckDataRunner` / `CheckDataRunnerWithOrder` - to verify the data at first
* `LoadDataRunner` / `LoadDataRunnerWithOrder` - to conditionally load the data 
* `FetchDataRunner` / `FetchDataRunnerWithOrder` - to fetch the data using a `Custom Query`

> The class with a suffix `WithOrder` uses the `@Order` Annotation 
> at a class level to specify the order of execution of each class.

