package fisei.uta.edu.ec.practica002;

import android.content.Intent;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private EditText nombre, base;
    private Button cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nombre = findViewById(R.id.editTextNombre2);
        base = findViewById(R.id.editTextBase2);

        //Referenciar para evitar cierre
        cerrar = findViewById(R.id.btnCerrar2);

        //Traer y Asignar Datos Activity3
        String n = getIntent().getStringExtra("nombre");
        nombre.setText(n);

        String b=getIntent().getStringExtra("base");
        base.setText(b);

        //Deshabilitar Botón
        cerrar.setEnabled(nombre.length() != 0);

    }

    public void enviarA3(View view){
        Intent siguiente = new Intent(this, ThirdActivity.class);
        startActivity(siguiente);
    }

    public void enviarA1(View view){
        Intent cerrar = new Intent(this, MainActivity.class);
        //Traer SIN ASIGNAR Datos Activity3
        String a=getIntent().getStringExtra("apellido");
        String e=getIntent().getStringExtra("exponente");
        String f=getIntent().getStringExtra("factorial");
        //Tomar el valor del EditText
        String n = nombre.getText().toString();
        String b = base.getText().toString();
        //Enviar los Valores que NO estan ASIGNADOS
        cerrar.putExtra("nombre", n);   //Nombre si está
        cerrar.putExtra("apellido", a);
        cerrar.putExtra("base", b);     //Base si está
        cerrar.putExtra("exponente", e);
        cerrar.putExtra("factorial", f);

        startActivity(cerrar);

    }
}