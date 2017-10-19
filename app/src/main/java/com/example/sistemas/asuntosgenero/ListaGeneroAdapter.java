package com.example.sistemas.asuntosgenero;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.sistemas.asuntosgenero.models.Genero;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Asus on 17/10/2017.
 */

public class ListaGeneroAdapter extends RecyclerView.Adapter<ListaGeneroAdapter.ViewHolder> {

    private ArrayList<Genero> dataset;
    private Context context;

    public ListaGeneroAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_genero, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Genero p = dataset.get(position);
        holder.campo1.setText(context.getResources().getString(R.string.anio) +": "+ p.getAO());
        holder.campo2.setText(context.getResources().getString(R.string.comuna) +": "+ p.getComuna());
        holder.campo3.setText(context.getResources().getString(R.string.month) +": "+ p.getMes());
        holder.campo4.setText(context.getResources().getString(R.string.municipality )+": "+ p.getMunicipio());
        holder.campo5.setText(context.getResources().getString(R.string.identitySexual) +": "+ p.getIdentidadDeGNeroUOrientaciNSexual());
        holder.campo6.setText(context.getResources().getString(R.string.relationAgressor) +": "+ p.getRelaciNConElPresuntoAgresor());
        holder.campo7.setText(context.getResources().getString(R.string.typeViolence) +": "+ p.getTipoDeViolencia());
        holder.campo8.setText(context.getResources().getString(R.string.socialSecurity) +": "+ p.getTipoDeSeguridadSocial());
        holder.campo9.setText(context.getResources().getString(R.string.age) +": "+ p.getEdad());

        ArrayList<String> urlsImg = new ArrayList<String>(Arrays.asList(
                "http://cuadrocomparativo.org/wp-content/uploads/2016/03/violencia_de_genero.jpg",
                "http://nutricionybuenasalud.com/wp-content/uploads/2017/02/violencia-de-genero-f%C3%ADsica.jpg",
                "http://www.emisordigital.cl/media/users/1/80024/images/public/6539/images.jpg?v=1429665344821",
                "https://us.123rf.com/450wm/pirateferry/pirateferry1508/pirateferry150800026/43156313-s-mbolo-del-movimiento-feminista.jpg?ver=6",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqD-y_DIVQa69tEL24ej3RPQFV9NVxvjAaO4OfYR_CfLT7wVS4JA",
                "https://extension.uned.es/archivos_publicos/webex_actividades/13654/fotofinal_med.gif",
                "https://s-media-cache-ak0.pinimg.com/originals/7f/a9/ae/7fa9ae70469482a13ceae3a5502a7218.jpg",
                "https://images.clarin.com/2016/05/20/rkeNdwnFNl_930x525.jpg",
                "http://www.diariojunin.com/fotos/2017/06/18_violencia_de_genero1.jpg",
                "https://media.elpatagonico.com/adjuntos/193/imagenes/011/109/0011109802.jpg",
                "https://historiadoreshistericos.files.wordpress.com/2011/05/violencia-de-gc3a9nero-1.jpg"

        ));

        Glide.with(context)
                .load(urlsImg.get((int) (Math.random() * 10) + 1))
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoImageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<Genero> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoImageView;
        private TextView campo1;
        private TextView campo2;
        private TextView campo3;
        private TextView campo4;
        private TextView campo5;
        private TextView campo6;
        private TextView campo7;
        private TextView campo8;
        private TextView campo9;

        public ViewHolder(View itemView) {
            super(itemView);

            campo1 = (TextView) itemView.findViewById(R.id.campo1);
            campo2 = (TextView) itemView.findViewById(R.id.campo2);
            campo3 = (TextView) itemView.findViewById(R.id.campo3);
            campo4 = (TextView) itemView.findViewById(R.id.campo4);
            campo5 = (TextView) itemView.findViewById(R.id.campo5);
            campo6 = (TextView) itemView.findViewById(R.id.campo6);
            campo7 = (TextView) itemView.findViewById(R.id.campo7);
            campo8 = (TextView) itemView.findViewById(R.id.campo8);
            campo9 = (TextView) itemView.findViewById(R.id.campo9);

            fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
        }
    }
}
