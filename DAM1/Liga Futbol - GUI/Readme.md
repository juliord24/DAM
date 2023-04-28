El proyecto de liga de futbol pero con interfaz gráfica desarrollada con Intellij, tiene algunos archivos extra para que sea detectado como un proyecto por NetBeans.
Comparto el codigo fuente y el .jar para ejecutar la aplicacion puesto que al menos que yo sepa solo IntelliJ es capaz de entender el .form que usa para diseñar la interfaz.
Al ser un proyecto de clase necesitar cumplir ciertos requisitos si quieres que la aplicación funcione.
Debes tener el servidor mysql encendido y con el puero 3306 abierto y debes tener alojada en él una base de datos que se llame 'bbdd'.


¿Cómo funciona?

Es bastante simple, en la pestaña información podemos ver los equipos y sus jugadores(generados aleatoriamente), en las pestañas cuartos, semis y final jugaremos la liga y viusalizaremos los partidos previstos y los jugados. En la pestaña herramientas se pueden guardar los jugadores y los equipos en una base de datos en localhost y a su vez cargarlos de nuevo a las JComboBox de la pestaña informacion.

¿Qué conocimientos he adquirido/utilizado?

Llevo con este proyecto aproximadamente 4 meses, empezó siendo algo más basico y ha evolucionado hasta esto.
Me ha ayudado a perfeccionar y comprender las estructuras de control y de datos, las propiedades de la POO, el desarrollo de interfaz gráfica con la libreríra Swing y la implementación y conexión con bases de datos.
