
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
