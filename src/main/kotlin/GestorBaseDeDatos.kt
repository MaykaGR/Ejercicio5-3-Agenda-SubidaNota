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
     * @return la lista de contactos.
     */
    fun mostrarTodo(): List<Contactos> {
       val lista = dao.selectAll()
        return lista
    }

    /**
     * Muestra un contacto concreto.
     * @return el contacto.
     */
    fun mostrarContacto(id: Int): Contactos{
        val contacto = dao.selectById(id)
        return contacto
    }
    /**
     * Modifica un contacto.
     * @return true o false en base a sí se ha modificado o no.
     */
    fun modificar(id: Int): Boolean{
        println("Introduce el nombre: ")
        val nombre = readLine()?: " "
        println("Introduce el tlf: ")
        val tlf = readLine()?: " "
        val contacto = Contactos(nombre,tlf)
        val modificado = dao.update(contacto,id)
        return modificado
    }

}