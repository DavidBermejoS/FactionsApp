package es.unicabra.factions.ui.cost_calculator;

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
import es.unicabra.factions.controllers.CostCalculatorController;
import es.unicabra.factions.pojos.values.CostCalculatorResults;
import es.unicabra.factions.pojos.values.CostCalculatorValues;
import es.unicabra.factions.pojos.values.HabilityCostValues;

/**
 * <b>Class CostCalculatorFragment</b>
 * This class contain all the connection to the Graphical Elements.
 * Here is filled the initialValues object and it will send
 * the resultValues to the graphical interface.
 * @author David Bermejo Simón
 */
public class CostCalculatorFragment extends Fragment {

    private CostCalculatorViewModel costCalculatorViewModel;

    private EditText energyEditText;
    private EditText limitationEditText;
    private EditText psEditText;
    private EditText pmEditText;
    private EditText paEditText;
    private EditText[] attackEditTexts = new EditText[2];
    private EditText[] defenseEditTexts = new EditText[2];
    private EditText[] hability1EditTexts = new EditText[5];
    private EditText[] hability2EditTexts = new EditText[5];
    private EditText[] hability3EditTexts = new EditText[5];
    private EditText[] passiveEditTexts = new EditText[2];

    private TextView energyResults;
    private TextView limitationResults;
    private TextView psResults;
    private TextView pmResults;
    private TextView paResults;
    private TextView attackResults;
    private TextView defenseResults;
    private TextView hability1Results;
    private TextView habiliy2Results;
    private TextView hability3Results;
    private TextView passiveResults;

    private Button resultsButton;
    private CostCalculatorValues initialValues;
    private CostCalculatorResults resultValues;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        costCalculatorViewModel =
                ViewModelProviders.of(this).get(CostCalculatorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cost_calculator, container, false);
        attachGraphicElements(root);
        attachButtonAndListener(root);
        return root;
    }

    private void attachButtonAndListener(View root) {
        this.resultsButton = root.findViewById(R.id.resultsButton);
        this.resultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    fillInitialValues();
                    resultValues = CostCalculatorController.getResults(initialValues);
                    printResults();
                }catch(NullPointerException ex){
                    Toast.makeText(getContext(),"¡Error! Debes introducir todos los valores",Toast.LENGTH_LONG);
                }
            }
        });
    }

    /**
     * Fills the initialValues object parameters with the parameters inserted by the user.
     *
     * @return values = CostCalculatorValues instance with all his parameters filled.
     */
    private void fillInitialValues() {
        try {
            initialValues = new CostCalculatorValues();
            initialValues.setEnergy(Integer.parseInt(energyEditText.getText().toString()));
            initialValues.setLimitation(Integer.parseInt(limitationEditText.getText().toString()));
            initialValues.setPs(Integer.parseInt(psEditText.getText().toString()));
            int[] attacksValues = {
                    Integer.parseInt(attackEditTexts[0].getText().toString()),
                    Integer.parseInt(attackEditTexts[1].getText().toString())
            };
            initialValues.setAttack(attacksValues);
            int[] defenseValues = {
                    Integer.parseInt(defenseEditTexts[0].getText().toString()),
                    Integer.parseInt(defenseEditTexts[1].getText().toString())
            };
            initialValues.setDefense(defenseValues);
            initialValues.setPm(Integer.parseInt(pmEditText.getText().toString()));
            initialValues.setPa(Integer.parseInt(paEditText.getText().toString()));
            HabilityCostValues h1 = new HabilityCostValues(
                    Integer.parseInt(hability1EditTexts[0].getText().toString()),
                    Integer.parseInt(hability1EditTexts[1].getText().toString()),
                    Integer.parseInt(hability1EditTexts[2].getText().toString()),
                    Integer.parseInt(hability1EditTexts[3].getText().toString()),
                    Integer.parseInt(hability1EditTexts[4].getText().toString())
            );
            HabilityCostValues h2 = new HabilityCostValues(
                    Integer.parseInt(hability2EditTexts[0].getText().toString()),
                    Integer.parseInt(hability2EditTexts[1].getText().toString()),
                    Integer.parseInt(hability2EditTexts[2].getText().toString()),
                    Integer.parseInt(hability2EditTexts[3].getText().toString()),
                    Integer.parseInt(hability2EditTexts[4].getText().toString())
            );
            HabilityCostValues h3 = new HabilityCostValues(
                    Integer.parseInt(hability3EditTexts[0].getText().toString()),
                    Integer.parseInt(hability3EditTexts[1].getText().toString()),
                    Integer.parseInt(hability3EditTexts[2].getText().toString()),
                    Integer.parseInt(hability3EditTexts[3].getText().toString()),
                    Integer.parseInt(hability3EditTexts[4].getText().toString())
            );
            initialValues.setHability1(h1);
            initialValues.setHability2(h2);
            initialValues.setHability3(h3);
            int [] passives = {
                    Integer.parseInt(passiveEditTexts[0].getText().toString()),
                    Integer.parseInt(passiveEditTexts[1].getText().toString())
            };
            initialValues.setPassives(passives);
            System.out.println(initialValues.toString());
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            Toast.makeText(this.getContext(), "Error en la introducción de valores", Toast.LENGTH_LONG).show();
        }
    }

    private void attachGraphicElements(View root) {
        this.energyEditText = root.findViewById(R.id.energyEditText);
        this.limitationEditText = root.findViewById(R.id.limitationEditText);
        this.psEditText = root.findViewById(R.id.pmEditText);
        this.pmEditText = root.findViewById(R.id.pmEditText);
        this.paEditText = root.findViewById(R.id.paEditText);
        this.attackEditTexts[0] = root.findViewById(R.id.firstAttackVariable);
        this.attackEditTexts[1] = root.findViewById(R.id.secondAttackVariable);
        this.defenseEditTexts[0] = root.findViewById(R.id.firstDefenseVariable);
        this.defenseEditTexts[1] = root.findViewById(R.id.secondDefenseVariable);

        this.hability1EditTexts[0] = root.findViewById(R.id.paHability1EditText);
        this.hability1EditTexts[1] = root.findViewById(R.id.rHability1EditText);
        this.hability1EditTexts[2] = root.findViewById(R.id.aHabitliy1EditText);
        this.hability1EditTexts[3] = root.findViewById(R.id.fHabilityVariable);
        this.hability1EditTexts[4] = root.findViewById(R.id.d10HabilityVariable);

        this.hability2EditTexts[0] = root.findViewById(R.id.paHability2EditText);
        this.hability2EditTexts[1] = root.findViewById(R.id.rHability2EditText);
        this.hability2EditTexts[2] = root.findViewById(R.id.aHabitliy2EditText);
        this.hability2EditTexts[3] = root.findViewById(R.id.fHability2Variable);
        this.hability2EditTexts[4] = root.findViewById(R.id.d10Hability2Variable);

        this.hability3EditTexts[0] = root.findViewById(R.id.paHability3EditText);
        this.hability3EditTexts[1] = root.findViewById(R.id.rHability3EditText);
        this.hability3EditTexts[2] = root.findViewById(R.id.aHabitliy3EditText);
        this.hability3EditTexts[3] = root.findViewById(R.id.fHability3Variable);
        this.hability3EditTexts[4] = root.findViewById(R.id.d10Hability3Variable);

        this.passiveEditTexts[0] = root.findViewById(R.id.firstPassiveVariable);
        this.passiveEditTexts[1] = root.findViewById(R.id.secondPassiveVariable);

        this.energyResults = root.findViewById(R.id.energyResult);
        this.limitationResults = root.findViewById(R.id.limitationResult);
        this.psResults = root.findViewById(R.id.psResult);
        this.pmResults = root.findViewById(R.id.pmResult);
        this.paResults = root.findViewById(R.id.paResult);
        this.attackResults = root.findViewById(R.id.attackResults);
        this.defenseResults = root.findViewById(R.id.defenseResults);
        this.hability1Results = root.findViewById(R.id.hability1Results);
        this.habiliy2Results = root.findViewById(R.id.hability2Results);
        this.hability3Results = root.findViewById(R.id.hability3Results);
        this.passiveResults = root.findViewById(R.id.passiveResults);
    }

    private void printResults() {
        System.out.println(resultValues);
        this.energyResults.setText(String.valueOf(resultValues.getEnergy()));
        this.limitationResults.setText(String.valueOf(resultValues.getLimitation()));
        this.psResults.setText(String.valueOf(resultValues.getPs()));
        this.pmResults.setText(String.valueOf(resultValues.getPm()));
        this.paResults.setText(String.valueOf(resultValues.getPa()));
        this.attackResults.setText(String.valueOf(resultValues.getAttack()));
        this.defenseResults.setText(String.valueOf(resultValues.getDefense()));
        this.hability1Results.setText(String.valueOf(resultValues.getHability1()));
        this.habiliy2Results.setText(String.valueOf(resultValues.getHability2()));
        this.hability3Results.setText(String.valueOf(resultValues.getHability3()));
        this.passiveResults.setText(String.valueOf(resultValues.getPassives()));
    }
}