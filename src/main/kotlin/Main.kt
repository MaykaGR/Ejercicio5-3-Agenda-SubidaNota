import kotlinx.cli.*
import java.sql.Connection
import java.sql.ConnectionBuilder
import java.sql.DriverManager
import java.sql.SQLException
import mu.KotlinLogging


fun main(args: Array<String>) {
    val agenda = Agenda()
    val contacto = Contactos("Mayka","956767898")
    val contacto2 = Contactos("Hisuu", "797699")
    val contacto3 = Contactos("hnjn","928937")
    agenda.contactos.add(contacto)
    agenda.contactos.add(contacto2)
    agenda.contactos.add(contacto3)
    val gestionDeArgumentos = GestorArgumentos(args,agenda)
    val escritor =  EscritorInfoConsola()
    escritor.mostrarAgenda(agenda)




}