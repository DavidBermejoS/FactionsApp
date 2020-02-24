package es.unicabra.factions.ui.cost_calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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
 *
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
    private TextView resultBoxTextView;

    private Button resultsButton;
    private CostCalculatorValues initialValues;
    private CostCalculatorResults resultValues;
    private ArrayList<EditText[]>  habilities;


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
                try {
                    fillInitialValues();
                    resultValues = CostCalculatorController.getResults(initialValues);
                    printResults();
                } catch (NullPointerException ex) {
                    Toast.makeText(getContext(), "¡Error! Debes introducir todos los valores", Toast.LENGTH_LONG);
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
            if (!energyEditText.getText().toString().isEmpty()) {
                initialValues.setEnergy(Integer.parseInt(energyEditText.getText().toString()));
            }
            if (!limitationEditText.getText().toString().isEmpty()) {
                initialValues.setLimitation(Integer.parseInt(limitationEditText.getText().toString()));
            }
            if (!psEditText.getText().toString().isEmpty()) {
                initialValues.setPs(Integer.parseInt(psEditText.getText().toString()));
            }


            //ATTACK VALUES
            int[] attacksValues = new int[2];
            for (int i = 0; i < attacksValues.length; i++) {
                if (!attackEditTexts[i].getText().toString().isEmpty()) {
                    attacksValues[i] = Integer.parseInt(attackEditTexts[i].getText().toString());
                }else{
                    attacksValues[i]=0;
                }
            }
            initialValues.setAttack(attacksValues);


            //DEFENSE VALUES
            int[] defenseValues = new int[2];
            for (int i = 0; i < defenseValues.length; i++) {
                if (!defenseEditTexts[i].getText().toString().isEmpty()) {
                    defenseValues[i] = Integer.parseInt(defenseEditTexts[i].getText().toString());
                }else{
                    defenseValues[i]=0;
                }
            }
            initialValues.setDefense(defenseValues);


            if(!pmEditText.getText().toString().isEmpty()){
                initialValues.setPm(Integer.parseInt(pmEditText.getText().toString()));
            }
            if(!paEditText.getText().toString().isEmpty()){
                initialValues.setPa(Integer.parseInt(paEditText.getText().toString()));
            }

            //HABILITIES
            initialValues.setHability1(getHabilityByIndex(0));
            initialValues.setHability2(getHabilityByIndex(1));
            initialValues.setHability3(getHabilityByIndex(2));


            //PASSIVES
            int[] passives = new int[2];
            for (int i = 0; i < passives.length; i++) {
                if(!passiveEditTexts[i].getText().toString().isEmpty()){
                    passives[i]=Integer.parseInt(passiveEditTexts[i].getText().toString());
                }else{
                    passives[i]=0;
                }
            }
            initialValues.setPassives(passives);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            Toast.makeText(this.getContext(), "Error en la introducción de valores", Toast.LENGTH_LONG).show();
        }
    }

    private HabilityCostValues getHabilityByIndex(int index) {
        EditText[]habilityEditText = habilities.get(index);
        HabilityCostValues hability = new HabilityCostValues();
        if (!habilityEditText[0].getText().toString().isEmpty()){
            hability.setPaValue(Integer.parseInt(habilityEditText[0].getText().toString()));
        }
        if (!habilityEditText[1].getText().toString().isEmpty()){
            hability.setrValue(Integer.parseInt(habilityEditText[1].getText().toString()));
        }
        if (!habilityEditText[2].getText().toString().isEmpty()){
            hability.setaValue(Integer.parseInt(habilityEditText[2].getText().toString()));
        }
        if (!habilityEditText[3].getText().toString().isEmpty()){
            hability.setfValue(Integer.parseInt(habilityEditText[3].getText().toString()));
        }
        if (!habilityEditText[4].getText().toString().isEmpty()){
            hability.setD10(Integer.parseInt(habilityEditText[4].getText().toString()));
        }
        return hability;
    }

    private void attachGraphicElements(View root) {
        this.energyEditText = root.findViewById(R.id.energyEditText);
        this.limitationEditText = root.findViewById(R.id.limitationEditText);
        this.psEditText = root.findViewById(R.id.psEditText);
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

        habilities = new ArrayList<>();
        habilities.add(hability1EditTexts);
        habilities.add(hability2EditTexts);
        habilities.add(hability3EditTexts);

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
        this.resultBoxTextView=root.findViewById(R.id.resultsBoxTextView);
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
        this.resultBoxTextView.setText(String.valueOf(resultValues.getTotal()));

    }
}