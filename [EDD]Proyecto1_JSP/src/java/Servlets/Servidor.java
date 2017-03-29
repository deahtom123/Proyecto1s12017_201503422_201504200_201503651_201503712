
package Servlets;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.net.MalformedURLException;
import java.net.URL;

public class Servidor {
    
    public static OkHttpClient webClient = new OkHttpClient();
    
    public static String ObtenerNombre(String id){
        RequestBody formBody = new FormEncodingBuilder()
                .add("dato1", id)
                .build();
        String r = getString("devolverNombre", formBody); 
        System.out.println(r + "---");  
        
        return r;
    }
    
    public static String ObtenerDescripcion(String id){
                RequestBody formBody = new FormEncodingBuilder()
                .add("dato1", id)
                .build();
        String r = getString("devolverDescripcion", formBody); 
        
        System.out.println(r + "---");  
        return r;
    }
    
    public static String[] ObtenerIDS(String user, String empresa,String departamento){
                RequestBody formBody = new FormEncodingBuilder()
                .add("dato1", user)
                .build();
        String r = getString("activosUsuario", formBody); 
        System.out.println(r + "---");  
      
        String[] a = r.split(" ");
        return a;
    }

    static void Registrar(String user, String empresa, String departamento, String contraseña, String nombreCompleto) {
                RequestBody formBody = new FormEncodingBuilder()
                .add("dato1", user)
                .add("dato2", empresa)
                .add("dato3", departamento)
                .add("dato4", contraseña)
                .add("dato5", nombreCompleto)
                .build();
        String r = getString("insertarMatriz", formBody); 
        System.out.println(r + "---");
    }

   public static String Eliminar(String idseleccionado) {
                 RequestBody formBody = new FormEncodingBuilder()
                .add("dato1", ServletLogin.user)
                .add("dato2", ServletLogin.emp)
                .add("dato3", ServletLogin.dep)
                .add("dato4", idseleccionado)
                .build();
        String r = getString("eliminarActivo", formBody); 
        System.out.println(r + "---");
        return r;
     }

   public static String AgregarActivo(String descripcion, String nombre) {
       
        RequestBody formBody = new FormEncodingBuilder()
                .add("dato1", ServletLogin.user)
                .add("dato2", ServletLogin.emp)
                .add("dato3", ServletLogin.dep)
                .add("dato4", nombre)
                .add("dato5", descripcion)
                .build();
                
        String r = getString("agregarActivo", formBody); 
        System.out.println(r + "---");
        return r;
    }
    
    public static String Login(String nombre,String empresa,String departamento, String contraseña)
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("dato1", nombre)
                .add("dato2", empresa)
                .add("dato3", departamento)
                .add("dato4", contraseña)
                .build();
        String r = getString("login", formBody); 
        System.out.println(r + "---");
        
        return r;
    }
         public static String getString(String metodo, RequestBody formBody) {

        try {
            URL url = new URL("http://0.0.0.0:5000/" + metodo);
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = webClient.newCall(request).execute();//Aqui obtiene la respuesta en dado caso si hayas pues un return en python
            String r = response.body().string();//y este seria el string de las respuesta
            return r;
        } catch (MalformedURLException ex) {
        } catch (Exception ex) {
        }
        return null;
    }

    static String Modificar(String idseleccionado, String descripcion) {
         RequestBody formBody = new FormEncodingBuilder()
                .add("dato1", ServletLogin.user)
                .add("dato2", ServletLogin.emp)
                .add("dato3", ServletLogin.dep)
                .add("dato4", idseleccionado)
                .add("dato5",descripcion)
                .build();
        String r = getString("modificarActivo", formBody); 
        System.out.println(r + "---");
        return r; 
    }

}
