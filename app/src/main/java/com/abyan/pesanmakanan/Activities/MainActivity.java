package com.abyan.pesanmakanan.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.abyan.pesanmakanan.R;
import com.abyan.pesanmakanan.fragments.AboutFragment;
import com.abyan.pesanmakanan.fragments.LihatMenuFragment;
import com.abyan.pesanmakanan.fragments.MenuFragment;
import com.abyan.pesanmakanan.fragments.MenuMakananFragment;
import com.abyan.pesanmakanan.fragments.MenuMinumanFragment;
import com.abyan.pesanmakanan.fragments.MenuPesanFragment;
import com.abyan.pesanmakanan.fragments.ResultFragment;
import com.abyan.pesanmakanan.util.Pesan;

public class MainActivity extends AppCompatActivity implements
        MenuFragment.OnFragmentInteractionListener,
        MenuPesanFragment.OnFragmentInteractionListener,
        ResultFragment.OnFragmentInteractionListener ,LihatMenuFragment.OnFragmentInteractionListener {
    private AboutFragment aboutFragment;
    private MenuFragment menuFragment;
    private MenuPesanFragment menuPesanFragment;
    private ResultFragment resultFragment;
    private LihatMenuFragment lihatMenuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aboutFragment = AboutFragment.newInstance("Moch. Abyan An-nabhany");
        menuFragment = new MenuFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, menuFragment)
                .commit();
        menuPesanFragment = new MenuPesanFragment();
        resultFragment = new ResultFragment();
        lihatMenuFragment = new LihatMenuFragment();
    }


//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        Intent intent = new Intent(this, MenuFragment.class);
//        startActivity(intent);
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // TODO: Tambahkan penanganan menu di sini

        if (item.getItemId() == R.id.menu_about) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, aboutFragment)
                    .addToBackStack(null)
                    .commit();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMenuPesanFragmentsButtonClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, menuPesanFragment)
                .commit();
    }

    @Override
    public void onLihatMenuFragmentsButtonClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, lihatMenuFragment)
                .commit();
    }

    @Override
    public void onTryAgainButtonClicked(String tag) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, menuPesanFragment)
                .commit();
    }


    @Override
    public void onMenuMakananFragmentsButtonClicked() {
        Intent intent = new Intent(this, MenuMakananFragment.class);
        startActivity(intent);
    }

    @Override
    public void onMenuMinumanFragmentsButtonClicked() {
        Intent intent = new Intent(this, MenuMinumanFragment.class);
        startActivity(intent);
    }


    @Override
    public void onPesanButtonClicked(String nama, int makanan, int minuman, int jumlah1, int jumlah2, int meja) {
        Pesan pesan = new Pesan(makanan, minuman,jumlah1,jumlah2, meja);
        Toast.makeText(this, makanan+" "+minuman+" "+jumlah1+" "+jumlah2+" "+meja+" ", Toast.LENGTH_SHORT).show();

        resultFragment.setInformation("Pesanan Anda "+ nama +" Segera Diantar... RP."+pesan.getTotal()+" Pesan Meja "+meja+" ");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, resultFragment, "Pesan")
                .commit();
    }
}
