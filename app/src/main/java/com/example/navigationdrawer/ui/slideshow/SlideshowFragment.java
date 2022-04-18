package com.example.navigationdrawer.ui.slideshow;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.android.volley.RequestQueue;
import com.example.navigationdrawer.R;
import com.example.navigationdrawer.databinding.FragmentGalleryBinding;
import com.example.navigationdrawer.databinding.FragmentSlideshowBinding;
import com.example.navigationdrawer.ui.gallery.GalleryViewModel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private static RequestQueue requestQueue;
    private static Context context;

    private FragmentGalleryBinding binding;
    private static final String url = "http://192.168.1.113:8090/machines/byMarque";



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        BarChart barChart = root.findViewById(R.id.barchart);
        getData();
        BarDataSet barDataSet = new BarDataSet(barArraylist,"Cambo Tutorial");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
        //color bar data set
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //text color
        barDataSet.setValueTextColor(Color.WHITE);
        //settting text size
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(true);
//            this.view=root;
//        final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    ArrayList barArraylist;


    private void getData()
    {
        barArraylist = new ArrayList();
        barArraylist.add(new BarEntry(1,1));
        barArraylist.add(new BarEntry(2,2));



    }

}