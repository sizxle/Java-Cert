
# Chapter 8 : Class Design

- Proper java class design is about reusability, functionality and standardization 
- Polymorphism - access to dynamic hierarchy that supports replacing method implementation


## Inheritance
- uses `extend` keyword
- a process whereby a subclass automatically includes any public or protected members of the class it it extending
- subclass- a class that inherits from others
- superclass - a class we inherit from

- inheritance is transitive
	- if `class x` inherits from `class y` that inherits from `class x` , then `x` is a subclass of `z`
	- `x` is a direct descendent of y 

- When you inherit
	- public and protected members are available to the child.
	- package -private are only available if they are in the same package as the parent
	- private are never available via inheritance. 

### Single vs Multiple inheritance

-  single inheritance - when a class inherits from one direct parent
- Java allows multiple levels of inheritances -> you could extend a class that also extents

- multiple inheritance
	- a class has more than one direct parent
	- java does not allow this type of inheritance 
	- java only allows multiple interfaces 
- Problem with multiple inheritance is that if a child implement the same member then which one will the child have [ Conflict ]
- `final` - prevents a class from being extended. if you try -> compilation error


### Inheriting Object 
- In java all classes inherit from `java.lang.Object`
- Object -> only class without a parent 
- How `Object` class gets automatically extended without specifying 
	- Java compiler automatically inserts code into any class you write that does not specifically extend any class
	
- Allows the class you are creating to have access to methods like toString() , equals that are in `Object` class
- `java.lang.Object` will always be on top of the inheritance structure
- Note 
	- use `javap` to view compiled class
	- primitives don't extend Object
	- Wrapper classes do inherit from Object 

#### Creating Classes

- extending a class 
	- `public abstract class DogSeal extends Seal{}`

##### Class access modifiers
- in java . top level class is a class not defined inside another class
	- They can only be `public` or `package-private
- public class can be refenced from anywhere
- package-private can only be refenced in the same package

- inner class - a class that is inside another class
	- Maybe be private or protected

- Java file - must have at most one public class or none


##### `this` Reference

- Java uses granular scope- basically the nearest scope
	- The fix to this is the keyword `this`
- `this`
	- refers to the current instance of a class
	- can be used to access members of this class including inherited members
	- Can be used in:
		- instance methods
		- constructors 
		- instance initializers
	- cannot be used without an implicit instance of  the class 
		- e.g. static method or static initilizer

##### `super` Reference 

- used to reference members in the parent class
	- CANNOT BE USED to access members of the current class
- in java we can have methods and variables with the same name in both child and parent class.


### Declaring Constructors

- no return type 
- must match the name of the class
- used to create new objects -> process is called instantiation 
	- `new Human();`
- when java sees `new` java allocates memory for a new object

#### Creating a Constructor 

- constructor parameters can be of any valid class, array , primitive including generics
	- `var` is not valid
- A class can have multiple constructors
	- As long as the the method signatures are different 
	- this is called `method overloading`

##### Default Constructor

- every java class has it - whether you create it explicitly or not
	- If not, java will create one for you at compile time
- it is only created for you when no other constructor is present
- use `this()` - to called overloaded constructor
- note
	```java
	public Human(int age){
		new Human(age,"sthembizo");// creates two objects so wrong
	}
	// soultion is to use this() if there this the overloaded method
```
	- if you choose to call this() - it must be the first statement in the constructor
	- there can only be one `this()` in a constructor

##### Rule for overloading Constructor

```java
public House(int num){
	this(num); // does not compile -it is recussive
}
```
- call parent classes constructor with `super()`
- in java constructors the first statement is either `this()` or `super()`

##### `super` vs `super()`

- super - used reference members of the parent class
- super() - calls the constructor of the parent class.

### Compiler enhancements

- First line of constructor calls `this()` or `super()`
- compiler calls super() if you don't call this() or super() explicitly
- Note
	- if a class only have private constructors - we can extend it but only inner classes extending it can access its private constructors and call super()
	- other top level classes cannot extend it

#### Default Constructor
- has no arguments
- compiler adds it for you if you do not have any constructor in a class
- Note
	- child classes may need to explicitly have a default constructor and calls super explicitly -> if the parents constructor is not the default one


#### Constructors and final fields

- `final static` variables
	- must be assigned a value once
		1. line of declaration 
		2. static initializer
		3. Constructor
	- By the time the constructor finishes running, all final values must be assigned.
- Note
	- local final variables are not required to have a value unless they are used.
	- final instance variable must have a value
	- `final` variables - > they don't get default values


## Order of Initialization

### Class initialization

- involves invoking static members in a class hierarchy 
- called class loading
- class is loaded before it is used -> JVM controls when a class is loaded.


- Initialize class `X`
	1. if there is a super class `Y` of `X` , then we initialize `Y` first
	2. process all the static variables in the order that they appear
	3. process all the static initializers in the order that they appear

- instance initialization
	- use keyword `new`
	- starts at the lowest constructor where `new` is used

- Initializing instance of class `X`
		1. If there is a super class `Y` of `X`, initialize the instance of `Y` first
		2. process all the instance variables in the order they occur
		3. process all instance initializers in order they appear
		4. Initialize the constructor including overloaded constructors



## Inheriting Members


- Java allows replacing or overriding parent methods implementation at run time
### Calling Inherited Members

- Java class may use any public or protected members of a parent class( Methods, variables , object references)
	- if child and parent class are part of the same package we can access package-private members too
- Note
	- we can use `this` to access members of the current class and parent class
	- `super` used for visible members of the parent class


### Inheriting Methods

- This sets a stage for conflict from methods in child and parent 

#### Overriding a Method

- If a method defined in both child and parent class have the same signature
	- solution override the method
- Overriding 
	- when a child class defines a new implementation for an inherited method -> with the same signature and compatible return type


##### Rules to override the Method

1. Method in the child must have the same signature as the one in the parent
2. Method in the child must at least be as accessible as the one in the parent
3. child method must not declare a checked exception that is new or broadens that was defined on the parent
4. if a method returns a value, it must be the same or the subtype of the parent methods return type. 
	- Know as covariant return Type


### subtype vs supertype

- if `X` is a subtype of `Y`
	- X and Y are classes, X is a subclass of Y
	- X and Y are interfaces, X is a sub interface of Y
	- X is a class and Y is an interface -> X implements Y


##### Overload Vs Override

- overload -> same name different parameters

- if a method is public on the parent class but it is overridden and set to private in the child class, Then calling it cause ambiguity 
	- Java avoids this -> by making sure the overridden members are as accessible or more accessible than the one from the parent class

- Covariant Type
	- given inherited type A, and overridden type B, We can assign instance of B to A without casting 


##### Overriding a generic method 

- Review of overloading a generic method 
	- Note
		- we cannot overload a generic method by changing the generic type  because of type erasure
		- we cannot overload generic methods in the parent method because of the same type erasure

##### Generic Method parameters

- You can override methods with generic parameters
	- But the signature should match, including the generic type

- GENRICS AND WILDCARDS
	- Java supports generic wildcards using question mark `?`
```java
	List<?> v;
	List<? super String> v; // lower bound wildcard
	List<? extends String> v; // upper bound wildcard
```


#### Generic Return type

- overridden methods that return generics - the return type must be a covariant

- in terms of generics, this means that the return type of the class or interface declared in the overriding method must be a subtype of a class defined in the parent class
	- Note whatever is inside the angle bracket must remain the same `<Reamin THe same>`
- Note
	- Generic type parameter must match
	- make sure generic type match for overridden methods
	- generics methods cannot be overloaded by change generic parameter type


##### Redeclaring private Methods

- you cannot override private methods
- Java permits you to redeclare the same method in the child
	- This is a separate and independent method from the one in the parent


##### Hiding Static Methods

- hidden static method
	- when the child class defines a static method with the same signature as the inherited static method in the parent 
- Method hiding - is similar to method overriding
	- all overriding rules must be followed 
	- there is One additional rule
		- 5. method in the child must be marked as static if it is static in the parent
- if one is marked static and the other one is not -> class will not compile


##### Final Methods

- `final` methods cannot be replaced/ overridden 
- Note
	- `final` can be used but the the cost of limiting polymorphism

### Hiding VARIABLES

- Java doesn't allow variables to be overridden but they can be hidden
- `a hidden variable` - when a child defined variables with the same name as  the inherited ones.
- This creates two distinct copies of the variable with an instance of the child class.


## Polymorphism 

- property of an object to take different forms
	- Java Object may be accessed using a reference with the same type as the object.
		- A reference that is a superclass of the object or reference that defines an interface that defines an interface the object implements directly or through a superclass.
- Note
	-  A cast is not needed if the object is being re-assigned to a super type or interface the object implements



### Interface 

- Can define abstract methods 
- A class can implement any number of interfaces 
- A class implements an interface by providing implementation for the abstract methods.
- An Object that implements an interface can be re-assigned to a reference of that interface

- Note
	- **Once an object is assigned to a reference type . only the methods and variables available to that type are callable on the object **


### Object Vs Reference 

- In java, all objects are accessed via a reference

- `Human man = new Human("Tshiamo");`
- `Object manAsObject= man;`

- without an explicit cast, we can not get access to methods on human class via `ManAsObject 


##### Rules
1. Type of object - determines which properties exist within the object in memory
2. Type of Reference - determines which properties are accessible to a java program


### Casting Object

- casting back to specific subclass of an object allows you to access some propeties
```java
	Primate primate = new Human(); // implicit cast
	Human man= primate; // doesnt compile

	Human man = (Human)primate;
```


- Note
	- When you cast - cast with compactible types or you will get `classCasrException` at runtime.
##### Rules of casting

1. Casting a reference from a subtype to a supertype, you do not need to explicitly cast 
2. Casting from a supertype to a subtype needs explicit casting
3. Compiler disallows casts to unrelated types/classes
4. At runtime, an invalid cast of a reference to an unrelated type results in a classCastException being thrown 

- Classes must be related through class hierarchy - for them to be related one must be a subtype of the other.

Note
- compiler can enforce rules for casting to unrelated classes But it cannot do this for **interfaces**
- Just because classes are related to each other through class hierarchy doesn't mean one can automatically be casted to another

#### instanceOf  Operator

- Helps prevent `classCastException` at runtime
- Compiler doesn't allow instanceOf operator to be used with unrelated types


### Polymorphism and method overriding 

- polymorphism in java , states that when a type overrides a method , you replace all calls to it - even those in the parent class
- `final` limits polymorphic behaviour


#### Overriding vs Hiding Members

- static method and variable hiding does not replace
- hiding method and variables is not form of polymorphism

- Method and variable hiding is sensitive to reference type and location where the member is being used

- using instance variables to access static variables/method is discouraged
- Besides location, reference type also plays a role in the value you get when working with hidden members

- since static members can only be hidden , Java uses reference type to determine which value is being used 

- DO NOT HIDE MEMBERS IN PRACTICE 

# Important thing to remember

- `new` - makes a new object

- overloading same name different signatures
	- can have different return types
- Overriding and hidden- same signature (name and parameters)
	- Must have covariant return types

- if a method is private on the parent the child cannot inherit it
	- the child can define a method with the same name and it will compile

- instance variables with the same name as the inherited instance variables are hidden not overridden

- if inherited method returns void then overridden method must also return void

- A valid override of a method with generic arguments must have a return type that is covariant - with matching generic type

- var cannot be used in a constructor

- a valid override of a method with generic arguments must have have the same signature with the generic type

- variables can be hidden not overridden
