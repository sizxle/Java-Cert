
# Chapter 6 : Lambdas and Functional Interfaces


- Programming abstractly through interfaces 


## Simple Lambdas

- anonymous functions -> functions without names
- Lambdas are basically  a function you can pass around like a variable
##### Functional Programming

- Java 8 - functional programming was introduced 
- A way of writing code more declarative 
	- you specify what you want to do more than dealing with the state of objects
- It uses lambda expression to write code
- Lambda expression -> a block of code that gets passed around
	- unnamed function 



###### Note 
- Traditionally 
	-  if we are calculating `age()` - we would have to create different types of calculations . You might have to define different subclasses or create multiple classes 


### Interfaces
- we use it to specify methods that our classes need to implement
```java
	public interface Animal{
	}
```
- Lambdas use a concept called Deferred execution 
- Deferred execution -> The code is specified now but will run later 


### Lambda Syntax

- `a -> a.canSwim();`  lambda syntax
- lambdas only work with interfaces that have only one abstract method.
- Java relies in context when figuring out what lambda expression mean 
	- e.g if you have a method we are passing the lambdas to 
		- Java checks the the `method signature`  , if it expects a Functional interface -> it maps the lambda to the functional interface

		- If , the method in the functional interface takes a `double` then the lambda takes a `double`
		- if  the method returns a `String` then the lambda also returns a  `String`

- Syntax -> both the following do the same thing 
	- `a -> a.canHop();`
	- `(Animal a ) -> {return a.canHop();}`

##### Note 
- Parentheses can be omitted if there is only one parameter an its type is not explicitly stated 
- You can omit braces on single statements and if omitted , no need for the return statement
- `s -> {}` this is a valid lambda



## [[Functional Interfaces]] 



## Variables in Lambdas

variables can appear in 
1. Parameter list
2. local variables
3. Variable reference from the lambda body

#### Parameter List 
- we can use `var`
	- `Predicate<String> p = (var x)-> true;`


#### Local Variables inside lambda Body

- can define variable in the body 
- Java does not allow you to create local variables with the same name as the one already declared in the scope

#### Variables Reference from lambda body 

- lambda body can reference code from surrounding code
	- can access
		- instance variables and class variables
		- method parameters
		- local variables
	- Method and local variables are allowed to be referenced only if they are `effectively final`
	- Effectively Final - the value never changes after being set


### Note 
- it is not wrong to assign a value to a non final variable, when a lambda tries to access it that is when the problem occurs 


## Calling API with Lambdas

- Methods that are used with lambdas


- `REMOVEIF()`
	- List and Set - have this method 
	- `removeIf()` - takes a predicate
	- `list.removeIf(s -> s.charAt(0)!= "s" )`

- `SORT()`
	- We can call `Collections.Sort(listName);`
	- but with lambdas we can call sort directly on the list
	- `list.sort((b1,b2)-> b1.compareTo(b2))`
	- note -> there is no sort on maps and set 

- `FOREACH()`
	-  Takes a consumer
	- `list.forEach(s -> System.out.println(s))`


###### Note
- We can define a set like this 
	- `Set<String> bunnies = Set.Of("long","short"); `
- To use the `forEach()` in Maps - we have to choose if we go through the keys or values 
	- e.g 
		- `bunnies.keySet().forEach( b -> sout(b) );`
		-  `bunnies.values().forEach( b -> sout(b) );`

- BiConsumer -functional interface that takes two parameters
	- it allows you to use `forEach()` with key/value pairs
	- `bunnies.forEach( (k,v) -> sout(k + v) );`

- 
