# Chapter 2 : Java Building blocks

- ```new ClassName()```, this is how we create a new object
- ```ClassName cn```, the type and  the reference to the object.

## Java Constructors
- Rules
    - Name must == Class Name
    - no return type
    - If no Constructor is provider by the programmer, java compiler will make a default constructor for you.
    

### Instance Initializer Blocks
    
- ```{ }``` == code block
- code blocks inside a method runs when a method is called..
- code blocks outside the methods are called **instance initializers**.```jar --create --verbose --file newFile.jar .```
### Order of initialization

- fields can be in multiple places
- order in which methods , constructors and blocks of code are initialized when an object is created.
    - Fields and instance initializers run in the order they appear on the code.
    - Constructor runs after
    - **answer this later, do they run after super is called or before**


## Java DataTypes

1. Primitive DataTypes
2. Reference DataTypes

#### Primitive DataTypes
- ```B B S I L F D C```
- ```  2**3 2**4 2**5 2**6 2**5 2**6 2**4```
- building blocks of java
- cannot be null
- not an object in java
- just a single value in memory

    ###### Shorts Vs Char
    - closely related-> both take 16 bit length
    - short - signed( can take negative)
    - char is unsigned

    2**8=256
 
    ##### Note
    - floating point in most  computer systems are stored as two values ```ax10^b```
    - number of bits is used by java to figure how much memory to allocate for the variable

### Reference Type

- Refers to the object(an instance of a class)
- unlike primitives, they don't hold a value in memory
- reference points to an object by storing the memory location of the object in memory
- Objects in Memory can only be access vis the reference


### Distinguish  between  primitivesTypes and referenceTypes

| Primitive | Reference |
| --------- | ----------|
| Small letter | begins with uppercase |
| Cant take null | can point to null |
| cannot call methods() | can call methods |


## Variables
- name for memory that store data
- Identifiers
    - Name of variable , method , class , interfaces or package

#### Four rules
    - Must begin with a letter, $ or _
    - can include a number but not at the beginning
    - A single underscore(_) is not allowed since java 9 
    - cannot use java reserved words- can play with case thought, since java is case sensitive

##### Note
- valid letters in java re not just english alphabets
- const static final -> written in snake_case.
- declaring multiple variables of the same type in the same statement is not allowed
- only legal when they share a type


### Initializing Variables
- some variables- depending on the dataType gets a default gets a default value.
- some need the programmer to set it. (local variables)
- Local variables do not get default values - they must be initialized before use
- ```Tip~ make sure variables are initiated before they are used```


## Instance and Class Variables

- Instance variable, belong to each instance of a class
- Class variables, belong to the class. all instances will share this variable
    - it has ```static``` keyword.
- They do not require Initialization because they get default values.
    - null for objects
    - 0/ false for primitives


## Introducing Var

- Java 10 feature.
- var - is used for local variables.
- var = local variable type inference.
- can be used in :
    - lambdas
    - functional interfaces
    - ```for``` loops
    - exceptions- int try with resource statements

#### Type Inference of Var

- compiler looks at where there ```var``` is declared and infer the type
    - initialization must happen on the same line
###### Note
    - var is still a type that is defined at compile time
    - cannot change the type at run time
    - var is not allowed in multiple variable declarations and method/constructor parameters
    - var is not a reserved key word- cab be used as an identifier. it is a reserved type name


### Scope
- Where variables exist

## Destroying Objects
- JVM automatically destroy objects that are not needed anymore.
    - via the  garbage collector
- In the JVM- there are a lot of processes that are running
    - these process are independent of our applications code. e.g garbage collector
- Java objects are stored in the programs **heap** also called free store.

### Garbage Collection
- process of automatically freeing up space on the heap by deleting objects that are no longer reachable in your program.

#### Eligible for Garbage Collection
- Make sure objects are marked for garbage collection.
- ```System.gc()``` helps support garbage collection
    - this command does not guarantee garbage collection- JVM is free to ignore the request

#### Tracing Eligibility 

- Objects remains in the heap until it is not reachable.
- ##### How an objects becomes unreachable
    - No reference pointing at it
    - All reference pointing to it goes out of scope

##### Note
    - References are the same size no matter thr type
    - it is the object that gets garbage collected not the reference.

### Finalize() Method
- this is deprecated
- java allows objects to implement this method
- garbage collector calls finalize() once
- finalize() runs  0 or 1 time only. IT CANNOT RUN TWICE