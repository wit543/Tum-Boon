# Tum-Boon

Group: 1
Project: TumBoon - Idle Clicker Game

<dt>Members :</dt>
      <dd>1) Parisa Supitayakul    5710546313</dd>
      <dd>2) Pongsakorn Somsri  5710546321</dd>
      <dd>3) Norawit  5710546437</dd>


#1) Project Detail
	This project is a idle clicker game that use some doctrine in Thailand as a theme. This game is about ridicule that doctrine and use its crazy dogma as a gameplay. In this game the higher you donate the higher "BOON" you deserve.
	##GAMEPLAY
	  There are 2 parts of the gameplay, the first part is collection the "BOON" as much as possible. You can collect boon by donating thing.
	  There are many objects that you can donate. The more expensive of the object the more boon you gain, but the expensive object will waste a lot of time to produce as well,
	  the produce boon of each object can be reduce by leveling up that object. The fastest produce time that one object can gain is 1 time per 0.1 second.
	  The second part of the game is control the innocent people's brain and make them to our follower. You can do this by clicking the UFO on the game. The follower can be change to the disciple later to increase your boon.

	##Feature
		1.)Donating Thing
		  -Donating will have different price,outcome and produce time.
		  -The more you donate the faster it produce the boon.
		  -The more you buy and object, it will also increase the boon you need to donate that object next time.
		  -The fastest produce time is 0.1 second.

		2.)Upgrade the donating thing
		  -Upgrade the all of the outcome of the upgraded object in percent.
		  -Upgrade will increase its price to 2 times higher and the upgrade will increase 10 percent.

		3.)Control innocent people's brain
		  -Receive the follower from clicking the ufo.

		4.)Rebirth
		  -Suicide yourself with your follower. You will born in the next life and your follower from the
		  previous life will become your disciple. The outcome in the current life will increase from the number of the disciple.

		5.)Show a supernatural thing(!?)
		  -Sacrifire your follower and show a miracle. You will get random multiply outcome form showing the miracle.

		6.)Saving the game
		  -Save the game when player quit the game. Use the shared preference to save the game.


#2) Design Pattern
			The design pattern that use in this project are Singleton, Factory, Strategy, Builder , Adapter, Observer and Memento pattern.

			1) Singleton Pattern
			WHERE - Game.java
			FOR - Use singleton in game.java because java is our controller and we need only one Game object to communicate with the
			      UI. The other reason is it easy to access this object from everywhere.

			2) Factory Pattern
			WHERE - factory package in the model package
			FOR - We use factory pattern to let the factory create every game object for us so the game and doesn't need to call it
			      directly. We can change map of our game by switch the factory. Changing map will change the factory each factory will create a different objects of game.

			3) Strategy Pattern
			WHERE - package BoonCalculatorStrategy in model package
			FOR - We can select the strategy to calculate boon from each donation thing.

			4) Builder Pattern
			WHERE - Layer.java
			FOR - Using builder pattern to solve the telescoping problem of constructor in case that we doesn't need to create            various constructor.

			5) Adapter Pattern
			WHERE - package adapter
			FOR - We create a adapter for Recycler view to bind the object and ui together.

			6) Observer Pattern
			WHERE - HomeActivity and Game.java
			FOR - HomeActivity will observe the game. When the follower in the game has change ,it will notify the HomeActivity
			      too change the new value of the follower.

			7) Mememto Pattern
			WHERE - Game.java
			FOR - We use mememto pattern to save the game. When player quit the game, we will save the state of the game and then
			      save the mememto object into the sharepreference. When we comeback to the game, the mememto will be load from the sharepreference and then game will restore from that mememto to load the game.


#3) Design Principles

		1) Creator :
			- Game create a upgrade,layer(donating thing) because it contains all of these thing.

	  	2) Information Expert :
			- Out factory have infomation to create all of the objects.

		3) Low Coupling
			- Adding a new layer won't affect the layer that already exist in our game.

		4) Controller
			- Game is a controller of out game, so the ui will interact only the game object.

		5) High Cohesion
			- The layer shouldn't need to have the nextProductionTime and ability to calculate the outcome by itself so I create a LayerManager to wrap the layer and handle those method.

	  	6) Polymorphism
			- The factory in the factory package is extend layerAbstractFactory.

		7) Pure Fabrication
			- BoonCalculator and BoonUnitTranformer is create to calculating boon, tranform the unit in to readable value.

		8) Indirection
			- Adapter in the adapter package

		9) Protect Variation
			- We use the layerManager to wrap keep the lv of each layer, so we doesn't need to change the layer.

    	10) Dry

    	11) SRP
    		- BoonCalculator have only responsibility that is too calculate boon from every layers
