package com.example.ramiro.transmision_php;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * Clase que hce la peticion https de tipo POST.
 * @author proyectosbeta
 *
 */
public class httpHandler {
    public String post(String posturl,String nombres,String apellidos,String correo,String twetter,String skype,String telefono) {

        try {
			/*
			 * Creamos el objeto de HttpClient que nos permitira conectarnos
			 * mediante peticiones http.
			 */
            HttpClient httpclient = new DefaultHttpClient();

			/*
			 * El objeto HttpPost permite que enviemos una peticion de tipo POST
			 * a una URL especificada
			 */
            HttpPost httppost = new HttpPost(posturl);

            // Una lista de parametros,
            List<NameValuePair> params = new ArrayList<NameValuePair>();

            // Se agregan parametros.
            //params.add(new BasicNameValuePair("dato", "Dato 1"));
            //params.add(new BasicNameValuePair("informacion", "Informacion 1"));
            params.add(new BasicNameValuePair("nombres", nombres));
            params.add(new BasicNameValuePair("apellidos", apellidos));
            params.add(new BasicNameValuePair("correo", correo));
            params.add(new BasicNameValuePair("tweter", twetter));
            params.add(new BasicNameValuePair("skype", skype));
            params.add(new BasicNameValuePair("telefono", telefono));

			/*
			 * Una vez añadidos los parametros actualizamos la entidad de
			 * httppost, esto quiere decir en pocas palabras anexamos los
			 * parametros al objeto para que al enviarse al servidor envien los
			 * datos que hemos añadido
			 */
            httppost.setEntity(new UrlEncodedFormEntity(params));

            // Eejecutamos enviando la informacion al Server.
            HttpResponse resp = httpclient.execute(httppost);

            // Obtenemos una respuesta.
            HttpEntity ent = resp.getEntity();

            String text = EntityUtils.toString(ent);
            // Envia la respuesta del Server.
            return text;

        }catch (Exception e) {
            // Devuelve el mensaje de error, en caso que lo haya.
            return e.getMessage();
        }
    }
}