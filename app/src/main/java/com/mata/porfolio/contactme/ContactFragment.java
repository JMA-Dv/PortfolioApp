package com.mata.porfolio.contactme;

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
public class ContactFragment extends Fragment {
    RecyclerView contactRecycler;
    ContactAdapter  adapter;
    List<ContactItem> data;

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contactRecycler = view.findViewById(R.id.rv_contact);

        data = new ArrayList<>();
        data.add(new ContactItem("Mata Avila",getString(R.string.lorem_text),R.drawable.mata));
        data.add(new ContactItem("Mata Avila",getString(R.string.lorem_text),R.drawable.mata));
        data.add(new ContactItem("Mata Avila",getString(R.string.lorem_text),R.drawable.mata));
        data.add(new ContactItem("Mata Avila",getString(R.string.lorem_text),R.drawable.mata));


        contactRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ContactAdapter(data);
        contactRecycler.setAdapter(adapter);
    }
}
