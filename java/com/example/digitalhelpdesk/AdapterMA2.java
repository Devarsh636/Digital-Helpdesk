package com.example.digitalhelpdesk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterMA2 extends ArrayAdapter {

    public AdapterMA2(Context context, ArrayList<ArrayListObject> arrayList) {
        super(context, 0, arrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_ma2, parent, false);
        }
        
        ArrayListObject obj = (ArrayListObject) getItem(position);

        //For string value find by text id
        TextView textView = (TextView) convertView.findViewById(R.id.text);
        //setText value
        textView.setText(obj.getString());

        //Find image view
        ImageView imageView = convertView.findViewById(R.id.image);
        //put image in image text
        imageView.setImageResource(obj.getImgId());

        return convertView;
    }
}