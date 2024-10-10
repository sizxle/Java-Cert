
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

#### OPTIONAL SPECIFIERS 

- We are allowed to have multiple specifiers
	- all not combinations are legal(allowed)
- They are optional- even without them it is fine


1.  `static` - makes methods/variables to belong to a class
2. `abstract` - used when the body of the method  is not provided
3. `final` - used to signal that method cannot be overridden 
4. `synchronized` - used in multi-thread programming
5. `native` - used when interacting with code written in another language
6. `strictfp` - used for making floating points calculation


##### Note
- Java allows optional specifiers to appear before the access modifiers
	- e.g
	- `final public void nap(){ }`

### Return Type

- Java types -> String , int , double
- if there is no return type use `void`
- Methods with the return type that is not void should have a `return` statement in the method body
	- the return statement must be a valid value
- void methods can have a return statement that is empty.

#### Method Name

- same as naming rules for variables
- letters , numbers, $ or_ are allowed
- By convention method names begin with lowercase

#### Parameter List

- requires `( )` - but doens't not have to contain parameters

#### Optional Exception List

- in code, we notify that something is wrong by throwing an exception 
- we can list as many types of exceptions
- separate by a comma ` , 


#### Method Body 

- code block ` { } `


#### Working with VARARGS

- variable arguments 
- must be the last element in the parameter list of a method
	- ONLY ONE VARARGS per method
- When passing to a method that takes varargs - you have a choice of passing an `array` or  a list of elements- > java creates this for you
- If you omit the varargs values in a method call - java will create an array of size 0 and pass it
- Java creates an empty array if you don't pass in values for varargs
	- We can still pass null explicitly 
- Accessing varargs is like accessing an array.


### Access Modifiers

- They impact members of a class
	- instance variables and instance methods

##### Private Access
- Only code in the same class can access private members of a class (private methods or private fields)
- Trying to access private methods/fields illegally -> compilation error
##### Package-private (Default)
- Only classes within the same package can access the members
##### Protected Access

- everything in private and protected access. with subclass
- same class + same package + subclass
- ability to access members of the parent class.
- Protected Rules
		1. Member is used without referring to a variable
			- takes advantage of inheritance 
		2. Member is used through a variable
			-  it is a subclass protected access is allowed
- refer to page 471 for the example


##### Public access

- 

## Applying static keyword

- can be applied to variables , methods , inner classes
- meaning it belong to the class rather than a specific instance 

### Static Methods and Fields

- static methods do not require an instance of a class to work
- JVM basically calls ClassName.main() -> because main is static 
##### Purpose of static methods
1. They work as utility or helper methods that do not require state. cant access instance methods
2. used for state that is shared across all instances of the class
	- Methods that use static should also be static 
	- note - static methods cannot access instance variables

### Accessing static methods and fields

- To access - use the className before the variable or method
	- `ClassName.method()`
- Note
	- We can use an instance of a class to call a static member
		- Compiler checks the type of the reference and uses that instead of the object 
```java
	// assume human has a count variable that is static
	Human h = new Human();	
	h.count= 0;
	h = null;
	System.out.printLn(h.count); // this still works because compiler turns this line to the following line
	System.out.printLn(Human.count);
```


### Static Vs Instance 

- a static member cannot access an instance member  without referencing an instance of a class
- STATIC does not require any instance of a class to exist.
- A static method can be called by both instance and static methods.
- Only instance method can call another instance method on the same class without using a reference 
	- instance methods require an instance

#### Static Variables

- we can initialize static variables on the line it is declared
- Static variables that re not meant to change use the keyword `final` - called constants

#### Static Initialization

- ` static { }` - static initializer block
- Runs when the class is loaded
- They run in the order in which they appear

#### Static Imports

- used for importing static members of a class.
- we are allowed to use wildcard or to import a specific member
- ` import static java.util.Array.asList;`
- Note
	- if there is a method we create that has the same name as the method we are inporting
		- Java gives the one we created higher precedence over the imported one
	- Importing two classes with the same name -> compilation error
		- you can use fully qualified names to bypass this
	- Importing two variables/ methods with the same name -> compilation error


### Passing Data Among Methods

- Java - is a `Pass By Value` - meaning copy of the variable is made and the method receives that copy
- calling methods on the reference can affect the caller


## Overloading Methods

- Method Overloading -> when you have methods with the same name but different method signatures  in the same class
	- different method parameters
- e.g.
	- `append()` -  StringBuilder class
	- `System.out.printLn()`
- Note
	- Everything besides the name can vary for overloaded methods
	- different access modifiers , specifiers , return type and exception list
	```java
	public void fly(int num){}
	public int fly(int num){}
	// this is not valid, because we have the same name with the same parameter list
```

#### VarArgs

- varargs = arrays
- so overloading wont work
```java
public void fly(int[] l){}
public void fly(int ...l){}
// this wont work
```

#### AutoBoxing

```java
public int sum(int m){}
public Integer sum(Integer m){}
// this will compile
```
- if you call `sum(2)` it will match the first one. if the first on was not there it would autobox 2 and use the second one

#### Reference Types

- Java picks the most specific type if overloaded methods are there, and the argument can fit in both

#### Primitives

- if passing  to a wider type java can help us -> if we are narrowing, it wont work -> we have to cast

#### Generics

- `public void walk(List<String> strings)`
- `public void walk(List<Integers> ints)`

- the above is not a valid overload. because of type erasure
- Java has [[Type erasure]]
	- it says Generics are only used at compile time
- compiled, it will look like this 
	- `public void walk(List strings){}`
	- `public void walk(List ints){}`

#### Arrays 
- arrays work fine - they do not participate in type erasure
```java
walk(int[] nums)
walk(Integer[] letters)
```

## Putting it all together

- when an overloaded method is called , the most specific one gets called
- when types interact -> java prioritizes backward compatibility 

- Order java uses to choose the right overloaded method
	1. Exact Match by type
	2. Larger Primitive Type
	3. Auto boxed Type
	4. Varargs

- as much as java does conventions, it will only do it once.
	- page 496 of the book for example look at it


#### Encapsulating Data

- Encapsulating means only methods in the class with the variables can refer to instance variables
	- callers are required to use the methods
	- basically lock access to instance variables
- Data ids private -> getter and setters are public

- For encapsulation , you don't have to use getters and setters as long as instance variables are private 
- Note
	- `var` is not a valid return type
