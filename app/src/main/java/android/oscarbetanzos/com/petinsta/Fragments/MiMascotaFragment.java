package android.oscarbetanzos.com.petinsta.Fragments;

import android.os.Bundle;
import android.oscarbetanzos.com.petinsta.Adapters.MascotaAdaptador;
import android.oscarbetanzos.com.petinsta.Adapters.MiMascotaAdaptador;
import android.oscarbetanzos.com.petinsta.Mascota;
import android.oscarbetanzos.com.petinsta.R;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MiMascotaFragment extends Fragment{
    private ArrayList<Mascota> miMascotaFotos;
    private RecyclerView rvMiMascota;


    public MiMascotaFragment(){
        //constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mimascota,container,false);

        rvMiMascota = (RecyclerView) v.findViewById(R.id.rvMiMascota);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);


        rvMiMascota.setLayoutManager(glm);

        inicializarMiMascota();
        inicializarAdaptador();

        return v;
    }


    public void inicializarMiMascota(){
        miMascotaFotos = new ArrayList<Mascota>();

        miMascotaFotos.add(new Mascota(R.drawable.sb2,"Kala","0"));
        miMascotaFotos.add(new Mascota(R.drawable.sb3,"Kala","2"));
        miMascotaFotos.add(new Mascota(R.drawable.sb4,"Kala","5"));
        miMascotaFotos.add(new Mascota(R.drawable.sb5,"Kala","7"));
        miMascotaFotos.add(new Mascota(R.drawable.sb6,"Kala","10"));
        miMascotaFotos.add(new Mascota(R.drawable.sb7,"Kala","9"));
        miMascotaFotos.add(new Mascota(R.drawable.sb8,"Kala","1"));
        miMascotaFotos.add(new Mascota(R.drawable.sb9,"Kala","4"));
        miMascotaFotos.add(new Mascota(R.drawable.sb10,"Kala","8"));
    }

    public void inicializarAdaptador(){
        MiMascotaAdaptador adaptador = new MiMascotaAdaptador(miMascotaFotos);
        rvMiMascota.setAdapter(adaptador);
    }
}
