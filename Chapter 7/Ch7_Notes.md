
# Chapter 7 : Methods And Encapsulation 

## Designing Methods

```java
public final void nap(int min) throws Exception{}
```
- basic method
- Method declaration - specify  information needed to call a  method
- Method signature = parameter list + method name


## Access Modifiers

1. `private` - methods/variables can only be accessed from the class that they are defined.
2. `default(package-private)` -> methods/variables can be accessed by classes in the same package
3. `protected` - methods/variables are accessed by classes in the same package and the subclasses of the class
4. `public`  can be accessed from any class
- from (1) it is more restrictive ,to (4) which is less restrictive