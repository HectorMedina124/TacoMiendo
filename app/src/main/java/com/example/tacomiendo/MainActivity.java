package com.example.tacomiendo;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tacomiendo.clases.Utilidades;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,userFrag.OnFragmentInteractionListener,
        masVendidoFrag.OnFragmentInteractionListener,contfFragment.OnFragmentInteractionListener,
        catFrag.OnFragmentInteractionListener, TarjetasFrag.OnFragmentInteractionListener,DireccionesFrag.OnFragmentInteractionListener,
         PerfilFrag.OnFragmentInteractionListener,contFrag.OnFragmentInteractionListener,bebFrag.OnFragmentInteractionListener
         ,plaFrag.OnFragmentInteractionListener,postresFrag.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        if(Utilidades.pantalla) {
            setTitle("Mas vendido");
            Fragment nuevo = new masVendidoFrag();
            getSupportFragmentManager().beginTransaction().add(R.id.content_main, nuevo).commit();
            Utilidades.pantalla=false;
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Fragment mifrag=null;
            boolean selec=false;
            mifrag= new contfFragment();
            selec=true;
            setTitle("Configuracion");
            if(selec){
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main,mifrag).commit();
            }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment mifrag=null;
        boolean selec=false;

        if (id == R.id.nav_user) {
            mifrag= new contFrag();
            setTitle("Mi cuenta");
            selec=true;
        } else if (id == R.id.nav_inicio) {
            mifrag= new masVendidoFrag();
            selec=true;
            setTitle("Mas vendido");



        } else if (id == R.id.nav_categoria) {
            mifrag= new catFrag();
            selec=true;
            setTitle("Menu");


        } else if (id == R.id.nav_conf) {
            mifrag= new contfFragment();
            selec=true;
            setTitle("Configuracion");


        }

        if(selec){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,mifrag).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
