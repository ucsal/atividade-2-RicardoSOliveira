package br.com.mariojp.exercise2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewHolder AViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.AViewHolder.textView = findViewById(R.id.textView);
        this.AViewHolder.btnTrocar = findViewById(R.id.btnTrocar);

        this.AViewHolder.btnTrocar.setOnClickListener((View.OnClickListener) this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        this.trocarUsuario();
    }


    private void trocarUsuario(){
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String usuarioConfirma = extras.getString(getString(R.string.UsuarioConfirma));
            if(!usuarioConfirma.equals(""))
                this.AViewHolder.textView.setText(String.format("Oi, "+ usuarioConfirma + "!"));
        }
    }


    public void onClick(View v) {
        Bundle extras = getIntent().getExtras();
        if(v.getId() == R.id.btnTrocar){
            Intent intent = new Intent(this, OutraActivity.class);
            if(extras != null){
                String usuarioAtual = extras.getString(getString(R.string.UsuarioConfirma));
                intent.putExtra(getString(R.string.UsuarioAtual),usuarioAtual);
            }
            startActivity(intent);


        }
    }

    private static class ViewHolder{
        TextView textView;
        Button btnTrocar;
    }

}
