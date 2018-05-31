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
import coms.example.marcosvinicius.myexpenses.helpers.FormularioCategoriaHelper;
import coms.example.marcosvinicius.myexpenses.helpers.FormularioDespesaReceitaHelper;
import coms.example.marcosvinicius.myexpenses.model.Categoria;
import coms.example.marcosvinicius.myexpenses.model.DespesaReceita;

public class FormularioCategoria extends AppCompatActivity {

    private FormularioCategoriaHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setTitle("Adicionar Categoria");

        setContentView(R.layout.fragment_formulario_cagetoria);

        this.helper = new FormularioCategoriaHelper(this);
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

                Categoria obCategoria = this.helper.getCategoria();
                DaoCategoria obDaoCategoria = new DaoCategoria(this);

                obDaoCategoria.insert(obCategoria);
                obDaoCategoria.close();

                Toast.makeText(this, "Categoria adicionada!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
