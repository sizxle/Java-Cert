
- CALM (conversational Ai Language Model)

- LLMs allowed developers to build more interactive open ended assistants- especially the conversational aspects of it
- LLMs  - prone to hallucinations - which is a tendency to create new facts in state of uncertainty 
  

- Business logic rules an assistant should follow to achieve business tasks


- Take conversational LLMs and combine with programable logic (THIS IS RASA)
  
  
-  with CALM, no need for training examples to enable assistants to understand user inputs. This is what LLMs are for. just focus on business logic 
  
# CALM

- Has 3 components 
	1. Business logic - rules assistants must follow to complete user requests
	2. Dialogue understanding - powered by LLMs - enable assistant to understand user inputs while keeping context of the initial request
	3.  Conversation repair -handles unexpected conversations
	   
- Goal - Natural conversation while heading to a specific goal. 

# Architecture of an assistant built with Calm

Whole Conversation ->  Dialogue Understanding -> Dialogue Manager -> Response

#### Key Files
- `flows.yml` - holds the business logic
- `config.yml` - configures the dialogue understanding component
- `domain.yml` - 
- `actons.py` - contains the code for custom actions like api calling
- `endpoint.yml` specify how assistant runs a custom action server
  
# Flows

- key component
- define logical steps for specific situations
- Business logic -> steps assistant should follow in certain situations
- Flows are not intended to represent the entire conversation between user and assistant

##### Components of Flows
- Defined in yml file e.g `flows.yml`
1. `a_flow` -flow id `required`
2. `name:`-  `optional
3. `description:` 
4. `if:`
5. `nlu_triggers` - optional list of intents that start a flow
6. `steps` - required lists of steps



# Dialogue Understanding in CALM

- allows the assistant to understand the users input
- DU works different from NLU-based systems
  
##### NLU-based system
- process users inputs by using predefined intents and entities
- makes it difficult to scale the assistant
- require a large amount of training data to train 
  
#### Dialogue Understanding 
- uses intentless approach
- takes a generative approach to the problem. 
- Does not interpret in isolation
-

## Command Generator

- Responsible for Dialogue Understanding in CALM

- Two generators are available:
	1. LLMCommandGenerator
	2. NLUCommandAdaptor
	   
### LLMCommandGenerator

- leverages LLMs 
- can use LLM of your choice e.g Open AI must support `/chat` endpoint.
- 
### NLUCommandAdapter

- **When to use the NLUCommandAdapter?**
	- **You want to migrate an existing bot that relies on NLU and stories / rules to the CALM paradigm**
	- **You want to minimize the costs by not making an API call to the LLM each time.**


Note :You can also use multiple CommandGenerator components in your configuration.


## Actions

- Types of actions:
	- Responses 
		- simple text responses that assistants sends to user. 
		- defined in domain file under responses section
		- start with a prefix `utter_`
	- Custom actions
		- action with custom code
		- all custom actions begin with `action_`
		- executed by Custom action server
	- Default actions
		- actions built into dialogue manager by default
		- has the same structure like custom actions
		- can be customized by overriding them in actions.py
		  
		  
#### Custom Action server
- can be configured as a separate server - This allows changes in custom actionms without having to restart assistant all the time
- runs custom actions
- `rasa run actions` - starts custom actions server
  
  
  
  
## Conversation Repair

- when users say something unexpected based on the general conversation. - conversation repairs handles such situations.
- 
  

### Rasa Pro Architecture

- In production
- The assistant will need cloud services to monitor it and make sure it runs fine
- ![[Pasted image 20251016092105.png]]
  

#### Model storage
- stores the trained model
- models can be stored in different places after training.
- on initialization or restart, Rasa plus will download the model into memory
  
### Lock Store
- needed when there is a high-load scenario and rasa server needs to be replicated across multiple instances
- ensures messages for each conversation is handled in the correct way . without loss or overlap

### Track Store
- stores the assistants conversations
- Rasa has different stores out of the box or you can create a custom one

### Secret Manager
- Securely stores and manages sensitive data(credentials)

### NLG Server

- Optional 
- Used to outsource response generation and separate it from dialogue learning process
- allows for the dynamic generation of responses without the need to retrain the bot
  
### Event Queue
- Used to stream all events from the Rasa server to a Kafka topic
-  serves as a link between your active assistant and various external services that handle data from conversations

  commands
- 'rasa train' - trains the assistants




# Rasa Open Source

Conversation data include:
1. Stories
2. Rules


### Designing Stories 
- account for two paths:
	1. happy path
	2. unhappy path

# Stories Vs Rules.


#### Stories
- training data for the assistant, on what it should do next
- models the conversations

#### Rules
- describe short pieces of conversations that always go the same way
- data used by dialogue manager for handling pieces of conversations that should follow the same path
- Useful when implementing:
	- One turn interactions - easy to map intent to responses
	- Fallback behaviour - these rules respond to low confidence messages
	- Forms - submitting a form will often follow a fixed path-  you can write rules handle unexpected input
- reserve rules for single-turn conversation and use stories for muti-turn conversations
  
  
  
## Forms

- define:
	1. slot mappings
	2. responses
- we only need two rules for a forms happy path.
	1. rule that define the start
	2. rule that define what happens when form has been filled

- look at this again [link](https://legacy-docs-oss.rasa.com/docs/rasa/business-logic)



Note:

- How conversations should go
	1. Stories
	2. Rules

- How users say things
	1. Intents
	   

## Entities
- pieces of information inside of a user message
-  These are important details your assistant could use later in the conversation
- stored inside nlu
- `[whatShouldBeExtracted](labelToEntity)`
- There are 3 ways entities can be extracted in Rasa
	1. Pre built models
	2. using Regex
	3. using Machine Learning
		- for custom entities
- output of an entity extraction is a JSON file


### Slots
- assistants memory 
- inside `domain.yml`
- Setting Slots
	1. Using NLU
		- ![[Pasted image 20251028161440.png]]
	2.  Using custom Actions
- Slots can be set to influence conversations flow
- If slots are configure to influence flow of conversation. include them in training stories

- SLOT Mappings
	- define how each slot will be filled in.
	- applied after each user message
	-   slot mapping Types:
		1. `from_entity`
			- fills in slots based on extracted entity
		2. `from_text`
			- uses the text of the last user message to fill the slot
		3. `from_intent`
			- fills slots wit a value if specific intent is predicated 
		4. `from_trigger_intent`
			- fills a slot with a specific value - if a form is activated by a user message with a specific intent
		5. `custom`

- Slot Types
	1. text
		- the text vaues cannot influnce the convesation. only its presence 
	2. boolean
		- the value can influnce conversation
	3. categorical 
		- one of option, in a list of options
	4. float
		- numerical numbers
	5. list
		- takes a list o
	6.  any
		- stores any value
		- don't have influence


### Responses

- messages assistants sends back  to the user
- inside `doamin.yml` - `responses:` section
- response template - has to start with prefix label `utter` 
	- this distinguish response templates from other response types
	- ![[Pasted image 20251029131424.png]]
	- we can include more than one possible response for a specific template. rasa will select which response to use.
	- can use slots in the responses
		- if slot has not been set, Rasa will fill it wit value `None`
	

	- Can include images  in responses
		- include urls to images you like to include in the responses
		- how they render depends on the frontend you are using
		- ![[Pasted image 20251029135459.png]]
		

	- Can include BUTTONS TO RESPONSE 
		-  ![[Pasted image 20251029135947.png]]



	- Channel specific responses
		- ![[Pasted image 20251029140448.png]]


### Pipeline and Policy

- NLU `pipeline` and `dialogue policy` configuration- are core of the assistant
- define `how assistant understands user inputs` and `how they decide how to respond` 
- inside `config.yml`
	- Consists of 3 main parts:
		1. language 
			- define language of the assistant
		2. pipeline 
			- define NLU training pipeline
			- defines steps in which users message pass through until a decision on what the user message is about is made
			- NLU pipeline to define steps used to detect `intents` and `entities`
			- order of the pipeline matters
		3. policies 
			- define `dialogue management techniques` and `models` the assistant will use to decide how to respond users inputs
			- Can define more than one 
				- not sequential- can be used in parallel
			- if two different `dialogue management policies` predict the next best action with the same accuracy. decision is being made on police priority
			- There are TWO types of polices:
				1. Rule based polices 
					- uses rules to determine how to respond based on rules
					- defined in `rules.yml`
					- great for strict behaviour
				2. Machine Learning policies 
					- try to learn patterns from conversational data inside `stories.yml`
					- make assistant more robust


Custom Actions
- custom python scripts that run on behalf of your users
- custom code to do task
- ![[Pasted image 20251029211903.png]]

-  Rasa custom action 
	- written as a python
	- rasa provides a library called `rasa_sdk` - makes it easy to define custom action
	- ![[Pasted image 20251029212405.png]]
		- Class inherits from `Action` class
		- Two methods-
			1. `name` - define name of the action we use in our `stories` and `rules`
			2. 'run' - where write run custom code
				- `dispatcher` - sends messages to the user
				- `tracker` - contains relevent data that is extracted from conversation so far(e.g intents, entities, slots)
				- `domain`- allows access to data defined in `domain.yml`



### Basic Forms
- this process is called slot filling
