package com.example.daniel.proyecto1_edd;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;

        import org.ksoap2.SoapEnvelope;
        import org.ksoap2.serialization.SoapObject;
        import org.ksoap2.serialization.SoapPrimitive;
        import org.ksoap2.serialization.SoapSerializationEnvelope;
        import org.ksoap2.transport.HttpTransportSE;
        import org.xmlpull.v1.XmlPullParserException;

        import java.io.IOException;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void LoginOnclick(View v) {
        final Button Login = (Button) findViewById(R.id.iniciar);
        final TextView tErrores = (TextView) findViewById(R.id.tErrores);
        final EditText Nickname = (EditText) findViewById(R.id.Email);
        final EditText empresa = (EditText) findViewById(R.id.empresa);
        final EditText departamento = (EditText) findViewById(R.id.Departamento);
        final EditText Password = (EditText) findViewById(R.id.password);

        Thread nt = new Thread() {
            int resultado;

            @Override
            public void run() {
                String NAMESPACE = "http://tempuri.org/";
                String URL = "http://localhost/[IPC2]Proyecto3_201503422/ScroogeGamesDB.asmx";
                String METHOD_NAME = "IniciarSesion";
                String SOAP_ACTION = "http://tempuri.org/IniciarSesion";

                SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
                request.addProperty("Nickname", Nickname);
                request.addProperty("Contraseña", Password);
                request.addProperty("Contraseña", empresa);
                request.addProperty("Contraseña", departamento);

                SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
                envelope.dotNet = true;

                envelope.setOutputSoapObject(request);

                HttpTransportSE transporte = new HttpTransportSE(URL);

                try {
                    transporte.call(SOAP_ACTION, envelope);
                    SoapPrimitive resultado_xml = (SoapPrimitive) envelope.getResponse();
                    resultado = Integer.parseInt(resultado_xml.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (resultado>-1){

                            Intent logingIntent = new Intent(Login.this, UserArea.class);
                            Login.this.startActivity(logingIntent);
                        }else{
                            tErrores.setText("Datos no Encontrados, Intente de Nuevo");
                        }
                    }
                });
            }
        };
        nt.start();

    }
}
