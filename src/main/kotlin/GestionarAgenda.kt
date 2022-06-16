class GestionarAgenda {
    var dato = " "
    fun introduceDato(){
        println("Introduce dato: ")
        dato = readLine()?: " "
    }

    fun comprobadora(agenda: Agenda){
        var continuar = true
        var contador = 0
        var existe = false
        var contacto = Contactos("","")
        var lector = LectorInfo()
        if(dato.matches(Regex("^\\pL+?[\\ -~\\d\\pL\\s]*$"))){
            while(contador<agenda.contactos.size && continuar){
                if(agenda.contactos[contador].nombre==dato){
                    existe = true
                    continuar = false
                    contacto = agenda.contactos[contador]
                }
                else contador += 1
            }
            if(!existe){
                var numero = lector.pideNumeroTelefono()
                var contactoNuevo = Contactos(dato,numero)
                agenda.contactos.add(contactoNuevo)
            }
        }
        else if(dato.matches(Regex("^\\+?\\d+(?:,\\d+)?$"))){
            while(contador<agenda.contactos.size && continuar){
                if(agenda.contactos[contador].tlf==dato){
                    existe = true
                    continuar = false
                    contacto = agenda.contactos[contador]
                }
                else contador += 1
            }
            if(!existe){
                var nombre = lector.pideContacto()
                var contactoNuevo = Contactos(nombre,dato)
                agenda.contactos.add(contactoNuevo)
            }
        }
        if(existe){
            agenda.infoContacto(contacto)
        }
    }
}