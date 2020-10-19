package br.barao.pdm.todotomorrow.dominio;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Tarefa
{
    @PrimaryKey(autoGenerate = true)
    private Long codigo;

    @ColumnInfo
    private String titulo;

    @ColumnInfo
    private String descricao;

    @ColumnInfo
    private String data;

    @ColumnInfo
    private String local;

    @ColumnInfo
    private Boolean status_realizado;

    @ColumnInfo
    private String prioridade;

    @ColumnInfo
    private Boolean alertar;

    @ColumnInfo
    private Double latitude_local;

    @ColumnInfo
    private Double longitude_local;

    @ColumnInfo
    private String anexo;

    @Ignore
    private String atributoQueNaoEColuna;

    public Tarefa()
    {
    }

    public Long getCodigo()
    {
        return codigo;
    }

    public void setCodigo(Long codigo)
    {
        this.codigo = codigo;
    }

    public String getTitulo()
    {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getData()
    {
        return data;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public String getLocal()
    {
        return local;
    }

    public void setLocal(String local)
    {
        this.local = local;
    }

    public Boolean getStatus_realizado()
    {
        return status_realizado;
    }

    public void setStatus_realizado(Boolean status_realizado)
    {
        this.status_realizado = status_realizado;
    }

    public String getPrioridade()
    {
        return prioridade;
    }

    public void setPrioridade(String prioridade)
    {
        this.prioridade = prioridade;
    }

    public Boolean getAlertar()
    {
        return alertar;
    }

    public void setAlertar(Boolean alertar)
    {
        this.alertar = alertar;
    }

    public Double getLatitude_local()
    {
        return latitude_local;
    }

    public void setLatitude_local(Double latitude_local)
    {
        this.latitude_local = latitude_local;
    }

    public Double getLongitude_local()
    {
        return longitude_local;
    }

    public void setLongitude_local(Double longitude_local)
    {
        this.longitude_local = longitude_local;
    }

    public String getAnexo()
    {
        return anexo;
    }

    public void setAnexo(String anexo)
    {
        this.anexo = anexo;
    }
}
