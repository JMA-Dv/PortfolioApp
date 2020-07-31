package com.mata.porfolio.cv;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mata.porfolio.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CVFragment extends Fragment {

    RecyclerView recycler;
    CVAdapter adapter;
    List<CVItem> items;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.recyclerview_cv);

        items = new ArrayList<>();
        items.add(new CVItem("20 julio 2020",getString(R.string.lorem_text)));
        items.add(new CVItem("20 julio 2020",getString(R.string.lorem_text)));
        items.add(new CVItem("20 julio 2020",getString(R.string.lorem_text)));
        items.add(new CVItem("20 julio 2020",getString(R.string.lorem_text)));
        items.add(new CVItem("20 julio 2020",getString(R.string.lorem_text)));
        items.add(new CVItem("20 julio 2020",getString(R.string.lorem_text)));
        items.add(new CVItem("20 julio 2020",getString(R.string.lorem_text)));
        items.add(new CVItem("20 julio 2020",getString(R.string.lorem_text)));
        items.add(new CVItem("20 julio 2020",getString(R.string.lorem_text)));
        items.add(new CVItem("20 julio 2020",getString(R.string.lorem_text)));

        adapter = new CVAdapter(items);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(adapter);


    }

    public CVFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_c_v, container, false);
    }
}
