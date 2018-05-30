package coms.example.marcosvinicius.myexpenses;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.clans.fab.FloatingActionButton;

public class VisaoGeralActivity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_visao_geral, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FloatingActionButton buttonAdicionarDespesa = (FloatingActionButton) view.findViewById(R.id.visaoGeralFloatingActionButtonDespesa);
        FloatingActionButton buttonAdicionarReceita = (FloatingActionButton) view.findViewById(R.id.visaoGeralFloatingActionButtonReceita);

        buttonAdicionarDespesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().setTitle("Adicionar Despesa");

                Bundle bundle = new Bundle();

                bundle.putString("tipo", "Despesa");

                Intent adicionarRegistro = new Intent(getActivity(), FormularioAdicionarActivity.class);

                adicionarRegistro.putExtra("tipo", "Despesa");
                startActivity(adicionarRegistro);
            }
        });

        buttonAdicionarReceita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("tipo", "Receita");

                Intent adicionarRegistro = new Intent(getActivity(), FormularioAdicionarActivity.class);

                adicionarRegistro.putExtra("tipo", "Receita");
                startActivity(adicionarRegistro);
            }
        });
    }
}