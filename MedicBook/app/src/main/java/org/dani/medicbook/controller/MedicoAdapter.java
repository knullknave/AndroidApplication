package org.dani.medicbook.controller;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.dani.medicbook.R;
import org.dani.medicbook.base.VisitasMedico;

import java.util.ArrayList;

public class MedicoAdapter extends BaseAdapter
{
    private Context context;
    private ArrayList<VisitasMedico> listado;
    private int idM;
    private LayoutInflater inflater;

    public MedicoAdapter(Activity context, ArrayList<VisitasMedico> listado, int idM) {
        this.context = context;
        this.idM = idM;
        this.listado = listado;
        inflater = LayoutInflater.from(context);
    }

    static class ViewHolder
    {
        ImageView foto;
        TextView nombreApellidos;
        TextView fechaVisita;
    }

    @Override
    public int getCount()
    {
        return listado.size();
    }

    @Override
    public Object getItem(int position)
    {
        return listado.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder holder = null;

        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.row_medic, null);

            holder = new ViewHolder();
            holder.foto = (ImageView) convertView.findViewById(R.id.image);
            holder.nombreApellidos = (TextView) convertView.findViewById(R.id.name);
            holder.fechaVisita = (TextView) convertView.findViewById(R.id.date);

            convertView.setTag(holder);
        }


        else {
            holder = (ViewHolder) convertView.getTag();
        }

        VisitasMedico visitas = listado.get(position);
        holder.foto.setImageBitmap(visitas.getFoto());
        holder.nombreApellidos.setText(visitas.getNombre());
        holder.fechaVisita.setText(visitas.getFecha().toString());

        return convertView;
    }
}
