# CORBA-Morse-Distribuidos

Traductor a idioma MORSE, utilizando CORBA

## Descripción 🚀

A partir del Ejemplo de HELLO WORLD de CORBA he diseñado e implementado este traductor de MORSE a nivel de cliente.


### Compilación 🔧
```
idlj -fall Hello.idl 
```
```
javac *.java HelloApp/*.java
```
```
start orbd -ORBInitialPort 1050
```
```
start java HelloServer -ORBInitialPort 1050 -ORBInitialHost localhost
```
```
java HelloClient -ORBInitialPort 1050 -ORBInitialHost localhost
```
_Donde se pedirá la frase a traducir_

## Construido con 🛠️

CORBA

## Autores ✒️

* **Álvaro Calderón Izquierdo** 
