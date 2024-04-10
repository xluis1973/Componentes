package com.softulp.componentes.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.componentes.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private Intent intent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        intent=new Intent(getContext(),ServicioMusical.class);
        binding.btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getContext().startService(intent);

            }
        });
        binding.btParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getContext().stopService(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}