package br.barao.pdm.todotomorrow.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.barao.pdm.todotomorrow.dao.DetalheTarefaDao;
import br.barao.pdm.todotomorrow.dao.TarefaDao;
import br.barao.pdm.todotomorrow.dominio.DetalheTarefa;
import br.barao.pdm.todotomorrow.dominio.Tarefa;

// Em entities devemos declarar todas as classes que irão ser tabelas
// no nosso banco de dados
@Database(entities = {Tarefa.class, DetalheTarefa.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase
{
    //Nome do banco de dados (arquivo)
    private static final String DATABASE_NAME = "BancoDeDados";

    //Declarar todos os DAOs que a gente tem no nosso app
    public abstract TarefaDao getTarefaDao();
    public abstract DetalheTarefaDao getDetalheTarefaDao();
    /*public abstract OutraTabelaDao getOutraTabelaDao();*/

    //Criação de método singleton para acesso a conexão única ao
    //banco de dados
    private static MyDatabase myDatabase;

    public static synchronized MyDatabase getInstance(Context context)
    {
        if(myDatabase == null)
            myDatabase = Room
                    .databaseBuilder(context, MyDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries().build();
        return myDatabase;
    }
}
