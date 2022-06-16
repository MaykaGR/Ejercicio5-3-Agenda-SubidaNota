/**
 * Esta clase gestiona la base de datos.
 * @param dao el dao a gestionar.
 */
class GestorBaseDeDatos(val dao: AgendaDAO) {
    /**
     * Crea la tabla.
     * @return nada.
     */
    fun crearTabla(){
        dao.prepareTable()
    }
    /**
     * Añade un contacto.
     * @return nada.
     */
    fun add(contactos: List<Contactos>){
        for(i in 0..contactos.size-1)
        {
            dao.insert(contactos[i])
        }
    }
    /**
     * Borra un contacto por su id.
     * @return nada.
     */
    fun borrar(id: Int){
        dao.deleteById(id)
    }
    /**
     * Muestra el contenido completo.
     * @return nada.
     */
    fun mostrarTodo(){
        dao.selectAll()
    }

    /**
     * Muestra un contacto concreto.
     * @return nada.
     */
    fun mostrarContacto(id: Int){
        dao.selectById(id)
    }
    /**
     * Modifica un contacto.
     * @return nada.
     */
    fun modificar(id: Int){
        println("Introduce el nombre: ")
        val nombre = readLine()?: " "
        println("Introduce el tlf: ")
        val tlf = readLine()?: " "
        val contacto = Contactos(nombre,tlf)
        dao.update(contacto,id)

    }

}