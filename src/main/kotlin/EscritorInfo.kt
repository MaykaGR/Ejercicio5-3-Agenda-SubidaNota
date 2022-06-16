interface EscritorInfo {
    fun mostrarAgenda(agenda: Agenda){}

    fun escribeInfoContacto(agenda: Agenda){
        println(agenda.infoContacto())
    }
}