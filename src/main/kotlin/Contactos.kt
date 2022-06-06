data class Contactos(var nombre: String, var tlf: String) {

    var nombreValidado = {if (checkNombre(nombre)) { nombre} else {}


    fun checkNombre (palabra: String): String{
        if(palabra.matches(Regex("^\\pL+?[\\ -~\\d\\pL\\s]*$")){
        return palabra
        }
        else return "error"
    }

}