
package Servlets;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class Servidor {
    
    public static OkHttpClient webClient = new OkHttpClient();
    
    public Servidor()
    {
//        String nombre = "Marco";
//        RequestBody formBody = new FormEncodingBuilder()
//                .add("dato", nombre)
//                .add("dato2", "4")
//                .build();
//        String r = getString("metodoWeb", formBody); 
//        System.out.println(r + "---");
        
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

}
