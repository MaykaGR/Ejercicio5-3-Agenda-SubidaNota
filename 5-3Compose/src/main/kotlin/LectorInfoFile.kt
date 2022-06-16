class LeerFichero(dir: String)  {
    private val file = File(dir)
     val datos = read()

    /**
     * Función encargada de la lectura del fichero.
     * @return una MutableList con el contenido del fichero.
     */
    fun read(): MutableList<String?> = file.bufferedReader().use(BufferedReader::readLines).toMutableList()
}