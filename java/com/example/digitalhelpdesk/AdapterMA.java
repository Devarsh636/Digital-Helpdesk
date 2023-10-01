package com.example.digitalhelpdesk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterMA extends ArrayAdapter<ArrayListObject> {
    private final ArrayList<ArrayListObject> mLogo;

    public AdapterMA(Context context, ArrayList<ArrayListObject> logo) {
        super(context, 0, logo);
        this.mLogo = logo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_ma, parent, false);
        }

        //make an custom object reference
        ArrayListObject obj = getItem(position);

        ImageView imageView=convertView.findViewById(R.id.logo_image);
        imageView.setImageResource(obj.getImgId());

        TextView textView = convertView.findViewById(R.id.logo_name);
        textView.setText(obj.getString());

        return convertView;
    }
}