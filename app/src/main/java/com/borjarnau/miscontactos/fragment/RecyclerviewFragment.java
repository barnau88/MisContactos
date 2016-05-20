package com.borjarnau.miscontactos.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borjarnau.miscontactos.R;
import com.borjarnau.miscontactos.adapter.ContactoAdaptador;
import com.borjarnau.miscontactos.pojo.Contacto;

import java.util.ArrayList;

/**
 * Created by ArnAu on 17/05/2016.
 */
public class RecyclerviewFragment extends Fragment {   //Fragment (android.support.v4.app)

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);


        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

////Para la vista q quiero hacer de la app del tfg el grid pega mas y es como lo quiero hacer,  lo q habria q retocar parametros para q queden cuadros igualados
        //GridLayoutManager glm = new GridLayoutManager(this, 2);


        listaContactos.setLayoutManager(llm);
        //listaContactos.setLayoutManager(glm);

        inicializarListaContactos();
        inicializarAdaptador();

        return  v;
    }

    public ContactoAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, getActivity());
        listaContactos.setAdapter(adaptador);
    }



    public void inicializarListaContactos(){

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.banana,"Anahi Salgado", "777799999","anahi@gmail.com"));
        contactos.add(new Contacto(R.drawable.patricio, "Borja Arnau", "23234545", "b.arnau@gmail.com"));
        contactos.add(new Contacto(R.drawable.turtle, "Sergio Palmer", "45367567", "sergio@gmail.com"));
        contactos.add(new Contacto(R.drawable.seta, "Juan Lopes", "67678989", "juan@gmail.com"));
        // contactos.add(new Contacto("Carlos Contrera", "77733344","carlos@gmail.com"));
    }
}
