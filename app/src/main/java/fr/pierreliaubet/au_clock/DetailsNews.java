package fr.pierreliaubet.au_clock;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsNews extends AppCompatActivity {

    News news;

    TextView titre;
    TextView contenu;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_news);

        Intent intent = getIntent();
        news = (News) intent.getSerializableExtra("new");

        titre = findViewById(R.id.titreDetails);
        contenu = findViewById(R.id.contenuDetails);
        img = findViewById(R.id.imgDetails);

        titre.setText(news.getTitre());
        contenu.setText(news.getTexteComplet());
        img.setImageResource(news.getImg());
    }

    public void retour(View view){
        this.finish();
    }
}
