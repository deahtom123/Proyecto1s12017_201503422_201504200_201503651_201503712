package com.example.daniel.proyecto1_edd;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.GridView;
        import android.widget.Toast;

public class UserArea extends AppCompatActivity {
    GridView gridView;
    String IDs[] = {"10", "7"," 2"," 5", "4","8", "5", "10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){


                Toast.makeText(UserArea.this, "Clicked Products :"+ Nombre[position], Toast.LENGTH_SHORT).show()
            }

        });

    }
}
