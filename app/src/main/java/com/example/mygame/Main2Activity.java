package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mygame.adapter.TienThuongAdapter;
import com.example.mygame.object.CauHoi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {
ListView lvTienThuong;
TienThuongAdapter tienThuongAdapter;
ArrayList<String> arrayTienThuong;
CauHoi cauHoi;
int vitricauhoi=1;
TextView txvCauHoi,txvCauTL1,txvCauTL2,txvCauTL3,txvCauTL4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        anhxa();
        setUp();
        setCick();
    }
    public void init(){
        arrayTienThuong=new ArrayList<>();
        arrayTienThuong.add("1.000.000");
        arrayTienThuong.add("500.000");
        arrayTienThuong.add("250.000");
        arrayTienThuong.add("125.000");
        arrayTienThuong.add("64.000");
        arrayTienThuong.add("32.000");
        arrayTienThuong.add("16.000");
        arrayTienThuong.add("8.000");
        arrayTienThuong.add("4.000");
        arrayTienThuong.add("2.000");
        arrayTienThuong.add("1.000");
        arrayTienThuong.add("500");
        arrayTienThuong.add("300");
        arrayTienThuong.add("200");
        arrayTienThuong.add("100");

        tienThuongAdapter = new TienThuongAdapter(this,0,arrayTienThuong);
        cauHoi=new CauHoi();


    }
    public void anhxa(){
        lvTienThuong= findViewById(R.id.lsvTienThuong);
        txvCauHoi=findViewById(R.id.txvCauHoi);
        txvCauTL1=findViewById(R.id.txvCauTL1);
        txvCauTL2=findViewById(R.id.txvCauTL2);
        txvCauTL3=findViewById(R.id.txvCauTL3);
        txvCauTL4=findViewById(R.id.txvCauTL4);
    }
    public void setUp(){
        lvTienThuong.setAdapter(tienThuongAdapter);
        setCauHoi();
        hienCauHoi();
    }
    public void setCick(){
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kiemTra(   ((TextView)v).getText().toString());
            }

        };
        txvCauTL1.setOnClickListener(listener);
        txvCauTL2.setOnClickListener(listener);
        txvCauTL3.setOnClickListener(listener);
        txvCauTL4.setOnClickListener(listener);

    }
    public void setCauHoi(){
        cauHoi=new CauHoi();
        cauHoi.setNoiDung("1+1=...");
        cauHoi.setDapAnDung("2");
        ArrayList<String> arrDapansai=new ArrayList<>();
        arrDapansai.add("3");
        arrDapansai.add("5");
        arrDapansai.add("0");
        cauHoi.setArrDapAnSai(arrDapansai);
    }
    public void hienCauHoi(){
        txvCauHoi.setText(cauHoi.getNoiDung());
        ArrayList<String> arrCauTraLoi=new ArrayList<>(cauHoi.getArrDapAnSai());
        arrCauTraLoi.add(cauHoi.getDapAnDung());
        ArrayList<Integer> listint=new ArrayList<>();
        for (int i=0;i<4;i++)
        {
            listint.add(new Integer(i));

        }
        int n=listint.size();
        Random r=new Random();
        ArrayList <String> traloi=new ArrayList<>();
        while (n > 0) {
            int vt=listint.remove(r.nextInt(n));//random ngau nhien tu 0-3
            String a=arrCauTraLoi.get(vt);//lay gia tri ngau nhien trong arrCauTraLoi
            traloi.add(a);
            n--;
        }
        txvCauTL1.setText(traloi.get(0));
        txvCauTL2.setText(traloi.get(1));
        txvCauTL3.setText(traloi.get(2));
        txvCauTL4.setText(traloi.get(3));
        tienThuongAdapter.setViTriCauHoi(vitricauhoi);
    }
    public  void kiemTra(String traloi){
        if(traloi.equals(cauHoi.getDapAnDung())){
            vitricauhoi++;
            if(vitricauhoi>=15){
                vitricauhoi=15;
            }
            hienCauHoi();
        } else
        {
            Toast.makeText(this, "Thua roi", Toast.LENGTH_SHORT).show();
        }

    }

}
