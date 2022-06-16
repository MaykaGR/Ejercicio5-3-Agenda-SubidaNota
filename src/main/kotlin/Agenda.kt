class Agenda {
    var contactos: MutableList<Contactos> = mutableListOf()

    fun alta(contacto: Contactos){
        contactos.add(contacto)
    }

    fun existeNumero(numero: String): Boolean{
        var continuar = true
        var contador = 0
        var existe = false
        while(contador<contactos.size && continuar){
            if(contactos[contador].tlf==numero){
                existe = true
                continuar = false
            }
            else contador += 1
        }
        return existe
    }

    fun existeContacto(nombre: String): Boolean{
        var continuar = true
        var contador = 0
        var existe = false
        while(contador<contactos.size && continuar){
            if(contactos[contador].nombre==nombre){
                existe = true
                continuar = false
            }
            else contador += 1
        }
        return existe
    }

    fun infoContacto(contacto: Contactos): Contactos{
        var continuar = true
        var contador = 0
        var existe = false
        var emptyContacto = Contactos("","")
        while(contador<contactos.size && continuar){
            if(contactos[contador]==contacto){
                existe = true
                continuar = false
            }
            else contador += 1
        }
        if(existe){
        return contacto}
        else return emptyContacto
    }

}