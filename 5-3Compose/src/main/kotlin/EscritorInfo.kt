interface EscritorInfo {
    fun mostrarAgenda(agenda: Agenda){}

    fun escribeInfoContacto(agenda: Agenda, contacto: Contactos){
        println(agenda.infoContacto(contacto))
    }
}