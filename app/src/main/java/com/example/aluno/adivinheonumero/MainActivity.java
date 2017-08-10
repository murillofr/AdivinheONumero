package com.example.aluno.adivinheonumero;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnKeyListener {

    EditText numero;
    TextView msg;
    int sorteio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg = (TextView) findViewById(R.id.mensagem);
        numero = (EditText) findViewById(R.id.Numero);
        numero.setOnKeyListener(this);
        sorteio = (int)(Math.random()*101);
    }

    @Override
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if(i == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() != KeyEvent.ACTION_DOWN){
            verificaPalpite();
            return true;
        }
        return false;
    }

    private void verificaPalpite() {
        int chute = Integer.parseInt(numero.getText().toString());
        if(chute == sorteio)
            msg.setText("Acertou Miserávi!");
        else if(chute > sorteio)
            msg.setText("Erro! Tente um número menor!");
        else
            msg.setText("Erro! Tente um número maior!");
    }
}