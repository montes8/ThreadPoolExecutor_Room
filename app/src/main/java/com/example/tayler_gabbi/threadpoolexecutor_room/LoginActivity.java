package com.example.tayler_gabbi.threadpoolexecutor_room;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tayler_gabbi.threadpoolexecutor_room.database.model.Usuario;
import com.example.tayler_gabbi.threadpoolexecutor_room.threadPoolExecutor.DefaultExecutorSupplier;

public class LoginActivity extends AppCompatActivity {

    EditText nombre,contasenia;
    Button logearle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre = findViewById(R.id.edit_usuario);
        contasenia = findViewById(R.id.edit_pasword);
        logearle = findViewById(R.id.button_ingresar);

        logearle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DefaultExecutorSupplier.getInstance().forBackgroundTasks().execute(new Runnable() {

                    @Override public void run() {

                        final Usuario usuario = DemoApplication.dataBase.usuarioDao().userLOgin(nombre.getText().toString(),contasenia.getText().toString());


                        DefaultExecutorSupplier.getInstance().forMainThreadTasks().execute(new Runnable() {
                            @Override public void run() {

                                if (usuario != null){
                                    Toast.makeText(LoginActivity.this,"Bienvenida"+usuario.getNombre(),Toast.LENGTH_SHORT).show();
                                    Intent inten = new Intent(LoginActivity.this,HomeActivity.class);
                                    startActivity(inten);
                                }else{

                                    Toast.makeText(LoginActivity.this,"Usuario o contraseña incorrectos",Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                });
            }
        });
    }
}
