package coms.example.marcosvinicius.myexpenses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import coms.example.marcosvinicius.myexpenses.dao.DaoCategoria;
import coms.example.marcosvinicius.myexpenses.dao.DaoDespesaReceita;
import coms.example.marcosvinicius.myexpenses.helpers.FormularioDespesaReceitaHelper;
import coms.example.marcosvinicius.myexpenses.model.Categoria;
import coms.example.marcosvinicius.myexpenses.model.DespesaReceita;

public class FormularioAdicionarActivity extends AppCompatActivity {

    private String tipo = "";
    private FormularioDespesaReceitaHelper helper;

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

        DaoCategoria obDaoCategoria= new DaoCategoria(this);


        List<Categoria> categorias = obDaoCategoria.select();

        Spinner dropdownCategorias = (Spinner) findViewById(R.id.formularioAdicionarCategoria);

        ArrayAdapter<Categoria> adapter = new ArrayAdapter<Categoria>(this, android.R.layout.simple_spinner_dropdown_item, categorias);

        dropdownCategorias.setAdapter(adapter);

        this.helper = new FormularioDespesaReceitaHelper(this);
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

                DespesaReceita obDespesaReceita = this.helper.getDespesaReceita();
                DaoDespesaReceita obDaoDespesaReceita = new DaoDespesaReceita(this);

                obDaoDespesaReceita.insert(obDespesaReceita);
                obDaoDespesaReceita.close();

                Toast.makeText(this, this.tipo + " adicionada!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
