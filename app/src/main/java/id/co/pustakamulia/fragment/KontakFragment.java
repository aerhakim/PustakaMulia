package id.co.pustakamulia.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.balysv.materialripple.MaterialRippleLayout;

import id.co.pustakamulia.R;
import id.co.pustakamulia.activity.WebActivity;

public class KontakFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_kontak, container, false);
        MaterialRippleLayout csphoneRippleLayout = view.findViewById(R.id.csphoneRippleLayout);
        csphoneRippleLayout.setOnClickListener(view1 -> {
            String toCall = "tel:+6281380002123";
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toCall)));
        });
        MaterialRippleLayout marphoneRippleLayout = view.findViewById(R.id.marphoneRippleLayout);
        marphoneRippleLayout.setOnClickListener(view1 -> {
            String toCall = "tel:+6281211297390";
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toCall)));
        });
        MaterialRippleLayout tcphoneRippleLayout = view.findViewById(R.id.tcphoneRippleLayout);
        tcphoneRippleLayout.setOnClickListener(view1 -> {
            String toCall = "tel:+6281234563609";
            startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toCall)));
        });
        MaterialRippleLayout csemailRippleLayout = view.findViewById(R.id.csemailRippleLayout);
        csemailRippleLayout.setOnClickListener(view1 -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","cs.pustakamulia@gmail.com", null));
            startActivity(Intent.createChooser(emailIntent, "Kirim email..."));
        });
        MaterialRippleLayout maremailRippleLayout = view.findViewById(R.id.maremailRippleLayout);
        maremailRippleLayout.setOnClickListener(view1 -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","novisetiadi2000@gmail.com", null));
            startActivity(Intent.createChooser(emailIntent, "Kirim email..."));
        });
        MaterialRippleLayout tcemailRippleLayout = view.findViewById(R.id.tcemailRippleLayout);
        tcemailRippleLayout.setOnClickListener(view1 -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","adm.pustakamulia@gmail.com", null));
            startActivity(Intent.createChooser(emailIntent, "Kirim email..."));
        });
        return view;
    }
}