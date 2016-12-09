package com.rft.pti.eke.ovibot.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rft.pti.eke.ovibot.Model.JsonModellGyerekek;
import com.rft.pti.eke.ovibot.R;

import java.util.List;

/**
 * Created by lazarferenc on 2016.12.09..
 */

public class AdapterGyerekek extends ArrayAdapter<JsonModellGyerekek> {

    Context context;
    int layoutResourceId;
    private List<JsonModellGyerekek> datas;

    public AdapterGyerekek(Context context, int layoutResourceId, List<JsonModellGyerekek> list) {
        super(context, layoutResourceId, list);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        datas = list;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        View row = convertView;
        ModellHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ModellHolder();
            holder.txtTeljesNev = (TextView) row.findViewById(R.id.txtTeljesNev);
            holder.txtMagatartas = (TextView) row.findViewById(R.id.txtMagatartas);
            holder.txtHangulat = (TextView) row.findViewById(R.id.txtHangulat);
            holder.txtJelenlet = (TextView) row.findViewById(R.id.txtJelenlet);
            holder.txtDatum = (TextView) row.findViewById(R.id.txtDatum);


            row.setTag(holder);
        } else {
            holder = (ModellHolder) row.getTag();
        }

        JsonModellGyerekek modell = datas.get(position);

        /*JsonModellGyerekek-be levenni a kommentet a getteről és működik is*/

        holder.txtTeljesNev.setText(modell.getTeljesNev());
        holder.txtMagatartas.setText(modell.getMagatartas());
        holder.txtHangulat.setText(modell.getHangulat());
        holder.txtJelenlet.setText(modell.getJelenlet());
        holder.txtDatum.setText(modell.getDatum());

        return row;
    }

    static class ModellHolder {
        TextView txtTeljesNev;
        TextView txtMagatartas;
        TextView txtHangulat;
        TextView txtJelenlet;
        TextView txtDatum;

    }
}
