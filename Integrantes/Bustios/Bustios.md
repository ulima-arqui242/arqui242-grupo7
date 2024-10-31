# Abraham Bustios

![Abraham Bustios Terres](bezos.jpg)

¿Cuál es mi experiencia en desarrollo de software?
Experienca en desarrollo de proyectos de curso en Java, C# y javascript. 

¿Qué tecnologías conozco o domino?

Conocimientos de ingenieria de Software y metologias ágiles.
NextJS 

¿Cuál es mi expectativa del curso?

Ampliar mis conocimientos en el área del desarrollo de software para adentrarme en el mundo laboral profesional.


¿Cómo me veo en 10 años? 

Como un desarrollador independiente y dueño de mi propio estudio de desarrollo de videojuegos.




## Tema elegido: API Management

### Desarrollo Conceptual
API management o gestión de API es el proceso de diseño, publicación, documentación y análisis de API, en un entorno seguro. Mediante una herramienta de administración de API, se puede garantizar que tanto APIs públicas como internas funcionen correctamente y sean seguras. Puedes controlar el acceso, nutrir a la comunidad de suscriptores, recopilar y analizar estadísticas de uso e informar sobre el rendimiento.

Usualmente, los componentes de API management, proporcionan mecanismos y herramientas para ayudar a la comunidad de desarrolladores y suscriptores.

#### Diseño de API: es decir, brinda a los usuarios, desde desarrolladores hasta socios, la capacidad de diseñar, publicar e implementar una API, así como registrar documentación, políticas de seguridad, descripciones, límites de uso, capacidad de tiempo de ejecución, entre otra información relevante.

#### Puerta de enlace de API: 
funciona como un filtro de todas las APIs al hacer cumplir las políticas y solicitudes de seguridad de las APIs relevantes y también garantiza la autorización y la seguridad. 

#### Tienda de APIs: 
brinda a los usuarios la capacidad de mantener sus APIs en una tienda o catálogo donde pueden exponerlas a posibles interesados. Además, los usuarios pueden obtener soporte de los usuarios y la comunidad, etc. 

#### Análisis de API: 
la gestión de APIs permite a los usuarios monitorear el uso del API, la carga, los registros, las transacciones, los datos históricos, entre otras métricas que informan mejor el estado y el éxito de las APIs disponibles.

#### Monetización: 
esta función permite el cobro por el acceso a APIs comerciales. Esto incluye el soporte para configurar reglas de precios, según el uso, la carga y la funcionalidad, emitir facturas y cobrar pagos.

### Consideraciones Técnicas:

La plataforma de API management en cuestión es "Apigee", plataforma de API management de google. Para este proyecto usaremos APIGEE para establecer un proxy entre el frontend y backend .

Para ello es necesario 


## Patron Cloud a Implementar : Asynchronous Request-Reply

### **Problema :**

Hoy en dia las aplicaciones  que corren en navegadores  hacen uso de multiples API's para ofrecer funcionalidad y valor a las empresas y usuarios. Estas usualmente se hacen mediante llamadas en el protocolo HTTP y Rest, y aunque en al acutalidad la gra mayoria de estas apis están optimizadas para responder en 100ms o menos todavia hay muchos factores que pueden afectar la latencia en la respuesta, cómo por ejemplo:

- Componentes de seguridad.
- La ubicación geográfica relativa del autor de la llamada y el backend.
- Infraestructura de red.
- Carga actual.
- El tamaño de la carga útil de la solicitud.
- Longitud de la cola de procesamiento.
- El tiempo que tarda el backend en procesar la solicitud.

Esto se refuerza aún más cuando de peticiones sincronas se tratan, aunque si bien se podria optar por peticiones asíncronas simples que se maneje en la misma sesión no podria ser viable para sistemas disbribuidos o con mulitples servicios.

### **Solución:**
Mediante la implementación del patrón Asynchronous Request-Reply se espera que los usuarios puedan completar formulario de registro sin la necesidad de esperar a que su dni o RUC se valide meidiante la API de APIsPerú, cumpliendo así con la finalidad del patrón Asynchronous Request-Reply de permitir seguir haciendo uso de otras funciones de la aplicación hast aque se reciba la respuesta de la API.

### **Casos de aplcación :**

### **Aplicación en el trabajo de Grupo :**



El problema que se logró identificar es que uno ed los pasos que los clientes y proveedores deben completar para registrarse es la validación del DNI o RUC por motivos de seguridad. Debido a que el registros consta de varios pasos y que la validadción puede demorar o dar algún error dependiendo de la API seria un problema detener el registro unicamente para validar los documentos de identidad cuando podrian validarse antes de enviar la conclusión del registro.

[Regresar al índice](../../README.md)
