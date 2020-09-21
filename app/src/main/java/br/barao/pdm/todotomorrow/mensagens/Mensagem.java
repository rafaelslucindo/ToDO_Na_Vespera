package br.barao.pdm.todotomorrow.mensagens;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import br.barao.pdm.todotomorrow.R;

public class Mensagem
{
    public static void exibeMensagemTemporaria(Context context, int id_mensagem)
    {
        Toast toast = Toast.makeText(context, id_mensagem, Toast.LENGTH_LONG);
        toast.show();
    }

    public static void exibeMensagemTemporaria(Context context, String mensagem)
    {
        Toast toast = Toast.makeText(context, mensagem, Toast.LENGTH_LONG);
        toast.show();
    }

    public static void exibeMensagemConfirmacao(Context context
            , String titulo
            , String mensagem
            , String botaoPositivo, String botaoNegativo
            , DialogInterface.OnClickListener eventoBotaoPositivo
            , DialogInterface.OnClickListener eventoBotaoNegativo
    )
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(titulo);
        builder.setMessage(mensagem);
        builder.setCancelable(false);
        builder.setPositiveButton(botaoPositivo, eventoBotaoPositivo);
        builder.setNegativeButton(botaoNegativo, eventoBotaoNegativo);
        Dialog dialog = builder.create();
        dialog.show();
    }

}
