package br.barao.pdm.todotomorrow.dominio;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys =
        {
                @ForeignKey(entity = Tarefa.class, parentColumns = "codigo", childColumns = "codigoTarefa"),
        }
)
public class DetalheTarefa
{
    @PrimaryKey(autoGenerate = true)
    private Long codigoDetalhe;

    @ColumnInfo
    private String descricao;

    @ColumnInfo
    private Long codigoTarefa;

    public Long getCodigoDetalhe()
    {
        return codigoDetalhe;
    }

    public void setCodigoDetalhe(Long codigoDetalhe)
    {
        this.codigoDetalhe = codigoDetalhe;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public Long getCodigoTarefa()
    {
        return codigoTarefa;
    }

    public void setCodigoTarefa(Long codigoTarefa)
    {
        this.codigoTarefa = codigoTarefa;
    }
}
