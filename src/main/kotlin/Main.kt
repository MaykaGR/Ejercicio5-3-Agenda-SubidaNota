import kotlinx.cli.*
import java.sql.Connection
import java.sql.ConnectionBuilder
import java.sql.DriverManager
import java.sql.SQLException
fun bla (palabra: String): Boolean{
    var palabra2 = palabra.replace("\\s".toRegex(), "")
    if(palabra2.startsWith("+")){
        palabra2 = palabra2.drop(3)
    }
    return palabra2.matches(Regex("^\\+?\\d+(?:,\\d+)?$"))
}

fun blaword (palabra: String): Boolean{
    return palabra.matches(Regex("^\\pL+?[\\ -~\\d\\pL\\s]*$"))
}
fun main(args: Array<String>) {
    val parser = ArgParser("Agenda")
    val adios by parser.option(ArgType.String, shortName = "a", description = "Input file")
    val listado by parser.option(ArgType.String, shortName = "l", description = "Input file")
    val filtra by parser.option(ArgType.String, shortName = "f", description = "Input file")

    parser.parse(args)
    val gestionDeArgumentos = GestorArgumentos(adios,listado,filtra)

    var coincide = bla("5 4 636463")
    println(coincide)
    println(blaword("M +óòPÓöÜ*}Ç! 4 636463"))


}