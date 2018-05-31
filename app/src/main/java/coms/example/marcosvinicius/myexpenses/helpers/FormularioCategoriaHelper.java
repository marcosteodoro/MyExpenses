package coms.example.marcosvinicius.myexpenses.helpers;

import android.widget.EditText;
import android.widget.Spinner;

import coms.example.marcosvinicius.myexpenses.FormularioAdicionarActivity;
import coms.example.marcosvinicius.myexpenses.FormularioCategoria;
import coms.example.marcosvinicius.myexpenses.R;
import coms.example.marcosvinicius.myexpenses.model.Categoria;
import coms.example.marcosvinicius.myexpenses.model.DespesaReceita;

public class FormularioCategoriaHelper {

    private final EditText campoDescricao;

    /**
     * Método construtor da classe
     */
    public FormularioCategoriaHelper(FormularioCategoria formularioCategoria) {
        this.campoDescricao = (EditText) formularioCategoria.findViewById(R.id.formularioCategoriaDescricao);
    }

    public Categoria getCategoria() {
        Categoria registro = new Categoria();

        registro.setDescricao(campoDescricao.getText().toString());

        return registro;
    }
}
