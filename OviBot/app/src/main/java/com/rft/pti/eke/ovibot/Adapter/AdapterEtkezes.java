package com.rft.pti.eke.ovibot.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rft.pti.eke.ovibot.Model.JsonModellEtkezes;
import com.rft.pti.eke.ovibot.R;

import java.util.List;

/**
 * Created by lazarferenc on 2016.12.09..
 */

public class AdapterEtkezes extends ArrayAdapter<JsonModellEtkezes> {

    Context context;
    int layoutResourceId;
    private List<JsonModellEtkezes> datas;

    public AdapterEtkezes(Context context, int layoutResourceId, List<JsonModellEtkezes> list) {
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
            holder.txtDatum = (TextView) row.findViewById(R.id.txtDatum);
            holder.txtReggeli = (TextView) row.findViewById(R.id.txtReggeli);
            holder.txtEbed = (TextView) row.findViewById(R.id.txtEbed);
            holder.txtUzsonna = (TextView) row.findViewById(R.id.txtUzsonna);



            row.setTag(holder);
        } else {
            holder = (ModellHolder) row.getTag();
        }

        JsonModellEtkezes modell = datas.get(position);
        holder.txtDatum.setText(modell.getDatum());
        holder.txtReggeli.setText(modell.getReggeli());
        holder.txtEbed.setText(modell.getEbed());
        holder.txtUzsonna.setText(modell.getUzsonna());


        return row;
    }

    static class ModellHolder {
        TextView txtDatum;
        TextView txtReggeli;
        TextView txtEbed;
        TextView txtUzsonna;


    }
}
