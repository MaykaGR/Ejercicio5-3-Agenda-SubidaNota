import de.m3y.kformat.Table
import de.m3y.kformat.table
import java.io.File

class EscritorInfoFile: EscritorInfo {

        fun convertirContactos(informacion: MutableList<String>): MutableList<Contactos>{
            var listaContactos: MutableList<Contactos> = mutableListOf()
            for(i in 1..informacion.size-1){
            var datos = informacion.split("|")
            var contacto = Contactos(datos[0],datos[1])
                listaContactos.add(contacto)
            }
            return listaContactos
        }

        override fun mostrarAgenda(informacion: MutableList<Contactos>) {
            var agenda = Agenda()
            agenda.contactos.addAll(informacion)
            val agendaTabla = table {
                header("Contacto", "Numero")

                for (i in 0..agenda.contactos.size-1) {
                    row(agenda.contactos[i].nombre, agenda.contactos[i].tlf)
                }

                hints {
                    borderStyle = Table.BorderStyle.SINGLE_LINE

                }
            }.render(StringBuilder())
            val filename = generarArchivo()
            val file = File(filename)
            val writer = PrintWriter(file)
            writer.append(agendaTabla.toString())
            writer.close()
        }

}