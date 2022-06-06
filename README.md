# Ejercicio5-3-Agenda-SubidaNota

A tener en cuenta:

    Uso de Listas, Mapas, Conjuntos
    Usos de clases, Interfaces, Inversión de dependencias.
    Uso de archivos
        -> Lectura Consola, parser Cli
        -> Mostrar Consola, format por tabla
    Uso de base de datos.
    Uso de Compose.
    Uso de Logs.
    Uso de Kdoc.
 


 
*** Programa documentado con doca

/*Crear un programa para gestionar una agenda de contactos. El funcionamiento será el siguiente:

GestionarAgenda

- El programa pedirá introducir algo por teclado:

LectorInfo
    - pideNumeroTelefono
    - pideContacto
EscritorInfo
    - escribeInfoContacto

o Si se introduce un número de teléfono comprobará si existe, si es así mostrará a quién pertenece.
Si no existe pedirá el nombre del contacto para darlo de alta.

GestionarAgenda.darDeAlta()

    Agenda.existeNumero
    
    Agenda.infoContacto
    
    Agenda.alta



o Si se introduce un contacto debe comprobar si existe, si es así mostrará el número de teléfono.
Si no existe pedirá el número de teléfono para darlo de alta.

    Agenda.existeContacto
    Agenda.infoContacto
    Agenda.alta


- Debe reconocer números de teléfono con espacios entre los dígitos o no y con el símbolo + al principio para indicar prefijo de país.

    Contacto
        formatearTelefono


- Los nombres deben comenzar por letras y pueden contener números y caracteres especiales imprimibles.

    Contacto
        validarFormato

Parseador
    parser

- Comandos especiales:
o adios: Sale del programa
o listado: Muestra el listado completo de contactos ordenados por nombre
o filtra texto_a_buscar: Muestra el listado de los contactos que contengan texto_a_buscar o “Ningún
contacto” si no hubiera ninguno.

- Se deben crear funciones cuando sea adecuado (por ejemplo, comprobar si existe un contacto en la agenda, comprobar si un texto puede ser un número de teléfono, etc).
*/
