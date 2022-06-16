import de.m3y.kformat.Table
import de.m3y.kformat.table

class EscritorInfoConsola {

        var cabecera = listOf("Contacto","Numero")


        fun generacionHorario(agenda: Agenda) {

            val agendaTabla = table {
                header(cabecera)

                for (i in agenda.contactos) {
                    row(*agenda.contactos[i].toTypedArray())
                }

                hints {
                    for (i in cabecera.indices) {
                        alignment(cabecera[i], Table.Hints.Alignment.RIGHT)
                    }

                    precision(cabecera[2], 2)
                    precision(cabecera.last(),2)
                    postfix(cabecera.last(),2)
                    borderStyle = Table.BorderStyle.SINGLE_LINE // or NONE

                }
            }.render(StringBuilder())
            println(agendaTabla)
        }

}