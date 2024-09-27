
- Immutable `object` - an object whose state cannot changed once it is created.
	- The object is is effectively read only.


- Why would you want to create an immutable object?
	- it allow java to save space 
		- `String name= "chris"`
		- `String nameAgain= "chris"`
			- they point to the same object.
	- debugging is easier
		- mutable objects, bugs can arise from unpredictable state change anywhere(methods , in other classes) compared to immutable ones, errors can only occur on creation, when the state is being set. makes debugging easy.
	- Thread safety 
		- Because the state cannot be changed after creation. multiple threads can access the same object without the programmer  needing to synchronize access
	- easier to cache. (The process of creating and discarding new objects all the time is solved here)
		- Like how strings have a `string pool`.
		- We can create an object pool for our user defined Object. if they point to the same reference they might be the same


### Implementing Immutability  in Java

- have Private fields- prevents unwanted access
- no setter methods or any method that alters the state of the current object to prevent modification.
- final fields - ensure field only assigned once
	- making the fields final also prevents the returned unmodifiable by client code.(Why we need final); 
	- java inforce that 
- return defensive copies of mutable objects in getters
- Final class

- are primitives immutable?
	- in short yes. 
		- Primitives store values directly in memory




Structure of the presentation


Constructor 

