package fr.pierreliaubet.au_clock;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Utilisateur lePigeon;

    List<News> lesNews = new ArrayList<>();

    int affiche;

    TextView titre;
    TextView presentation;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        lePigeon = (Utilisateur) getIntent().getSerializableExtra("lePigeon");

        titre = findViewById(R.id.titreNews);
        presentation = findViewById(R.id.presNews);
        image = findViewById(R.id.imgNews);

        News n1 = new News();
        n1.setPresentation("Un texte de présentation pour une news inutile pour des connards de hypsters.");
        n1.setTitre("Ma première news inutile");
        n1.setTexteComplet("J'estpère que t'es content d'avoir cliqué ici comme un gros boloss pour lirejkhvbdswhjgvdghcsvqjcbqdsjhbchjksqdbcjhqsdbchjkbdshjbcqsdjhbcjhqdsbchjsqdbcjhbqdshjcbqsdhjbchjsdvcjhdsqvghdsqhjvbdshjbchjsqdbchjqdsbcjhkqbsdcjhbqsdhjcbjqhsdvcghdsvcjhsdvcghvsqdhgcvqsdvchgsqdvcghjdsvqhgcvqsdghvcgqsdvcghsqdvcghjvqsdghcvqsdghvchgqdsvchgqs");
        n1.setImg("@drawable/ic_menu_gallery");

        News n2 = new News();
        n2.setPresentation("Un texte de présentation pour une news inutile pour des connards de hypsters.");
        n2.setTitre("Ma seconde news inutile");
        n2.setTexteComplet("J'estpère que t'es content d'avoir cliqué ici comme un gros boloss pour lirejkhvbdswhjgvdghcsvqjcbqdsjhbchjksqdbcjhqsdbchjkbdshjbcqsdjhbcjhqdsbchjsqdbcjhbqdshjcbqsdhjbchjsdvcjhdsqvghdsqhjvbdshjbchjsqdbchjqdsbcjhkqbsdcjhbqsdhjcbjqhsdvcghdsvcjhsdvcghvsqdhgcvqsdvchgsqdvcghjdsvqhgcvqsdghvcgqsdvcghsqdvcghjvqsdghcvqsdghvchgqdsvchgqs");
        n2.setImg("@drawable/logo");

        lesNews.add(n1);
        lesNews.add(n2);

        affiche = 0;
        afficher(0);


    }

    private void afficher(int index){
        News trucAafficher = lesNews.get(index);
        titre.setText(trucAafficher.getTitre());
        presentation.setText(trucAafficher.getPresentation());
    }

    public void btnAvancer(View view){
        if (lesNews.size()-1 == affiche){

        }else{
            affiche += 1;
            afficher(affiche);
        }
    }

    public void btnReculer(View view){
        if (0 == affiche){

        }else{
            affiche -= 1;
            afficher(affiche);
        }
    }

    public void moreInfos(View views){
        News news = lesNews.get(affiche);
        Intent details = new Intent(this, DetailsNews.class);
        details.putExtra("new", news);
        startActivity(details);
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
        getMenuInflater().inflate(R.menu.home, menu);

        TextView nom = findViewById(R.id.nomMenu);
        nom.setText(lePigeon.getNom());
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
