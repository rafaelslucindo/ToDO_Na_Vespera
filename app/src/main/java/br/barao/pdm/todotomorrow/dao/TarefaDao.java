package br.barao.pdm.todotomorrow.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Update;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;

import java.util.ArrayList;
import java.util.List;

import br.barao.pdm.todotomorrow.dominio.Tarefa;
import br.barao.pdm.todotomorrow.dominio.TarefaResumoView;

@Dao
public abstract class TarefaDao
{
    @Insert
    public abstract void insert(Tarefa tarefa);

    @Update
    public abstract void update(Tarefa tarefa);

    @Delete
    public abstract void delete(Tarefa tarefa);

    @Query("select * from tarefa")
    public abstract List<Tarefa> selectTodosRegistros();

    @Query("select count(1) from tarefa")
    public abstract int contaRegistros();

    @Query(" select * " +
            "  from tarefa " +
            " where codigo = :parametroCodigo")
    public abstract Tarefa selectPelaChave(Long parametroCodigo);

    @Query(" select codigo, titulo, descricao " +
            "  from tarefa " +
            " where codigo = :parametroCodigo")
    public abstract TarefaResumoView selectResumoTarefa(Long parametroCodigo);

    @RawQuery
    public abstract List<Tarefa> selectCustomizado(SupportSQLiteQuery query);

    public List<Tarefa> selectCustomizado(Long codigo, String titulo, String data)
    {
        List<Object> listaParametros = new ArrayList<>();

        String query = "select * from tarefa where 1 = 1";

        if(codigo != null)
        {
            query += " and codigo = ?";
            listaParametros.add(codigo);
        }

        if(titulo != null)
        {
            query += " and titulo = ?";
            listaParametros.add(titulo);
        }

        if(data != null)
        {
            query += " and data = ?";
            listaParametros.add(data);
        }

        SupportSQLiteQuery supportSQLiteQuery = new SimpleSQLiteQuery(query, listaParametros.toArray());
        return selectCustomizado(supportSQLiteQuery);
    }

}
