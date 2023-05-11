# MC SQUAD
### Portafolio

|Desarrollador|GitHub|
|-------|---|
|Valentina Saldias|mundenius|

## Sitio para la comunidad de Minecraft del Mundo

### Nicho

<p style="text-align: justify;">La comunindad de Minecraft se caracteriza por ser muy activa respecto al juego. Esto significa que desde los comienzos se ha modificado el juego, ya sea a partir del codigo base, como pasaba en las primeras versiones; o como pasa con las versiones mas actuales, es necesario el uso de otros recursos y librerias que nos permiten acceder a los accesores, mutadores, metodos, interfaces, etc. De esta comunidad incansable e inconforme con lo logrado con las versiones comerciales, nacen mods, plugins y shaders que cambian por completo la experiencia de juego.  
</p>

### Propuesta

<p style="text-align: justify;">
En este proyecto en particular se propone un sitio web, en el cual se tendra acceso a los plugins que he ido creando las ultimas semanas. Estos plugins tienen distinto nivel de complejidad a nivel de codigo, y tambien distintas funcionalidades dentro del juego. Permitiran personalizar tanto los servidores, como los juegos singleplayer. Aunque se recomienda jugar con amigos, ya que estan pensados para eso. 
</p>


### Desarrollo

<p style="text-align: justify;">
Para la creacion del proyecto web se implemento SPRING MVC, a partir de un proyecto Maven. La version de Java es la 1.8, y se uso Tomcat 9.071 para levantar el proyecto. Se utilizo el patros de diseño dao 
</p>
<p style="text-align: justify;">
Minecraft es un juego que esta codificado en Java, por ende conocer el lenguaje Java es indispensable para hacerle modificaciones y agregarle funcionalidades. Para el desarrollo de los plugins creados se utilizo el software Spigot 1.19.2, que se utiliza para crear y alojar servidores personalizados. Este consume una API llamada Bukkit, la cual contiene las librerias, metodos, etc del codigo base del juego. Estas librerias, metodos accesores y mutadores, interfaces y funciones, son las que uno debe uitlizar al crear un Plugin para Minecraft. Se desarrollaron dos plugins en su totalidad, y hay uno que esta en proceso de construcción, con aproximadamente un 45% de la lógica lista.   
</p>

#### Objetivos a Cumplir
- [x] Plugin I: ManHunt
- [x] Plugin II: Teleport Hubs
- [ ] Plugin III: Assault Squad: EN PROCESO
- [x] Sitios Web
- [x] Base de Datos
- [x] CRUD

### Respecto a la rubrica Talento Digital

<h3> Base de Datos </h3>
<p style="text-align: justify;"> 
Se utilizo el patron de de conexion DAO. Por ende en las clases respectivas a ImplXxxxDao, se podran encontrar las sentencias de mySQL. 
Existen distintos tipos de sentencias las cuales se usan para que el CRUD sea existoso. Estas sentencias son de INSERT, UPDATE, SELECT y DELETE. Tambien se utilizaron otras sentencias como WHERE y ORDER BY para filtar y ordenar los datos.</p>
Se podran encontrar en este path: 
- java.cl.mundenius.mcsquad.dao.*;
Clases:
	- ImplAdminDao: lineas 34-48
	- ImplClienteDao: lineas 32 -46
	- ImplUsuarioDao: lineas 30-41


<h3> Algoritmos y Unidades de Prueba </h3>
<p style="text-align: justify;"> 
El grueso de los algoritmos de mis codigos, se encuentra en los plugins. Los plugins fueron codificados en su totalidad en lenguaje Java, y al tener funcionalidades tan especiales, era necesario hacer uso de sentencias repetitivas como for loops, y crear formulas de calculos especificos para determinar ciertos comportamientos de los objetos dentro del juego.
Al utilizar el software Spigot para alojar y crear el servidor en donde corren los plugins, es necesario utilizar herencia, polimorfismo e interfaces, además de entender como funcionan las relaciones entre los objetos para de esta forma crear nuevas funcionalidades con las ya existentes. </p>
Se podran encontrar estas en estos directorios de los proyectos ManHunt, TeleportHubs y AssaultSquad: 
- Manhunt.src.main.java.main.comandos.*;
- TeleportHubs.src.main.java.main.comandos.*;
- AssaultSquad.src.main.java.main.comandos.*;

<p style="text-align: justify;"> 
El CRUD per sé, no utilizaba muchas sentencias repetitivas, ni algoritmos especificos, sino que vienen de parte de un patrón de diseño. Parte de este patrón de diseño inlcuye utilizar interfaces y polimorfismo. Mi modelo en particular se basa en la herencia de datos, desde una clase padre Usuario, a dos clases hijas Administrativo y Cliente. A esta clase padre se le hicieron pruebas unitarias, respecto a los getters, setters y su constructor. 
</p>

Estas se pueden encontrar en los siguientes directorios del proyecto MCSQUAD:
- mcsquad.src.main.java.*;
- mcsquad.src.test.java.*;



<h3> Pagina Web </h3>
<p style="text-align: justify;"> 
Todas las paginas web fueron maqueteadas con BootsTrap5; la paleta de colores y pequeños ajustes de formato se pueden encontrar en el archivo CSS. Se utlizo taglib en los archivos JSP.
</p>

Estos archivos podran ser encontrados en este path del proyecto MCSQUAD: 
- webapp.WEB-INF.views.*;


<h3> Spring MVC </h3>
<p style="text-align: justify;"> 
Se utlizo el modelo MVC para crear el proyecto, por ende dentro de la carpeta Controllers se encuentran todos los controladores de las paginas web. 
En la carpeta DAO se encuentran las clases de implementacion del DAO y los rowmappers necesarios para su implementacion. 
En la carpeta Modelo se encuentran las clases padre e hijas. 
La carpeta View aloja los archivos JSP, estos incluyen el home, navbar, listar Usuario, etc.
</p>
En general, todo lo relacionado al proyecto podra ser encontrado en estos directorios del proyecto MCSQUAD: 
- java.cl.mundenius.mcsquad.controllers.*;
- java.cl.mundenius.mcsquad.interfaces.*;
- java.cl.mundenius.mcsquad.dao.*;
- java.cl.mundenius.mcsquad.modelo.*;
- webapp.WEB-INF.views.*;

