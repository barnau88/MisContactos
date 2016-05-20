package com.borjarnau.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.borjarnau.miscontactos.DetalleContacto;
import com.borjarnau.miscontactos.MainActivity;
import com.borjarnau.miscontactos.fragment.RecyclerviewFragment;
import com.borjarnau.miscontactos.pojo.Contacto;
import com.borjarnau.miscontactos.R;

import java.util.ArrayList;

/**
 * Created by ArnAu on 13/05/2016.
 */
public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder>{

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto>contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }


    //inflar o dar vida a el layout (cardview) y lo pasara al viewholder para el obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);

        return new ContactoViewHolder(v);

    }

    //asocia cada elemento de nuestra lista con cada view
    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, final int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());


        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("nombre", contacto.getNombre());
                intent.putExtra("telefono", contacto.getTelefono());
                intent.putExtra("email", contacto.getEmail());
                activity.startActivity(intent);


            }
        });

        contactoViewHolder.btLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText( activity, "Diste like a " + contacto.getNombre(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {  //Cantidad de elementos que tiene mi lista contactos
        return contactos.size();
    }



    ////////////////////////////////////////////////////////////////////////////

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;

        private ImageButton btLike;

        //Este constructor se ha puesto automaticamente, poniendome
        //alado de RecyclerView.ViewHolder cuando me salia la linea entera en rojo
        //apretando Alt+enter y me a sugerido el constructor

        public ContactoViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView)itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView)itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV= (TextView)itemView.findViewById(R.id.tvTelefonoCV);

            btLike= (ImageButton)itemView.findViewById(R.id.btLike);
        }
    }


}
