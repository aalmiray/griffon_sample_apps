Esta es la apliacion de ejemplo demostrada en el Spring I/O Madrid 2011.

Permite realizar consultas de fotos disponibles en Flickr haciendo uso
de la interfaz de servicios REST que Flickr expone segun se explica en

    http://www.flickr.com/services/api/

La aplicacion demuestra como es que varios plugins ayudan a la creacion
de la misma, en concreto:

 * rest: realizar llamadas de red usando el mecanismo REST
 * miglayout: organizar los components visuales con MigLayout
 * jbusycomponent: presenta un estrobo de espera
 * transitions: transiciones animadas entre imagen e imagen

Es necesario resaltar que la aplicacion no se hace cargo de todos los
errores que puedieren ocurrir, como por ejemplo una falla en la 
conexion de red (idealmente un dialogo con informacion pertinente al
error ocurrido seria presentado al usuario).

El numero total de lineas de codigo por artefacto es el siguiente:

     +----------------------+-------+-------+
     | Name                 | Files |  LOC  |
     +----------------------+-------+-------+
     | Models               |     1 |     6 | 
     | Views                |     1 |    38 | 
     | Controllers          |     1 |    28 | 
     | Services             |     1 |    23 | 
     | Lifecycle            |     5 |     5 | 
     +----------------------+-------+-------+
     | Totals               |     9 |   100 | 
     +----------------------+-------+-------+

