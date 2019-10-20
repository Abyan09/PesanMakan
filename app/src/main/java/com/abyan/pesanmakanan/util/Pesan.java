package com.abyan.pesanmakanan.util;

import android.widget.Toast;

public class Pesan {
    public static final int TEH =0;
    public static final int JERUK =1;
    public static final int MILO =2;

    public static final int PECEL =0;
    public static final int GEPREK =1;
    public static final int NASGOR =2;

    private int makanan;
    private int minuman;
    private int jumlah1;
    private int jumlah2;
    private int meja;
    private int total;

    public Pesan(int makanan, int minuman, int jumlah1, int jumlah2, int meja){
        this.makanan = makanan;
        this.minuman = minuman;
        this.jumlah1 = jumlah1;
        this.jumlah2 = jumlah2;
        this.meja = meja;
        this.total = calculate1() + calculate2();
    }

    public int getTotal(){
        return this.total;
    }

    private int calculate1() {
        switch (makanan) {
            case 0:
                return (jumlah1 * 8000);
            case 1:
                return (jumlah1 * 10000);
            case 2:
                return (jumlah1 * 9000);
            default:
                return 0;
        }
    }

    private int calculate2(){
        switch (minuman) {
            case 0:
                return (jumlah2 * 2000);
            case 1:
                return (jumlah2 * 3000);
            case 2:
                return (jumlah2 * 5000);
            default:return 0;
        }
    }

}
