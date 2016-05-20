package com.borjarnau.miscontactos;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.borjarnau.miscontactos.adapter.ContactoAdaptador;
import com.borjarnau.miscontactos.adapter.PageAdapter;
import com.borjarnau.miscontactos.fragment.PerfilFragment;
import com.borjarnau.miscontactos.fragment.RecyclerviewFragment;
import com.borjarnau.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    //ArrayList<Contacto> contactos;
    //private RecyclerView listaContactos;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /////////PARA Q SE VEA MI NUEVO ACTION BAR  //PERO ALFINAL NO LO HE PUESTO
       // Toolbar miActionBar= (Toolbar) findViewById(R.id.miActionBar);
        //setSupportActionBar(miActionBar);
        /////


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);


        setUpViewPager();



        if(toolbar != null){
            setSupportActionBar(toolbar);
        }



/*    NUESTRO RECICLERVIEW YA NO VIVE EEN EL MAIN ACTIVITY
        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

////Para la vista q quiero hacer de la app del tfg el grid pega mas y es como lo quiero hacer,  lo q habria q retocar parametros para q queden cuadros igualados
        //GridLayoutManager glm = new GridLayoutManager(this, 2);


        listaContactos.setLayoutManager(llm);
        //listaContactos.setLayoutManager(glm);

        inicializarListaContactos();
        inicializarAdaptador();
*/
        /*   COMO AHORA TENEMOS RYCYCLEVIEW, QUITAMOS ESTO y LO ACOMODAMOS AL RECYCLEVIEW

        ListView lstContactos = (ListView)findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));


        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());

                startActivity(intent);


                finish();

            }
        });

        */

    }


    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerviewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_perfil);
    }


/*

    public ContactoAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }



    public void inicializarListaContactos(){

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.banana,"Anahi Salgado", "777799999","anahi@gmail.com"));
        contactos.add(new Contacto(R.drawable.patricio, "Borja Arnau", "23234545","b.arnau@gmail.com"));
        contactos.add(new Contacto(R.drawable.turtle, "Sergio Palmer", "45367567","sergio@gmail.com"));
        contactos.add(new Contacto(R.drawable.seta, "Juan Lopes", "67678989", "juan@gmail.com"));
        // contactos.add(new Contacto("Carlos Contrera", "77733344","carlos@gmail.com"));
    }



*/



}
