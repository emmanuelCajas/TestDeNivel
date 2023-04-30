# TestDeNivel
Nuestro cliente nos ha pedido una pequeña aplicación para gestionar su aparcamiento. El usuario de la aplicación será un empleado que, mediante un menú, podrá:
1- Dar de alta un vehículo. *
2- Registrar la entrada de un vehículo. 
3- Registrar la salida de un vehículo. *
4- Calcular importe de la tarifa.
5- Consultar la última entrada de un vehículo.
6- Mostrar las entradas/salidas según fecha.
7- Mostrar entradas/salidas de un vehículo hechas en un determinado mes.
8- Mostrar entradas/salidas de un propietario.
9- Generar informe. Escribe en un fichero "Vehículo.CSV" los vehículos que se dieron de alta (nro de vehículo, matrícula, dni propietario, tarifa, residente SI|NO) y en "Registros.CSV", los registros del día (nro de registro, matricula, fecha entrada, fecha salida).

El aparcamiento sólo permite la entrada de tres categorías:
-Letra L: motos y vehículos de menos de cuatro ruedas.
-Letra M: vehículo convencional para el transporte de personas y su equipaje.
-Letra N: transporte de mercancías.

Cada catagoría abona una tarifa diferente:
Letra L: 1% + sobre la tarifa bruta.
Letra M: 1,5%  + sobre la tarifa bruta.
Letra N: 2%  + sobre la tarifa bruta.

A los vehículos residentes se les aplica un descuento del 0,5% sobre la tarifa bruta, mientras que a los no residentes se les suma un 0,25% de la tarifa bruta.


* Al dar de alta un vehículo se le asigna un número.
 Excepción -> un vehículo no puede volver a ingresar si no ha salido primero.
* Excepción -> un vehículo no puede salir si no ha ingresado
