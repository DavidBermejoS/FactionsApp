package es.unicabra.factions.pojos.values;

import java.io.Serializable;

/**
 * <b>Class Values</b>
 * In this super class is be contained the two types of value objects.
 * @author: David Bermejo Simón
 */
public class Values implements Serializable {

    private  InitialValues initialValues;
    private  CalculatedValues calculatedValues;

    public Values(InitialValues initialValues, CalculatedValues calculatedValues) {
        this.initialValues = initialValues;
        this.calculatedValues = calculatedValues;
    }

    public Values() {
    }

    public InitialValues getInitialValues() {
        return initialValues;
    }

    public void setInitialValues(InitialValues initialValues) {
        this.initialValues = initialValues;
    }

    public CalculatedValues getCalculatedValues() {
        return calculatedValues;
    }

    public void setCalculatedValues(CalculatedValues calculatedValues) {
        this.calculatedValues = calculatedValues;
    }

//    @Override
//    public String toString() {
//        return "Values{" +
//                "initialValues=" + initialValues.toString() +
//                ", calculatedValues=" + calculatedValues.toString() +
//                '}';
//    }
}
