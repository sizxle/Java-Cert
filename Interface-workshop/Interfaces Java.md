
# What is an interface?

- abstract reference type used as a blue print for classes.​​ 

## Purpose

- Provides a way to achieve abstraction and multiple inheritance

	- abstraction
		- it is about hiding away the details of how something works
		- users of the class don't need to know about the implementation of the class. They interact with the class through the public interface
		
	- multiple inheritance
		- when a child can inherit from multiple parents

	- We also get polymorphism


# Anatomy Of Interfaces


- Can have no state and fields.
	- this is called a marker interface
	- Common Java Marker 
		- SERIALIZABLE :  Marks a class as capable of being serialized
	- annotations are more used now than marker interfaces

S3 CODE



# Interfaces

- No state
	- removes the confusion of which state it will inherit 
	- state is one of the reason classes don't have multiple inheritance
	- other languages like c++, solved this , java choose to disallow it 
	- EXAMPLE CODE



# Java 8+

- static method on interfaces are not inherited
	- because of multiple inheritance , Java cant figure out which interface the merhod belongs to 
	- It can figure this out for constants if you are only implemnting one interface
# Discussion

- why doesn't java solve mutiple in habtabce for class like it did for interfaces 