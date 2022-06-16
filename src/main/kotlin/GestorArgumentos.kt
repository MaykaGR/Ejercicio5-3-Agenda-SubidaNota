import kotlin.system.exitProcess

class GestorArgumentos(val args: Array<String>) {


    //val adios: String? -a, val filtra: String? -f, val listado: String? -l

    fun gestionDeArgumentos(){
        for(i in 0..args.size-1){
            if(args[i]== "a"){
                exitProcess(0)
            }
            else if(args[i]== "f"){
                var buscar = args[i+1]
                if(buscar.matches(Regex("^\\+?\\d+(?:,\\d+)?$"))){

                }
                else if(buscar.matches(Regex("^\\pL+?[\\ -~\\d\\pL\\s]*$"))){

                }

            }
            else if(args[i]=="l"){

            }
        }
    }
}