package es.unicabra.factions.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import es.unicabra.factions.R;
import es.unicabra.factions.ToolResultsActivity;
import es.unicabra.factions.controllers.RollSimulatorController;

/**
 * <b>RollSimulatorFragment</b>
 * This fragment contains all code relative to the functionality
 * of Dice´s rolls calculator. This calculator give as result
 * the average of an imaginary number of rolls and all the results (stored in a matrix).
 *
 * @author David Bermejo Simón.
 */
public class RollSimulatorFragment extends Fragment {

    private RollSimulatorViewModel rollSimulatorViewModel;
    private RollSimulatorController controller;
//    private RollSimulatorController controller;

    //with this objects we access the GUI to show the user the calculated parameters.
    private Button rollButton;
    private Button resultsButton;
    private EditText editTextRolls;
    private EditText editTextDices;
    private EditText attackFixedValue;
    private EditText defenseFixedValue;
    private EditText defenseVariableValue;
    private EditText attackVariableValue;
    private TextView textAverage;
    private TextView textMode;
    private TextView textMaxMin;
    private TextView textMedian;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {
        rollSimulatorViewModel =
                ViewModelProviders.of(this).get(RollSimulatorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_roll_simulator, container, false);
        instantiateGUIObjects(root);
        addListenerToRollButton();
        addListenerToResultsButton();
        return root;
    }

    /**
     * In this method we engage our components in GUI to the objects of this class.
     *
     * @param root : the actual fragment View.
     */
    private void instantiateGUIObjects(View root) {
        editTextRolls = root.findViewById(R.id.editTextRolls);
        editTextDices = root.findViewById(R.id.editTextDices);
        attackFixedValue = root.findViewById(R.id.attackFixedValue);
        defenseFixedValue = root.findViewById(R.id.defenseFixedValue);
        attackVariableValue = root.findViewById(R.id.attackVariableValue);
        defenseVariableValue = root.findViewById(R.id.defenseVariableValue);

        textAverage = root.findViewById(R.id.textAverage);
        textMode = root.findViewById(R.id.textMode);
        textMaxMin = root.findViewById(R.id.textMin);
        textMedian = root.findViewById(R.id.textMedian);

        rollButton = root.findViewById(R.id.roll_button);
        resultsButton = root.findViewById(R.id.resultsButton);
        resultsButton.setEnabled(false);

    }

    /**
     * In this method is assigned a Listener to a roll button. In addition, will be
     * added the sequence of actions that will be trigger by the same action.
     */
    private void addListenerToRollButton() {
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int rolls = Integer.parseInt(String.valueOf(editTextRolls.getText()));
                    int dices = Integer.parseInt(String.valueOf(editTextDices.getText()));
                    //instantiate new controller
                    controller = new RollSimulatorController(rolls, dices);
                    //Fill the initial values to calculate from GUI
                    fillControllerInitialValues(controller);
                    //Calculate results with controller object.
                    controller.throwsRollsAction();
                    //add to GUI all the calculated results.
                    addGUIValues(controller);
                    resultsButton.setEnabled(true);
                } catch (Exception e) {
                    Toast.makeText(getContext(), "Introduce un número válido de tiradas",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    /**
     * In this method is assigned a Listener to a see results button. In addition, will be
     * added the instantiation
     */
    private void addListenerToResultsButton() {
        resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentResults = new Intent(getActivity(),ToolResultsActivity.class);
                intentResults.putExtra("Values", controller.getAllValues());
                startActivity(intentResults);
            }
        });

    }

    /**
     * This method assign to the initial values object of the controller with
     * the parameters introduced by the user.
     *
     * @param controller: controller responsible of calculate all the results to show.
     */
    private void fillControllerInitialValues(RollSimulatorController controller) {
        controller.getInitialValues().setAttackFixedValue
                (Integer.parseInt(String.valueOf(attackFixedValue.getText())));
        controller.getInitialValues().setAttackVariableValue
                (Integer.parseInt(String.valueOf(attackVariableValue.getText())));
        controller.getInitialValues().setDefenseFixedValue
                (Integer.parseInt(String.valueOf(defenseFixedValue.getText())));
        controller.getInitialValues().setDefenseVariableValue
                (Integer.parseInt(String.valueOf(defenseVariableValue.getText())));
        controller.getInitialValues().setDices
                (Integer.parseInt(String.valueOf(editTextDices.getText())));
    }

    /**
     * This method is responsible of shows the user all the calculated results.
     *
     * @param controller: controller responsible of calculate all the results to show.
     */
    private void addGUIValues(RollSimulatorController controller) {
        textAverage.setText(String.valueOf(controller.getCalculatedValues().getAverage()));
        textMode.setText(String.valueOf(controller.getCalculatedValues().getMode()));
        textMaxMin.setText(String.valueOf(controller.getCalculatedValues().getMax())
                +" / "+String.valueOf(controller.getCalculatedValues().getMin()));
        textMedian.setText(String.valueOf(controller.getCalculatedValues().getMin()));
    }

}