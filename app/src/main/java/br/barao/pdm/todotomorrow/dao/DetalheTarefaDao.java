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

import br.barao.pdm.todotomorrow.dominio.DetalheTarefa;
import br.barao.pdm.todotomorrow.dominio.Tarefa;
import br.barao.pdm.todotomorrow.dominio.TarefaResumoView;

@Dao
public abstract class DetalheTarefaDao
{
    @Insert
    public abstract void insert(DetalheTarefa detalheTarefa);

    @Update
    public abstract void update(DetalheTarefa detalheTarefa);

    @Delete
    public abstract void delete(DetalheTarefa detalheTarefa);

    @Query("select * from detalhetarefa")
    public abstract List<DetalheTarefa> selectTodosRegistros();
}
