
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


## Multidimensional Arrays

- multiple array separators(`[]`) are all it takes to declare an array as a multidimension.
	- `int [][] var;`
	- `int var [][];`
	-  `int [] var[];`
		- note we can specify the size of the array if we want.
- while arrays seem to be rectangular in shape, an array doesn't need to be 
	- e.g.
		- `int [] [] nonRectangular={{1,2},{3},{4,5,6}};`
		- Asymmetric multidimensional array
	- Another way is only initializing is with just writing the first dimension


## ArrayList

##### Problem
-  you have to know the exact size of an array when creating it.
###### Solution
- ArrayList
	- can change capacity at runtime
	- `java.util.ArrayList;`

### Creating an ArrayList

- `ArrayList a = new ArrayList();`
	- can take in a numeric number
- slots are not assigned to anything or a list of anything 

 - [[Generics]] - allow you to specify the type of object `ArrayList` will contain
	 - `ArrayList<String> a = new ArrayList<String>()`
		 - you don't need the generic on the right side. java will just infer using the datatype on the left 
		- `<>` - called diamond operator

- `var list = new ArrayList<String>();`
	- `ArrayList` of String 
	
- `var list = new ArrayList<>();`
	- `ArrayList` of Object 


- `ArrayList` implements an interface called `List`.
- we can store `ArrayList` in a `List` reference.
- `List` is an interface and interfaces cannot be instantiated.
	- `new List<>();// does not work`


## ArrayList Methods

- `E` 
	- is not really a class
	- used by convention in generics to mean "any class that this `array` can hold"
- `toString()` method is implemented for `arrayList`


- add()
	- `boolean add(E element)` - always returns true
	- `void add(int index, E element)`
	- if an `ArrayList`  is not assigned a type we can add anything besides `primitives`
	- adding something that is not of the type is a `compile error`

- remove()
	- removes the first matching element it finds in the `ArrayList` or at a specific location(index) 
	- `boolean remove(Object object)`
	- `E remove(int index)`
		- trying to remove something that is not there returns false
		- an index that doesn't exist throws `IndexOutOfBoundsException`

- removeIf()
	- used in lambda expressions


- set()
	- changes an element in a `List` without affecting the size
	- `E set (int index, E newElement)`
		- `E` that is returned is the replaced element
		- trying to change index that is not there throws an `IndexOutOfBounds`

- isEmpty()
	- `boolean isEmpty()`
		- checks if there are elements in the list

- size()
	- `int size()`
		- returns number of elements in a list

- clear()
	- discards all the elements in the ArrayList
	- `void clear()`

- contains()
	- checks if a certain value is in an `ArrayList`
	- `boolean conatains(Object obj)`
		- this method calls `equals()` on each element of the `ArrayList` to see whether there are any matches

- equals()
	- `ArrayList` has a custom implementation of `equals()`
	- `boolean equals(Object object)`



## Wrapper classes 

- each primitive has a wrapper class
	- e.g.
		- `Boolean.valueOf(true)`
		- `Byte.valueOf((byte)1)`
- Wrapper classes have constructors, but `valueOf()` method is more recommended to create instance of them. it has object caching like `String` has `string pool` 
- Wrapper classes are not immutable
- They have methods to convert back to `primitives`

- There are also methods for converting a string to a `primitive` or `a wrapper class`
	- Parse methods
		- e.g.
			- `int i = Integer.parseInt("123");`
		- parse methods return a primitive
	- if the string passed is not valid for a given type then java throws an exception


	##### Note 
		- Character class has no parse method or valueOf(). when it comes to strings


### Creating primitive or Wrapper class from String 

- Boolean
	- `Boolean.parseBoolean("true")`// returns primitive
	- `Boolean.valueOf("false")`// returns a wrapper class
- Double
	- `Double.parseDouble("1")`
	- `Double.valueOf("1.3")`


### Autoboxing and Unboxing

- Autoboxing - passing a primitive and java converts it to a wrapper class for you 
- unboxing - does the opposite of autoboxing.
- Note
	- unboxing null - gives a `nullPointerException`
	- calling a method on null returns a `nullPointerException`



### Converting between Array and List 

#### ArrayList to Array
- `listName.toArray()` 
- `toArray()` returns  `Object[]` an array of objects
	- to make it return a specific type `toArray(new String[0])`


#### Array to ArrayList

- There are two methods to do this
	- they do not guarantee that you will get an `ArrayList`


1. Option 1: `Arrays.asList(arrayName)`
	- creates a List linked to the original array
	- when change is made to one it reflects on another
	- gives ,Fixed size `List` and known as backed list because it changes with the array
	- use `Arrays.asList(arrayName); // returns a List`
	- `remove()` will cause exception `UnsupportedOperationException`
		- we are not allowed to temper with the `size`
2. Option 2 : `List.of(arrayName)`
	- creates an immutable list
	- cannot change value and the size of the list after.
	- changes to the `Array` will not reflect on the `List`


### Using VARARGS to create a List

- Varargs - allow you to create Lists in a cool way
- `List<String> list =  Arrays.asList("one","two")`
- `List<String> list =  List.of("one","two")`
	- both creates a fixed size list
- To add or remove, create `ArrayList` via constructor 


#### Sorting
- same as array 
	- just different helper class
	- `Collection.sort(NameOfList)`


### Creating Sets and Maps


#### Sets

- a collection that cannot contain duplicates
- it is not ordered , so does not need indexes

- `boolean add(E element)`
	- it returns a boolean because of sets
		- when trying to insert a value that is inside a set it returns `false`
- Two classes that implement Sets
	1. HashSet (common)
	2. TreeSet (when sorting is important)
- `Set<Integer> set = new HashSet<>()`


#### Maps

- uses a key to identify values `key-value` pairs
- HashMap - common implementation of map.

##### Methods for maps


- `V get(Object key)`
	- returns value mapped to the key or `null`

- `V getOrDefault(Object key, V other)`
	- returns the mapped value to the key or returns other;
- `V put(K key, V value)`
	- adds or replaces key/value pair
	- returns `previous` value or `null`
- `V remove(Object key)`
	- removes and returns value mapped to key 
	- if no value is available return null
- `boolean conatainsKey(Object key)`
	- checks if key is present in the map
- `boolean containsValue(Object value)`
	- checks if value exist in the map
- `Set<V> keySet()`
	- returns a set of keys of the map
- `Collection<V> values()`
	- returns collection of all values.

MATH API

- `max()` an `min()`
	- return the larger / smallest of the two
- round
	- gets rid of decimals
	- `0.5` or higher -> Round up
	
	- returns a long for doubles
	- `long round(double num)`
	
	- returns int for floats
	- `int round(float num)`
- pow()
	- exponents
	- `double power(double num, double exp)`

- Random()
	- returns a value greater or  equals to zero . but less than 1
	- `double Random()`

