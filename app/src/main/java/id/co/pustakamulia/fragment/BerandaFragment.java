package id.co.pustakamulia.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.balysv.materialripple.MaterialRippleLayout;

import id.co.pustakamulia.R;
import id.co.pustakamulia.activity.MainActivity;
import id.co.pustakamulia.activity.WebActivity;


public class BerandaFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_beranda, container, false);
        MaterialRippleLayout websiteRippleLayout = view.findViewById(R.id.websiteRippleLayout);
        websiteRippleLayout.setOnClickListener(view1 -> {
            ((MainActivity) getActivity()).viewPager.setCurrentItem(1);
        });

        MaterialRippleLayout mystoreRippleLayout = view.findViewById(R.id.mystoreRippleLayout);
        mystoreRippleLayout.setOnClickListener(view1 -> {
            ((MainActivity) getActivity()).viewPager.setCurrentItem(2);
        });

        MaterialRippleLayout siplahRippleLayout = view.findViewById(R.id.siplahRippleLayout);
        siplahRippleLayout.setOnClickListener(view1 -> {
            Intent mIntent = new Intent(getActivity().getApplicationContext(), WebActivity.class);
            mIntent.putExtra("title", "SIP Lah");
            mIntent.putExtra("link", "https://siplah.blibli.com/merchant-detail/SCSP-0025?itemPerPage=40&page=0&merchantId=SCSP-0025");
            mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getActivity().getApplicationContext().startActivity(mIntent);
            getActivity().finish();
        });

        MaterialRippleLayout jasacetakRippleLayout = view.findViewById(R.id.jasacetakRippleLayout);
        jasacetakRippleLayout.setOnClickListener(view1 -> {
            Intent mIntent = new Intent(getActivity().getApplicationContext(), WebActivity.class);
            mIntent.putExtra("title", "Jasa Cetak");
            mIntent.putExtra("link", "http://www.pustakamulia.co.id/berita/layanan/jasa-cetak");
            mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getActivity().getApplicationContext().startActivity(mIntent);
            getActivity().finish();
        });

        MaterialRippleLayout multimediaRippleLayout = view.findViewById(R.id.multimediaRippleLayout);
        multimediaRippleLayout.setOnClickListener(view1 -> {
            Intent mIntent = new Intent(getActivity().getApplicationContext(), WebActivity.class);
            mIntent.putExtra("title", "Multimedia Pembelajaran");
            mIntent.putExtra("link", "http://www.pustakamulia.co.id/berita/layanan/multimedia-pembelajaran");
            mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getActivity().getApplicationContext().startActivity(mIntent);
            getActivity().finish();
        });

        MaterialRippleLayout bukudigitalRippleLayout = view.findViewById(R.id.bukudigitalRippleLayout);
        bukudigitalRippleLayout.setOnClickListener(view1 -> {
            Intent mIntent = new Intent(getActivity().getApplicationContext(), WebActivity.class);
            mIntent.putExtra("title", "Penerbit Buku Digital");
            mIntent.putExtra("link", "http://www.pustakamulia.co.id/berita/layanan/penerbit-buku-digitalw");
            mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getActivity().getApplicationContext().startActivity(mIntent);
            getActivity().finish();
        });

        return view;
    }
}