package es.unicabra.factions.ui.cost_calculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CostCalculatorViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CostCalculatorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}