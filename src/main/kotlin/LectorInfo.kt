class LectorInfo {

    fun pideNumeroTelefono(): String{
        var continuar = true
        println("Introduce el número de teléfono")
        var numero = readLine()?: " "
        numero = numero.replace("\\s".toRegex(), "")
        if(numero.startsWith("+")){
            numero = numero.drop(3)
        }
        while(continuar){
        if(numero.matches(Regex("^\\+?\\d+(?:,\\d+)?$"))){
            println("El numero es correcto.")
            continuar = false
        }
        else {
            println("El numero no cumple el formato necesario. Introduce de nuevo el numero: ")
            numero = readLine()?: " "
        }}
        return numero
    }

    fun pideContacto(): String{
        var continuar = true
        println("Introduce el contacto: ")
        var contacto = readLine()?: " "
        while(continuar){
        if(contacto.matches(Regex("^\\pL+?[\\ -~\\d\\pL\\s]*$"))){
            println("El contacto es correcto.")
            continuar = false
            }
            else {
                println("El contacto no cumple el formato necesario. Introduce de nuevo el contacto: ")
                contacto = readLine()?: " "
            }}
        return contacto
    }
}