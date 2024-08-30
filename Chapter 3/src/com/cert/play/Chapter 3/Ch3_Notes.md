# Chapter 3: [[Operators]]

Interesting example
```java
var results = (1==1) ? "1" :2;
```

## Java Operators

- Operator - a special symbol that is applied to a set of Variables, Values or literals
	- and returns a result
- Operand - refers to a value or variable the operator is being applied to.


# Type Of Operators

 1. Unary operator- one operand
 2. Binary operator- two operands
 3. ternary Operator- three operands

#### Note
	- java operators do not neccessarily go from left to right

## OPERATOR PRECEDENCE 

- Determining which operators are evaluated and the order in which the order is evaluated. This is referred to as operator precedence.
- Java closely follows the rules of Mathematics BODMAS
-  `(=)` has the lowest precedence
- `Note 
	- Unless overridden with parenthesis - java operators follow order of precedence
	- if operators have the same level of precedence- it is goes from left to right

| Operator names                     | symbols                       |
| ---------------------------------- | ----------------------------- |
| Post-unary Operator                | exp++, exp--                  |
| Pre-unary Operator                 | ++exp, --exp                  |
| Unary Operator                     | - , ! , ~, +, (type)          |
| Multiplication/ division / Modulus | * , / , %                     |
| Addition/ Subtraction              | + , -                         |
| Shift Operator                     | << , >> , >>>                 |
| Relational Operator                | < , > ,<= , >=, instanceof    |
| Equal to/ not Equals too           | ==, !=                        |
| Logical Operator                   | & , ^, \|                     |
| Short Circuit Logical              | && , \|\|                     |
| Ternary Operator                   | (boolean) ? option1: option2; |
| Assignment Operator                | =, += , -=, *=, /=, %=        |

### Unary Operator
- require one operand(variable) to work.
- ` !, +, -, ++, --, (type)`
```java
	int variable=80L++;
```
- the above does not work , we cannot apply operator to a literal or constant

### Logical Complement and Negation Operator

- logical Complement operator `!` , flips the value of a Boolean 
- Negation Operator `-` , reverses the sign of numeric expressions
- some operators  require a specific type of an operand.

##### Note
	- in java (false and 0) , (true and 1 ) are not related.

### Increment and Decrement Operators

- `++, --`
- Pre- increment/decrement Operator
	- when the operator is placed before the operand
	- Operator is applied first 
- Post- increment/decrement operator
	- operator is placed after the expression
	- original value is returned first and operator is applied after 


### Binary Arithmetic Operator 
- Two operands/ arguments
- used in mathematical operations on variables
- used to create logical expressions
- can combine to create complex expression with other binary operators

##### Note
	- only +, += may be applied to String values
	- String Concatenation

### Parenthesis
- The parts that you wrap in `( ) ` will override the order of precedence and evaluate what is in `( )` first .
- `[ ]` - in java they are not considered as parenthesis

### Division And Modulus Operators

- `%` remainder after division
- division results in the floor value of the int -> basically if `4.5`, `4.999` the answer will be `4`
- Modulus- not limited to integers, negative and floating points also  
##### Note
	- for p%y, for a given divisor y, modulus % result in a variable a value between 0 and (y-1) for postive dividends of p () 
	

### Numeric Promotion
- primitive numeric promotion

#### Rules
	1. if two values have tow dataTypes , java will automatically promote the value with the smaller dataType to the one with the larfer dataType
	2. if one of the value is an int and the other one is a floating point. java will promote int to a floating point value dataType
	3. Smaller(char, short, byte) dataTypes are firsted promoted to int. Anytime they are used with a java binary arithemetic operator. even if neither of the operator is an int . **Unary operators are exclued from this** 
	4. After all the promotions, the results keep the same dataType as the operands.


### Assignment Operator
- `=` binary operator that modifies
-  Java automatically promotes from smaller to larger datatypes.
-  Java throws a `Compiler` exception if it detects that you are converting from larger to smaller data Types without a casting.

#### CASTING VALUES
- casting is a unary operation
	- where one type is explicitly interpreted as another type
- Casting is unnecessary if you are converting from smaller to larger data types.
- Required for casting from larger to smaller data types
```java
int k = (int)44.5;
```


##### Note 
	- Casting is allowed on Objects/ References
	- No conversion is performed there - cast is allowed only if the underlying object is a member of a class
	- OVERFLOW AND UNDERFLOW
		- when a number is too large to be stored in as short - numeric overflow occurs 
	- overflow - when a number is big and can fit a numeric type-> it wraps around and start counting up
	- underflow - when a numeric number is too low to fit in a data Type 
		- e.g storing -200 in a byte field

### Compound Assignment Operator
- `+= , ==, *= , /= `
- The left side of the compound operator can be applied only to a variable that is already defined and cannot be used to declare a new variable ( it results in a compile error).
- Compound Operator-> save us from explicitly casting a value
- Compiler auto cast the results value to the datatype of the value on the left

##### Note
- Assignment operator return a value
	- e.g `int t=3;`
		- sets t to 3
		- returns 3 , also 

### Comparing Values

##### Equality Operators
- In Java there is a difference between
	1. Two objects are the same
	2. Two objects are equivalent 
	note. for java primitives there is no such distinction
- `== , !=` -> compare two operands and return a value


##### Note
	-Numeric values are promoted if they have different dataTypes
	- we can compare two boolean objects
	- can compare objects, e.g (null,String)
	- Pay close attention to dataTypes when you see an eqality operator
### Object  Comparison 

- equality operator is applied to the object reference and not the object itself
- Two references are `equal, if and only if` - they point to the same object or both to null.

##### Note
```java
null==null //true , comparing nukk ub java works 
```
	

### Relational Operators

- used to compare two operands and returns a Boolean
- `<, <= , > , >=, a instanceof b`

##### InstanceOf Operator
- returns a boolean
- useful to determine whether an object  is a member of a particular class or interface
- all classes inherit from `java.lang.object`
	- all objects can be assigned to an objects
	- e.g`newClass a= new newClass()`
		-`Object b= a`
- Calling instance of on a `null object` or `reference `results to false always.
- If null is used on the right of insatanceOf - we will get compiler error

##### Note
	- Polymorphism come into use when you create a method that takes a dataType with many possible subClasses
	- it is good practice to use instanceOf togther with casting
```java 
Number time = Integer.valueOf(6);

if(time instaceOf String){

}
```
	- the code above will fail- inompleriable type
	- compilation error
	- this applies for classes but not interfaces.

### [[Logical Operators]]
- `&, | , ^- Exclusive OR`
- apply to both numeric and Boolean
- when applied to a Boolean -> logical  operator 
				Numeric	-> bitwise operators. -> they do bitwise comparison on the bill that make up a number

### Short circuit
- `&&, ||`
- the difference from the logical operators  -i that the right hand may never get evaluated
-  `AVOID nullPointerException`
	- short circuit maybe helpful here
```java
if(human != null & human.getName()){
// might throw a null pointer
}
```

### Checking for unperformed side
- short circuit behaviour has side effects - if you modify variables on the right and it is never executed . we may get problems.

#### Making Decisions with the ternary Operators
- `(boolean) ? option1 : option2`
- known as ternary operator
- takes 3 operands

##### Note 
	- It is not a requirement that the options has the same dateType.
	- But if used with = there will be issues.