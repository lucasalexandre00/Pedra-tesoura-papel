package br.edu.ifsp.dmo.pedratesourapapel;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.edu.ifsp.dmo.pedratesourapapel.model.Coisa;
import br.edu.ifsp.dmo.pedratesourapapel.model.Papel;
import br.edu.ifsp.dmo.pedratesourapapel.model.Pedra;
import br.edu.ifsp.dmo.pedratesourapapel.model.Tesoura;

public class SelecaoActivity extends AppCompatActivity implements View.OnClickListener {

    private String nome;
    private int numero;

    private TextView textView;
    private Button pedraButton;
    private Button tesouraButton;
    private Button papelButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao);

        Intent intent = getIntent();
        if (intent != null){
            nome = intent.getStringExtra(Constantes.KEY_NOME);
            numero = intent.getIntExtra(Constantes.KEY_NRO_JOGADOR, 0);
        }

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null){
            getSupportActionBar().hide();
        }

        textView = findViewById(R.id.textview_mensagem);
        pedraButton = findViewById(R.id.buttonPedra);
        tesouraButton = findViewById(R.id.buttonTesoura);
        papelButton = findViewById(R.id.buttonPapel);

        textView.setText(nome + getString(R.string.escolha_arma));
        pedraButton.setOnClickListener(this);
        tesouraButton.setOnClickListener(this);
        papelButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Coisa coisa = null;
        if (view == pedraButton){
            coisa = new Pedra();
        }else if (view == papelButton){
            coisa = new Papel();
        } else if (view == tesouraButton) {
            coisa = new Tesoura();
        }
        retornarResultado(coisa);
    }

    private void retornarResultado(Coisa coisa) {
        if (coisa == null){
            setResult(RESULT_CANCELED);
            finish();
        }else {
            Intent intent = new Intent();
            intent.putExtra(Constantes.KEY_NRO_JOGADOR, numero);
            intent.putExtra(Constantes.KEY_COISA, coisa);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}