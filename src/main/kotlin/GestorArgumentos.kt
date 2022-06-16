import kotlin.system.exitProcess
/**
 * Esta clase gestiona la agenda.
 * @param args los parámetros a recibir.
 * @param agenda la agenda que se va a usar.
 */
class GestorArgumentos(val args: Array<String>, val agenda: Agenda) {

    /**
     * Gestiona los argumentos, realizando acciones en base al parámetro que sea,
     * si es una -a, se sale del programa, si es una -f debe estar seguida del texto a buscar, y se busca ese
     * texto en la agenda, si es una -l se muestran los contactos.
     * @return nada.
     */
    fun gestionDeArgumentos(){
        for(i in 0..args.size-1){
            if(args[i]== "a"){
                exitProcess(0)
            }
            else if(args[i]== "f"){
                var buscar = args[i+1]
                    for(buscar in agenda.contactos){
                        println(buscar)
                    }
                }

            else if(args[i]=="l"){
                println(agenda.contactos.sortedBy { it.nombre })
            }
        }
    }
}