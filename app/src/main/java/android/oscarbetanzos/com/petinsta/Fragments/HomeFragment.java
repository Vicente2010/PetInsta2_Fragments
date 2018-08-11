package android.oscarbetanzos.com.petinsta.Fragments;

import android.os.Bundle;
import android.oscarbetanzos.com.petinsta.MainActivity;
import android.oscarbetanzos.com.petinsta.Mascota;
import android.oscarbetanzos.com.petinsta.Adapters.MascotaAdaptador;
import android.oscarbetanzos.com.petinsta.R;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment{
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;







    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_home,container,false);
        mascotas =  ((MainActivity) this.getActivity()).getMascotas();

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvListaMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        //inicializarMascotas();
        inicializarAdaptador();

        ((MainActivity) this.getActivity()).setMascotas(mascotas);

        return v;

    }

    /*
    public void inicializarMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.bulyteryer,"Hook","0"));
        mascotas.add(new Mascota(R.drawable.labrador,"Peyton","0"));
        mascotas.add(new Mascota(R.drawable.mittelyshnauter,"Cali","0"));
        mascotas.add(new Mascota(R.drawable.huskies,"Moon moon","0"));
        mascotas.add(new Mascota(R.drawable.chihuahua,"Lua","0"));
        mascotas.add(new Mascota(R.drawable.daschound,"Chispa","0"));
        mascotas.add(new Mascota(R.drawable.bulyteryer2,"Chester","0"));
    }
    */

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

}
