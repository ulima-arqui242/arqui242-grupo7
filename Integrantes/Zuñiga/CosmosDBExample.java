package com.ejemplo.cosmosdb;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;

public class CosmosDBExample {

    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    public static void main(String[] args) {
        // URI de conexión obtenida desde el portal de Azure
        String connectionString = "mongodb://ge45:FuNquYbxIDYOwCyXk88UtEmraegjGmvZsTx8Ff5Kzxak9ICIMxvRuFXjXXeSpUbejz3WwWxhoD32ACDbkESzRQ==@ge45.mongo.cosmos.azure.com:10255/?ssl=true&replicaSet=globaldb&retrywrites=false&maxIdleTimeMS=120000&appName=@ge45@";
        MongoClientURI uri = new MongoClientURI(connectionString);

        // Conectar al cliente de MongoDB
        mongoClient = new MongoClient(uri);

        // Seleccionar la base de datos
        database = mongoClient.getDatabase("miBaseDeDatos");

        // Seleccionar la colección
        collection = database.getCollection("miColeccion");

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Insertar documento");
            System.out.println("2. Obtener documentos");
            System.out.println("3. Modificar documento");
            System.out.println("4. Eliminar documento");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (option) {
                case 1:
                    insertDocument(scanner);
                    break;
                case 2:
                    getDocuments();
                    break;
                case 3:
                    updateDocument(scanner);
                    break;
                case 4:
                    deleteDocument(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (option != 0);

        // Cerrar la conexión
        mongoClient.close();
    }

    private static void insertDocument(Scanner scanner) {
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese la profesión: ");
        String profesion = scanner.nextLine();

        Document documento = new Document("nombre", nombre)
                                .append("edad", edad)
                                .append("profesion", profesion);
        collection.insertOne(documento);
        System.out.println("Documento insertado exitosamente en Cosmos DB");
    }

    private static void getDocuments() {
        System.out.println("Documentos en la colección:");
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }
    }

    private static void updateDocument(Scanner scanner) {
        System.out.print("Ingrese el ID del documento a modificar: ");
        String id = scanner.nextLine();
        Document updatedDocument = new Document("nombre", "Nuevo Nombre")
                                     .append("edad", 30)
                                     .append("profesion", "Nueva Profesión");

        // Modificar el documento
        collection.updateOne(new Document("_id", new org.bson.types.ObjectId(id)), 
                              new Document("$set", updatedDocument));
        System.out.println("Documento modificado exitosamente.");
    }

    private static void deleteDocument(Scanner scanner) {
        System.out.print("Ingrese el ID del documento a eliminar: ");
        String id = scanner.nextLine();
        
        // Eliminar el documento
        collection.deleteOne(new Document("_id", new org.bson.types.ObjectId(id)));
        System.out.println("Documento eliminado exitosamente.");
    }
}

