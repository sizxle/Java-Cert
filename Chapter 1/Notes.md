# Chapter 1

## JDK- java development kit

 - Contains the minimum software to do java development
 - Javac(compiler), java(launcher), jar(Archiver)
 - 

## Javac (Compiler)

- The compiler turns java files into a dot class file, called bytecode
- JVM( Java Virtual Machine)- launched by java
- JVM runs the bytecode on your machine


## BENEFITS OF JAVA

    - OO (Object oriented )- code is defined in classes- java allows for procedural programming within a class
    - Encapsulation - protects data from unintended access or modification
    - Platform independent - allows for sharing of the compiled piece of code easily
    - Robust - does its  own memory management - prevents data leaks
    - Simple -
      Secure - java code runs inside the JVM- basically a sandbox. Makes it hard for it to do evil things to the computer it is running on.
    - MultiThreaded
    - Backward compatibility
    - (SPERM OBS)

## Java Classes

- Classes are the main building blocks
- An object is a runtime instance of a class in memory .
- Objects define the state of your programme


## MAIN() METHOD

- Needed by the jvm to start the program
- the only reason we need the class structure is because the language requires it.

### How to Compile & Run java code
  ```java
  javac Zoo.java
  ```

 ```java
  java Zoo
 ```


## Rules for Java files

- can only contain one public class
- filename must match the class name, case sensitive

### PSV Main()
  - access modifiers -> they declare the level of exposure for methods or fields to potential callers
  - static binds the main method to the class -> basically the main belong to the class not the instance of the class(object)
    - it also allows for the main to be called by the class ```java  Zoo.main()```
    - if the main is not there, programme will throw an error and terminate
    - if the main is not static it will throw an exception
    - non static main() is invincible to the JVM
  - void
    - return type
    - good practice to use on methods that change objects state

  - String[] args , String args[], String... args
    - hints that there were arguments passed in when JVM started
    - ```bash [] ``` An array is a fixed-size list of items that are all of the same type.
    - ... these are VarArgs(variable argument lists).
    - we can use any variable name we want


## Passing Parameters to a java program

  - Basically pass parameter to the main method, via command line
  - after compiling 
  - ```bash java Zoo firstArg SecondArd ```
  - ```bash java Zoo "firstArg World" SecondArd ```
  - command line arguments are treated as String objects


Note. 
 - Java class files runs on any machine that has java. Doesn't matter which machine or operating system complied the file
 - from java 11 we can run a file without explicitly compiling first
 - ```bash 
  java SingleLineRun.java argumentsHere ```
 - called launching **single-file source-code** programs , can only be used if your programm is one file
      - Can only import code that come with the **JDK** with single line command


### In-Memory compilation
 - This basically means that the java complier is being used internally to check for errors e.g like how IDE
 check for errors without having us explicitly compile the file
 - no class file is created from this 


## Packages and Imports

  - packages are logical groupings for classes
  - java looks for code inside packages -/. import lines tell java(compiler) which package 
    to look in  for classes 
  - more detailed packages are called **child packages** example **com.yfg.order** -> this is a detailed package
  of **ygf.com**
  - packages rules- they are mostly letters or number separated by ( . ) an period 


## WildCards

  - ```java java.util.* ```
  - used to import all the classes in the packages.
  - It doesn’t import child packages,fields, or methods; it imports only classes.
  - using the wildcard doesn't affect code slow down execution. compiler can figure out what is needed

#### Note
  - ``` java.lang ``` package is automatically imported
  - Be careful of redundant imports - like importing a class in the same package
      - JAVA automatically looks in the package for other classes
  - if a classes can be found on multiple packages and they are both imported, this causes a compiler
  error. 
  - explicitly importing a class takes precedence over wildcards imports.
  - **If you really want to use both classes at the same time** -import the other one while you use the
  fully qualified class name of the other one.


###