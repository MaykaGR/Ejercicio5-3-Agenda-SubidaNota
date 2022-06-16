import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

/**
 * Esta clase crea la conexión a la base de datos.
 * @property connection la Connection.
 * @property jdbcURL la jdbcURL.
 * @property jdbcUsername el nombre de usuario.
 * @property jdbcPassword la contraseña.
 */
class ConnectionBuilder {
    // TODO Auto-generated catch block
    lateinit var connection: Connection
    private val jdbcURL = "jdbc:h2:mem:default"
    private val jdbcUsername = "PROG"
    private val jdbcPassword = "prog"

    init {
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)
            connection.autoCommit = false
        } catch (e: SQLException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }
    }

}