# George Zuñiga Mariño

### Experiencia:
Cuento con experiencia en codigo de bajo nivel ,ademas de herramientas digitales aplicadas a la realidad virtual , y con desarrollo en antiguos proyectos experimentales para sitios web. 
### Tecnologías:
- Java
- Python
- Javascript
- C#
- C++
- Rstudio
### Expectativa
Aplicar mi conocimiento aprendido a diferentes usos , ademas de tener diferentes medios de perspectiva en el area de la arquitectura de software.
### De aquí a 10 años
- Desarrollar mi sueño de aplicar mis conocimientos a mayor profundidad en el desarrollo de la realidad virtual

----------------------------------------------------------------------------------------------------------------------------


## **TEMA ELEGIDO**:  NoSQL - Bases de Datos Orientadas a Documentos
Las bases de datos de documentos son una categoría de sistemas NoSQL que permiten almacenar y consultar datos en formatos como JSON. Este formato, conocido como Notación de Objetos de JavaScript (JSON), es un medio de intercambio de datos que resulta fácil de leer tanto para umanos como para máquinas. Los desarrolladores pueden utilizar documentos JSON en su código y guardarlos de forma directa en una base 
de datos de documentos. Su naturaleza flexible, semi-estructurada y jerárquica facilita la evolución de las aplicaciones de acuerdo a sus necesidades.
![](CosmoDB.png)
### Bases de datos de documentos JSON
1. **Facilidad de desarrollo**:
Los documentos JSON se alinean estrechamente con los objetos, un tipo de dato común en la mayoría de lenguajes de programación. Durante el desarrollo de aplicaciones, los programadores pueden crear y actualizar documentos de forma directa desde su código, eliminando la necesidad de definir modelos de datos previamente, lo que hace que el desarrollo sea más ágil.
2. **Esquema flexible**:Una base de datos orientada a documentos permite tener distintos tipos de documentos con diferentes estructuras dentro de la misma colección. Esto es útil para almacenar datos no estructurados, como correos electrónicos o publicaciones en redes sociales. Algunas bases de datos incluso permiten aplicar validaciones de esquema para imponer restricciones a la estructura.
3. **Rendimiento a escala**:Las bases de datos de documentos pueden escalar horizontalmente sobre múltiples servidores sin afectar el rendimiento, lo que resulta en una solución rentable. También soportan la replicación integrada, lo cual mejora la tolerancia a fallos y la disponibilidad.
### Casos de uso
Las bases de datos de documentos son adecuadas para escenarios como 
gestión de contenido, catálogos de productos y gestión de datos de 
sensores, donde cada documento es único y puede evolucionar a lo largo 
del tiempo. 
1. **Administración de contenido**:I
deal para aplicaciones como blogs y plataformas de video, donde cada entidad puede ser almacenada como un único documento. Si el modelo de datos cambia, solo se actualizan los documentos afectados sin la necesidad de modificar esquemas.
2. **Comercio**: En el comercio electrónico, donde los productos pueden tener diferentes atributos, las bases de datos de documentos permiten almacenar cada producto en un solo documento, lo que facilita su gestión y mejora el rendimiento de las consultas.
3. **Sensores**:En aplicaciones IoT, los datos de los sensores son variables y pueden llegar incompletos o duplicados. Las bases de datos de documentos son ideales para almacenar estos datos de manera rápida y flexible, sin necesidad de limpiarlos de antemano.
### Cómo funcionan
Estas bases de datos almacenan la información en pares clave-valor, donde la clave es una cadena de texto y el valor puede ser cualquier tipo de dato (número, booleano, etc.). Además, permiten trabajar con matrices y objetos anidados, lo que facilita la representación de estructuras de datos complejas.

## **BASE DE DATOS ELEGIDA : cosmoDB**
Azure Cosmos DB es una base de datos NoSQL de Microsoft, diseñada para ofrecer alta disponibilidad y escalabilidad global. Soporta múltiples modelos de datos como JSON, claves-valor y grafos. Su arquitectura distribuida permite replicar datos en varias regiones, garantizando baja latencia y acceso rápido a nivel mundial.
### Ventajas:
1. Replicación Global: Datos replicados en varias regiones para acceso rápido y alta disponibilidad.
2. Escalabilidad: Ajuste automático de almacenamiento y rendimiento según demanda.
3. Modelos de Consistencia: Ofrece cinco niveles de consistencia para balancear latencia y precisión de los datos.
### Desventajas:
1. Costo Elevado: Puede ser caro con muchas réplicas o alto tráfico.
2. Relaciones Complejas: No es ideal para aplicaciones con múltiples relaciones entre datos, como bases de datos SQL.

## INICIACION DE LA BD
ABRIR LA BD DE COSMODB MEDIANTE UN NAVEGADOR
### 1er paso : Ir al portal de AZURE , inciar sesion con una cuenta e ingresar a CosmoDB.
![image](https://github.com/user-attachments/assets/04ed3851-7d07-4d03-8db9-670785703c88)

### 2do paso : Crear la BD
![](BDMON.png)
### 3er paso : Construir el codigo y Ejecutarlo
1. Descargar los recursos MAVEN 
**https://maven.apache.org/download.cgi**

2. Crear un proyecto Maven 
Ejecutar el siguiente codigo en la terminal de VSCODE para crear un archivo MAVEN:

---------------
**mvn archetype:generate -DgroupId=com.ejemplo.cosmosdb -DartifactId=CosmosDBExample -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false**

--------------


3. Modificar las dependencias actuales por
**<dependencies>
    <dependency>
        <groupId>org.mongodb</groupId>
        <artifactId>mongo-java-driver</artifactId>
        <version>3.12.10</version>
    </dependency>
</dependencies>**

4. Estructurar el Codigo en VSCODE con la cadena de CONEXION PRINCIPAL que azure te proporciona
![image](https://github.com/user-attachments/assets/2fa7a265-0df5-4946-a7fc-9b6711f01a5b)
![image](https://github.com/user-attachments/assets/e54dd511-0d04-4510-a21c-b3b72ba6601d)
5. Instalar las dependencias necesarias
![image](https://github.com/user-attachments/assets/ce650f6b-8388-41b0-9b44-e261b646b0c6)
6. Ejecutar el codigo
![image](https://github.com/user-attachments/assets/904dd710-2e27-4d98-88d3-f9779e8d9632)
![image](https://github.com/user-attachments/assets/878efb1e-e1af-4fc4-9881-4bb50e832c24)


# ENLACE DEL VIDEO :
### https://drive.google.com/file/d/1xSZsN9KD-ypYWFEx6YlAGP5Ns1hzhukX/view?usp=sharing








------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------


## Patron CLOUD - Patrón Valet Key
### Problema
En sistemas distribuidos y aplicaciones modernas que manejan grandes volúmenes de datos, como servicios de almacenamiento en la nube o plataformas de streaming, los clientes frecuentemente necesitan acceso directo a los recursos de almacenamiento. Sin embargo, permitir acceso directo implica desafíos en términos de seguridad, control de acceso y costos operativos. La transferencia de datos a través de la aplicación, aunque controlada, puede derivar en una sobrecarga de procesamiento y consumo de recursos, impactando negativamente en el rendimiento, la escalabilidad y el costo de operación de la aplicación. En sistemas donde múltiples clientes solicitan el acceso a datos masivos, el proceso de autenticación y autorización continua genera latencia y demanda adicional de ancho de banda y poder de procesamiento, volviéndose un obstáculo significativo para la eficiencia de la aplicación.

### Propuesta de Solución
El patrón Valet Key (o "clave auxiliar") surge como una solución que permite otorgar acceso directo y seguro a los recursos de almacenamiento a través de la generación de un token temporal o clave auxiliar. Este token es emitido por la aplicación y permite al cliente realizar operaciones específicas en el almacenamiento (como lectura o escritura) durante un tiempo limitado. El patrón Valet Key no solo optimiza el flujo de datos al reducir la carga sobre el servidor, sino que también mejora la seguridad al evitar compartir credenciales de acceso permanentes.

### Características Fundamentales 
1. *Acceso Temporal y Limitado:* Los tokens generados bajo el patrón Valet Key permiten un acceso restringido a los recursos, tanto en permisos (lectura, escritura) como en el tiempo de validez. Esto garantiza que, una vez expirado el token, el cliente no podrá realizar más operaciones en el recurso.

2. *Control de Permisos Granulares:* La aplicación puede configurar los permisos específicos de cada token, adaptándolos a los requisitos de cada operación. Por ejemplo, se pueden definir permisos de solo lectura para permitir que el cliente consulte datos sin poder modificarlos.

3. *Optimización de Recursos y Costos:* Al permitir el acceso directo del cliente al almacenamiento, se descarga el procesamiento en el servidor, lo cual mejora la escalabilidad del sistema y reduce costos operativos derivados de la transferencia de datos.

4. *Seguridad Mejorada:* La seguridad se ve fortalecida al no compartir credenciales duraderas con el cliente. Los tokens de acceso son únicos, temporales y específicos para cada operación, limitando la exposición a ataques o usos indebidos.

### Componentes Principales
- API de Autenticación y Generación de Tokens: Es el punto inicial donde la aplicación valida la solicitud del cliente y genera el token. Esta API, alojada en un entorno seguro (por ejemplo, una Azure Function o un servicio Lambda en AWS), controla el acceso inicial y establece los permisos y el tiempo de validez del token.

- Token o Clave Auxiliar: Este token contiene las reglas de acceso y el período de validez, permitiendo que el cliente interactúe con el recurso de almacenamiento según los permisos asignados.

- Almacenamiento en la Nube: Es el recurso final donde se encuentran los datos a los que el cliente necesita acceder. El cliente utiliza el token para ejecutar las operaciones requeridas (como cargas, descargas, consultas) directamente en el almacenamiento, sin que la aplicación actúe como intermediaria.

- Sistema de Registro y Monitoreo: Para garantizar la seguridad y trazabilidad del acceso, se registran las solicitudes de generación de tokens y las operaciones realizadas por los clientes, permitiendo auditorías y análisis de seguridad.

###  Implementación
Se debe considerar una plataforma de almacenamiento de datos multimedia en la nube, donde cada cliente necesita cargar archivos de manera periódica:

1. Solicitud del Cliente: Un cliente realiza una solicitud de carga de archivo a la aplicación.
2. Validación y Generación del Token: La aplicación valida la autenticidad de la solicitud y, si es legítima, genera un token de acceso con permisos de carga, válido solo por un tiempo breve (por ejemplo, 10 minutos).
3. Acceso Directo al Almacenamiento: El cliente utiliza el token para cargar el archivo directamente al almacenamiento en la nube. Esto evita que la aplicación tenga que gestionar el flujo de datos.
4. Expiración del Token: Después de la carga, el token expira, evitando accesos no autorizados posteriores al recurso.

### Aplicaciones Prácticas y Reales del Patrón Valet Key en la Industria
1. **Plataformas de Distribución de Contenidos:** Plataformas de contenido en línea, como servicios de almacenamiento en la nube y streaming, implementan este patrón para manejar grandes volúmenes de carga y descarga de archivos, optimizando la transferencia y garantizando la seguridad.

2. **Aplicaciones de Respaldo y Almacenamiento en la Nube:** Servicios de respaldo en la nube utilizan el patrón Valet Key para que los usuarios carguen y descarguen datos con permisos y tiempos de acceso definidos, evitando congestión y costos adicionales en el servidor.

3. **CDNs (Redes de Entrega de Contenido)**: Para mejorar el tiempo de carga y entrega de recursos a los usuarios en distintas ubicaciones, los CDNs utilizan el patrón Valet Key, permitiendo a los usuarios acceder a recursos específicos sin que la plataforma central actúe como intermediaria, lo cual mejora la eficiencia de red y reduce la latencia.

## Ventajas y Limitaciones 
**Ventajas:**

1. **Escalabilidad Mejorada:** Al reducir la carga del servidor, el sistema puede manejar un mayor número de solicitudes sin comprometer el rendimiento.
2. **Costos Reducidos:** Al evitar que la aplicación gestione directamente la transferencia de datos, se reducen los costos de procesamiento y ancho de banda.
3. **Acceso Seguro y Controlado:** El uso de tokens temporales limita la exposición a riesgos de seguridad y garantiza que los accesos sean seguros y monitorizados.

**Limitaciones:**

1. **Pérdida de Control:** Una vez que el token es emitido, la aplicación tiene un control limitado sobre cómo el cliente lo utiliza. Si el token es interceptado, el recurso estará expuesto durante el período de validez.
2. **Complejidad en la Auditoría:** No siempre es posible controlar el número exacto de accesos o la cantidad de datos transferidos sin un sistema de monitoreo adicional.
3. **Integración Compleja en Sistemas Heredados:** Para aplicaciones que no están diseñadas con una arquitectura en la nube, la implementación de este patrón puede requerir modificaciones estructurales importantes.
### Consideraciones de Implementación Adicionales
Para que se pueda asegrar de que la implementacion se realize correctamente ,es necesario considerar diferentes aspectos , tales como ...

1. *Período de Validez del Token:* Debe ser lo suficientemente breve para reducir riesgos de seguridad, pero también permitir que el cliente complete la operación.
2. *Control de Permisos Granular:* El token debe tener permisos mínimos para realizar la operación, limitando el acceso solo a las acciones necesarias.
3. *Monitoreo y Auditoría Continua:* Implementar un sistema de monitoreo que registre todas las operaciones de los tokens para analizar el uso y detectar comportamientos inusuales.

# Implementacion del Codigo y Prueba


## Requisitos Necesarios
1. **Cuenta de Azure Storage:** Necesitarás una cuenta de almacenamiento en Azure.
2. **Visual Studio Code:** Configura un proyecto .NET Core en Visual Studio Code.
3. **Bibliotecas NuGet:** Instala la biblioteca Azure.Storage.Blobs para trabajar con el almacenamiento de blobs en Azure.

para instalar el az.st.bl ,ejecuta el comando en vscode en su terminal

- dotnet add package Azure.Storage.Blobs

## Implementación

- Crear un Contenedor en la cuenta de Azure storage y tener la cadena de conexion de cuenta de almacenamiento en azure

Codigo para VSCODE(en C#)

```
using Azure.Storage;
using Azure.Storage.Blobs;
using Azure.Storage.Sas;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using System;

namespace ValetKeyExample.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class StorageController : ControllerBase
    {
        private readonly IConfiguration _configuration;

        public StorageController(IConfiguration configuration)
        {
            _configuration = configuration;
        }

        [HttpGet("generate-sas-token")]
        public IActionResult GenerateSasToken(string blobName)
        {
            try
            {
                // Obtiene la cadena de conexión del archivo de configuración
                string connectionString = _configuration.GetConnectionString("AzureStorage");

                // Es el nombre del contenedor
                string containerName = "EsperoAprobar"; //

                // Crea un cliente para el contenedor
                BlobContainerClient containerClient = new BlobContainerClient(connectionString, containerName);

                // Verificar que el contenedor exista
                if (!containerClient.Exists())
                {
                    return NotFound("El contenedor especificado no existe.");
                }

                // Crear un cliente para el blob
                BlobClient blobClient = containerClient.GetBlobClient(blobName);

                // Define la política SAS con permisos de escritura y tiempo de expiración
                BlobSasBuilder sasBuilder = new BlobSasBuilder
                {
                    BlobContainerName = containerClient.Name,
                    BlobName = blobClient.Name,
                    Resource = "b", // Tipo de recurso "blob"
                    ExpiresOn = DateTimeOffset.UtcNow.AddMinutes(10) // Tiempo de expiración del token
                };

                // Establece los permisos (solo escritura en este caso)
                sasBuilder.SetPermissions(BlobSasPermissions.Write);

                // Generar la URI SAS
                string sasToken = sasBuilder.ToSasQueryParameters(new StorageSharedKeyCredential(
                    containerClient.AccountName, 
                    _configuration["AzureStorageKey"])).ToString();

                // Genera la URI completa con el token
                Uri sasUri = new Uri($"{blobClient.Uri}?{sasToken}");

                // Retorna el URI SAS al cliente
                return Ok(new { sasUri });
            }
            catch (Exception ex)
            {
                return StatusCode(500, $"Error al generar el token SAS: {ex.Message}");
            }
        }
    }
}
```
### Ademas de Esto es necesario tener un archivo que configure la cadena de conexion y la clave de acceso a azure Storage(Ponerlo en otro archivo )
```
{
  "ConnectionStrings": {
    "AzureStorage": "DefaultEndpointsProtocol=https;AccountName=**************;AccountKey=******************;EndpointSuffix=core.windows.net"
  },
  "AzureStorageKey": "***********"
}
```
### Con la URI SAS que generamos , cualquier cliente puede subir un archivo directamente al almacenamiento
```
using Azure.Storage.Blobs;
using System;
using System.IO;
using System.Threading.Tasks;

public class UploadClient
{
    public async Task UploadFileAsync(Uri sasUri, string filePath)
    {
        BlobClient blobClient = new BlobClient(sasUri);
        using FileStream fileStream = File.OpenRead(filePath);
        await blobClient.UploadAsync(fileStream);
        Console.WriteLine("Archivo subido exitosamente.");
    }
}
```

Ejecucion :
Para que funcione correctamente , debes ejecutar la API en VSCODE , para que este disponible

```
http://localhost:5000/api/storage/generate-sas-token?blobName=ProfeQuiero20.
```

[Regresar al índice](../../README.md)
