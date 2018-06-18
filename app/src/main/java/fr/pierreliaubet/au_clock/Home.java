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

    static Home home;

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
        home = this;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home.home, ListeExercices.class));
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
        n1.setPresentation("Conseil pour gérer la lumière dans votre chambre.");
        n1.setTitre("La luminosité");
        n1.setTexteComplet("Pour un meilleur sommeil, il est conseillé de dormir dans le noir complet. Coupez toutes les lumières et évitez toutes celles qui peuvent être parasite (par exemple un réveil à affichage digital). En plus de ça, nous vous recommendons d'avoir des murs sombres dans votre chambre pour être le plus dans le noir possible.");
        n1.setImg(R.drawable.soleil);

        News n2 = new News();
        n2.setPresentation("Informations sur la températures dans votre chambre.");
        n2.setTitre("La température");
        n2.setTexteComplet("Il est important de veiller à ce que cette dernière ne dépasse pas les 20°C. L'été, climatisez ou ventilez votre chambre avant d'aller dormir et assurez vous que l'air ne soit pas trop sec.");
        n2.setImg(R.drawable.temperature);

        News n3 = new News();
        n3.setPresentation("Quelle alimentation est recommandée avant d'aller se coucher ?");
        n3.setTitre("L'alimentation");
        n3.setTexteComplet("Les alimentations de type sucres rapides ainsi que le lait chaud favorisent l'endormissement.\nNous vous recommendons de ne pas trop manger le soir pour avoir un sommeil de meilleure qualité.");
        n3.setImg(R.drawable.manger);

        News n4 = new News();
        n4.setPresentation("Que peut-on dire des animaux dans la chambre ?");
        n4.setTitre("Les animaux");
        n4.setTexteComplet("Votre animal de compagnie peut être une source de mico-réveil. Aménagez lui un endroit pour qu'il ait son propre lit.\nLes poils n'animaux peuvent être source d'allergie, évitez les si vous y êtes sujet.");
        n4.setImg(R.drawable.chat);

        News n5 = new News();
        n5.setPresentation("News : Le manque de sommeil.");
        n5.setTitre("Le manque de sommeil");
        n5.setTexteComplet("La dette de sommeil a un impact direct sur notre quotidien comme le manque de performance et les difficultés de concentration.\nA long terme, des risques plus important sont à venir comme le surpoids et des risques cardio vasculaire.");
        n5.setImg(R.drawable.info);

        lesNews.add(n1);
        lesNews.add(n2);
        lesNews.add(n3);
        lesNews.add(n4);
        lesNews.add(n5);

        affiche = 0;
        afficher(0);


    }

    private void afficher(int index){
        News trucAafficher = lesNews.get(index);
        titre.setText(trucAafficher.getTitre());
        presentation.setText(trucAafficher.getPresentation());
        image.setImageResource(trucAafficher.getImg());
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


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_manage) {
            Intent intent = new Intent(this, Profile.class);
            intent.putExtra("lePigeon", lePigeon);
            intent.putExtra("monzbi", true);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
            startActivity(new Intent(this, ListeExercices.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void afficherExercices(View view) {
        startActivity(new Intent(this, ListeExercices.class));
    }
}
