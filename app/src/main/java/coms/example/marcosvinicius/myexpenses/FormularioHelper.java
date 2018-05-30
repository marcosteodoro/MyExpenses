package coms.example.marcosvinicius.myexpenses;

import android.widget.EditText;
import android.widget.Spinner;

import coms.example.marcosvinicius.myexpenses.model.DespesaReceita;

public class FormularioHelper {
    private final EditText campoValor;
    private final Spinner campoCategoria;
    private final EditText campoObservacao;
    private final String tipo;

    /**
     * Método construtor da classe
     */
    public FormularioHelper(FormularioAdicionarActivity formularioAdicionarActivity) {
        this.campoValor = (EditText) formularioAdicionarActivity.findViewById(R.id.formularioAdicionarValor);
        this.campoCategoria = (Spinner) formularioAdicionarActivity.findViewById(R.id.formularioAdicionarCategoria);
        this.campoObservacao = (EditText) formularioAdicionarActivity.findViewById(R.id.formularioAdicionarObservacao);
        this.tipo = formularioAdicionarActivity.getTipo();
    }

    public DespesaReceita getDespesaReceita() {
        DespesaReceita registro = new DespesaReceita();

        registro.setValor(Double.parseDouble(campoValor.getText().toString()));
        registro.setIdCategoria(campoCategoria.getSelectedItemId());
        registro.setObservacao(campoObservacao.getText().toString());
        registro.setTipo(this.tipo);

        return registro;
    }
}
