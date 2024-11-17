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


______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________


# Patrones Cloud: Ambassador Pattern

El desarrollo de aplicaciones distribuidas y la adopción de arquitecturas basadas en microservicios han llevado a la necesidad de patrones que faciliten la comunicación y la gestión de servicios en entornos cloud. Uno de estos patrones, el Ambassador Pattern, ha ganado popularidad por su capacidad para simplificar la interacción de un servicio con sistemas externos y manejar la complejidad inherente a la conectividad en redes. Este ensayo explora en profundidad qué es el Ambassador Pattern, sus aplicaciones, ventajas y desventajas, así como sus mejores prácticas.

## ¿Qué es el Ambassador Pattern?

El Ambassador Pattern se basa en la idea de utilizar un "embajador" como intermediario entre un servicio y su entorno externo. Este patrón introduce un proxy especializado que se encarga de gestionar tareas comunes relacionadas con la red, como:

- Autenticación
- Encriptación
- Supervisión (monitoring)
- Gestión de tráfico
- Manejo de fallos

A diferencia de un proxy genérico, un embajador está diseñado específicamente para actuar como una extensión del servicio al que representa, manejando toda la comunicación hacia el exterior.

En términos simples, en lugar de que cada microservicio tenga que lidiar con las complejidades de la comunicación en red, el embajador se encarga de esas tareas. Esto permite a los desarrolladores enfocarse en la lógica del negocio del servicio, mientras el embajador maneja las preocupaciones externas.

## ¿Por qué es importante?

En una arquitectura distribuida, los microservicios suelen depender de servicios externos para obtener datos o realizar operaciones críticas. Esto puede incluir bases de datos, APIs de terceros, servicios de autenticación, entre otros. Sin un patrón adecuado, la comunicación entre estos servicios puede volverse compleja, difícil de mantener y propensa a errores.

El **Ambassador Pattern** resuelve este problema al:

1. **Simplificar la comunicación entre servicios**: El embajador maneja todas las interacciones de red, permitiendo que el servicio principal se mantenga simple y centrado en su propósito.
2. **Aumentar la seguridad**: Al canalizar el tráfico a través del embajador, se pueden implementar políticas de seguridad, como encriptación SSL/TLS y autenticación de manera centralizada.
3. **Mejorar la observabilidad**: Al actuar como punto de control, el embajador puede recolectar métricas de tráfico, registros (logs) y datos de trazabilidad (tracing) que facilitan el monitoreo y diagnóstico de problemas.

## ¿Cómo funciona el Ambassador Pattern?

El patrón se basa en desplegar un contenedor o proceso adicional que actúa como el embajador junto al servicio que se quiere proteger y gestionar. A menudo, en entornos basados en contenedores, como **Kubernetes**, se implementa como un **sidecar container** que se despliega junto al servicio principal dentro del mismo pod.

### Ejemplo de flujo de trabajo:

1. **Llamadas entrantes**: Cuando un cliente externo o un servicio desea interactuar con el servicio principal, la solicitud pasa primero por el embajador.
2. **Gestión de la comunicación**: El embajador puede manejar tareas como la autenticación, encriptación, balanceo de carga y enrutamiento.
3. **Interacción con el servicio principal**: Una vez que la solicitud ha sido validada y procesada, el embajador la envía al servicio principal.
4. **Monitoreo y métricas**: Mientras la solicitud es gestionada, el embajador recopila métricas y datos de trazabilidad, lo que facilita el análisis de rendimiento y la resolución de problemas.

## Ventajas del Ambassador Pattern

### 1. Desacoplamiento
El uso de un embajador desacopla las responsabilidades relacionadas con la red del servicio principal, lo que simplifica su diseño y mantenimiento. Esto es especialmente útil en entornos donde la seguridad y el cumplimiento normativo son críticos.

### 2. Observabilidad mejorada
Al canalizar todo el tráfico a través del embajador, se pueden implementar herramientas de monitoreo y tracing sin modificar el código del servicio principal. Esto permite obtener una visibilidad completa de las interacciones entre servicios y facilita la detección de cuellos de botella o fallos.

### 3. Reusabilidad y consistencia
Dado que el embajador es independiente del servicio al que representa, puede ser reutilizado para múltiples servicios que comparten requisitos similares. Además, garantiza que todas las políticas de red y seguridad se apliquen de manera consistente.

### 4. Facilidad de pruebas y despliegue
La separación de preocupaciones hace que sea más sencillo probar los servicios de forma aislada. El embajador puede simular entornos de producción, lo que facilita las pruebas y el despliegue continuo en entornos DevOps.

## Desventajas y desafíos

A pesar de sus múltiples beneficios, el Ambassador Pattern no está exento de desafíos:

- **Latencia adicional**: Todas las solicitudes deben pasar por el embajador antes de llegar al servicio, lo que puede introducir una latencia adicional.
- **Complejidad operativa**: Aunque simplifica el servicio principal, introduce un nuevo componente que debe ser gestionado y mantenido.
- **Consumo de recursos**: El embajador, al ser un contenedor o proceso adicional, consume recursos del sistema, lo que puede ser un problema en entornos con limitaciones de CPU o memoria.

## Casos de uso comunes

- **Autenticación y autorización centralizadas**: Ideal para entornos donde la autenticación es crítica.
- **Comunicación segura entre microservicios**: El embajador maneja la encriptación y autenticación de todas las comunicaciones salientes.
- **Monitoreo y trazabilidad en entornos de microservicios**: Simplifica la recolección de métricas y datos de trazabilidad para análisis y diagnóstico.

## Mejores prácticas para implementar el Ambassador Pattern

1. **Utiliza sidecars en Kubernetes**: Implementar el embajador como un sidecar container en Kubernetes permite una gestión más sencilla y consistente de los servicios.
2. **Configura políticas de seguridad**: Asegúrate de que el embajador implemente encriptación y autenticación robustas.
3. **Automatiza la gestión del embajador**: Utiliza herramientas de automatización para gestionar y actualizar los embajadores.
4. **Monitoreo constante**: Implementa herramientas de monitoreo como **Prometheus** y **Grafana** para obtener visibilidad sobre el rendimiento.

## Conclusión

El Ambassador Pattern es una solución poderosa para gestionar la complejidad de la comunicación entre microservicios en entornos cloud. Si bien introduce ciertos desafíos, sus beneficios en términos de desacoplamiento, seguridad y escalabilidad lo convierten en una herramienta valiosa para arquitecturas modernas. Al aplicar este patrón, las organizaciones pueden mejorar la eficiencia de sus servicios, reducir la complejidad del código y optimizar el rendimiento de sus aplicaciones.


[Regresar al índice](../../README.md)
