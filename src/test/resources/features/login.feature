Feature: Login en Sauce
		
	Scenario Outline: Hacer login con el usuario <user>
		Given Nos encontramos en la pagina de login
		When Hacemos login con usuario <user> y password <password>
		Then Estamos en Products
		
	Examples:
	|user|password|
	|standard_user|secret_sauce|
	|locked_out_user|secret_sauce|
	|problem_user|secret_sauce|
	|performance_glitch_user|secret_sauce|
	
	Scenario: Hacer login con usuario invalido
		Given Nos encontramos en la pagina de login
		When Hacemos login con usuario fakeuser y password fakepassword
		Then Se muestra error de usuario invalido
		
	Scenario: Hacer logout
		Given Nos encontramos en la pagina de login
		When Hacemos login con usuario standard_user y password secret_sauce
		Then Estamos en Products
		When Hacemos logout
		Then Nos encontramos en la pagina de login
