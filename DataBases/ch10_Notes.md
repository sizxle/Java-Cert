
# Chapter 10 :  Transaction Management and Concurrency Control


## Objectives
- Describe DB transaction management process
- identify four properties of transaction management
- Explain concurrency control and the role it play in data integrity
- Locking methods for concurrency control
- Stamping methods for concurrency control
- optimistic methods used for concurrency control
- List an explain ANSI levels of transaction isolation
- Describe the role of database recovery management in maintaining database integrity 


Database Transaction - are triggered by events (e.g. customer buys a product) .
All parts of a transaction must be be completed for it to be successful 

Main properties of transaction :
- atomicity
- consistency
- isolation
- durability
- serializability for concurrent transaction

### Transaction

- In DB, any action that reads from and writes to a database.
- Transactions are managed( controlled and executed) by the DBMS
- Transactions may be:
	- A simple `SELECT` statement
	- `UPDATE` statements
	- `INSERT` statements
	- a combination of the above


- Transactions meaning:
	- A logical unit of work that must be entirely completed or aborted.
	- A sequence of database requests that access the database

###### Note
- If any of the transaction fails, the entire transaction must be rolled back to the original state of the db that existed before the transaction was started.
- A successful transaction changes the db from one consistent db to another.


- Consistent Database State
	- one in which all `data integrity constraints` are satisfied.
	- to ensure a consistent db, every transaction must begin with the db in a consistent state.
	- inconsistent db , ruins integrity and violates business rules

- Database request
	- a single SQL statement in the transaction


##### Note
- `commit` statement used to end a transaction  successfully 

- If a transaction fails:
	- The DBMS will roll back the database to a previous consistent state 
- Although The DBMS is designed to recover a database to a previous consistent state
	- Make sure your transaction is semantically correct, DBMS cannot evaluate if the transaction is correct anyway
- Some DBMSs - provides means in which a user can define enforceable constraints based on business rules - other integrity rules are enforced automatically by the database e.g. primary key integrity rule


### Transaction Properties

- each individual transaction must display `atomicity, consistency, isolation and durability`
- Called `ACID` test

- Atomicity
	- requires that all `SQL` requests of a transaction to be completed
	- A Transaction is treated a single indivisible, logical unit of work. 
- Consistency
	- Basically shows the permanence of the databases consistent state
- ISOLATION
	- Means that no two transaction can use the same data at once.
	- If `T1` is using data `X`, Then no other transaction can access` X`
	- This is useful in multiuser database environments, since several users can access and update the database at once.
- Durability
	- make sure once the transaction is done and committed, it cannot be undone or lost


- This property apply when we have multiple transactions at the same time.
	- Serializability 
		- ensures that the schedule for the concurrent execution of the transactions yields consistent results
		- 


### Transaction Management with SQL

- ANSI- defined standards that governs SQL DB transactions
- Transaction support is provided by 2 SQL statements
	1. COMMIT
	2. ROLLBACK 
- ANSI wants a traction to run until:
	1. A `commit `statement is reached
	2. a `Rollback` statement is reached
	3. end of program successfully. equal to a `commit`
	4. Program ends abnormally, database changes are aborted and db is rolled back. equal to a `ROLLBACK` statement 


##### Note
- `COMMIT` statement is not necessary if the `UPDATE` statement is the applications last action. IT  is good programming practice to include it to signify end of transaction.
- A Transaction begins implicitly when the firs SQL statement is reached. But we can explicitly start a transaction by using `BEGIN TRANSACTION;`  OR in oracle `SET TRANSACTION;`  


### Transaction Log

- DBMSs uses a `Transaction log` to keep track of all the transaction that update the database.
	- information in the log is used as a recovery requirement triggered by `ROLLBACK` statement, abnormal termination or system failure
- Some RDBMSs uses the log to recover the database forward
- Transaction Log Stores:
	- a record for the beginning of the transaction
	- each transaction component(sql statements)
		- before and after values of fields being updated
		- pointer to the previous and next transaction log entries
	- The end of the transaction(`COMMIT`)


## Concurrency Control

- Basically coordinating simultaneous transactions. in a multiuser system
	- the purpose is to ensure serializability . 
- It is a DBMS feature
- Most concurrency control techniques are towards the isolation property.
- Concurrency control solves 3 main problems
	1. Lost Updates
	2. uncommitted data
			- When two transactions T1 and T2 are accessing the same data but T1 is rolled back while T2 has already accessed T1s uncommitted data. This breaks isolation property of transactions
	3. inconsistent retrievals


### The Scheduler

- Built in feature of the DBMS
- A special process that establish the order in which operations are executed within concurrent transaction
- The scheduler interleaves the execution of database operations to ensure serializability and isolation of transactions
- to determine the order. the scheduler depends on the algorithm of concurrency control
	- e.g. Time stamping or method locking 

- NOT ALL TRANSACTIONS ARE SERLIZABLE
	- DBMS determines which transactions are serializable
	- Transactionsa that re not serializable are exected on first come first server

- The scheduler’s main job is to create a serializable schedule of a transaction’s operations, in which the interleaved execution of the transactions (T1, T2, T3, etc.) yields the same results as if the transactions were executed in serial order (one after another). 
- it also makes sure the CPU and storage is used effectively 
###### Note
- if a transaction contains one sql statement , there is never an inconsistent state.
- but if more we have an unavoidable inconsistent state the bd has to move through. the inconsistent state is the consequence of the computer computing operations serially



### Concurrency Control with Locking Methods

- commonly used techniques in concurrency control. they facilitates isolation of data items used in concurrent transactions.
- A lock guarantees exclusive access to the transaction that has a lock.
- The use of locks based on the assumption that conflict between transactions is likely is referred to as `pessimistic locking` .
- Most DBMSs use locking procedures
- Lock Manger - it is resposibile for assigning and policing the locks used by the transactions.

#### Lock Granularity

- indicates the level of lock use.
- Locking can take place at different levels
	- database
	- table
	- page
	- row
	- field


- Database Level
	- entire database is locked
	- Good for batch processes, unsuitable for multiuser DBMSs

- Table Level
	- locks entire table
	- transaction can access the same database as long as they use different tables
	- also not suitable for multiuser DBMSs

- Page Level
	- Page- this is a disk block. this is addressable section of a disk
	- DBMSs locks entire diskpage
	- page has a fixed size, 
	- a table can span several pages, a page can conatin several rows of one or more table
	- Curretly the most used method for mutliuser DBMSs

- Row Level 
	- locks the entire row
	- its management is an overhead
	- Modern DBMSs automatically escalate a lock from a row level to a page level when the application session requests multiple locks on the same page.

- Field Level
	- Locks only a field(attribute)
	- most flexible for multiuser DBMSs
	- it is rarely implemented, it needs high level of computational overhead

### Lock Types

- regardless of the level of granularity, DBMSs use different lock types
	- Binary lock
	- shared /exclusive lock


- Binary Lock
	- has two states
		- locked and unlocked
	- each transaction requires a lock and unlock operation for each accessed data item. Operations are scheduled and managed by the DBMS.
	- DBMSs have default locking mechanisms . it can be overidden with the use of` LOCK TABLE ` command
	- Binary is considered too strict to achieve optiimal concurrency conditions


- Shared/Exclusive Lock
	
	- Exclusive Lock - access is reserved for transaction that locked the object
		- use when potential conflict exist 
		- issued on update
	- Shared Lock - when concurrent transactions are granted read access on a common lock
		- no conflicts as long as both transactions are read only 
		- issued on read and there is no exclusive lock on the data item
	- 3 states
		- unlocked
		- shared 
		- exclusive


## Shared Lock

- increases a lock mangers overhead . 
	- reasons
		- Type of lock held must be known before a lock is granted
		- 3 lock operations exists
			1. READ_LOCK - checks the type  of lock
			2. WRITE_LOCK - issue a lock
			3. UNLOCK  - release a lock
		- an upgrade from `shared` to `exclusive` , and a downgrade from exclusive to shared is allowed
		- The schedule might create a deadlock


### TWO PHASE LOCKING

- main purpose is to ensure serializability, but doesn't prevent deadlocks
- defines how transactions acquire and releases locks.
- The Phases
	1. A growing phase
		- here a transaction acquires all required locks without unlocking data.
		- Once all locks are acquired , transaction is in a locked state
	2. A shrinking phase
		- a transaction releases all the locks and cannot obtain a new lock 

- Note
	- two transactions cant have conflicting locks
	- no unlock operation can proceed a lock operation in the same transaction
	- No data is affected until all locks are acquired
- it increases transaction processing costs and can cause deadlocks

### Dead Locks

- when two transactions wait indefinitely for each other to unlock data.
- deadlocks are possible when one transactions wants to obtain an exclusive lock on a data item, deadlocks don't exist in shared locks

- 3 techniques to avoid deadlocks
	1. Dead lock prevention
		- if a transaction request for a new lock and there is a possibility of a dead lock, the transaction is rolled back and rescheduled
	2. deadlock detection
		- DBMSs searches for dead locks, if found , it aborts the transaction and rolls back. the other transaction continues
	3. deadlock avoidance
		- transaction gets all the locks it needs before executing. prevents having to roll back



### Concurrency control with Time stamping Methods

- Time stamping - assign a unique time stamp to each transaction
	- produces a specific order in which transactions are submitted to the DBMS
	- must have two properties
		1. uniqueness -no equal time stamps can exist 
		2. monotonicity - ensures time stamp values always increase
- DBMS executes conflicting operations in time stamp order, therefore ensure serializability of transactions 

- Disadvantage
	- increases memory need cause we need to store time stamps
	- stopping, rescheduling and re stamping need more computer resources


#### WAIT/DIE AND WOUND/WAIT schemes

- these schemes are used to decide which transaction is rolled back and which is continued.




![[Pasted image 20241002154052.png]]


## Concurrency Control with optimistic Methods

- based on the assumption that most of the operations do not conflict.
- No locking and time stamping is required.
- Transaction runs until it is committed. 
- mostly suitables for databases with less update operations

- Using this approach- Transaction moves through 3 phases
	- read
	- validation
	- write

##### Read
- the whole database is read, executes the computation needed, makes a private copy of the database values. All update operations are kept in a temporary file other transactions cannot access
##### Validation 
- transaction is validated , to ensure it does not affect the integrity and consistency of the database.
- if test is passed. it goes to write phase
- if test is failed, it is restarted and changes are discarded

##### Write
- changes are applied to the database




# ANSI Levels of Transaction Isolation

- ANSI SQL (1992) defines transaction management based on transaction isolation levels.
- Transaction isolation levels- is the degree in which data is protected form other concurrent transactions- based on data other transaction can see during their execution. Basically types of read a transaction allows

- Types of reads Operations
	- Dirty Read - transaction can read data that is not committed
	- Non repeatable read - a transaction reads a row and later reads it again, if it gest different results, the row might have been updated or deleted
	- Phantom read- a transaction runs a query at t1 and then runs the same query at t2, resulting in additional rows that satisfy the query 

- Based on the Reads operations, ANSI defines 4 levels of isolation
	- Read uncommitted.
	- Read committed
	- Repeatable read
	- Serializable


##### Read uncommitted
- a transaction can read uncommitted data from other transactions
- it is not good for data consistency 


##### Read Committed
- default mode of most for most dbs.
- forces transaction only to read committed data.
- here database will use exclusive locks on data


##### Repeatable read
- ensures that queries return consistent results
- used shared locks
- new rows are read as they did not exist when the query first ran


##### Serializable
- Most restrictive level


# Note

- transaction isolation level is defined in the transaction statement
```
BEGIN TRANSACTION ISOLATION LEVEL READ COMMITTED;
--SQL STATEMENTS
COMMIT TRANSACTION ;
```


## Database Recovery Management

- restore db from inconsistent state to previously consistent state
- based on atomic  property of transactions

#### Data base recovery techniques

- Transaction recovery
	- uses data in the transaction log to recover from inconsistent state to consistent state


## Four concepts about recovery process

1. write ahead log protocol
	-  ensures logs are written before any database is actually updated.
2.  Redundant transaction logs
	- ensures physical disk failure doesn't affect DBMSs ability to recover
3.  Buffers
	- temporary storage in primary memory 
	- DBMSs use it to improve processing time. By copying data from physical disk to buffer. updates are done on data in the buffer and later done to physical disk
4. Data base checkpoints
	- operation in which DBMSs writes all of its updated buffers in memory to physical disk
	- check points operations are also written in the transaction log.
	- transaction log and database will be in sync
	- 