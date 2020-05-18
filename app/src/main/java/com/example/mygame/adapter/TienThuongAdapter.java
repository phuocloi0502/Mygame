package com.example.mygame.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mygame.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TienThuongAdapter extends ArrayAdapter<String> {
    Context mct;
    ArrayList<String> arr;

    public TienThuongAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.mct = context;
        this.arr = new ArrayList<>(objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)mct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.layout_tienthuong,null);
        }
        if(arr.size()>0){
            int pos = 15 - position;
            TextView txvTienThuong = convertView.findViewById(R.id.txvTienThuong);
            if(pos%5==0){
                txvTienThuong.setTextColor(Color.parseColor("#FFFFFF"));
            }else{
                txvTienThuong.setTextColor(Color.parseColor("#FF9800"));
            }
            String khoangTrang;
            if(pos/10>0){
                khoangTrang = "    ";
            }else{
                khoangTrang = "      ";
            }

            String textHienThi = pos+khoangTrang+"$"+arr.get(position);
            txvTienThuong.setText(textHienThi);


        }
        return convertView;
    }
}
