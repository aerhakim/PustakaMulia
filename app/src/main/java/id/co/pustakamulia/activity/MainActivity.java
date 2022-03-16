package id.co.pustakamulia.activity;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import dev.shreyaspatil.MaterialDialog.MaterialDialog;
import dev.shreyaspatil.MaterialDialog.model.TextAlignment;
import id.co.pustakamulia.R;
import id.co.pustakamulia.fragment.BerandaFragment;
import id.co.pustakamulia.fragment.KontakFragment;
import id.co.pustakamulia.fragment.MyStoreFragment;
import id.co.pustakamulia.fragment.WebsiteFragment;

public class MainActivity extends AppCompatActivity {
    public BottomNavigationView navigation;
    public ViewPager viewPager;
    MenuItem prevMenuItem;
    int pager_number = 4;
    View view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(android.R.id.content);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(pager_number);
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_beranda:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_website:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_store:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_kontak:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        cekKoneksi();
    }

    @Override
    public void onBackPressed() {
        if(WebsiteFragment.canGoBack()){
            WebsiteFragment.goBack();
        } else if(MyStoreFragment.canGoBack()){
            MyStoreFragment.goBack();
        } else{
            final MaterialDialog produkDialog = new MaterialDialog.Builder(MainActivity.this)
                    .setTitle("Keluar Dari Aplikasi?")
                    .setMessage("Apakah anda ingin keluar dari aplikasi?", TextAlignment.START)
                    .setCancelable(false)
                    .setPositiveButton("Ya", new MaterialDialog.OnClickListener() {
                        @Override
                        public void onClick(dev.shreyaspatil.MaterialDialog.interfaces.DialogInterface dialogInterface, int which) {
                            finish();
                            dialogInterface.dismiss();
                        }
                    })
                    .setNegativeButton("Batal", new MaterialDialog.OnClickListener() {
                        @Override
                        public void onClick(dev.shreyaspatil.MaterialDialog.interfaces.DialogInterface dialogInterface, int which) {
                            dialogInterface.dismiss();
                        }
                    })
                    .build();
            produkDialog.show();
        }

    }


    public void cekKoneksi() {
        if (isNetworkAvailable()) {
            //Keknya ga ush di isi, dibiarin aja
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Tidak ada Koneksi Internet!");
            builder.setMessage("Silahkan Periksa Koneksi Internet Anda dan Coba Kembali!");
            builder.setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
//                    if (Build.VERSION.SDK_INT >= 11) {
//                        recreate();
//                    }else{
                    Intent j = getIntent();
                    j.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    finish();
                    startActivity(j);
//                    }
                }
            });

            builder.setPositiveButton("Connect", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
            Toast.makeText(this, "Koneksi Internet Tidak Ada", Toast.LENGTH_SHORT).show();

        }
    }


    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();

    }


    public class MyAdapter extends FragmentPagerAdapter {

        MyAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new BerandaFragment();
                case 1:
                    return new WebsiteFragment();
                case 2:
                    return new MyStoreFragment();
                case 3:
                    return new KontakFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return pager_number;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}
