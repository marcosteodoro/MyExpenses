package coms.example.marcosvinicius.myexpenses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import coms.example.marcosvinicius.myexpenses.dao.DaoDespesaReceita;
import coms.example.marcosvinicius.myexpenses.model.DespesaReceita;

public class ListaReceitaDespesaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_receita_despesa);

        DaoDespesaReceita obDaoDespesaReceita = new DaoDespesaReceita(this);

        List<DespesaReceita> despesaReceitas = obDaoDespesaReceita.select();

        obDaoDespesaReceita.close();

        ListView listaDespesaReceita = (ListView) findViewById(R.id.listaReceitaDespesa);

        ArrayAdapter<DespesaReceita> adapter = new ArrayAdapter<DespesaReceita>(this, android.R.layout.simple_list_item_1, despesaReceitas);

        listaDespesaReceita.setAdapter(adapter);

    }
}
