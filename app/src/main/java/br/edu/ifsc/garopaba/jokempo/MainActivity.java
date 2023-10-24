package br.edu.ifsc.garopaba.jokempo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int jogadapc(){
        int n = new Random().nextInt(3)+1;
        ImageView imagepadrao=findViewById(R.id.imagepadrao);
        switch (n){
            case 1:
                imagepadrao.setImageResource(R.drawable.pedra);
                break;
            case 2:
                imagepadrao.setImageResource(R.drawable.papel);
                break;
            case 3:
                imagepadrao.setImageResource(R.drawable.tesoura);
                break;
        }
        return n;
    }

    public void verificar(int jogadauser, int jogadapc){
        TextView resultado=findViewById(R.id.textresultado);
        if(jogadauser == 1 && jogadapc== 2)
        resultado.setText("Voce perdeu!!!!");
        else if(jogadauser == 2 && jogadapc== 3)
            resultado.setText("Voce perdeu!!!!");
        else if(jogadauser == 3 && jogadapc== 1)
            resultado.setText("Voce perdeu!!!!");
        else if(jogadauser == jogadapc)
            resultado.setText("Empate!!!!");
        else {
            resultado.setText("Voce ganhou!!!!");
        }


    }

    public void jogar(View view){
        String jogada = getResources().getResourceEntryName(view.getId());
        int jogadauser=0;
        int jogadapc = jogadapc();
        switch (jogada){
            case"imagepedra":
                jogadauser=1;
                Toast.makeText(this, "Voce jogou pedra", Toast.LENGTH_SHORT).show();
                break;
            case"imagepapel":
                jogadauser=2;
                Toast.makeText(this, "Voce jogou papel", Toast.LENGTH_SHORT).show();
                break;
            case"imagetesoura":
                jogadauser=3;
                Toast.makeText(this, "Voce jogou tesoura", Toast.LENGTH_SHORT).show();
                break;
        }
        verificar(jogadauser, jogadapc);
    }
}