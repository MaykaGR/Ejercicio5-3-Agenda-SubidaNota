import mu.KotlinLogging
/**
 * Esta clase gestiona la agenda.
 * @property logger el logegr para mostrar mensajes de información o error.
 */
class GestionarAgenda {
    private val logger = KotlinLogging.logger{}

    /**
     * Recibe la agenda y comprueba que la información que se introduzca esté o no en agenda, si está muestra
     * la información, sino crea un nuevo contacto.
     * @return nada.
     */
    fun comprobadora(agenda: Agenda){
        var continuar = true
        var contador = 0
        var existe = false
        var contacto = Contactos("","")
        var lector = LectorInfo()
        println("Introduce dato: ")
        val dato = readLine()?: " "
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
        logger.error { "Error" }
    }
}