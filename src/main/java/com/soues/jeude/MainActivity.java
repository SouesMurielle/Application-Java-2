package com.soues.jeude;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.soues.jeude.model.PartieBean;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_tour;
    private TextView tv_score_j1;
    private ImageView iv_j1;
    private TextView textView6;
    private TextView tv_score_j2;
    private ImageView iv_j2;
    private Button bt_lancer;
    private TextView tv_de1;
    private TextView tv_de2;
    private TextView tv_gagnant;

    private PartieBean partie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_tour = findViewById(R.id.tv_tour);
        tv_score_j1 = findViewById(R.id.tv_score_j1);
        iv_j1 = findViewById(R.id.iv_j1);
        textView6 = findViewById(R.id.textView6);
        tv_score_j2 = findViewById(R.id.tv_score_j2);
        iv_j2 = findViewById(R.id.iv_j2);
        bt_lancer = findViewById(R.id.bt_lancer);
        tv_de1 = findViewById(R.id.tv_de1);
        tv_de2 = findViewById(R.id.tv_de2);
        tv_gagnant = findViewById(R.id.tv_gagnant);

        bt_lancer.setOnClickListener(this);

        partie = new PartieBean("Ginette", "Gaston");
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2019-10-20 19:15:21 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == bt_lancer) {
            // Je fais jouer le joueur courrant
            partie.getJc().lancer();

            // Je controle son lancer
            if (partie.getJc().getScoreDes() >= PartieBean.NB_A_ATTEINDRE) {
                partie.getJc().setScore(partie.getJc().getScore() + 1);
            }

            // Je change de joueur courrant
            partie.changerJoueur();

            // J'incrément le tour si c'est à J1 de jouer
            if (partie.getJc() == partie.getJ1()) {
                partie.ajouter1Tour();
            }

            // J'actualise l'écran
            rafraichirEcran();
        }
    }

    private void rafraichirEcran() {
        // Le tour de la partie
        tv_tour.setText(partie.getTourEnCours() + "");

        // Le score des joueurs
        tv_score_j1.setText(partie.getJ1().getScore() + "");
        tv_score_j2.setText(partie.getJ2().getScore() + "");

        if (partie.getJ1() == partie.getJc()) {
            iv_j1.setVisibility(View.VISIBLE);
            iv_j2.setVisibility(View.INVISIBLE);

            // On affiche les dés de J2
            tv_de1.setText(partie.getJ2().getDe1() + "");
            tv_de2.setText(partie.getJ2().getDe2() + "");
        } else {
            iv_j2.setVisibility(View.VISIBLE);
            iv_j1.setVisibility(View.INVISIBLE);

            // On affiche les dés de J1
            tv_de1.setText(partie.getJ1().getDe1() + "");
            tv_de2.setText(partie.getJ1().getDe2() + "");
        }

        // Le jeu se termine
        if (partie.getTourEnCours() == PartieBean.NB_LANCER) {
            tv_gagnant.setVisibility(View.VISIBLE);
            bt_lancer.setVisibility(View.INVISIBLE);

            if (partie.getJ1().getScore() == partie.getJ2().getScore())
                tv_gagnant.setText("Egalité !");
            else if (partie.getJ1().getScore() > partie.getJ2().getScore())
                tv_gagnant.setText(partie.getJ1().getNom() + " a gagné la partie !");
            else
                tv_gagnant.setText(partie.getJ2().getNom() + " a gagné la partie !");
        }
    }
}
