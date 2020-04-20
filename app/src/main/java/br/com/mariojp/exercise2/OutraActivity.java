package br.com.mariojp.exercise2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


@SuppressWarnings("SpellCheckingInspection")
public class OutraActivity extends AppCompatActivity implements View.OnClickListener  {
    private ViewHolder AViewHolder = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.outra_activity);
        this.AViewHolder.editText = (EditText) findViewById(R.id.editText);
        this.AViewHolder.btnConfirmar = (Button) findViewById(R.id.btnConfirmar);
        this.AViewHolder.btnCancelar = (Button) findViewById(R.id.btnCancelar);

        this.AViewHolder.btnConfirmar.setOnClickListener((View.OnClickListener) this);
        this.AViewHolder.btnCancelar.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.usuarioAtual();
    }

    private void usuarioAtual(){
        Bundle extras = getIntent().getExtras();
        String usuarioAtual;
        if(extras != null){
            usuarioAtual = extras.getString(getString(R.string.UsuarioAtual));
            this.AViewHolder.editText.setText(usuarioAtual);
        }
    }

    @Override
    public void onClick(View v) {
        String valueConfirm = this.AViewHolder.editText.getText().toString();
        Intent intent = new Intent(this,MainActivity.class);
        if(v.getId() == R.id.btnConfirmar){
            intent.putExtra(getString(R.string.UsuarioConfirma),valueConfirm);
        }
        startActivity(intent);


    }

    private static class ViewHolder{
        EditText editText;
        Button btnConfirmar, btnCancelar;

    }

}
