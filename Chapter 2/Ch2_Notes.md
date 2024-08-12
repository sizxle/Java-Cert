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
- valid letters in java re not just engligh alphabets
- const static final -> written in snake_case.
- declaring multiple variables of the same type in the same statement is not allowed
- only legal when they share a type 