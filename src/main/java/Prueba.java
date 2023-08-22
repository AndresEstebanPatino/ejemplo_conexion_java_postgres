import javax.swing.plaf.nimbus.State;

import java.sql.*;

public class Prueba {
    public static void main(String[] args) throws SQLException {
        // Definimos la url a la que nos vamos a conectar
        String url = "jdbc:postgresql://localhost:5433/alumnos";
        // Definimos el nombre y la contraseña del servidor de postgres
        String user = "postgres";
        String password = "root";

        // Defino una variable en la que voy a almacenar la conexión a la base de datos y le paso la url, nombre y contraseña
        Connection conection = DriverManager.getConnection(url, user, password);

        // Se utiliza el try para asegurarnos de que los recursos que se usen se cierren adecuadamente
        // Se crea un objeto de la clase Statement que se utiliza para hacer consultas a la base de datos
        try(Statement declaracion = conection.createStatement();
            // Se crea un objeto de la clase ResultSet para almacenar la respuesta de la petición
            // Se ejecuta la consulta con el método executeQuery
            ResultSet response = declaracion.executeQuery("SELECT * FROM alumnos")){
            // Definimos el bucle while para decir que si hay repuesta por medio del método next pase al siguiente resultado
            while (response.next()){

                String nombre = response.getString("nombre");
                Integer id = response.getInt("numcontrol");
                System.out.println("Alumno: " + nombre + " " + "Id: " + id);
            }

        }

    }
}
