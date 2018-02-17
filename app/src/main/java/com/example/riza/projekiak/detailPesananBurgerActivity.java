package com.example.riza.projekiak;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class detailPesananBurgerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pesanan_burger);

        TextView total = (TextView)findViewById(R.id.text0);
        TextView namaPemesan = (TextView)findViewById(R.id.text1);
        TextView emailPemesan = (TextView)findViewById(R.id.text2);
        TextView telponPemesan = (TextView)findViewById(R.id.text3);
        TextView KeteranganPemesan = (TextView)findViewById(R.id.text4);

        if(getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();

            total.setText(bundle.getString("total_bayar"));
            namaPemesan.setText(bundle.getString("nama"));
            emailPemesan.setText(bundle.getString("email"));
            telponPemesan.setText(bundle.getString("telpon"));
            KeteranganPemesan.setText(bundle.getString("keterangan"));
        }
        else{
            namaPemesan.setText(String.valueOf("Tidak Ada Nama"));
            emailPemesan.setText(String.valueOf("Tidak Ada Email"));
            telponPemesan.setText(String.valueOf("Tidak Ada Telepon"));
            KeteranganPemesan.setText(String.valueOf("Tidak Ada Keterangan"));
        }
    }


}
