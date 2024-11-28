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

![image](https://github.com/user-attachments/assets/bb6fa2f2-9ddc-4667-b9af-d8bf94d1544a)

## ¿Por qué es importante?

En una arquitectura distribuida, los microservicios suelen depender de servicios externos para obtener datos o realizar operaciones críticas. Esto puede incluir bases de datos, APIs de terceros, servicios de autenticación, entre otros. Sin un patrón adecuado, la comunicación entre estos servicios puede volverse compleja, difícil de mantener y propensa a errores.

El Ambassador Pattern resuelve este problema al:

1. **Simplificar la comunicación entre servicios**: El embajador maneja todas las interacciones de red, permitiendo que el servicio principal se mantenga simple y centrado en su propósito.
2. **Aumentar la seguridad**: Al canalizar el tráfico a través del embajador, se pueden implementar políticas de seguridad, como encriptación SSL/TLS y autenticación de manera centralizada.
3. **Mejorar la observabilidad**: Al actuar como punto de control, el embajador puede recolectar métricas de tráfico, registros (logs) y datos de trazabilidad (tracing) que facilitan el monitoreo y diagnóstico de problemas.

## ¿Cómo funciona el Ambassador Pattern?

El patrón se basa en desplegar un contenedor o proceso adicional que actúa como el embajador junto al servicio que se quiere proteger y gestionar. A menudo, en entornos basados en contenedores, como Kubernetes, se implementa como un sidecar container que se despliega junto al servicio principal dentro del mismo pod.

### Ejemplo de flujo de trabajo:

1. **Llamadas entrantes**: Cuando un cliente externo o un servicio desea interactuar con el servicio principal, la solicitud pasa primero por el embajador.
2. **Gestión de la comunicación**: El embajador puede manejar tareas como la autenticación, encriptación, balanceo de carga y enrutamiento.
3. **Interacción con el servicio principal**: Una vez que la solicitud ha sido validada y procesada, el embajador la envía al servicio principal.
4. **Monitoreo y métricas**: Mientras la solicitud es gestionada, el embajador recopila métricas y datos de trazabilidad, lo que facilita el análisis de rendimiento y la resolución de problemas.

![image](https://github.com/user-attachments/assets/c3398e2b-9f9a-4ada-af30-fd5da227dac7)

## Ventajas del Ambassador Pattern

### 1. Desacoplamiento
El uso de un embajador desacopla las responsabilidades relacionadas con la red del servicio principal, lo que simplifica su diseño y mantenimiento. Esto es especialmente útil en entornos donde la seguridad y el cumplimiento normativo son críticos.

### 2. Observabilidad mejorada
Al canalizar todo el tráfico a través del embajador, se pueden implementar herramientas de monitoreo y tracing sin modificar el código del servicio principal. Esto permite obtener una visibilidad completa de las interacciones entre servicios y facilita la detección de cuellos de botella o fallos.

### 3. Reusabilidad y consistencia
Dado que el embajador es independiente del servicio al que representa, puede ser reutilizado para múltiples servicios que comparten requisitos similares. Además, garantiza que todas las políticas de red y seguridad se apliquen de manera consistente.

### 4. Facilidad de pruebas y despliegue
La separación de preocupaciones hace que sea más sencillo probar los servicios de forma aislada. El embajador puede simular entornos de producción, lo que facilita las pruebas y el despliegue continuo en entornos DevOps.

![image](https://github.com/user-attachments/assets/ce86c2bd-48d7-4312-9af3-ed07da4bdad4)

## Desventajas y desafíos

A pesar de sus múltiples beneficios, el Ambassador Pattern no está exento de desafíos:

- **Latencia adicional**: Todas las solicitudes deben pasar por el embajador antes de llegar al servicio, lo que puede introducir una latencia adicional.
- **Complejidad operativa**: Aunque simplifica el servicio principal, introduce un nuevo componente que debe ser gestionado y mantenido.
- **Consumo de recursos**: El embajador, al ser un contenedor o proceso adicional, consume recursos del sistema, lo que puede ser un problema en entornos con limitaciones de CPU o memoria.

## Casos de uso comunes

- **Autenticación y autorización centralizadas**: Ideal para entornos donde la autenticación es crítica.
- **Comunicación segura entre microservicios**: El embajador maneja la encriptación y autenticación de todas las comunicaciones salientes.
- **Monitoreo y trazabilidad en entornos de microservicios**: Simplifica la recolección de métricas y datos de trazabilidad para análisis y diagnóstico.

![image](https://github.com/user-attachments/assets/01814e9c-40c4-422b-9190-abbbfd739e90)

## Mejores prácticas para implementar el Ambassador Pattern

1. **Utiliza sidecars en Kubernetes**: Implementar el embajador como un sidecar container en Kubernetes permite una gestión más sencilla y consistente de los servicios.
2. **Configura políticas de seguridad**: Asegúrate de que el embajador implemente encriptación y autenticación robustas.
3. **Automatiza la gestión del embajador**: Utiliza herramientas de automatización para gestionar y actualizar los embajadores.
4. **Monitoreo constante**: Implementa herramientas de monitoreo como Prometheus y Grafana para obtener visibilidad sobre el rendimiento.

## Conclusión

El Ambassador Pattern es una solución poderosa para gestionar la complejidad de la comunicación entre microservicios en entornos cloud. Si bien introduce ciertos desafíos, sus beneficios en términos de desacoplamiento, seguridad y escalabilidad lo convierten en una herramienta valiosa para arquitecturas modernas. Al aplicar este patrón, las organizaciones pueden mejorar la eficiencia de sus servicios, reducir la complejidad del código y optimizar el rendimiento de sus aplicaciones.


______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________


# Detección de Ataques DoS con Snort

## 1. Introducción

El objetivo de este proyecto es analizar la eficacia de los **Sistemas de Detección de Intrusiones (IDS)**, específicamente el IDS **Snort**, para la detección de ataques **Denegación de Servicio (DoS)**. Los ataques DoS son una de las amenazas más comunes y sencillas en el ámbito de la ciberseguridad, caracterizados por la sobrecarga de un servidor con solicitudes maliciosas, haciendo que los servicios se vuelvan inaccesibles para los usuarios legítimos. Este trabajo evalúa cómo Snort, un IDS basado en firmas y anomalías, puede detectar y mitigar un ataque DoS.

![snort_large](https://github.com/user-attachments/assets/b42cfc57-0862-43ca-9ba0-ba3728e37d19)

## 2. Fundamentos de Snort y su Función en la Detección de Ataques DoS

Snort es una de las herramientas IDS más utilizadas debido a su capacidad para detectar diversos tipos de ataques mediante el análisis profundo de paquetes de red. En el caso de los ataques DoS, Snort se configura para identificar patrones específicos de tráfico malicioso, como el envío masivo de paquetes ICMP (ping floods) o TCP SYN floods. Snort también puede detectar anomalías en el tráfico de red que puedan indicar un posible ataque, como un aumento inusitado de solicitudes hacia un servidor en particular.

## 3. Ataque DoS: Características y Riesgos

Un ataque de **Denegación de Servicio (DoS)** busca interrumpir el servicio de un sistema mediante la sobrecarga de sus recursos. En un ataque DoS, el atacante envía una gran cantidad de solicitudes al objetivo, agotando recursos como CPU, memoria o ancho de banda, y evitando que el sistema procese las solicitudes legítimas.

### Características del ataque DoS:
- **Sobrecarga de tráfico:** Gran volumen de paquetes enviados a un servidor o red.
- **Fácil ejecución:** Los atacantes no necesitan grandes conocimientos técnicos para ejecutar un ataque DoS, lo que lo convierte en una amenaza común.
- **Impacto significativo:** Aunque no causa daño directo a los sistemas, puede provocar la caída de servicios, pérdidas económicas y daños a la reputación.

![syn-flood-attack-ddos-attack-diagram-2](https://github.com/user-attachments/assets/f67981a5-0b78-414f-9964-568a81a1c257)

## 4. Metodología de Detección de Ataques DoS con Snort

El proceso para detectar un ataque DoS utilizando Snort se basa en el análisis de tráfico de red en tiempo real. Snort identifica patrones y anomalías que corresponden a técnicas comunes de ataques DoS. A continuación se describe la metodología utilizada:

1. **Monitoreo del tráfico:** Snort se configura para capturar y analizar el tráfico de red, observando cualquier comportamiento anómalo que pueda indicar un ataque DoS.
   
2. **Análisis de patrones:** Snort utiliza reglas predefinidas para comparar el tráfico observado con patrones de ataques DoS conocidos. Por ejemplo, el tráfico de un SYN flood o ping flood es detectado por firmas específicas que identifican estas amenazas.

3. **Generación de alertas:** Si Snort detecta un ataque, genera una alerta en tiempo real, indicando la posible presencia de un ataque DoS.

![0_m3PUPRURKYEDPiW6](https://github.com/user-attachments/assets/ed477988-f806-4210-8176-75da2529ef89)

## 5. Experimentación

Para evaluar la capacidad de Snort para detectar un ataque DoS, se realizaron las siguientes pruebas experimentales:

- **1) Entorno de prueba:** Se configuró un entorno de red controlado con un servidor de prueba y un sistema Snort desplegado en un equipo intermediario que analiza el tráfico entre los clientes y el servidor.

  ![imagen](https://github.com/user-attachments/assets/6b6955ff-1886-4920-b5d0-d8f3b3dec9b2)


- **2) Tipo de ataque:** Se utilizó un ataque SYN flood, donde un cliente malicioso envió bastantes y pesados paquetes SYN a la red para agotar los recursos del servidor y evitar que aceptara conexiones legítimas.

  ![imagen](https://github.com/user-attachments/assets/2efb9116-aebc-4be5-ace0-53b85f00c6a3)

- **3) Snort Configuración:** Se configuró Snort con las reglas predeterminadas para ataques DoS, específicamente para detectar SYN floods y ping floods.

![imagen](https://github.com/user-attachments/assets/ce9c3fa7-0ee9-4e9f-ac37-5c7c024e5042)

## 6. Resultados

![imagen](https://github.com/user-attachments/assets/46741522-e390-4df7-99c7-a6cf988df32b)

Los resultados de las pruebas experimentales mostraron lo siguiente:
  
- **Detección de Ping flood:** Snort detectó correctamente el ping flood, alertando sobre el aumento excesivo de paquetes ICMP enviados al servidor objetivo.

- **Tiempo de respuesta:** Snort reaccionó rápidamente a los ataques, generando alertas dentro del rango de 1 a 3 segundos después de que el tráfico malicioso alcanzara el umbral configurado para la detección.

## 7. Conclusiones

A partir de los resultados obtenidos, se concluye que Snort es una herramienta altamente eficaz para la detección de ataques DoS, particularmente SYN floods o ping floods. Su capacidad para identificar patrones de tráfico malicioso mediante firmas y anomalías le permite reaccionar rápidamente y generar alertas en tiempo real, lo cual es fundamental para mitigar el impacto de los ataques DoS en redes y servidores.

### Ventajas:
- **Eficiencia:** Snort detectó ataques DoS con una alta tasa de precisión y en tiempo real.
- **Configurabilidad:** Snort permite configurar reglas específicas para detectar diferentes tipos de ataques DoS, lo que le otorga flexibilidad en su implementación.

### Limitaciones:
- **Falsos positivos:** Aunque la tasa de falsos positivos fue baja, algunos ataques legítimos de alta frecuencia pudieron haber sido malinterpretados como amenazas.
- **Requiere mantenimiento de reglas:** Para detectar ataques DoS desconocidos o variantes nuevas, es necesario actualizar las reglas y firmas de Snort regularmente.

Snort demuestra ser una herramienta confiable y efectiva en la detección de ataques DoS, aunque su desempeño puede mejorar con ajustes y actualizaciones continuas de las firmas y configuraciones. Para redes con alto riesgo de ataques DoS, su implementación es una estrategia valiosa para la protección y seguridad de un sistema.

### Link al video

https://www.youtube.com/watch?v=V0uDJufSpNI



[Regresar al índice](../../README.md)
