package coms.example.marcosvinicius.myexpenses;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import coms.example.marcosvinicius.myexpenses.model.DespesaReceita;

public class FormularioAdicionarActivity extends AppCompatActivity {

    private String tipo = "";
    private FormularioHelper helper;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();

        this.setTipo(extras.getString("tipo"));

        setTitle("Adicionar " + this.tipo);

        setContentView(R.layout.activity_formulario_adicionar);

        String[] categorias = {"Alimentação", "Transporte", "Lazer", "Diversos"};

        Spinner dropdownCategorias = (Spinner) findViewById(R.id.formularioAdicionarCategoria);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, categorias);

        dropdownCategorias.setAdapter(adapter);

        this.helper = new FormularioHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.menu_formulario, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuFormularioAdicionarSalvar:

                DespesaReceita registro = this.helper.getDespesaReceita();

                Toast.makeText(this, this.tipo + " adicionada!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
