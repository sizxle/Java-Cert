
# Chapter 5 : CORE JAVA API

- An API (Application Programming Interface)
	- interface refers to a group of classes or java interfaces- designed to give access to services or functionality

## Creating and Manipulating Strings

- `String` class- Fundamental class
- `String` - a sequence of characters

##### We create Strings in two ways:

1. `String name = "Sthembizo";`
2. `String name = new String("Sthembizo");`

- There is a subtle (little) difference - [[String Pool]]

### Concatenation

Rules for string concatenation and the `+` Operator.

1. If both operands are numeric , `+` means addition.
2. if either operands is a String, `+` means concatenation.
3. expressions are evaluated from left to right.


### [[ Immutability]] 
- An object cannot change once created .
- once a `String` object is created- it is not allowed to change
- mutable- means changeable

###### Note 
	 1. even if String class is immutable- it can be used in mutable classes
	 2. immutable classes in java are final - meaning they prevent a creation of subclass creation
		 - you dont want subclasses to add mutable behaviour


## String Methods

-  length()
	- return a number of characters in a String
	- `int length()`

- charAt()
	- return a character at a certain index or position
	- `char charAt(int index)`
	- `charAt()`   -   out of range throws an exception
				- `StringIndexOutOfBoundException`
- indexOf()
	- looks at characters in a string and returns the index of the first matching character
	- `int indexOf(char ch)`
	- takes both a `String` and a `char`
	- It can start looking from a certain position
	- returns `-1` if no match is found

#### Note
- char can be passed to an int parameter!!!!
```java
test(`f`); // this is valid
public void test(int k){
	System.out.println(k*2);
}
```
- There are other types of String Class 
	- e.g.
		- `StringLatin` and `StringUTF16`


- subString() 
	- Looks for characters in a string and returns part of the string
	- `String subString(int startIndex)`
	- `String subString(int startIndex, int endIndex)`
```java
String string = "animals";

string.substring(3,7); //mals
string.substring(3,8); //throws an exception 
```
	-basically we cant have endIndex be greater than lenth of the string

- toLowerCase() and toUpperCase()
	- one converts any upperCase to lowerCase.
	- one converts any lowerCase to upperCase.

- equals() and equalsIgnoreCase()
	- `equals()` -checks if two strings contain the same characters in the same order
	- `equalsIgnoreCase()` - checks if two strings contain the same characters in the same order with the exception that it will convert character case if needed

- StartsWith() and endWith() 
	- checks if the provided value matches part of the String
	- `boolean startWith(String prefix)`
	- `boolean endWith(String surfix)`
	- it is case sensitive.

- replace() 
	- does a search and replace in a string
	- one version takes a `char` and another takes a `characterSequence` (String)
	- it replaces all the matches it finds

- contains()
	- looks for matches in a string 
		- the matches could be anywhere in a string.
	- case sensitive 
	- [[String Vs CharacterSequence ]]

- trim() and strip() 
	- `trim()` - removes the whitespaces from the beginning and end of string.
		- white spaces = space, tab `/t` , newline `/n`
	- `strip()`- java 11 -does everything that trim does bur it supports `unicode`. 

- stripLeading() and stripTrailing()
	- `stripLeading()` - removes whitespaces from the beginning.
	- `stripTrailing()` - removes whitespaces from the end

- intern()
	- returns the value from [[String Pool]] if it is there otherwise it adds it to the string pool
	- `String intern()`

#### Method chaining 
- calling a method on top of another method.


## StringBuilder Class

- Provides a solution to the `String` class.

##### Problem
- `String` class is immutable and we create a lot of `String` Objects along the way .
- It is not efficient. 
#### Solution
- `StringBuilder` class
- creates a string without storing all the interim values
- `StringBuilder` is mutable


```java
StringBuilder name = new StringBuilder();// can pass in initial vaules e.g. "Sthembizo"
```

#### Note
- `StringBuffer` - works like `StringBuilder`
	- used to support threads.
	- `StringBuffer` - performs slower that `StringBuilder`
### Mutability and Chaining
- `StringBuilder`- it is not immutable. 
- chaining `StringBuiler` -> changes its own state and returns a `reference to itself`

### Creating a StringBuilder
- `StringBuilder name = new StringBuilder("Sthembizo");`
- we can pass in a number (int value). it tells java we know how many character spaces to reserve 
	- `if you exceed the reserved space , nothing is reported`


## StringBuilder Methods


- charAt()
- indexOf()
- length()
- subString()
	- the above methods are exactly the same as the ones in the `String class`. even their return type

- append()
	- adds character/ CharacterSequence to the end of the string and return a reference to the string Builder  
	- `StringBuilder append(String string)`
		- can take a character
		- they take different dataTypes

- insert()
	- add character at a requested index and returns a reference to the current `StringBuilder`
	- `StringBuilder insert(int offset, String string)`
		- offset - position where we insert the string 
	- We can insert from 0 to the StringBuilder max length
		- after that we get `StringIndexOutOfBoundsException`

- delete() and deleteCharAt() 
	- `delete()` 
		- opposite to `insert()` 
		- but can take more than max length of StringBuilder 
		- `StringBuilder delete(int start, int end)`
	- `deleteCharAt()`
		- removes char at a position
		- `StringBuilder deleteCharAt(int index)`

- replace() 
	- works different from the one in the `String` class.
	- `StringBuilder replace(int startIndex, int endIndex, String string)`

- reverse()
	- reverses the sequence of the characters in a string.
	- `StringBuilder reverse()`

- toString()
	- converts `StringBuilder` to a `String`
	- `String toString()`


### Understanding Equality 

- comparing `equals()`  and `==`
- `==`  checks if the references refer to the same object in memory
- `equals()`
	- it is a logical equality 

- `String` class has a defined equals method
	- if a class has no defined `equals()` method . Java checks whether the references are pointing to the same object.
- `StringBuilder` has no `equals()` method defined


### The [[String Pool]]


## Understanding Java Arrays

- `String` , `StringBuilder` - implemented using an array or characters
- `Array` - an area in memory on the heap with space for a designated number of elements
- `StringBuilder` - implemented as an array. an array is replaced with a bigger array Object when it runs out of space.
- Array can be of any `java Type`
- `String == char[] letters`. 
- Array
	- ordered list.
	- can have duplicates. 

### Array of primitive

- `int[] nums= new int[5];`
	- when using this form all elements are set to the default of the type, int get 0.
- another way of creating an array
	- `int[] nums = new int[]{1,2,3,4,5};`
	- it is equivalent to this
		- `int[] nums = {1,2,3,4,5}; //annoymous array`
###### Note
	- we can type array before and after the name 
		- int[] nums;
		- int nums[];


### Array of Reference

### Note
	- equals() comes with Object class. if not defined == is used
	- Java 5,  provided a method to print out an array. Arrays.toString(arrayName);


#### Using an Array

- `array.length` - gives one more than the max valid index.

#### Sorting
- java makes it easy to sort arrays - via sort()
- `Arrays.sort(passInArray)`
- Arrays -> in `java.util.*`
- Sorting `String` array
	- sorts in alphabetic order
	- Number before letters, Uppercase before lower case
- There are custom Sort orders called [[Comparator]]. 

#### Searching
- works only if an array is already sorted


### Binary Search

##### Rules
1. Target elements found in a sorted array- index of match
2. Target elements not found in the array- negative value- where it should have been and -1
3. unsorted array - A surprise (undefined./ cannot be determined)

- Unsorted array leads to unpredictable output 
- Binary search -> splits array into two until it finds the elements



### Comparing 

- method to compare two arrays and determine which is smaller
- `compare()` 
- `Arrays.comapare( array1 , array2 )`
	- arrays must be of the same type
	- Meaning of the return values
		1. Negative- first array is smaller than second one (`array1 < array2`)
		2. Zero- they are equal  (`array1 == array2`)
		3. Positive- first array is larger than second  (`array1 > array2`)
		
		4. If both array have the same `length` , and the same `values` in each spot, in the same `order`, returns `zero`.
		5. if all elements are the same but the second one has one extra element, it returns `negative` value
		6. if all elements are the same and the first one has on extra element, it returns `positive` value 
		
		7. if the first element that differs is smaller in the first array , returns `negative` value.
		8. if the first element that differs in smaller in the second array , returns `positive` value.
		
		#### These rules apply to compareTo() 
		
		9. null is smaller than other values
		10. for numbers - Numerical order applies
		11. for strings - one is smaller  if it is a prefix of the other
		12. for characters 
			-  numbers are smaller than letters
			-   uppercase is smaller than lowercase ....// please review these i sense a contrast 


### Mismatch()
- if array are equal, it returns -1
- or else returns the index of the first mismatch


### VARARGS
- variable arguments
```java
public static void main(String... args){}// varargs
```
- you can use a variable defined as `varargs` as if its a normal array
