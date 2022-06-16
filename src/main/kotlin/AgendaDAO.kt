
import java.sql.Connection
import java.sql.SQLException

/**
 * Esta clase crea una agenda como base de datos, en la que se almacenan los contactos.
 * @property create_table query para crear tabla.
 * @property insert query para insertar.
 * @property update query para actualizar.
 * @param nombre_tabla el nombre de la tabla.
 * @param c la conexión a la base de datos.
 * @param nomID el nombre del ID.
 */
class AgendaDAO(nombre_tabla: String = "agenda", c: Connection, nomID: String = "id_agenda") : DAO<Contactos>(nombre_tabla, c, nomID) {

        override val CREATE_TABLE =
            "CREATE TABLE $nombre_tabla (ID_AGENDA NUMBER(10,0) AUTO_INCREMENT, NOMBRE VARCHAR2(50), NUMERO VARCHAR2(20) );"
        override val INSERT = "INSERT INTO $nombre_tabla (nombre, numero) VALUES (?, ?)"
        override val UPDATE = "update $nombre_tabla set nombre = ?, numero = ? where id_agenda = ?"

    /**
     * Recibe un contacto y lo añade a la agenda, por medio de la query insert.
     * @return nada.
     */
        fun insert(contacto: Contactos) {
            //println(INSERT)
            // try-with-resource statement will auto close the connection.
            try {
                c.prepareStatement(INSERT).use { st ->
                    st.setString(1, contacto.nombre)
                    st.setString(2, contacto.tlf)
                    st.executeUpdate()
                }
                //Commit the change to the database
                c.commit()
            } catch (e: SQLException) {
                printSQLException(e)
            }
        }

    /**
     * Recibe un id y encuentra al contacto que corresponde.
     * @return contacto.
     */
        override fun selectById(id: Int): Contactos {
            var contacto = Contactos(nombre = "", tlf = "")
            // Step 1: Establishing a Connection
            try {
                c.prepareStatement(SELECT_BYID).use { st ->
                    st.setInt(1, id)
                    // Step 3: Execute the query or update query
                    val rs = st.executeQuery()

                    // Step 4: Process the ResultSet object.
                    while (rs.next()) {
                        val nombre = rs.getString("NOMBRE")
                        val numero = rs.getString("NUMERO")
                        contacto = Contactos(nombre = nombre, tlf = numero)
                    }
                }

            } catch (e: SQLException) {
                printSQLException(e)
            }
            return contacto
        }

        /**
         * No recibe nada.
         * @return la lista de todos los contatos.
         */
        override fun selectAll(): List<Contactos> {

            // using try-with-resources to avoid closing resources (boiler plate code)
            val contactos: MutableList<Contactos> = ArrayList()
            // Step 1: Establishing a Connection
            lateinit var contacto: Contactos
            try {
                c.prepareStatement(SELECT_ALL).use { st ->
                    // Step 3: Execute the query or update query
                    val rs = st.executeQuery()

                    // Step 4: Process the ResultSet object.
                    while (rs.next()) {
                        val id = rs.getInt("ID_AGENDA")
                        val nombre = rs.getString("NOMBRE")
                        val numero = rs.getString("NUMERO")
                        contacto = Contactos(nombre = nombre, tlf = numero)
                        contactos.add(contacto)
                    }
                }

            } catch (e: SQLException) {
                printSQLException(e)
            }
            return contactos
        }

        /**
         * Recibe un id y actualiza el contacto que corresponda.
         * @return true o false en caso de que se haya actualizado o no.
         */
        override fun update(contacto: Contactos, id: Int): Boolean {
            var rowUpdated = false

            try {
                c.prepareStatement(UPDATE).use { st ->
                    st.setString(1, contacto.nombre)
                    st.setString(2, contacto.tlf)
                    st.setInt(3, id)
                    rowUpdated = st.executeUpdate() > 0
                }
                //Commit the change to the database
                c.commit()
            } catch (e: SQLException) {
                printSQLException(e)
            }
            return rowUpdated
        }

}