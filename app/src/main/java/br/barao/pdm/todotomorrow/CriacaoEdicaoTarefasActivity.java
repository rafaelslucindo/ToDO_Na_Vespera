package br.barao.pdm.todotomorrow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;

import br.barao.pdm.todotomorrow.mensagens.Mensagem;
import br.barao.pdm.todotomorrow.negocio.TarefaControlador;

public class CriacaoEdicaoTarefasActivity extends AppCompatActivity
{
    private Context context = CriacaoEdicaoTarefasActivity.this;

    private ScrollView svTela;
    private EditText etTitulo;
    private EditText etDescricao;
    private EditText etData;
    private EditText etLocal;
    private EditText etLatitude;
    private EditText etLongitude;
    private CheckBox ckRealizado;
    private Spinner spPrioridade;
    private RadioGroup rgAlertar;
    private RadioButton rbAlertarSim;
    private RadioButton rbAlertarNao;
    private Button btAnexarFoto;
    private Button btSalvar;
    private Button btCancelar;
    //
    private TarefaControlador tarefaControlador;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criacao_edicao_tarefas);
        criaControladores();
        inicializaComponentes();
        inicializaEventos();
    }

    private void criaControladores()
    {
        tarefaControlador = new TarefaControlador();
    }

    private void inicializaComponentes()
    {
        svTela = findViewById(R.id.svTela);
        etTitulo = findViewById(R.id.etTitulo);
        etDescricao = findViewById(R.id.etDescricao);
        etData = findViewById(R.id.etData);
        etLocal = findViewById(R.id.etLocal);
        etLatitude = findViewById(R.id.etLatitude);
        etLongitude = findViewById(R.id.etLongitude);
        ckRealizado = findViewById(R.id.ckRealizado);
        spPrioridade = findViewById(R.id.spPrioridade);
        rgAlertar = findViewById(R.id.rgAlertar);
        rbAlertarSim = findViewById(R.id.rbAlertarSim);
        rbAlertarNao = findViewById(R.id.rbAlertarNao);
        btAnexarFoto = findViewById(R.id.btAnexarFoto);
        btSalvar = findViewById(R.id.btSalvar);
        btCancelar = findViewById(R.id.btCancelar);
    }

    private void inicializaEventos()
    {
        btSalvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                salvaNovaTarefa();
            }
        });
    }

    private void salvaNovaTarefa()
    {
        if (!validaTela())
            return;

        final String titulo = etTitulo.getText().toString();
        final String descricao = etDescricao.getText().toString();
        final String data = etData.getText().toString();
        final String local = etLocal.getText().toString();
        final Boolean status_realizado = ckRealizado.isChecked();
        final String prioridade = null;
        final Boolean alertar = rbAlertarSim.isChecked();
        //Boolean alertar = rgAlertar.getCheckedRadioButtonId() == rbAlertarSim.getId();
//        switch (rgAlertar.getCheckedRadioButtonId())
//        {
//            case R.id.rbAlertarSim:
//                alertar = true;
//                break;
//            case R.id.rbAlertarNao:
//                alertar = false;
//                break;
//        }
        final Double latitude = !etLatitude.getText().toString().trim().isEmpty() ? Double.valueOf(etLatitude.getText().toString()) : null;
        final Double longitude = !etLongitude.getText().toString().trim().isEmpty() ? Double.valueOf(etLongitude.getText().toString()) : null;

        Mensagem.exibeMensagemConfirmacao(context, getString(R.string.Confirmacao), getString(R.string.MensagemConfirmacao),
                getString(R.string.Sim), getString(R.string.Nao)
                , new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        if (tarefaControlador.adicionaTarefa(titulo, descricao, data, local, status_realizado, prioridade, alertar, latitude, longitude))
                        {
                            Mensagem.exibeMensagemTemporaria(context, R.string.TarefaSalvaSucesso);
                            reiniciaTela();
                        }
                    }
                }
                , null);



    }

    private boolean validaTela()
    {
        if (rgAlertar.getCheckedRadioButtonId() == -1)
        {
            Mensagem.exibeMensagemTemporaria(context, R.string.MensagemInformarAlertar);
            return false;
        }

        return true;
    }

    private void reiniciaTela()
    {
        etTitulo.setText("");
        etDescricao.setText("");
        etData.setText("");
        etLocal.setText("");
        etLatitude.setText("");
        etLongitude.setText("");
        ckRealizado.setChecked(false);
        //spPrioridade;
        rgAlertar.clearCheck();
        //Traz o foco para o campo
        etTitulo.requestFocus();
        svTela.scrollTo(0, 0);
    }
}