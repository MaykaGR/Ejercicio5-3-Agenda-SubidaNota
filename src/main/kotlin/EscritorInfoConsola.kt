import de.m3y.kformat.Table
import de.m3y.kformat.table
/**
 * Esta clase escribe la información por consola.
 */
class EscritorInfoConsola: EscritorInfo {

    /**
     * Recibe la agenda y muestra la información en una tabla.
     * @return nada.
     */
        override fun mostrarAgenda(agenda: Agenda) {

            val agendaTabla = table {
                header("Contacto", "Numero")

                for (i in 0..agenda.contactos.size-1) {
                    row(agenda.contactos[i].nombre, agenda.contactos[i].tlf)
                }

                hints {
                    borderStyle = Table.BorderStyle.SINGLE_LINE

                }
            }.render(StringBuilder())
            println(agendaTabla)
        }

}