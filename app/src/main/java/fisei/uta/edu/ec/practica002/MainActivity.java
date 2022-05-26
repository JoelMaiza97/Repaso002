package fisei.uta.edu.ec.practica002;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, apellido, base, exponente, factorial, potencia;
    private Button calcular;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu001, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.Menu001){
            Toast.makeText(this, "Hola Mundo", Toast.LENGTH_SHORT).show();
        }else if(id==R.id.Menu002){
            Toast.makeText(this, "Adiós Mundo", Toast.LENGTH_SHORT).show();
        }else if(id==R.id.Menu003){
            Toast.makeText(this, "Maiza Joel", Toast.LENGTH_SHORT).show();
        }else if(id==R.id.MenuCambiar){
            enviarA2(new View(this));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        nombre = findViewById(R.id.editTextNombre);
        apellido = findViewById(R.id.editTextApellido);
        base = findViewById(R.id.editTextBase);
        exponente = findViewById(R.id.editTextExponente);
        factorial = findViewById(R.id.editTextFactorial);
        potencia = findViewById(R.id.editTextPotencia);

        calcular = findViewById(R.id.btnCalcular);


        //Traer Datos Activity3
        String n = getIntent().getStringExtra("nombre");
        nombre.setText(n);

        String a = getIntent().getStringExtra("apellido");
        apellido.setText(a);

        String b = getIntent().getStringExtra("base");
        base.setText(b);

        String e = getIntent().getStringExtra("exponente");
        exponente.setText(e);

/*        String f=getIntent().getStringExtra("factorial");
        factorial.setText(f);*/

        calcular.setEnabled(nombre.length() != 0);
    }

    public void enviarA2(View view) {
        Intent siguiente = new Intent(this, SecondActivity.class);
        startActivity(siguiente);
    }

    public void mostrarDatos(View view) {
        String f = getIntent().getStringExtra("factorial");

        Integer fac = Integer.parseInt(f);
        Integer bas = Integer.parseInt(base.getText().toString());
        Integer exp = Integer.parseInt(base.getText().toString());

        String res = String.valueOf(factorial(fac));
        factorial.setText(res);

        String res2 = String.valueOf(exponente(bas, exp));
        potencia.setText(res2);

    }

    public int factorial(int x) {
        int fac = 1, i;
        for (i = 2; i <= x; i++)
            fac *= i;
        return fac;
    }

    public int exponente(int x, int y){
        int res = 1;
        for(int i=0;i<x;i++)
            res *= y;
        return res;
    }


}