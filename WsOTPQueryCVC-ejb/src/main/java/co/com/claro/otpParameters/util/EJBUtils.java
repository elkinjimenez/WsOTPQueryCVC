/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.otpParameters.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Date;
import net.telmex.util.StringUtil;

/**
 *
 * @author omarMad
 */
public class EJBUtils {

    /**
     * Objetivo: Metodo encargado de mapear un objeto a otro, es decir de un
     * entity a un dao y viceversa el obj "in" ces el objeto lleno y el out es
     * el objeto q se quiere llenar y q el metodo devuelve
     *
     * @autor acastanv-Everis
     * @param <T>
     * @param obj1
     * @param obj2
     * @return
     * @throws Exception
     *
     */
    public static <T> T mapperEntityAndDao(T obj1, T obj2) throws Exception {
        T valorParam = obj2;
        Class claseOut = obj1.getClass();
        Class claseIn = obj2.getClass();
        Field[] atributos = claseIn.getDeclaredFields();
        for (Field field : atributos) {
            if (!field.getName().equals("entityManager")) {
                if (!field.getName().equals("serialVersionUID")) {
                    if (!field.getName().contains("_")) {
                        Method getMethod = claseIn.getMethod(
                                "get"
                                + StringUtil
                                        .toCamelCase(field.getName()));

                        Object value = getMethod.invoke(valorParam);
                        if (value instanceof String
                                || value instanceof Long
                                || value instanceof Short
                                || value instanceof Date
                                || value instanceof BigInteger
                                || value instanceof Integer
                                || value instanceof Character) {
                            Method setMethod = claseOut.getDeclaredMethod(
                                    "set"
                                    + StringUtil
                                            .toCamelCase(
                                                    field.getName()),
                                    value.getClass()
                            );
                            setMethod.invoke(obj1, value);
                        }
                    }
                }
            }
        }
        return obj1;
    }

    /**
     * Objetivo: Metodo que valida una cadena con una Expresion Regular (RE)
     *
     * @param pattern - Expresion regular para validar String
     * @param text - String a validar con la Expresion regular 'patron'
     * @return <code>true</code> si la cadena concuerda a la RE y
     * <code>false</code> si no concuerda
     */
    public static boolean evaluateStringInRegularExpression(
            Pattern pattern,
            String text
    ) {
        Matcher mtch = pattern.matcher(text);
        return mtch.matches();
    }

    /**
     * Objetivo: Metodo para verificar si una URL esta o no disponible
     *
     * @param url URL a validar
     * @return <code>true</code> Si URL esta disponible y <code>false</code> si
     * no esta disponible
     * @throws IOException
     */
    public static boolean getStatusUrl(String url) throws IOException {

        try {
            URL urlObj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
            con.setRequestMethod(EJBConstants.GET_STATUS_URL_HTTP_METHOD);
            con.setConnectTimeout(EJBConstants.GET_STATUS_URL_TIMEOUT);
            con.connect();
            int code = con.getResponseCode();
            if (code == EJBConstants.GET_STATUS_URL_CODE_200) {
                return true;
            }
        } catch (IOException e) {
        }
        return false;
    }

    /**
     * Objetivo: Este metodo convierte cualquier objeto en un JSONObject
     *
     * @param objetoConvertir - Objeto que se quiere convertir
     * @return - JSONObject resultante
     */
    public static JSONObject convertObjectToJSONObject(
            Object objetoConvertir
    ) {
        JSONObject requestJson = new JSONObject(objetoConvertir);
        return requestJson;
    }

    /**
     * Objetivo: Este metodo verifica si por lo menos uno de los valores del
     * array A[i] es null
     *
     * @param values - ArrayList que contiene los valores a verificar
     * @return <code>true</code> si almenos un valor es nulo o
     * <code>false</code> si ningun valor es nulo
     */
    public static boolean checkIfArrayValueIsNull(ArrayList<?> values) {

        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) == null) {
                return true;
            }
        }
        return false;
    }

}
