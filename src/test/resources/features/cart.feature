Feature: Operaciones con productos y carro en Sauce
		
	Scenario: Ordenar precio ascendente
		Given Nos encontramos en la pagina de login
		When Hacemos login con usuario standard_user y password secret_sauce
		Then Estamos en Products
		When Pulsamos ordenar precio de bajo a alto
		Then Los productos estan ordenados por precio ascendentemente
		
	Scenario: Agregar varios items al carro
		Given Nos encontramos en la pagina de login
		When Hacemos login con usuario standard_user y password secret_sauce
		Then Estamos en Products
		When Agregamos 3 elementos al carro
		Then Hay 3 elementos en el carro
		When Accedemos al carro
		Then Estamos en el carro
		Then Los productos estan en el carro
	
	Scenario: Agregar Onesie al carro
		Given Nos encontramos en la pagina de login
		When Hacemos login con usuario standard_user y password secret_sauce
		Then Estamos en Products
		When Agregamos elemento Sauce Labs Onesie al carro
		Then Hay 1 elementos en el carro
		When Accedemos al carro
		Then Estamos en el carro
		Then Los productos estan en el carro
		
	Scenario: Completar una compra
		Given Nos encontramos en la pagina de login
		When Hacemos login con usuario standard_user y password secret_sauce
		Then Estamos en Products
		When Agregamos 3 elementos al carro
		Then Hay 3 elementos en el carro
		When Accedemos al carro
		Then Estamos en el carro
		Then Los productos estan en el carro
		When Pulsamos checkout
		Then Estamos en checkout
		When Rellenamos datos personales de compra con nombre, apellido, 04001
		And Pulsamos continue
		Then Estamos en checkout overview
		And Los productos son correctos
		And Subtotal es correcto
		And Total es correcto
		When Pulsamos finish
		Then Estamos en Checkout complete
		And Se muestra el mensaje de compra correcta
		When Pulsamos go back
		Then Estamos en Products
