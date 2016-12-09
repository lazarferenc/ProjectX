package com.rft.pti.eke.ovibot.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rft.pti.eke.ovibot.Model.JsonModelKollegak;
import com.rft.pti.eke.ovibot.R;

import java.util.List;

/**
 * Created by lazarferenc on 2016.12.09..
 */

public class AdapterKollegak extends ArrayAdapter<JsonModelKollegak>{
    Context context;
    int layoutResourceId;
    private List<JsonModelKollegak> datas;

    public AdapterKollegak(Context context, int layoutResourceId, List<JsonModelKollegak> list) {
        super(context, layoutResourceId, list_kollegak);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        datas = list;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        View row = convertView;
        AdapterKollegak.ModellHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new AdapterKollegak.ModellHolder();
            holder.txtTeljesNev = (TextView) row.findViewById(R.id.txtTeljesNev);
            holder.txtIroda = (TextView) row.findViewById(R.id.txtIroda);
            holder.txtTelefon = (TextView) row.findViewById(R.id.txtTelefon);
            holder.txtEmail = (TextView) row.findViewById(R.id.txtEmail);



            row.setTag(holder);
        } else {
            holder = (AdapterKollegak.ModellHolder) row.getTag();
        }

        JsonModelKollegak modell = datas.get(position);
        holder.txtTeljesNev.setText(modell.getTeljesNev());
        holder.txtIroda.setText(modell.getIroda());
        holder.txtTelefon.setText(modell.getTelefon());
        holder.txtEmail.setText(modell.getEmail());


        return row;
    }

    static class ModellHolder {
        TextView txtTeljesNev;
        TextView txtIroda;
        TextView txtTelefon;
        TextView txtEmail;


    }
}
