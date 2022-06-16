import mu.KotlinLogging
/**
 * Esta clase crea una agenda en la que se almacenan los contactos.
 * @property contactos la lista de los contactos de la agenda.
 * @property logger el logegr para mostrar mensajes de información o error.
 */
class Agenda {
    var contactos: MutableList<Contactos> = mutableListOf()
    private val logger = KotlinLogging.logger {  }
    /**
     * Recibe un contacto y lo añade a la agenda.
     * @return nada.
     */
    fun alta(contacto: Contactos){
        contactos.add(contacto)
        logger.info { "OK" }
    }

    /**
     * Recibe un número de teléfono y comprueba si está en la agenda.
     * @return True en caso de que esté, False en caso de que no.
     */
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
        logger.error { "Error" }
        return existe
    }

    /**
     * Recibe un nombre y comprueba si está en la agenda.
     * @return True en caso de que esté, False en caso de que no.
     */
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
        logger.error { "Error" }
        return existe
    }
    /**
     * Recibe un contacto y comprueba si está en la agenda.
     * @return Devuelve el contacto en caso de que esté, y un contacto vacío en caso de que no.
     */
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
        logger.error { "Error" }
        if(existe){
        return contacto}
        else return emptyContacto
    }

}