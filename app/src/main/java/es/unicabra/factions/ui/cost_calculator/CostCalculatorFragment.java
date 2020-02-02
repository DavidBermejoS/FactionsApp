package es.unicabra.factions.ui.cost_calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import es.unicabra.factions.R;

public class CostCalculatorFragment extends Fragment {

    private CostCalculatorViewModel costCalculatorViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        costCalculatorViewModel =
                ViewModelProviders.of(this).get(CostCalculatorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cost_calculator, container, false);
//put here some code to attach more elements
        return root;
    }
}