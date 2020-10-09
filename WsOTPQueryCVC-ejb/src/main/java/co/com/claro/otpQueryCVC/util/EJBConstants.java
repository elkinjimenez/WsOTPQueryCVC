package co.com.claro.otpParameters.util;

/**
 *
 * @author omarMad
 */
public class EJBConstants {

    public static final int GET_STATUS_URL_TIMEOUT = 3000;
    public static final String GET_STATUS_URL_HTTP_METHOD = "GET";
    public static final int GET_STATUS_URL_CODE_200 = 200;
    public static final String KEY_FTP_CONFIGURATION = "StrictHostKeyChecking";
    public static final String VALUE_FTP_CONFIGURATION = "no";
    public static final String CHANNEL_FTP_SERVER = "sftp";

    public static enum CODIGO_EXCEPCION {
        EXITOSO("000"),
        INSERTAR("999"),
        OBLIGATORIO("976"),
        ACTUALIZAR("998"),
        CONSULTAR("997"),
        INSERTAR_NOEXISTE("996"),
        ACTUALIZAR_NOEXISTE("995"),
        CONSULTAR_NOEXISTE("994"),
        NO_ENCONTRADO("993"),
        CONEXION("992"),
        ERROR_SQL("991"),
        BAD_REQUEST("989"),
        DUPLICADO("988"),
        ARCHIVO_EXISTE("986"),
        CARPETA_ERRONEA("985"),
        CONEXION_CAIDA("077"),
        SUBIDA_ARCHIVO("987");
        String descripcion;

        private CODIGO_EXCEPCION(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescription() {
            return descripcion;
        }
    }

    public static enum MENSAJE_EXCEPCION {
        EXITOSO("Query exitoso"),
        INSERTAR("Error de insercion en la tabla"),
        ACTUALIZAR("Error de edicion en la tabla"),
        CONSULTAR("Error de Consulta de la tabla"),
        OBLIGATORIO("El campo es obligatorio"),
        INSERTAR_NOEXISTE("Insercion erronea, elemento existente"),
        ACTUALIZAR_NOEXISTE("Edicion erronea, elemento inexistente"),
        CONSULTAR_NOEXISTE("Elemento inexistente"),
        NO_ENCONTRADO("Elemento no encontrado"),
        CONEXION("Conexion de base de datos no es posible"),
        ERROR_SQL("Error de SQL"),
        BAD_REQUEST("Formato o sintaxis request no compatible."),
        DUPLICADO("Registro Duplicado."),
        ARCHIVO_EXISTE("El archivo ya existe"),
        CONEXION_CAIDA("No hay conexión con el SFTP"),
        CARPETA_ERRONEA("No se encuentra la carpeta"),
        SUBIDA_ARCHIVO("No se pudo cargar el archivo");
        String descripcion;

        private MENSAJE_EXCEPCION(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescription() {
            return descripcion;
        }
    }

}
