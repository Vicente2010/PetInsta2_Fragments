package android.oscarbetanzos.com.petinsta;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContactoActivity extends AppCompatActivity {

    Button btnSendEmail;
    TextInputEditText ctcTietCorreo;
    TextInputEditText ctcTietAsunto;
    TextInputEditText ctcTietMensaje;

    String correo;
    String asunto;
    String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        if (getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        btnSendEmail = (Button) findViewById(R.id.btnSendEmail);
        ctcTietCorreo = (TextInputEditText) findViewById(R.id.ctcTietCorreo);
        ctcTietAsunto = (TextInputEditText) findViewById(R.id.ctcTietAsunto);
        ctcTietMensaje= (TextInputEditText) findViewById(R.id.ctcTietMensaje);





        btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo = ctcTietCorreo.getText().toString();
                asunto = ctcTietAsunto.getText().toString();
                mensaje = ctcTietMensaje.getText().toString();



                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            GMailSender sender = new GMailSender("TU_CORREO",
                                    "TU_CONTRASEÑA");
                            sender.sendMail(asunto, correo + ": "+ mensaje,
                                    correo, "TU_CORREO");
                        } catch (Exception e) {
                            Log.e("SendMail", e.getMessage(), e);
                        }
                    }

                }).start();

                Intent back = new Intent(ContactoActivity.this, MainActivity.class);
                setResult(RESULT_OK,back);
                finish();
            }

        });

    }
}
