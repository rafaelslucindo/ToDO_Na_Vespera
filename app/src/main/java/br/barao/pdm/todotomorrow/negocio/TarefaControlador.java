package br.barao.pdm.todotomorrow.negocio;

import java.util.ArrayList;
import java.util.List;

import br.barao.pdm.todotomorrow.dominio.Tarefa;

public class TarefaControlador
{
    private static final List<Tarefa> listaTarefas = new ArrayList<>();

    public TarefaControlador()
    {
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
        listaTarefas.add(novaTarefa);
        return true;
    }

    public static List<Tarefa> getListaTarefas()
    {
        return listaTarefas;
    }

    public static void removeItemLista(Tarefa tarefaRemocao)
    {
        listaTarefas.remove(tarefaRemocao);
    }
}
