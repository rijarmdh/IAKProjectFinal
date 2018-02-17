package com.example.riza.projekiak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class burgerActivity extends AppCompatActivity {

    int burgerSmall= 1;
    int burgerMedium= 1;
    int burgerBig= 1;

    boolean checkBurgerSmall = false;
    boolean checkBurgerMedium = false;
    boolean checkBurgerBig = false;

    int total_pesanan_allChecked;

    int hargaBurgerSmall = 25000;
    int hargaBurgerMedium = 30000;
    int hargaBurgerBig = 40000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger);

    }

    public void tambahBurgerSmall(View view) {
        burgerSmall++;

        tampilBurgerSmall(burgerSmall);
        displayHarga();
    }

    private void tampilBurgerSmall(int burgerSmall) {
        TextView tampilBurgerSmall = (TextView)findViewById(R.id.jmlTampil);
        tampilBurgerSmall.setText(valueOf(burgerSmall));

    }

    public void kurangBurgerSmall(View view) {
        if(burgerSmall>1){
            burgerSmall--;
        }

        tampilBurgerSmall(burgerSmall);
        displayHarga();
    }

    public void tambahBurgerMedium(View view) {
        burgerMedium++;

        tampilBurgerMedium(burgerMedium);
        displayHarga();
    }

    public void kurangBurgerMedium(View view) {

        if(burgerMedium>1){
            burgerMedium--;
        }
        tampilBurgerMedium(burgerMedium);
        displayHarga();
    }

    private void tampilBurgerMedium(int burgerMedium) {

        TextView tampilBurgerMedium = (TextView)findViewById(R.id.jmlTampilMedium);
        tampilBurgerMedium.setText(valueOf(burgerMedium));

    }

    public void tambahBurgerBig(View view) {
        burgerBig++;

        tampilBurgerBig(burgerBig);
        displayHarga();
    }

    public void kurangBurgerBig(View view) {
        if(burgerBig>1){
            burgerBig--;
        }

        tampilBurgerBig(burgerBig);

        displayHarga();
    }

    private void tampilBurgerBig(int burgerBig) {
        TextView tampilBurgerBig = (TextView)findViewById(R.id.jmlTampilBig);
        tampilBurgerBig.setText(valueOf(burgerBig));


    }

    public void pesanBurger(View view) {
        EditText namaPemesanBurger = (EditText)findViewById(R.id.namaPemesanBurger);
        EditText emailPemesanBurger = (EditText)findViewById(R.id.email);
        EditText noTelpPemesanBurger = (EditText)findViewById(R.id.noTelp);
        EditText keteranganTambahan = (EditText)findViewById(R.id.ketTambahan);

        String namaCustBurger = namaPemesanBurger.getText().toString().trim();
        String emailCustBurger = emailPemesanBurger.getText().toString().trim();
        String telpCustBurger = noTelpPemesanBurger.getText().toString().trim();
        String ketCustBurger = keteranganTambahan.getText().toString().trim();


        Bundle bundle = new Bundle();

        bundle.putString("total_bayar", String.valueOf(total_pesanan_allChecked) );
        bundle.putString("nama", namaCustBurger);
        bundle.putString("email", emailCustBurger);
        bundle.putString("telpon", telpCustBurger);
        bundle.putString("keterangan", ketCustBurger);
        Intent intent = new Intent(burgerActivity.this, detailPesananBurgerActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void isChecked(View view) {
        boolean hasChecked = ((CheckBox)view).isChecked();

        switch (view.getId()){
            case R.id.cb_burgerSmall:
                if(hasChecked){
                    checkBurgerSmall = true;

                    displayHarga();
                }else{
                    checkBurgerSmall = false;
                    displayHarga();
                }
                break;
            case R.id.cb_burgerMedium:
                if(hasChecked){
                    checkBurgerMedium = true;

                    displayHarga();
                }else{
                    checkBurgerMedium = false;
                    displayHarga();
                }
                break;
            case R.id.cb_burgerBig:
                if(hasChecked){
                    checkBurgerBig = true;

                    displayHarga();
                }else{
                    checkBurgerBig = false;

                    displayHarga();
                }
                break;
            default:
                break;
        }
    }

    public void displayHarga(){
        if(checkBurgerSmall && checkBurgerMedium && checkBurgerBig){
             total_pesanan_allChecked =    (hargaBurgerSmall * burgerSmall) + (hargaBurgerMedium * burgerMedium) + (hargaBurgerBig * burgerBig);
             TextView harga_Total = (TextView)findViewById(R.id.hargaTotal);
             harga_Total.setText(valueOf(total_pesanan_allChecked));
        }
        else if(checkBurgerSmall && checkBurgerMedium){
            total_pesanan_allChecked =    (hargaBurgerSmall * burgerSmall) + (hargaBurgerMedium * burgerMedium);
            TextView harga_Total = (TextView)findViewById(R.id.hargaTotal);
            harga_Total.setText(valueOf(total_pesanan_allChecked));
        }

        else if(checkBurgerSmall && checkBurgerBig){
            total_pesanan_allChecked =    (hargaBurgerSmall * burgerSmall) + (hargaBurgerBig * burgerBig);
            TextView harga_Total = (TextView)findViewById(R.id.hargaTotal);
            harga_Total.setText(valueOf(total_pesanan_allChecked));
        }

        else if(checkBurgerMedium && checkBurgerBig){
            total_pesanan_allChecked =    (hargaBurgerBig * burgerBig) + (hargaBurgerMedium * burgerMedium);
            TextView harga_Total = (TextView)findViewById(R.id.hargaTotal);
            harga_Total.setText(valueOf(total_pesanan_allChecked));
        }

        else if (checkBurgerSmall){
            total_pesanan_allChecked =    (hargaBurgerSmall * burgerSmall);
            TextView harga_Total = (TextView)findViewById(R.id.hargaTotal);
            harga_Total.setText(valueOf(total_pesanan_allChecked));
        }

        else if (checkBurgerMedium){
            total_pesanan_allChecked =    (hargaBurgerMedium * burgerMedium);
            TextView harga_Total = (TextView)findViewById(R.id.hargaTotal);
            harga_Total.setText(valueOf(total_pesanan_allChecked));
        }

        else if (checkBurgerBig){
            total_pesanan_allChecked =    (hargaBurgerBig * burgerBig);
            TextView harga_Total = (TextView)findViewById(R.id.hargaTotal);
            harga_Total.setText(valueOf(total_pesanan_allChecked));
        }

        else{
            TextView harga_Total = (TextView)findViewById(R.id.hargaTotal);
            harga_Total.setText(valueOf("Belum Ada Pesanan !"));
        }
    }
}

