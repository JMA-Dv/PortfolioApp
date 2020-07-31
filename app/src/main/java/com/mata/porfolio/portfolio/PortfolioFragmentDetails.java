package com.mata.porfolio.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.mata.porfolio.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortfolioFragmentDetails extends BottomSheetDialogFragment {
    private ImageView imgProject;
    private TextView title;
    private TextView description;

    public PortfolioFragmentDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio_details, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgProject = view.findViewById(R.id.portfolio_details_img);
        title = view.findViewById(R.id.portfolio_details_title);
        description = view.findViewById(R.id.portfolio_details_content);

        Bundle bundle = getArguments();
        PortfolioItem items = (PortfolioItem) bundle.getSerializable("portfolioData");

        loadPortfolioData(items);
    }
    void loadPortfolioData(PortfolioItem items){
        Glide.with(getContext()).load(items.getImage()).into(imgProject);
    }
}
