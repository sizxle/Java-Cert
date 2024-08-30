
# Chapter 4 : Making Decisions

## Decision making statements

- Java statement 
	- it is a complete unit of execution
- A single statement or a block of code functions as a target for decision making statements

### IF Statement
- executes a block of code under a certain conditions

### Else Statement
- executes the block of code if the condition in the if is false
- optional - it cannot exists alone

### Switch Statement
- its a decision making structure
```java
switch(variableToTest){
	case exp:
	//.......
	default:
	
}
```
- a single value is evaluated and flow is redirected to the first matching branch .

##### Switch dataTypes
- Before java5 , switch statements could only take primitives.
	##### switch statement support:
			- enum
			- int / Interger
			- short / Short
			- byte / Byte
			- String
			- char / Character
			- 
- Switch statements work with certain primitives  and their Wrapper Classes.
- [[Wrapper classes]]- objects that can store primitives
- Note 
	- boolean, long, float, double - theses primitives and their wrapper classes are excluded from switch statements.


#### Default
- we only go there when there is no matching case.


#### Acceptable Case Value
- At compile time- case values must be constants  of the same dataType as the switch value
	- Only Literals
	- Enum Constant
	- Final constant variables
- Switch statement support numeric promotion that does not require explicit Casting.

## Loops

- Repetitive Control structure
	- execute code multiple times in succession 
### While Loop Statement
- `{ }` braces are optional for single statements.
- may not execute at all or may execute a lot of times.

### Do/While Loop
- statement or block is executes at least once( one or more times).
```java
public static void main(String[] args){  
    int i=0;  
    do  
       System.out.println(i++);  
    while(i<5);  
}
```

### Infinite Loops
- Termination condition is never reached
- leads to:
	- Bad performance
	- Memory leak
	- Bad data
	- overflow execution

### For Loop
```java
for(initialization; boolean; update){

}
```
- `{ }` optional with single statements

##### Note 
	- initalization and update may contain multiple statements separated by commas
	- var can be used in for loops

### For Loop Edge Cases

1. Infinite Loop
```java
for(;;){}
```
- components of a for loop are optional

2. We can add multiple terms to the For Statement
```java
int x=0
for(int y=0, z=4; x<5 && y<10 ; x++,y++){

}
```

3. Redeclaring a variable in initialization 
```java
int x= 0
for(int x=4; x<5; x++){} //does not compile, because of a duplicate variable
```

4. Using incompatible dataTypes in initialization part of the For Statement
```java
int x=0
for(long y=0, int z=4;x<5;x++){}// does not compile incompatible dataType in the initialzation block
```

5. Using Loop variables outside
	- does not work, because they lose scope outside the loop


[ConcurrentModificationException](https://medium.com/javarevisited/4-essential-techniques-for-tackling-concurrency-fixing-the-concurrentmodificationexception-468d8e22b496)


## The For-Each Loop

- called, Enhanced For loop
- used to iterate over arrays and various collections
```java
for(dataTypeOfCollectionMember insatance : collection){

}
```

#### Right side of For each loop:
- Built in Java array
- any object that implements `java.lang.Iterable` interface
- arrays or collection of items - `Note` - not all collection frameworks classes or interfaces are included - they must also implement/extend `Collection` interface
	- e.g. 
		- Map is not included
		- String and StringBuilder - do not implement iterable

#### Left Side of the For each loop

- declaration for instance of a variable which is compatible with the `item` in the collection or the array.
- We can use keyword `var`
- use standard for loop for fine grained control


## Controlling flow with branching

#### Nested Loops
- a loop that contains another loop


## Optional Labels

- if , switch , while have optional labels
- `Label` -it is an `optional pointer` to the head of the statement- it is used to allow application flow to jump to it or break from it 
- It is a single Identifier followed by a colon `:`
	- e.g.
		- `OUTERLOOP:`
		- `INNERLOOP:`
	- it is useful in nested statements
###### note
	- check OPC textbook here

### Break Statements

- ends the loops ,"easy".
- transfer the flow control out of the enclosing statement;
- can be use with labels
```java
OPTIONALLABEL:while(booleanExpression){
	//body
	break OPTIONALLABEL;
}
```
- The break above can take optional label parameters, without the label - it will terminate the nearest inner loop

### Continue Statement
- it causes the flow to finish the execution of the current loop
- basically it is like a skip
- Continue statement transfer control to the boolean expression 
```java
OptionalLabel:while(booleanExpression){
	//body 
	continue optionalLabel;
	
}
```

- Continue is applied to the nearest inner loop- Optional Label statement override this behaviour

#### Return Statement

- Having statements after a return statement causes compilation failure