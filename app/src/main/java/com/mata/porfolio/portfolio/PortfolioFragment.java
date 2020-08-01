package com.mata.porfolio.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mata.porfolio.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortfolioFragment extends Fragment implements PortfolioCallback{
    List<PortfolioItem> data;
    RecyclerView rvPortfolio;
    PortfolioAdapter portfolioAdapter;

    public PortfolioFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPortfolio = view.findViewById(R.id.rv_porfolio);
        data = new ArrayList<>();
        data.add(new PortfolioItem(R.drawable.chambee_icon,"Chambee",getString(R.string.chambee_description)));
        data.add(new PortfolioItem(R.drawable.mandame_logo, "Mándame",getString(R.string.mandame_description)));
        data.add(new PortfolioItem());
        data.add(new PortfolioItem());
        data.add(new PortfolioItem());
        data.add(new PortfolioItem());
        data.add(new PortfolioItem());
        data.add(new PortfolioItem());
        data.add(new PortfolioItem());


        portfolioAdapter = new PortfolioAdapter(data,this);

        rvPortfolio.setLayoutManager(new GridLayoutManager(getActivity(),3));
        rvPortfolio.setAdapter(portfolioAdapter);

    }

    @Override
    public void onPortfolioItemView(int position) {
        PortfolioFragmentDetails portfolioFragmentDetails = new PortfolioFragmentDetails();

        Bundle bundle = new Bundle();
        bundle.putSerializable("portfolioData", data.get(position));
        portfolioFragmentDetails.setArguments(bundle);

        portfolioFragmentDetails.show(getActivity().getSupportFragmentManager(),"Tagme");




    }
}
