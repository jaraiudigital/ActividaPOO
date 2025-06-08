//Clase que representa a un profesor, hereda de Persona
public class Profesor extends Persona {
    private String especialidad;
    private double salario;
// Constructor de la clase Profesor que hereda de Persona
    public Profesor(String nombre, String apellido, String fechaNacimiento, String genero,
                    double estatura, double peso, String especialidad, double salario) {
        super(nombre, apellido, fechaNacimiento, genero, estatura, peso); // llamar al constructor de Persona
        this.especialidad = especialidad;
        this.salario = salario;
    }
//método para mostrar los datos del profesor
    public void mostrarProfesor() {
        super.mostrarDatos(); // reutiliza método de la clase padre
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Salario: " + salario);
    }
// Método para obtener la sentencia SQL de inserción del profesor en la base de datos
    public String getInsertSQL() {
        return "INSERT INTO profesores(nombre, apellido, fecha_nacimiento, genero, estatura, peso, especialidad, salario) " +
                "VALUES ('" + nombre + "', '" + apellido + "', '" + fechaNacimiento + "', '" + genero + "', " +
                estatura + ", " + peso + ", '" + especialidad + "', " + salario + ")";
    }
}
