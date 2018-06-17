package fr.pierreliaubet.au_clock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Profile extends AppCompatActivity {

    private Utilisateur lePigeon = new Utilisateur();
    private EditText nom;
    private EditText dateNaissance;
    private EditText heureLever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        nom = findViewById(R.id.prenom);
        dateNaissance = findViewById(R.id.dateNaissance);
        heureLever = findViewById(R.id.heureLever);
    }

    public void demarrer(View view) {
        lePigeon.setNom(nom.getText().toString());
        lePigeon.setDateNaissance(dateNaissance.getText().toString());
        lePigeon.setHeureReveil(heureLever.getText().toString());
        Intent questions = new Intent(this, Questions.class);
        questions.putExtra("lePigeon", lePigeon);
        startActivity(questions);
    }
}
