package me.looorielovbb.boom.ui.home.mine;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.looorielovbb.boom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {


    public MineFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new MineFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }
}
