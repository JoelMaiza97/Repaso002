package fisei.uta.edu.ec.practica002;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ThirdActivity extends AppCompatActivity {

    private EditText nombre, apellido, base, exponente, factorial, dato;
    private ListView lista;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        nombre = findViewById(R.id.editTextNombre3);
        apellido = findViewById(R.id.editTextApellido3);
        base=findViewById(R.id.editTextBase3);
        exponente=findViewById(R.id.editTextExponente3);
        factorial =findViewById(R.id.editTextNumero3);

        dato = findViewById(R.id.editTextDatoSeleccionado);

        lista = findViewById(R.id.lista001);
        //
        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this
                , android.R.layout.simple_list_item_1,arrayList);
        lista.setAdapter(adapter);

        //metodo para seleccionar el dato
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dato.setText(""+lista.getAdapter().getItem(position));
                Toast.makeText(ThirdActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });

    }

    //Metodo boton agregar
    public void Agregar(View view){
        arrayList.add(nombre.getText().toString());
        adapter.notifyDataSetChanged();
    }


    public void enviarA2(View view){
        Intent cerrar = new Intent(this, SecondActivity.class);

        String a3, e3, f3,n3, b3;

        n3=nombre.getText().toString();
        b3=base.getText().toString();
        a3=apellido.getText().toString();
        e3=exponente.getText().toString();
        f3= factorial.getText().toString();

        cerrar.putExtra("nombre", n3);
        cerrar.putExtra("apellido", a3);
        cerrar.putExtra("base", b3);
        cerrar.putExtra("exponente", e3);
        cerrar.putExtra("factorial", f3);

        startActivity(cerrar);

    }

}