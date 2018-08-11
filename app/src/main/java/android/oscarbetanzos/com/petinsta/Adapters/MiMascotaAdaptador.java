package android.oscarbetanzos.com.petinsta.Adapters;

import android.oscarbetanzos.com.petinsta.Mascota;
import android.oscarbetanzos.com.petinsta.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MiMascotaAdaptador extends RecyclerView.Adapter<MiMascotaAdaptador.MiMascotaViewHolder> {
    ArrayList<Mascota> MiMascota;

    public MiMascotaAdaptador(ArrayList<Mascota> miMascota) {
        MiMascota = miMascota;
    }

    @Override
    public MiMascotaAdaptador.MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mimascota,parent,false);
        return new MiMascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MiMascotaAdaptador.MiMascotaViewHolder miMascotaViewHolder, int position) {
        Mascota mascota = MiMascota.get(position);
        miMascotaViewHolder.tvRateMM.setText(mascota.getRate());
        miMascotaViewHolder.imgMascotaMM.setImageResource(mascota.getFoto());
    }

    @Override
    public int getItemCount() {
        return MiMascota.size();
    }

    public static class MiMascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMascotaMM;
        private TextView tvRateMM;

        public MiMascotaViewHolder(View itemView) {
            super(itemView);

            imgMascotaMM    = (ImageView) itemView.findViewById(R.id.imgMascotaMM);
            tvRateMM        = (TextView)  itemView.findViewById(R.id.tvRateMM);
        }
    }
}
