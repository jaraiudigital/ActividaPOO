import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//se crea el arreglo de profesores y se inicializa el contador
public class GestorProfesores {
    private Profesor[] profesores = new Profesor[50];
    private int contador = 0;
//
    public void agregarProfesor(Profesor p) {
        if (contador < profesores.length) {
            profesores[contador] = p;
            insertarEnBaseDatos(p);
            contador++;
        } else {
            System.out.println("No se pueden agregar más profesores.");
        }
    }
//conexión a la bd usando el driver jdbc y ejecución de la sentencia SQL para insertar el profesor
    private void insertarEnBaseDatos(Profesor p) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mi_bd", "root", "Jara1975");
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(p.getInsertSQL());
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al insertar en la base de datos: " + e.getMessage());
        }
    }

    public void mostrarProfesores() {
        for (int i = 0; i < contador; i++) {
            profesores[i].mostrarProfesor();
            System.out.println("-------------------------");
        }
    }
}