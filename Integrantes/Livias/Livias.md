# Aarón Livias

![Aarón Livias](https://media.licdn.com/dms/image/v2/D4E03AQGd6fPm4Jv6OA/profile-displayphoto-shrink_800_800/profile-displayphoto-shrink_800_800/0/1703021391954?e=1729728000&v=beta&t=a5BQTeZpRUQChEQEBUOQGYtUZSlD-jUI57po782suKA)
### Experiencia:
Mi experiencia en desarrollo de software se ve presente en los trabajos personales realizados en las vacaciones. Últimamente eh desarrollado un proyecto de web scraping a distintas páginas web para armar una base de datos propia. Por otro lado, me enfoqué en proyectos relacionado a manejar páginas wed que se centren a cumplir ciertos requisitos de seguridad.
### Tecnologías:
- Python
- Javascript (React)
- Typescript
- Rstudio
### Expectativa:
Aprender a seleccionar las mejores opciones para desarrollar un proyecto apropiadamente, así como incrementar las habildades técnicas y blandas para culminar el proyecto con la calidad deseada.
### De aquí a 10 años
- Trabajando para un proyecto relacionada a las páginas web, tareas como darle mantenimiento o agregar nuevas funcionalidades.

# Tema elegido: Técnicas NLP
## Panorama General
El presente proyecto aborda técnicas NLP para tareas de resumenes y similitud de textos. De esta forma se plantea incorporarlo en el trabajo grupal para ayudar al usuario en la elección del servicio del hogar de modo que se le muestre un resumen de las las reseñas que van generando los servicios. La estrategia se inspira de Mercado Libre en la que incorpora una IA el resumen de textos asociados a sus productos.

![Mercado Libre](https://drive.google.com/uc?export=view&id=1hCmi7Io9b_BaNVUuTnPKbqm_TUABGyW5)

## Modelos de simlitud de textos

### Desarrollo conceptual
#### TF-IDF
Es un algoritmo que realiza un cálculo estadístico para medir qué terminos son relevantes para un texto en particular. Está compuesto por dos términos:
TF: Calcula el número total de términos y el número total de apariciones de un término específico (t) en un documento (d). 

$$
TF (t,d)=(`Número total de t en d`)/(`Número total de términos en d`)
$$

IDF: El IDF mide que tanto ese término específico aparece en el corpus

$$
IDF (t)=1+log⁡((`Número total de documentos`)/(`Número de documentos en t`))
$$

En síntesis, las palabras con mayor TF-IDF se caracterizar por ser de las más frecuentes en ese texto pero excasas en todo el corpus que representa el conjunto de texto. Funciona bien si comentarios similares tienden a compartir las mismas palabras o términos clave, pero sensible a los stopwords. Son palabras irrelevantes para el algoritmo las cuales pueden ser: "la", "y", "los", etc. Por eso hay que filtrarlos.

#### Doc2vec
Captura relaciones semánticas más profundas a nivel de documento. Ejemplo: "La entrega fue excelente" y "Me llegó muy rápido" tiene una relación semántica alta. Esta basada en word2vec la cual tiene dos arquitecturas principales:
1. CBOW: Captura la relación semántica de las palabras y su entrenamiento consiste en predecir una palabra a partir de las palabras que lo rodea, pero expresado en números o vectores. La cual la arquitectura DM se basa de CBOW para la creación de la variante Doc2vec.
2. Skip-gram: En contraste, esta arquitectura se centra en predecir varias palabras a partir de la palabra objetivo. A partir de este se basa la arquitectura DBOW de Doc2vec.

Arquitectura principales de Doc2vec:

| **Memoria Distribuida (DM)** | **Bolsa Distribuida de Palabras (DBOW)** |
|-------------------------------|-----------------------------------------|
| Predice palabras a partir de los vectores de palabras y documentos. | Predecir las palabras a partir del vector del documento. |
| Representación global del documento y la relación que hay dentro de sus palabras. | Representación global del documento. |
| Los datos no se tratan como una bolsa. | Las palabras se tratan como una "bolsa" dado que el orden de estas no importan |

Asimismo, Eberhard et al. (2024) realiza una comparación de estas técnicas en su desempeño para la recomendación de películas:

![Doc2vec y TF-IDF](https://drive.google.com/uc?export=view&id=1d0D7_7yMKR82JuIjj2x0OLeuQTzh5Q8V)

### Consideraciones técnicas
El lenguaje de programación a utilizar es python. Primero se establece una maquina virtual con los siguientes comandos en el command prompt:

```
python -m venv mi_entorno
mi_entorno\Scripts\activate
```

Luego se instala las librerias necesarias para la generación del modelo:
```
pip install nltk scikit-learn gensim pandas numpy
```

Adicionalmente, se descarga librerias específicas, lo puede hacer con el command prompt o ejecutandolo una sola vez en el código:
```
# Tokenización
nltk.download('punkt') 
nltk.download('punkt_tab')

# Lematización
nltk.download('wordnet')
#   Soporta lematización en varios idiomas
nltk.download('omw-1.4')
```
Terminada la instalación, se procederá a explicar la lógica del proyecto.

![Flujo Doc2vec y TF-IDF](https://drive.google.com/uc?export=view&id=16LtKE4OniMIASw3RjdzQo5vLLYf-ncbL)

1) A partir de un diccionario, se tokeniza para segmentar las oraciones en palabras y se lematiza para convertar la palabra en su forma base.
2) Podemos utilizar tanto TF-IDF como Doc2vec para generar vectores de representación de reseñas o Embeddings. Con respecto al modelo Doc2vec se requiere establecer algunos parametros de entrada para el entrenamiento. Cabe aclara que por default, el Doc2vec utiliza la arquitectura DM, pero si se requiere cambiar de arquitectura se agraga un parámetro extra definido como 'dm=0'. A continuación los parámetros del modelo:
```
# Definir y entrenar el modelo Doc2Vec
model = Doc2Vec(vector_size=50, #longitud vector que representa la palabra
                window=2, #Número de palabras (izq o der) a tomar en cuenta para hallar la palabra objetivo (La palabra que se va a predecir).
                min_count=1, # El número mínimo de veces que una palabra debe aparecer para considerarse.
                workers=4, # El número de hilos (threads) - Tareas que se realizan en parelelo para agilizar el modelo.
                epochs=100 # Número de veces que pasará el modelo por el conjunto de datos.
                )
```
3) Luego se utiliza las métricas de similitud más populares como la similitud coseno o la distancia euclidiana y así clasificar los vectores. Esto genera una matriz o un arrays de arryas, en la que cada array representa un documento y sus valores el nivel de similitud que tien hacia otros documentos. En la imagen, el primer valor es 1 porque el texto uno es igual al texto 1, pero en el segundo array el 1 se observa en el segundo valor (indicando que el texto 2 es igual al . Así se representa la probabilidad que hay en que un texto sea similar a otro.

![Matriz Doc2vec y TF-IDF](https://drive.google.com/uc?export=view&id=1zF2DL02Ile-c2_AzyUA9sHxSZNHT-f6Z)
  
4) Se escoge la ID de un texto, por ejemplo, la ID=3 y a partir de la array escogido se ordena de mayor a menor las probabilidades a través de un algoritmo de ordenamiento de Quicksort o directamente argost de Numpy.

Lo cual si se escoge la ID = 3, se obtendrá como resultado:

![Resultado Doc2vec y TF-IDF](https://drive.google.com/uc?export=view&id=1mdlsfVwzELy5BNfo2FMh8hBEkP08fGbu)


## Algoritmos de resumen de texto

## Fuentes
[Doc2Vec — Computing Similarity between Documents](https://medium.com/red-buffer/doc2vec-computing-similarity-between-the-documents-47daf6c828cd)

[Practical Guide To Doc2Vec & How To Tutorial In Python](https://spotintelligence.com/2023/09/06/doc2vec/)

[Abdurahman, B. Z., Ikhsan, N., Muslim, K. K. I., Kenneth, D. R., & Dwi, H. R. (2023). Movie recommender chatbot based on Dialogflow. International Journal of Electrical and Computer Engineering (IJECE).](https://doi.org/10.11591/ijece.v13i1.pp936-947)

[Blessed, G., Bello Kontagora, N., Agajo, J., & Aliyu, I. (2023). Performance evaluation of keyword extraction techniques and stop word lists on speech-to-text corpus. The International Arab Journal of Information Technology, 20(1).](https://doi.org/10.34028/iajit/20/1/14)

[¿Cómo generar palabras clave a partir de un texto? (2024, mayo 2). Eskritor.](https://eskritor.com/es/generar-palabras-clave-a-partir-de-texto/)

[Eberhard, L., Popova, K., Walk, S., & Helic, D. (2024). Computing recommendations from free-form text. Expert Systems with Applications, 236(121268), 121268.](https://doi.org/10.1016/j.eswa.2023.121268)

[Hong, M., Chung, N., & Koo, C. (2023). Tourism recommendation based on word embedding from card transaction data. Computer Science and Information Systems.](https://doi.org/10.2298/CSIS220620002H)

## Regresar
[Regresar al índice](../../README.md)
