package com.example.mygame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
    int vitricauhoi = 1;
    ArrayList<TextView> arrtxvcautraloi=new ArrayList<>();
    String traloi;
    TextView txvCauHoi, txvCauTL1, txvCauTL2, txvCauTL3, txvCauTL4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        anhxa();
        init();

        setUp();
        setCick();
    }

    public void init() {
        arrayTienThuong = new ArrayList<>();
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

        tienThuongAdapter = new TienThuongAdapter(this, 0, arrayTienThuong);
        cauHoi = new CauHoi();



    }

    public void anhxa() {
        lvTienThuong = findViewById(R.id.lsvTienThuong);
        txvCauHoi = findViewById(R.id.txvCauHoi);
        txvCauTL1=findViewById(R.id.txvCauTL1);
        txvCauTL2=findViewById(R.id.txvCauTL2);
        txvCauTL3=findViewById(R.id.txvCauTL3);
        txvCauTL4=findViewById(R.id.txvCauTL4);

        arrtxvcautraloi.add(txvCauTL1);
        arrtxvcautraloi.add(txvCauTL2);
        arrtxvcautraloi.add(txvCauTL3);
        arrtxvcautraloi.add(txvCauTL4);
    }

    public void setUp() {
        lvTienThuong.setAdapter(tienThuongAdapter);
        setCauHoi();
        hienCauHoi();
    }

    public void setCick() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kiemTra((TextView) v);
            }

        };
        for (TextView t : arrtxvcautraloi) {
            t.setOnClickListener(listener);
        }

    }

    public void setCauHoi() {
        cauHoi = new CauHoi();
        cauHoi.setNoiDung("1+1=...");
        cauHoi.setDapAnDung("2");
        ArrayList<String> arrDapansai = new ArrayList<>();
        arrDapansai.add("3");
        arrDapansai.add("5");
        arrDapansai.add("0");
        cauHoi.setArrDapAnSai(arrDapansai);
    }

    public void hienCauHoi() {
        txvCauHoi.setText(cauHoi.getNoiDung());
        ArrayList<String> arrCauTraLoi = new ArrayList<>(cauHoi.getArrDapAnSai());
        arrCauTraLoi.add(cauHoi.getDapAnDung());
        ArrayList<Integer> listint = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            listint.add(i);

        }
        int n = listint.size();
        Random r = new Random();
        ArrayList<String> traloi = new ArrayList<>();
        while (n > 0) {
            int vt = listint.remove(r.nextInt(n));//random ngau nhien tu 0-3
            String a = arrCauTraLoi.get(vt);//lay gia tri ngau nhien trong arrCauTraLoi
            traloi.add(a);
            n--;
        }

        for (int i = 0; i < arrtxvcautraloi.size(); i++) {
           // arrtxvcautraloi.get(i).setBackgroundResource(R.drawable.btn_tl);
            arrtxvcautraloi.get(i).setText(traloi.get(i));
        }
        tienThuongAdapter.setViTriCauHoi(vitricauhoi);
    }

    public void kiemTra(TextView txv) {
        traloi = txv.getText().toString();
        txv.setBackgroundResource(R.drawable.bg_btn_caudachon);
        new CountDownTimer(2000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                for (TextView t : arrtxvcautraloi) {
                    String tl = t.getText().toString();
                    if (tl.equals(cauHoi.getDapAnDung())) {
                        doimau(t);
                     //   t.setBackgroundResource(R.drawable.bg_btn_caudung);
                        break;
                    }
                }
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        if (traloi.equals(cauHoi.getDapAnDung())) {
                            vitricauhoi++;
                            if (vitricauhoi >= 15) {
                                vitricauhoi = 15;
                            }
                            hienCauHoi();
                        } else {
                            Toast.makeText(Main2Activity.this, "Thua roi", Toast.LENGTH_SHORT).show();
                        }
                    }
                }.start();
            }
        }.start();


    }
    public void doimau(final TextView button) {


        CountDownTimer t1=  new CountDownTimer(500, 500) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                button.setBackgroundResource(R.drawable.bg_btn_caudung);
                new CountDownTimer(300, 300) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        button.setBackgroundResource(R.drawable.btn_tl);
                        new CountDownTimer(300, 300) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                button.setBackgroundResource(R.drawable.bg_btn_caudung);
                                new CountDownTimer(300, 300) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {

                                    }

                                    @Override
                                    public void onFinish() {
                                        button.setBackgroundResource(R.drawable.btn_tl);
                                        new CountDownTimer(300, 300) {
                                            @Override
                                            public void onTick(long millisUntilFinished) {

                                            }

                                            @Override
                                            public void onFinish() {
                                                button.setBackgroundResource(R.drawable.bg_btn_caudung);
                                            }
                                        }.start();
                                    }
                                }.start();
                            }
                        }.start();
                    }
                }.start();
            }
        }.start();

    }

}
