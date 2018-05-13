package coms.example.marcosvinicius.myexpenses;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentHostCallback;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setTitle("MyExpenses");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        this.fragment = new VisaoGeralActivity();
        this.setLayoutFragment();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menuDrawerItemVisaoGeral) {
            setTitle("MyExpenses");
            this.fragment = new VisaoGeralActivity();
        } else if (id == R.id.menuDrawerItemAdicionarDespesa) {
            setTitle("Adicionar Despesa");


            Bundle bundle = new Bundle();
            bundle.putString("tipo", "Despesa");


            this.fragment = new FormularioAdicionarActivity();

            this.fragment.setArguments(bundle);

        } else if (id == R.id.menuDrawerItemAdicionarReceita) {
            setTitle("Adicionar Receitas");




            Bundle bundle = new Bundle();
            bundle.putString("tipo", "Receita");


            this.fragment = new FormularioAdicionarActivity();

            this.fragment.setArguments(bundle);






        } else if (id == R.id.menuDrawerItemRelatorio) {

        } else if (id == R.id.menuDrawerAdicionarCategoria) {
            setTitle("Adicionar Receitas");
            this.fragment = new FormularioCategoria();
        }

        this.setLayoutFragment();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Método responsável por gerenciar o carregamento do Fragmente selecionado no FrameLayout
     */
    public boolean setLayoutFragment()
    {
        if (this.fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.screen_area, this.fragment);

            fragmentTransaction.commit();

            return true;
        }

        return false;
    }
}