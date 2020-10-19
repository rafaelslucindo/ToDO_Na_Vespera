package br.barao.pdm.todotomorrow.negocio;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import br.barao.pdm.todotomorrow.dao.TarefaDao;
import br.barao.pdm.todotomorrow.database.MyDatabase;
import br.barao.pdm.todotomorrow.dominio.Tarefa;

public class TarefaControlador
{
    private TarefaDao tarefaDao;

    public TarefaControlador(Context context)
    {
        tarefaDao = MyDatabase.getInstance(context).getTarefaDao();
    }

    public boolean adicionaTarefa(String titulo, String descricao, String data, String local, Boolean status_realizado,
                                  String prioridade, Boolean alertar, Double latitude, Double longite)
    {
        Tarefa novaTarefa = new Tarefa();
        novaTarefa.setTitulo(titulo);
        novaTarefa.setDescricao(descricao);
        novaTarefa.setData(data);
        novaTarefa.setLocal(local);
        novaTarefa.setStatus_realizado(status_realizado);
        novaTarefa.setPrioridade(prioridade);
        novaTarefa.setAlertar(alertar);
        novaTarefa.setLatitude_local(latitude);
        novaTarefa.setLongitude_local(longite);
        tarefaDao.insert(novaTarefa);
        return true;
    }

    public List<Tarefa> getListaTarefas()
    {
        return tarefaDao.selectTodosRegistros();
    }

    public void removeItemLista(Tarefa tarefaRemocao)
    {
        tarefaDao.delete(tarefaRemocao);
    }

    public int contaRegistros()
    {
        return tarefaDao.contaRegistros();
    }
}
