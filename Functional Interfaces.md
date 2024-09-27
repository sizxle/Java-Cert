

- Only has one abstract methods
- SAM(Single Abstract Method) rule
- it is recommended that all functional interfaces are annotated with `@FunctionalInterface`
	- used to communicate the intention of the interface
	- allow compiler to generate an error if annotated interface does not satisfy the conditions
- functional interface can have multiple default methods but only allowed one abstract method

###### Note
- java has default methods that can were introduced in java 8 
	- before interfaces could only have abstract methods
	- now they can have default methods without affecting the classes implementing the interfaces
- Functional interfaces can have `static` and `default` methods.


## Four Interfaces 

- found in `java.util.fuctions.*`
1. Predicate
2. Consumer
3. Supplier
4. Comparator


### Predicate

- A function that receives a value and returns a boolean value
- used to test for something
- basically we don't need our own interfaces for this since it is provided in `java.util.function`
```java 
public interface Predicate<T>{
	boolean test(T t);
}
```
- Basically put this method on the method definition -> then you pass in a lambda

### Consumer

- A function that receives something but returns nothing '
- `void accept(T t)'
- use if you want to receive and not return just print
- `Consumer<String>  consumer = x -> System.out.println(x)`
- There a specialized version 
	- `DoubleConsumer`
	- `IntConsumer`
	- `LongConsumer`
	- The above takes primitive values as arguments
	- `BiConsumer` - one of its use cases is to travel through a map 


### Supplier

- T get()
- used to return something of type T 
- if you want to generate values
- `Supplier<Integer> supplier = x-> 42 `


### Comparator

- used for ordering objects even in user defined classes
- used also to compare objects of the same class
- `int compare(T obj1, T obj2);`
	- -1 = first object is greater
	- 0 = equal object 
	- 1 = second object is greater
	- 