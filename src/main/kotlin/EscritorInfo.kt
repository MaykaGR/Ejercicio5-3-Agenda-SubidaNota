/**
 * Esta interface crea el comportamiento de escribir la información.
 */
interface EscritorInfo {
    fun mostrarAgenda(agenda: Agenda){}

    /**
     * Recibe la agenda y el contacto e imprime la información de ese contacto.
     * @return nada.
     */
    fun escribeInfoContacto(agenda: Agenda, contacto: Contactos){
        println(agenda.infoContacto(contacto))
    }
}