/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jframes;

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
    public static String graficarMatriz()
    {
         RequestBody formBody = new FormEncodingBuilder()
                 .add("dato1","as")
                .build();
        String r = getString("graficarMatriz", formBody); 
        return r;
    }
    public static String graficarEmpresa(String empresa)
    {
         RequestBody formBody = new FormEncodingBuilder()
                 .add("dato1",empresa)
                .build();
        String r = getString("graficarEmpresa", formBody); 
        System.out.println(r +"");
        return r;
    }
    public static String graficarDepartamento(String departamento)
    {
         RequestBody formBody = new FormEncodingBuilder()
                 .add("dato1",departamento)
                .build();
        String r = getString("graficarDepartamento", formBody); 
        System.out.println(r +"");
        return r;
    }
    public static String graficarAVL(String dato1,String dato2,String dato3)
    {
         RequestBody formBody = new FormEncodingBuilder()
                .add("dato1",dato1)
                .add("dato2",dato2)
                .add("dato3",dato3)
                .build();
        String r = getString("graficarAVL", formBody); 
        System.out.println(r +"");
        return r;
    }
    public static void activosUuario(String dato1,String dato2,String dato3)
    {
        RequestBody formBody = new FormEncodingBuilder()
                
                .add("dato2",dato2)
                .add("dato3",dato3)
                .build();
        String r = getString("activosUsuario", formBody); 
        System.out.println(r +"");
    }
     public static void prueba()
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("nombre","fdsfasfas")
                .build();
        String r = getString("eliminar", formBody); 
        System.out.println(r +"");
    }
    
     public static String getString(String metodo, RequestBody formBody) {

        try {
            URL url = new URL("http://192.168.2.4:5000/" + metodo);
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
     public static String getString2(String metodo, RequestBody formBody) {

        try {
            URL url = new URL("http://192.168.2.5:5057/" + metodo);
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
