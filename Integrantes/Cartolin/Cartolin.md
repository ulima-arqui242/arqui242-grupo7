# Integrante: Mario Alexander Cartolin Yanque

Soy Mario Alexander Cartolin Yanque, estudiante de noveno ciclo en la carrera de Ingeniería de Sistemas. Tengo experiencia intermedia en desarrollo de software a través de proyectos académicos, principalmente en lenguajes como C++, Python, Java, y JavaScript, además de frameworks como React. Aunque no tengo mucho conocimiento sobre la arquitectura de software, sé que esta área es crucial para diseñar sistemas robustos y escalables. Espero que el curso me ayude a entender cómo aplicar principios de arquitectura para mejorar la eficiencia y mantenimiento de los proyectos que desarrolle en el futuro. En 10 años, me imagino trabajando como ingeniero de software en una empresa innovadora, desarrollando soluciones que impacten positivamente en la sociedad.

# Trabajo Individual: Arquitectura Basada en Eventos

## Introducción

La **Arquitectura Basada en Eventos** (EDA, por sus siglas en inglés) es un paradigma de diseño ampliamente utilizado en sistemas distribuidos modernos que requieren alta escalabilidad, flexibilidad y capacidad de procesamiento en tiempo real. A través de este enfoque, los componentes del sistema están diseñados para reaccionar a los **eventos** que representan cambios de estado o actividades de interés. Esta arquitectura permite a las aplicaciones reaccionar a las condiciones de su entorno de manera casi instantánea, lo que es crucial para los sistemas que gestionan grandes volúmenes de datos o requieren respuestas inmediatas.

---

## ¿Qué es la Arquitectura Basada en Eventos?

La arquitectura basada en eventos se centra en la creación, detección y consumo de eventos como un mecanismo de comunicación entre los componentes de un sistema. Un **evento** es cualquier ocurrencia significativa que puede ser detectada por el sistema. Los componentes en este tipo de arquitectura no están directamente conectados entre sí, sino que se comunican a través de la generación y captura de eventos. 

En lugar de depender de la tradicional interacción sincrónica entre componentes (como las llamadas directas), los eventos permiten un **desacoplamiento temporal** entre productor y consumidor. Esto es posible porque los eventos se transmiten a través de **canales** que actúan como intermediarios, permitiendo que los consumidores reciban los eventos cuando estén disponibles para procesarlos.

---

## Componentes Clave

### **Productor (Producer)**

El **Productor** es el componente responsable de detectar cambios o eventos dentro del sistema y emitirlos para ser consumidos. Los eventos pueden ser generados en respuesta a una acción del usuario, una modificación de datos, un cambio en el sistema o una condición externa.

- **Rol y Funciones**:
  - **Detección de eventos**: El productor detecta que ha ocurrido una acción o evento de interés en el sistema.
  - **Creación de eventos**: Luego de la detección, el productor crea un evento que representa este cambio. Este evento contiene información relevante sobre la acción.
  - **Publicación de eventos**: El productor publica este evento a través de un **canal de eventos**, donde estará disponible para ser consumido por uno o varios consumidores.

- **Ejemplos**:
  - Un sistema de comercio electrónico genera un evento cada vez que un cliente realiza una compra, proporcionando detalles como el producto comprado, la cantidad y el usuario.
  - Un sistema de monitoreo de sensores puede generar eventos cuando la temperatura de un sensor excede un umbral determinado.

### **Consumidor (Consumer)**

El **Consumidor** es el componente que escucha y reacciona a los eventos emitidos por uno o varios productores. A diferencia del productor, que solo genera eventos, el consumidor está diseñado para recibir estos eventos y ejecutar las acciones correspondientes, como actualizar bases de datos, iniciar procesos adicionales o notificar a otros sistemas.

- **Rol y Funciones**:
  - **Suscripción**: El consumidor se suscribe a uno o más canales de eventos para recibir actualizaciones de interés.
  - **Procesamiento de eventos**: Una vez que recibe un evento, el consumidor realiza una acción en función del contenido del evento. Este procesamiento puede variar desde actualizar registros hasta iniciar procesos complejos de negocio.
  - **Reacción**: Después de procesar un evento, el consumidor puede generar nuevos eventos en respuesta, los cuales a su vez pueden ser consumidos por otros componentes.

- **Ejemplos**:
  - Un sistema de inventario que, al recibir un evento de compra, reduce la cantidad disponible del producto en cuestión.
  - Un servicio de notificaciones que envía un correo electrónico al cliente una vez que su pedido ha sido confirmado.

### **Canales de Eventos (Event Brokers)**

Los **Canales de Eventos** son la infraestructura que permite que los productores y los consumidores intercambien información sin depender directamente uno del otro. Estos canales pueden tomar la forma de colas, temas o flujos de datos en tiempo real, y su elección depende de las necesidades del sistema en términos de rendimiento y fiabilidad.

- **Características de los Canales**:
  - **Desacoplamiento temporal**: Los productores y consumidores no necesitan estar activos al mismo tiempo. Los eventos pueden ser almacenados en el canal hasta que los consumidores estén listos para procesarlos.
  - **Escalabilidad**: Los canales permiten manejar grandes volúmenes de eventos de manera eficiente, distribuyendo la carga entre múltiples consumidores si es necesario.
  - **Fiabilidad**: Los canales de eventos pueden implementar mecanismos como confirmaciones de recepción, reintentos automáticos y particionamiento de eventos para garantizar que ningún evento se pierda.

- **Tipos de Canales**:

  | Tipo                | Descripción                                                                                       |
  |---------------------|---------------------------------------------------------------------------------------------------|
  | **Colas (Queues)**  | Los eventos son almacenados en una cola y procesados por un solo consumidor en orden FIFO (First In, First Out). Ideal para tareas secuenciales. |
  | **Temas (Topics)**  | Los eventos son publicados en un tema al que múltiples consumidores pueden suscribirse. Esto permite que varios servicios respondan al mismo evento. |
  | **Streams**         | Los eventos son transmitidos como un flujo continuo de datos, donde pueden ser procesados en tiempo real o almacenados para procesamiento posterior. |

![Diagrama de Interacción entre Productor, Consumidor y Canal](./diagrama.png)

*Figura 1: Relación entre Productor, Consumidor y Canal de Eventos.*

---

## Tipos de Procesamiento de Eventos

El procesamiento de eventos en una arquitectura basada en eventos puede dividirse en dos categorías:

1. **Procesamiento en Tiempo Real**: Los eventos se procesan inmediatamente después de su emisión, lo que es fundamental para sistemas que requieren respuestas inmediatas, como los sistemas financieros o aplicaciones IoT. 
2. **Procesamiento Diferido**: Los eventos se acumulan y procesan de manera conjunta en intervalos regulares. Esto es útil cuando el procesamiento no necesita ser inmediato, como en la generación de informes.

---

## Ventajas y Desventajas

### Ventajas

- **Desacoplamiento**: Los productores y consumidores están separados, lo que permite que los componentes evolucionen de manera independiente. Esto facilita la modificación y el mantenimiento del sistema sin causar interrupciones.
- **Escalabilidad**: Los consumidores pueden ser escalados horizontalmente para manejar grandes cantidades de eventos, mejorando el rendimiento del sistema.
- **Reactividad en tiempo real**: La capacidad de responder rápidamente a eventos hace que los sistemas basados en eventos sean ideales para aplicaciones críticas en tiempo real.
- **Tolerancia a fallos**: Los eventos pueden ser almacenados en canales hasta que los consumidores estén listos o disponibles, lo que aumenta la fiabilidad del sistema.

### Desventajas

- **Complejidad**: Implementar una arquitectura basada en eventos introduce nuevos desafíos en cuanto a la gestión de eventos, monitoreo y trazabilidad. Además, puede ser difícil depurar el flujo de eventos en sistemas grandes y distribuidos.
- **Consistencia eventual**: Dado que los eventos pueden no ser procesados inmediatamente, existe una posible inconsistencia temporal en el sistema.
- **Costes de infraestructura**: El uso de canales de eventos como Kafka o RabbitMQ puede incrementar los costes en términos de infraestructura y mantenimiento.

---

## Casos de Uso

- **Sistemas de Comercio Electrónico**: Cuando un usuario realiza una compra, el sistema genera eventos que activan acciones en múltiples componentes, como la actualización del inventario, la confirmación del pedido y el envío de una notificación al cliente.
- **IoT (Internet de las Cosas)**: En entornos de IoT, los dispositivos conectados emiten constantemente eventos que pueden ser procesados para tomar decisiones en tiempo real, como activar una alarma cuando un sensor detecta movimiento.
- **Finanzas**: El procesamiento de transacciones financieras o la detección de fraudes son áreas clave donde la arquitectura basada en eventos proporciona beneficios al permitir una respuesta rápida a las acciones del usuario o condiciones sospechosas.
- **Monitorización de Infraestructura**: Los sistemas de monitoreo pueden emitir eventos en función del estado de servidores, redes o bases de datos, y reaccionar en tiempo real a fallos o degradaciones.

---

## Consideraciones de Diseño

Al diseñar un sistema basado en eventos, es importante tener en cuenta:

1. **Selección de Herramientas**: Debes elegir la plataforma adecuada para manejar tus eventos, como Kafka, RabbitMQ o servicios en la nube como AWS SNS/SQS. Cada uno tiene diferentes ventajas en términos de rendimiento, fiabilidad y escalabilidad.
2. **Diseño de Eventos**: Los eventos deben ser ricos en información relevante pero compactos para minimizar la sobrecarga de procesamiento y transmisión.
3. **Monitoreo y Trazabilidad**: Es crucial implementar un sistema de monitoreo para rastrear los eventos a medida que se propagan por el sistema y poder detectar cuellos de botella o fallos.
4. **Consistencia Eventual**: En sistemas distribuidos, debes estar preparado para manejar la consistencia eventual y la posibilidad de que los consumidores reciban eventos con cierto retraso.

---

## Conclusión

La Arquitectura Basada en Eventos es una solución eficiente y flexible para sistemas que requieren procesamiento en tiempo real, alta escalabilidad y tolerancia a fallos. Su capacidad para desacoplar los componentes del sistema mediante el uso de eventos como mecanismo de comunicación es esencial para la construcción de aplicaciones modernas. Sin embargo, la implementación exitosa de este paradigma requiere una cuidadosa planificación en la elección de herramientas, el diseño de eventos y la gestión de la infraestructura subyacente.


# Implementación de Apache Kafka

## Introducción

### ¿Qué es Apache Kafka?

Apache Kafka es una plataforma de streaming distribuida y de código abierto desarrollada por la Fundación Apache. Está diseñada para manejar flujos de datos en tiempo real de manera eficiente y confiable. Kafka permite la publicación, suscripción, almacenamiento y procesamiento de flujos de registros en tiempo real, convirtiéndolo en una opción ideal para sistemas que requieren alto rendimiento y escalabilidad.

### Características de Apache Kafka

- **Alto Rendimiento**: Capaz de manejar millones de mensajes por segundo con baja latencia.
- **Escalabilidad Horizontal**: Se puede escalar fácilmente añadiendo más nodos al clúster.
- **Durabilidad y Fiabilidad**: Los mensajes se persisten en disco y se replican en el clúster para evitar pérdidas de datos.
- **Sistema Distribuido**: Soporta múltiples productores y consumidores simultáneamente.
- **Integración**: Compatible con diversas herramientas y frameworks para procesamiento en tiempo real como Kafka Streams y Apache Spark.

### Ventajas sobre Otras Soluciones

- **Comparado con RabbitMQ**:
  - **Modelo de Mensajería**: Kafka utiliza un modelo de registro distribuido, lo que lo hace más eficiente para el procesamiento de flujos de datos y eventos en tiempo real.
  - **Rendimiento**: Mejor manejo de altas tasas de transferencia de mensajes con menor sobrecarga de red.
  - **Persistencia por Defecto**: A diferencia de RabbitMQ, Kafka persiste todos los mensajes, lo que permite procesar datos históricos.

- **Comparado con ActiveMQ**:
  - **Escalabilidad**: Kafka ofrece una escalabilidad horizontal más sencilla y eficiente.
  - **Latencia**: Proporciona latencias más bajas para la entrega de mensajes.
  - **Ecosistema**: Cuenta con un ecosistema más amplio y una comunidad activa que aporta mejoras y soporte continuo.

---

# Patrón Cloud a Implementar: SideCar

Para implementar un sistema de soporte al usuario robusto y eficiente en la plataforma “A tu Puerta”, se seleccionó el **patrón Sidecar**. Este patrón permite que cada funcionalidad específica, como el soporte al usuario, funcione de manera autónoma y aislada del resto del sistema. Esto facilita tanto la escalabilidad como el mantenimiento, además de mejorar la integración de Kafka para la gestión de eventos en tiempo real. A continuación, se detalla cómo el patrón Sidecar responde a las necesidades del sistema.

---

## Problema

En el desarrollo de la plataforma “A tu Puerta”, el módulo de asistencia y soporte enfrenta varios retos específicos. Este módulo debe integrarse de manera eficiente en el sistema sin afectar el rendimiento de otros servicios y garantizar una atención rápida y escalable para los usuarios. A continuación, se detallan los problemas principales que aborda el patrón Sidecar:

1. **Aislamiento de Funcionalidades**: El módulo de soporte necesita estar aislado de los demás servicios para evitar que su carga afecte a otros módulos de la plataforma, asegurando una operación estable y autónoma.

2. **Escalabilidad de Recursos**: Durante los períodos de alta demanda, es fundamental que el sistema pueda escalar el soporte sin necesidad de aumentar recursos en toda la plataforma, optimizando así el uso de recursos.

3. **Manejo de Eventos en Tiempo Real**: Con la implementación de Kafka, el sistema requiere un patrón que permita la comunicación en tiempo real de forma simple y eficaz, adaptándose a los flujos dinámicos del soporte al usuario.

4. **Facilidad de Mantenimiento y Actualización**: El módulo de soporte necesitará actualizaciones frecuentes y una arquitectura que permita realizar estos cambios sin interferir con la operación del resto de la plataforma.

5. **Adaptación a Flujos Cambiantes**: La demanda y naturaleza de las consultas de los usuarios pueden variar, por lo que se requiere una arquitectura flexible que pueda adaptarse a estos cambios sin afectar al resto del sistema.

---

## Solución

El patrón **Sidecar** se ajusta a los requisitos del módulo de asistencia y soporte en la plataforma “A tu Puerta” al permitir la ejecución de sus funcionalidades en un contenedor separado. Este enfoque no solo asegura la independencia del módulo, sino que facilita la escalabilidad, la integración con Kafka y el mantenimiento sin interrupciones. A continuación, se presentan los beneficios específicos que ofrece Sidecar en este contexto:

1. **Aislamiento Mediante Sidecar**: Al ejecutar el módulo de soporte en un contenedor separado, Sidecar asegura que las operaciones del soporte no interfieran con otros módulos, manteniendo la estabilidad general del sistema.

2. **Escalabilidad Independiente**: Sidecar permite escalar el módulo de soporte sin necesidad de asignar recursos adicionales al resto de la plataforma, asegurando una respuesta rápida en momentos de alta demanda.

3. **Integración Optimizada con Kafka**: Este patrón facilita la comunicación basada en eventos mediante Kafka, gestionando eficientemente los mensajes en tiempo real y ofreciendo una experiencia de usuario fluida en la interacción con el soporte.

4. **Mantenimiento Simplificado**: La arquitectura independiente de Sidecar permite realizar mejoras y actualizaciones en el módulo de soporte sin necesidad de interrumpir otros servicios, garantizando así la continuidad operativa.

5. **Adaptación a Cambios**: Sidecar brinda flexibilidad para modificar el módulo de soporte según nuevos flujos o necesidades sin que el resto del sistema se vea afectado, facilitando la evolución de la plataforma.

---

## Casos de Aplicación

El patrón Sidecar ha sido seleccionado específicamente para optimizar el rendimiento y la experiencia de usuario en el módulo de soporte. A continuación se describen algunos de los principales casos de aplicación en los que este patrón beneficiará a la plataforma “A tu Puerta”:

1. **Escalabilidad en Picos de Demanda**: En momentos de alta demanda, como durante eventos o promociones, el patrón Sidecar permite que el módulo de soporte escale sin afectar a otros servicios, asegurando así que todos los usuarios reciban asistencia oportuna.

2. **Actualización Continua del Módulo de Soporte**: Con Sidecar, el equipo de desarrollo puede aplicar mejoras o parches de seguridad en el módulo de soporte sin necesidad de desconectar o afectar el servicio para otros módulos de la plataforma.

3. **Comunicación en Tiempo Real**: Sidecar, en conjunto con Kafka, permite que el soporte al usuario maneje eventos y consultas en tiempo real, garantizando una atención eficiente y una comunicación fluida entre el soporte y los usuarios.

4. **Experiencia de Usuario Mejorada**: Gracias al aislamiento del módulo de soporte, se garantiza una interacción rápida y estable para los usuarios, quienes pueden recibir asistencia sin experimentar lentitud o interrupciones en el resto de la plataforma.

5. **Adaptabilidad a Cambios de Escenario**: El patrón Sidecar permite modificar los flujos de trabajo del módulo de soporte sin impactar la infraestructura general, permitiendo que la plataforma evolucione y se adapte a nuevos requerimientos de los usuarios.

[Regresar al índice](../../README.md)
