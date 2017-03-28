/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyecto1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

/**
 *
 * @author Dénilson Argueta
 */
public class testwebserver {
    public static OkHttpClient webClient = new OkHttpClient();
    
    public testwebserver()
    {
    }
    
    public static void nombre()
    {
         String nombre = "Marco";
        RequestBody formBody = new FormEncodingBuilder()
                .add("p", nombre)
                .build();
        String r = getString("tarea2", formBody); 
        System.out.println(r + "---");
    }
    public static void insertarmatriz(String dato1,String dato2,String dato3,String dato4,String dato5)
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("dato1",dato1)
                .add("dato2",dato2)
                .add("dato3",dato3)
                .add("dato4",dato4)
                .add("dato5",dato5)
                .build();
        String r = getString("insertarMatriz", formBody); 
        System.out.println(r +"");
    }
    public static void login(String dato1,String dato2,String dato3,String dato4)
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("dato1",dato1)
                .add("dato2",dato2)
                .add("dato3",dato3)
                .add("dato4",dato4)
                .build();
        String r = getString("login", formBody); 
        System.out.println(r +"");
    }
    public static void agregaractivo(String dato1,String dato2,String dato3,String dato4,String dato5)
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("dato1",dato1)
                .add("dato2",dato2)
                .add("dato3",dato3)
                .add("dato4",dato4)
                .add("dato5",dato5)
                .build();
        String r = getString("agregarActivo", formBody); 
        System.out.println(r +"");
    }
    public static void modificaractivo(String dato1,String dato2,String dato3,String dato4,String dato5)
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("dato1",dato1)
                .add("dato2",dato2)
                .add("dato3",dato3)
                .add("dato4",dato4)
                .add("dato5",dato5)
                .build();
        String r = getString("modificarActivo", formBody); 
        System.out.println(r +"");
    }
    public static void eliminaractivo(String dato1,String dato2,String dato3,String dato4)
    {
         RequestBody formBody = new FormEncodingBuilder()
                .add("dato1",dato1)
                .add("dato2",dato2)
                .add("dato3",dato3)
                .add("dato4",dato4)
                .build();
        String r = getString("eliminarActivo", formBody); 
        System.out.println(r +"");
    }
    
    
     public static String getString(String metodo, RequestBody formBody) {

        try {
            URL url = new URL("http://0.0.0.0:5000/" + metodo);
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = webClient.newCall(request).execute();//Aqui obtiene la respuesta en dado caso si hayas pues un return en python
            String response_string = response.body().string();//y este seria el string de las respuesta
            return response_string;
        } catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(testwebserver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(testwebserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
