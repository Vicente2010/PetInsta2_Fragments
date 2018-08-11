package android.oscarbetanzos.com.petinsta;

import android.oscarbetanzos.com.petinsta.Adapters.PageAdapter;
import android.oscarbetanzos.com.petinsta.Fragments.HomeFragment;
import android.oscarbetanzos.com.petinsta.Fragments.MiMascotaFragment;
import android.support.v4.app.Fragment;
import android.content.Intent;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    RecyclerView listaMascotas;
    ImageButton starButton;
    int indices[] = new int[5];
    ArrayList<Mascota>topFiveMascotas;
    String[] topNombres = new String[5];;
    String[] topRates = new String[5];
    int topFoto[] = new int[5];
    Toolbar miActionBar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    public ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarMascotas();

        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        setUpViewPager();


        starButton = (ImageButton) findViewById(R.id.starButton);
        starButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int rates[] = new int[mascotas.size()];
                //Toast.makeText(MainActivity.this,Integer.toString(rates.length),Toast.LENGTH_SHORT).show();

                for (int i=0; i<rates.length;i++){
                    rates[i]=Integer.parseInt(mascotas.get(i).getRate());
                    //Log.v("Contador " + Integer.toString(i),Integer.toString(rates[i]));
                }

                topCinco(rates);
                crearTopFive();

                Intent intent = new Intent(MainActivity.this,TopFiveActivity.class);
                intent.putExtra("TopNombres",topNombres);
                intent.putExtra("TopRates",  topRates);
                intent.putExtra("TopFoto",   topFoto);
                startActivity(intent);

            }
        });



    }


    public void topCinco(int[] rates){

        int i;
        int max = 0;
        int indiceAux;
        for (int j=0; j<5; j++){
            max = rates[0];
            indiceAux = 0;
            for (i =1; i<rates.length; i++){
                if (max< rates[i]){
                    max=rates[i];
                    indiceAux=i;
                }
            }
            indices[j]=indiceAux;
            rates[indiceAux]=Integer.MIN_VALUE;
        }
    }

    public void crearTopFive(){
        topFiveMascotas = new ArrayList<Mascota>();

        for (int i=0;i<indices.length;i++){
            //Log.v("Indices " + Integer.toString(i),Integer.toString(indices[i])+mascotas.get(indices[i]).getNombre());

            topFoto[i] = mascotas.get(indices[i]).getFoto();
            topNombres[i]= mascotas.get(indices[i]).getNombre();
            topRates[i]= mascotas.get(indices[i]).getRate();

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);

        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.mnContacto:
                Intent ctcAct = new Intent(MainActivity.this, ContactoActivity.class);
                startActivityForResult(ctcAct,1);
                break;


            case R.id.mnAbout:
                Intent aboutAct = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(aboutAct);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new HomeFragment());
        fragments.add(new MiMascotaFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_my_pet);
    }

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==1){
            if (resultCode ==RESULT_OK){
                Toast.makeText(MainActivity.this,"Mensaje enviado",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
