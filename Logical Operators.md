


# Notes  
  
  
  
## Slide one   
- is immutability exclusive to java  
  - it is a design pattern ,used universally across all programming languages. especially IN FUNCTIONAL PROGRAMMING, where objects are immutable by default  
  
- Money Class(Kaddy)  
  
  - show first 3 rules using `Money.java` (with the class)      
      - private   
      - no getter   
      - final fields  
  - use `Money1.java` as reference.  
  - ask a question to lead the explanation of having a `final` class.  
      - `based on this , there is no way to mutate the class why should we now make the class final?`  
      - show `BetterMoney.java`  
    - overhead of immutable objects garbage collection and all that  
      - show static  
      - show cache - `cache/Money.java` (sthembizo)  
      -  show that the two money  references are pointing to the same thing in memory   
      - jvm does string pooling for literals - logic is not part of string class but it is part of the JVM bytecode handling .  
        - typically in class loading.  
      - code to add:  
```java 
        System.out.println(System.identityHashCode(balance));  
	    System.out.println(System.identityHashCode(balance2));
	    System.out.println(balance == balance2);   
        System.out.println(balance2.hashCode());  
```

  
-  Deep Copying(sthembizo)  
  - show "exclusive-access" on the constructor  
    - `this.beneficiaries = new ArrayList<>(beneficiaries);`  
  - Use excalidraw for the example  
  - https://excalidraw.com/#json=LVG311Sl9vd5WzS19ao9Y,CUjXHcI2RZgI75dktUHvKg  
  - Code to Add  
  ```java

  public List<String> getBeneficiaries() {   
    return  new ArrayList<>(beneficiaries);  
    //return  Collections.unmodifiableList(beneficiaries);    // makes sure it provides a read only of a list  
     }   
  


List<String> beneficiaries2 = obj.getBeneficiaries();        beneficiaries2.add("sthembizo");        System.out.println(beneficiaries2);        System.out.println(obj.getBeneficiaries());// damn!  
```    
  

- Thread safety by Kaddy  



Questions to kaddy

1. Programmers are often reluctant to use immutable objects, because we worry about the cost of creating a new object all the time compared,  to updating an object in place.. so why should we use immutablity?
