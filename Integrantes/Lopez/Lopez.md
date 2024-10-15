# Andre Lopez Taranco

![Jeff Bezos](bezos.jpg)

No tengo mucha experiencia en desarrollo de software ya que no es algo que me apasione mucho y los proyectos que he realizado son los que pedían tanto en Soft 2 como en Progra Web. Las tecnologías que domino son muy variadas gracias a los cursos que hemos llevado, como Cisco Packet Tracer, SQL Developer, PowerBI, entre otras. Mi expectativa del curso es conocer más a profundidad el campo de la programación enfocado a las tendencias actuales como para estar preparado para el mundo laboral. En 10 años me veo teniendo un trabajo fijo como jefe o supervisor de un grupo de personas y a la vez empezando un proyecto para hacer mi propio negocio de servicio tercero de ciberseguridad para empresas.

______________________________________________________________________________________________________________________________________________________________________________________________________________________________

## TEMA ELEGIDO: Hacking Ético y Herramientas de Pentesting
El hacking ético es un campo dentro de la seguridad informática que busca identificar vulnerabilidades en sistemas y redes antes de que los atacantes maliciosos puedan explotarlas. Los hackers éticos o pentesters emplean una serie de herramientas que permiten evaluar la seguridad de aplicaciones, sistemas y redes, y así ayudar a fortalecerlas. Dos de las herramientas más conocidas en este campo son Metasploit y Wireshark.

### Herramientas para el Hacking Ético
#### Metasploit Framework

![image](https://github.com/user-attachments/assets/b6c2acb2-5f8a-4463-a360-57976886b2af)


Es una de las plataformas más populares para realizar pruebas de penetración (pentesting) y evaluaciones de seguridad. Su principal ventaja es que incluye una vasta base de datos de exploits, permitiendo realizar pruebas de vulnerabilidades y facilitar el acceso a sistemas de manera controlada.


##### Características clave:

Base de datos de exploits: Incluye una colección de vulnerabilidades conocidas y permite al usuario elegir el exploit adecuado para una prueba específica.
Modularidad: Metasploit permite ejecutar diferentes módulos, como escaneos de vulnerabilidades, exploits y payloads, de forma independiente.
Integración: Se puede integrar fácilmente con otras herramientas de seguridad, lo que lo convierte en una solución flexible.
Aplicación práctica: Metasploit es ideal para pruebas de penetración en redes empresariales. Un pentester puede identificar vulnerabilidades en servidores y realizar exploits controlados para verificar la seguridad.



#### Wireshark

![image](https://github.com/user-attachments/assets/5ad96c72-06fa-4d3e-86ba-55d9d5e321fe)

Es una herramienta de análisis de tráfico en redes, ampliamente utilizada para capturar y examinar paquetes de datos que pasan por una red. Es útil tanto para la resolución de problemas de red como para detectar actividades sospechosas.


##### Características clave:

Captura de paquetes en tiempo real: Wireshark permite ver el tráfico de red en vivo, ayudando a detectar problemas como ataques de tipo "man-in-the-middle".
Filtros avanzados: Permite aplicar filtros para concentrarse en paquetes específicos o tipos de tráfico, como HTTP, TCP o UDP.
Análisis profundo: Wireshark ofrece un análisis detallado de los protocolos de red y ayuda a los profesionales a entender el tráfico de red hasta en el nivel más bajo.
Aplicación práctica: Wireshark se utiliza a menudo para monitorear redes en busca de anomalías o ataques activos. Por ejemplo, en un entorno empresarial, un administrador de red puede detectar intentos de intrusión y verificar la seguridad del sistema.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

### Casos de Uso del Hacking Ético
#### *Pruebas de Seguridad en Aplicaciones Web:* 
Los pentesters utilizan Metasploit para verificar las vulnerabilidades en aplicaciones web y comprobar si pueden ser explotadas. Por ejemplo, en el caso de aplicaciones que no validan correctamente las entradas de los usuarios, un hacker ético podría realizar un ataque de inyección SQL controlado para comprobar la fortaleza del sistema.

#### *Análisis de Redes:* 
Wireshark es extremadamente útil para auditar la seguridad de una red, identificando actividades sospechosas como intentos de intrusión. Por ejemplo, se puede utilizar en entornos de trabajo para detectar la transferencia no autorizada de información o ataques de denegación de servicio.


### Cómo Funciona el Hacking Ético con Metasploit y Wireshark
Ambas herramientas están diseñadas para su uso por profesionales de la seguridad y requieren conocimientos técnicos sólidos. Metasploit se ejecuta típicamente en la terminal de un entorno Linux o Windows, mientras que Wireshark proporciona una interfaz gráfica para capturar paquetes.

*Metasploit:* El usuario selecciona una vulnerabilidad conocida en el sistema objetivo, ejecuta un exploit y utiliza payloads para obtener acceso controlado al sistema. Se pueden simular varios ataques, como la escalada de privilegios.
*Wireshark:* Captura paquetes de red y los muestra en un formato estructurado. A través de análisis de paquetes, los pentesters pueden identificar actividades anómalas y determinar el tipo de tráfico que fluye a través de la red.

#### Plataforma Elegida: Kali Linux
Kali Linux es un sistema operativo basado en Debian, especialmente diseñado para pruebas de penetración y análisis de seguridad. Viene con más de 600 herramientas preinstaladas, incluyendo Metasploit y Wireshark, por lo que es ampliamente utilizado por profesionales del hacking ético.

### Ventajas:

*Integración de herramientas:* Kali Linux incluye una amplia gama de herramientas de pentesting y análisis de redes, facilitando el trabajo de los hackers éticos.
*Seguridad avanzada:* Ofrece seguridad robusta para realizar pruebas en un entorno controlado.
*Accesibilidad:* Es una distribución gratuita y de código abierto, lo que permite que cualquiera pueda utilizarla.

### Desventajas:

*Curva de aprendizaje:* Aunque es poderoso, Kali Linux tiene una curva de aprendizaje pronunciada para los nuevos usuarios.
*Riesgo de abuso:* Si no se usa con ética, estas herramientas pueden ser mal utilizadas por atacantes maliciosos.



### Demo: Uso de Metasploit para un Pentesting


- 1er Paso: Abrir Kali Linux y ejecutar el comando "*msfconsole*" para iniciar Metasploit.

![image](https://github.com/user-attachments/assets/f67a0853-f9f7-4078-b591-8acf7343497f)


- 2do Paso: Elegir un exploit para una vulnerabilidad específica usando el comando "*searchsploit*":

![image](https://github.com/user-attachments/assets/446e855a-776f-4f8c-97f1-32411e4e45c6)


3er Paso: Configurar el payload y ejecutar el exploit.

![image](https://github.com/user-attachments/assets/6481e7c3-c2b1-4b2a-9268-77507b63f719)



[Regresar al índice](../../README.md)
