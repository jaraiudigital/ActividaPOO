import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // Prueba de conexión a la base de datos
        try {
            Connection conexion = ConexionMySQL.getInstancia().getConexion();
            if (conexion != null && !conexion.isClosed()) {
                System.out.println("Conexión exitosa a la base de datos.");
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (Exception e) {
            System.out.println("Error al probar la conexión: " + e.getMessage());
        }

        // Gestión de profesores
        GestorProfesores gestor = new GestorProfesores();

        // Adicionar 50 profesores al sistema y a la base de datos
        Profesor[] nuevosProfesores = {
                new Profesor("Ana", "Gómez", "1980-05-15", "Femenino", 1.68, 65, "Historia", 3200000),
                new Profesor("Carlos", "Pérez", "1975-03-20", "Masculino", 1.75, 80, "Matemáticas", 4000000),
                new Profesor("Lucía", "Martínez", "1990-07-10", "Femenino", 1.60, 55, "Física", 3500000),
                new Profesor("Juan", "Rodríguez", "1985-11-25", "Masculino", 1.80, 85, "Química", 3700000),
                new Profesor("María", "Fernández", "1992-01-30", "Femenino", 1.65, 60, "Biología", 3300000),
                new Profesor("Amalia", "Sanchez", "1982-05-15", "Femenino", 1.65, 70, "Idiomas", 3200000),
                new Profesor("Armando", "Pelaez", "1978-03-20", "Masculino", 1.79, 80, "Software", 4000000),
                new Profesor("Laura", "Melendez", "1992-07-10", "Femenino", 1.63, 58, "Comunicaciones", 3500000),
                new Profesor("Bernardo", "Restrepo", "1988-11-25", "Masculino", 1.82, 88, "Literatura", 3700000),
                new Profesor("Mirella", "Farias", "1998-01-30", "Femenino", 1.60, 66, "Derecho", 3300000),
                new Profesor("Carolina", "Guevara", "1980-05-15", "Femenino", 1.68, 65, "Sicologia", 3200000),
                new Profesor("Edgar", "Peralta", "1985-03-20", "Masculino", 1.75, 80, "Matemáticas", 4000000),
                new Profesor("Veronica", "Merlano", "1990-07-10", "Femenino", 1.60, 55, "Física", 3500000),
                new Profesor("Nicolas", "Renteria", "1985-11-25", "Masculino", 1.80, 85, "Química", 3700000),
                new Profesor("Genoveva", "Hurtado", "1992-01-30", "Femenino", 1.65, 60, "Biología", 3300000),
                new Profesor("Juanita", "Garcia", "1980-05-15", "Femenino", 1.68, 65, "Historia", 3200000),
                new Profesor("Cesar", "Lopez", "1975-03-20", "Masculino", 1.75, 80, "Matemáticas", 4000000),
                new Profesor("Lorena", "Duarte", "1990-07-10", "Femenino", 1.60, 55, "Física", 3500000),
                new Profesor("Jeronimo", "Cuadrado", "1985-11-25", "Masculino", 1.80, 85, "Química", 3700000),
                new Profesor("Mercedes", "Sossa", "1992-01-30", "Femenino", 1.65, 60, "Biología", 3300000),
                new Profesor("Wendy", "Alcaraz", "1980-05-15", "Femenino", 1.68, 65, "Historia", 3200000),
                new Profesor("Fabian", "Estrada", "1975-03-20", "Masculino", 1.75, 80, "Matemáticas", 4000000),
                new Profesor("Leidy", "Lora", "1990-07-10", "Femenino", 1.60, 55, "Física", 3500000),
                new Profesor("Jonas", "Hinestrosa", "1985-11-25", "Masculino", 1.80, 85, "Química", 3700000),
                new Profesor("Yesenia", "Granda", "1992-01-30", "Femenino", 1.65, 60, "Biología", 3300000),
                new Profesor("Eliana", "Quintero", "1980-05-15", "Femenino", 1.68, 65, "Historia", 3200000),
                new Profesor("Colacho", "Mendoza", "1975-03-20", "Masculino", 1.75, 80, "Matemáticas", 4000000),
                new Profesor("Estela", "Diaz", "1990-07-10", "Femenino", 1.60, 55, "Física", 3500000),
                new Profesor("Werly", "De Ossa", "1985-11-25", "Masculino", 1.80, 85, "Química", 3700000),
                new Profesor("Desiret", "Bermudez", "1992-01-30", "Femenino", 1.65, 60, "Biología", 3300000),
                new Profesor("Olga", "Perez", "1980-05-15", "Femenino", 1.68, 65, "Historia", 3200000),
                new Profesor("Oscar", "Rojas", "1975-03-20", "Masculino", 1.75, 80, "Matemáticas", 4000000),
                new Profesor("Manuela", "Benavides", "1990-07-10", "Femenino", 1.60, 55, "Física", 3500000),
                new Profesor("Raul", "Giraldo", "1985-11-25", "Masculino", 1.80, 85, "Química", 3700000),
                new Profesor("Eva", "Mendez", "1992-01-30", "Femenino", 1.65, 60, "Biología", 3300000),
                new Profesor("Yulieth", "Jimenez", "1980-05-15", "Femenino", 1.68, 65, "Historia", 3200000),
                new Profesor("Jorge", "Aviles", "1975-03-20", "Masculino", 1.75, 80, "Matemáticas", 4000000),
                new Profesor("Marcela", "Rojas", "1990-07-10", "Femenino", 1.60, 55, "Física", 3500000),
                new Profesor("Jose", "Chaverra", "1985-11-25", "Masculino", 1.80, 85, "Química", 3700000),
                new Profesor("Mery", "Hoyos", "1992-01-30", "Femenino", 1.65, 60, "Biología", 3300000),
                new Profesor("Diana", "Perez", "1980-05-15", "Femenino", 1.68, 65, "Historia", 3200000),
                new Profesor("Argemiro", "Gallego", "1975-03-20", "Masculino", 1.75, 80, "Matemáticas", 4000000),
                new Profesor("Lilibeth", "Gutierrez", "1990-07-10", "Femenino", 1.60, 55, "Física", 3500000),
                new Profesor("Jorge", "Bermejal", "1985-11-25", "Masculino", 1.80, 85, "Química", 3700000),
                new Profesor("Sara", "Fino", "1992-01-30", "Femenino", 1.65, 60, "Biología", 3300000),
                new Profesor("Isabel", "Santodomingo", "1980-05-15", "Femenino", 1.68, 65, "Historia", 3200000),
                new Profesor("Corina", "Machado", "1975-03-20", "Masculino", 1.75, 80, "Matemáticas", 4000000),
                new Profesor("Cindy", "Avello", "1990-07-10", "Femenino", 1.60, 55, "Física", 3500000),
                new Profesor("Nicolas", "Cabellos", "1985-11-25", "Masculino", 1.80, 85, "Química", 3700000),
                new Profesor("Mirta", "Almanza", "1992-01-30", "Femenino", 1.65, 60, "Biología", 3300000)
        };

        for (Profesor profesor : nuevosProfesores) {
            gestor.agregarProfesor(profesor);
        }

        System.out.println("Se han agregado los profesores al sistema y a la base de datos.");

        // Mostrar el arreglo de profesores
        gestor.mostrarProfesores();
    }
}