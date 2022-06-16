import java.sql.DriverManager
import java.sql.SQLException
import mu.KotlinLogging
import ProcesadoArchivo.Lector
import ProcesadoArchivo.Procesador
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.AwtWindow
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.awt.FileDialog
import java.awt.Frame
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


internal fun AppGui() = application {
    val titleWindowIni = "Procesa archivo: "
    var isFileChooserOpen by remember { mutableStateOf(false) } //Indica que se quiere abrir el FileChooser
    val titleWindow by remember { mutableStateOf(titleWindowIni) } //Titulo de la ventana
    var filePath by remember { mutableStateOf("") } //Path al fichero que se está procesando
    var isActiveProcess by remember { mutableStateOf(false) } //Activar o desactivar el menuItem  procesar
    var isActiveExport by remember { mutableStateOf(false) }
    var textProcesed by remember { mutableStateOf("") } //El texto a poner en el campo de procesado.
    var lector by remember {mutableStateOf(LectorInfoFile(""))}
    var procesador by remember {mutableStateOf(EscritorInfoFile(lector))}

    //Ventana principal.
    Window(
        title = titleWindow,
        onCloseRequest = ::exitApplication
    ) {
        //MenuBar de la ventana
        MenuBar {
            Menu("Archivo") {
                Item("Abrir", onClick = { isFileChooserOpen = true })
                Item("Exportar", onClick = {procesador.mostrarAgenda(procesador.convertirContactos(textProcesed))}, enabled = isActiveExport)
                Item("Salir", onClick = ::exitApplication)
            }
        }
        //El resto de la ventana
        FrameWindow(
            isFileChooserOpen,
            filePath = filePath,
            onCloseFileChooser = { directory: String?, fileName: String? -> lector = LectorInfoFile("${directory}${fileName}")
                filePath="${directory}${fileName}"
                textProcesed = lector.read()
                isActiveProcess = true
                isActiveExport = true
                isFileChooserOpen = false
            },
            onClickSelectFile = { isFileChooserOpen = true },
            textProcesed = textProcesed
        )
    }

}

/**
 * TODO
 *
 * @param isFileChooserOpen Si se ha elegido abrir el FileChooser
 * @param filePath El path al archivo
 * @param onCloseFileChooser Evento que se lanza cuando se cierra el FileChooser. Devuelve el path y nombre del archivo seleccionado. Null si no se cancelo.
 * @param onClickSelectFile Evento al pulsar sobre el botón Abrir
 * @param textProcesed El texto que con tiene los resultados, se vuelcan en el textField que contiene los resultados
 */
@Composable
internal fun FrameWindow(
    isFileChooserOpen: Boolean = false,
    filePath: String = "",
    onCloseFileChooser: (directory: String?, file: String?) -> Unit,
    onClickSelectFile: () -> Unit,
    textProcesed: String
) {
    MaterialTheme {
        if (isFileChooserOpen)
            FileChooser(onCloseFileChooser = onCloseFileChooser)


        Box(
            modifier = Modifier.fillMaxSize()
                .background(color = Color(180, 180, 180))
                .padding(10.dp)
        )
        {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 12.dp, bottom = 12.dp)

            ) {
                Column {

                    TextField( // Contiene el path+nombre del fichero leido
                        value = filePath,
                        onValueChange = {  },
                        label = { Text("Seleccione un archivo:") },
                        placeholder = { Text("Archivo no seleccionado") },
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
                            .fillMaxWidth(),
                        leadingIcon = { //Icono que funciona igual que la opción del menuItem Abrir
                            IconButton(onClick = onClickSelectFile) {
                                Icon(
                                    imageVector = Icons.Filled.Create,
                                    contentDescription = "Seleccione un archivo"
                                )
                            }
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color(0xFF120524),
                            backgroundColor = Color.White,
                            focusedLabelColor = Color(0xFF120524).copy(alpha = ContentAlpha.high),
                            focusedIndicatorColor = Color.Transparent,
                            cursorColor = Color(0xFF120524),
                        ),
                        readOnly = false,
                    )
                    Space()
                    TextField( // Campo de texto que contiene el texto en el que se vuelcan los resultados
                        value = textProcesed,
                        onValueChange = {  },
                        label = { Text("Resultado") },
                        placeholder = { Text("No obtenido resultados") },
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 10.dp)
                            .fillMaxSize().width(300.dp)
                            .height(200.dp),
                        readOnly = false,
                        leadingIcon = { //Icono que funciona igual que la opción del menuItem Exportar
                            IconButton(onClick = {  }) {
                                Icon(
                                    imageVector = Icons.Filled.Create,
                                    contentDescription = "Exportar archivo"
                                )
                            }
                        }
                    )
                }

            }

        }
    }
}

/**
 * TODO
 *
 * @param parent
 * @param onCloseFileChooser Evento que se lanza cuando se cierra FileChooer. Devuelve directory en el que se encuentra el fichero y file el nombre del fichero.
 */
@Composable
internal fun FileChooser(
    parent: Frame? = null,
    onCloseFileChooser: (directory: String?, file: String?) -> Unit
) = AwtWindow(
    create = {
        object : FileDialog(parent, "Choose a file", LOAD) {
            override fun setVisible(value: Boolean) {
                super.setVisible(value)
                if (value) {
                    onCloseFileChooser(directory, file)
                }
            }
        }
    },
    dispose = FileDialog::dispose
)


@Composable
internal fun Space() {
    Spacer(modifier = Modifier.size(16.dp))
}