package br.barao.pdm.todotomorrow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.barao.pdm.todotomorrow.dominio.Tarefa;
import br.barao.pdm.todotomorrow.negocio.TarefaControlador;

public class MainActivity extends AppCompatActivity
{
    private Context context = MainActivity.this;
    private FloatingActionButton btAdicionar;
    private RecyclerView rvLista;
    private TarefaControlador tarefaControlador;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaControladores();
        inicializaComponentes();
        inicializaEventos();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        rvLista.getAdapter().notifyDataSetChanged();
    }

    private void inicializaControladores()
    {
        tarefaControlador = new TarefaControlador(context);
    }

    private void inicializaComponentes()
    {
        rvLista = findViewById(R.id.rvLista);
        rvLista.setAdapter(new Adapter());
        btAdicionar = findViewById(R.id.btAdicionar);
    }

    private void inicializaEventos()
    {
        btAdicionar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                abreTelaAdicao();
            }
        });
    }

    private void abreTelaAdicao()
    {
        startActivity(new Intent(context, CriacaoEdicaoTarefasActivity.class));
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        private View item;
        private ImageView ivRealizado;
        private ImageView ivPrioridade;
        private TextView tvTitulo;
        private TextView tvDescricao;
        private TextView tvData;
        private TextView tvLocal;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            item = itemView;
            inicializaComponentesItem();
            inicializaEventosItem();
        }

        private void inicializaComponentesItem()
        {
            ivRealizado = item.findViewById(R.id.ivRealizado);
            ivPrioridade = item.findViewById(R.id.ivPrioridade);
            tvTitulo = item.findViewById(R.id.tvTitulo);
            tvDescricao = item.findViewById(R.id.tvDescricao);
            tvData = item.findViewById(R.id.tvData);
            tvLocal = item.findViewById(R.id.tvLocal);
        }

        private void inicializaEventosItem()
        {
            item.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    rvLista.getAdapter().notifyItemRemoved(tarefaControlador.getListaTarefas().indexOf((Tarefa) v.getTag()));
                    tarefaControlador.removeItemLista((Tarefa) v.getTag());
                    return true;
                }
            });
        }
    }

    public class Adapter extends RecyclerView.Adapter<ViewHolder>
    {

        @Override
        //É o método no qual o Adapter chama para verificar quantos
        // itens existem na lista que será exibida
        //Devemos retornar o número de registros que serão exibidos na lista
        public int getItemCount()
        {
            return tarefaControlador.contaRegistros();
        }

        @NonNull
        @Override
        //Método responsável por inflar (responsabilidade do Android que interpreta o xml do layout e instancia os
        //objetos/componentes visuais de cada item
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
        {
            View view = getLayoutInflater().inflate(R.layout.item_layout_listagem_tarefa, parent, false);
            return new ViewHolder(view);
        }

        @Override
        // Atribuir aos componentes visuais do item/viewholder os valores desejados referentes a posição da lista
        public void onBindViewHolder(@NonNull ViewHolder holder, int position)
        {
            Tarefa tarefaDaPosicao = tarefaControlador.getListaTarefas().get(position);
            //holder.ivRealizado;
            //holder.ivPrioridade;
            holder.tvTitulo.setText(tarefaDaPosicao.getTitulo());
            holder.tvDescricao.setText(tarefaDaPosicao.getDescricao());
            holder.tvData.setText(tarefaDaPosicao.getData());
            holder.tvLocal.setText(tarefaDaPosicao.getLocal());
            //
            holder.item.setTag(tarefaDaPosicao);
        }

    }
}