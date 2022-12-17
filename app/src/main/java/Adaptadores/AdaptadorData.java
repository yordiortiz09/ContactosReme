package Adaptadores;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactosreme.MainActivity;
import com.example.contactosreme.R;

import java.util.List;

import Modelos.Contacto;
import Modelos.Data;

public class AdaptadorData extends RecyclerView.Adapter<AdaptadorData.viewHolder> {
    List<Contacto> contactos;
    Context context;

    public AdaptadorData(List<Contacto> contactos, Context context) {
        this.contactos = contactos;
        this.context = context;
    }

    @NonNull
    @Override
    public AdaptadorData.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorData.viewHolder holder, int position) {
        holder.persona(contactos.get(position));

    }

    @Override
    public int getItemCount() {
       return contactos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        Contacto persona;
        TextView nombre, telefono, url;



        public viewHolder(@NonNull View itemView) {

            super(itemView);
            nombre = itemView.findViewById(R.id.Nombre);
            telefono = itemView.findViewById(R.id.Numero);
            url = itemView.findViewById(R.id.Url);
            telefono.setText(persona.getNumero());

             url.setText(persona.getUrl());
             nombre.setText(persona.getNombre());
            telefono.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + persona.getNumero()));
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions((MainActivity) context, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    } else {
                        context.startActivity(intent);
                    }
                }
            });
        }

        public void persona(Contacto contacto) {

            this.persona = contacto;

        }
    }
}
