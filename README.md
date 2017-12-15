# PatternChainOfResponsibility

##Univerity Project - Design Pattern

###Miage Bartender

####Context
Coffee machines at home is commonplace in 2017, in some clicks you can drink your favourite coffee without any effort. 
That's why, the startup *MiageConcept* is proud to announced their new product the **Miage Bartender**.

MiageConcept wants to bring a real bartender at home for everyone.
As a coffee machine with coffee capsule, MiageConcept is in discussion with major brands (alcohol, soda...) to adapt their products to the **Miage Bartender**.

After refill raw product in the machine, the user can select a cocktail and the machine will prepare it.
**Miage Bartender** takes care of its users because it includes an alcohol sensor. 
In fact before using this machine, the user can blow into the sensor and the machine will inform him about his blood alcohol level and then purpose cocktails adapted to the situation.

####Technical aspect - Chain of responsibility
Here we imagine engineers in *MiageConcept* designed the machine with 3 main raw product distributor :
- One for Soft drinks (No alcohol)
- One for Medium drinks (Low/Medium alcohol level)
- One for Strong drinks (High alcohol level)
*MiageConcept* wants to spread the product at home and in bars, that's why they split distributors with alcohol level to respect law about alcohol distribution.

Software engineers decided to use the Chain of responsibility pattern to implement the distribution of alcohol process.

####Source Code

Here is a prototype of the source code of the machine.
- Visual interface is replace by the console interaction
- Alcohol test is replace by a random value between 0 and 2g/L