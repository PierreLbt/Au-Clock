package fr.pierreliaubet.au_clock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private Utilisateur lePigeon = new Utilisateur();
    private EditText nom;
    private EditText dateNaissance;
    private EditText heureLever;
    private SeekBar sommeil;
    private TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        nom = findViewById(R.id.prenom);
        dateNaissance = findViewById(R.id.dateNaissance);
        heureLever = findViewById(R.id.heureLever);
        sommeil = findViewById(R.id.heuressommeil);
        label = findViewById(R.id.labelHeures);
        sommeil.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                label.setText(String.valueOf(progress) + " heures");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        if (getIntent().getSerializableExtra("lePigeon") != null){
            lePigeon = (Utilisateur) getIntent().getSerializableExtra("lePigeon");
            nom.setText(lePigeon.getNom());
            dateNaissance.setText(lePigeon.getDateNaissance());
            heureLever.setText(lePigeon.getHeureReveil());
        }
    }

    public void demarrer(View view) {
        lePigeon.setNom(nom.getText().toString());
        lePigeon.setDateNaissance(dateNaissance.getText().toString());
        lePigeon.setHeureReveil(heureLever.getText().toString());
        if (getIntent().getSerializableExtra("lePigeon") != null){
            Intent home = new Intent(this, Home.class);
            home.putExtra("lePigeon", lePigeon);
            startActivity(home);
        }else{
            Intent questions = new Intent(this, Questions.class);
            questions.putExtra("lePigeon", lePigeon);
            startActivity(questions);
        }

    }
}
