package com.example.eliascapasso.alljobs;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.eliascapasso.alljobs.Actividades.PropuestaActivity;
import com.example.eliascapasso.alljobs.DAO.TrabajosRepositorio;
import com.example.eliascapasso.alljobs.Modelo.Trabajo;

public class PropuestaReceiver extends BroadcastReceiver{
    public static String ESTADO_ACEPTADO = "ACEPTADO";

    private TrabajosRepositorio trabajoRepositorio;
    private Trabajo unTrabajo;


    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        Bundle extras = intent.getExtras();
        int idTrabajo = extras.getInt("idTrabajo");
        trabajoRepositorio = new TrabajosRepositorio();

        unTrabajo = trabajoRepositorio.obtenerTrabajo(idTrabajo);

        if(unTrabajo.getEstado().equals(Trabajo.Estado.ACEPTADO)){
            Toast.makeText(context, "El trabajo " + unTrabajo.getTitulo() + " ha cambiado a estado ACEPTADO", Toast.LENGTH_LONG).show();

            Intent trabajoIntent = new Intent(context, PropuestaActivity.class);
            trabajoIntent.putExtra("idTrabajo", idTrabajo);
            trabajoIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, trabajoIntent, PendingIntent.FLAG_UPDATE_CURRENT);

            NotificationManager nManager = (NotificationManager) context
                    .getSystemService(Context.NOTIFICATION_SERVICE);

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "CANAL01")
                    .setSmallIcon(android.R.drawable.ic_dialog_info)
                    .setContentTitle("¡El trabajo fue aceptado!")
                    .setWhen(System.currentTimeMillis())
                    .setContentIntent(pendingIntent)
                    .setAutoCancel(true);

            nManager.notify(123456, builder.build());
        }
    }
}
