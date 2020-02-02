package es.unicabra.factions.pojos.values;


import java.io.Serializable;

import es.unicabra.factions.ui.tools.RollSimulatorFragment;

/**
 * <b>InitialValues Class</b>
 * This class is maded to storage all the calculated values by the formula of attack and defense to
 * liberate the fragment of calculable values.
 * @see RollSimulatorFragment
 * @author David Bermejo Simón.
 */
public class CalculatedValues implements Serializable {
    private int average;
    private int mode;
    private int min;
    private int max;
    private double median;
    private String [] sumValues;
    private int [] sumValuesInt;
    private String sumValuesTextChain;
    private double [] indexFailed;

    public CalculatedValues(int rolls, int dices) {
        this.sumValues = new String[rolls];
        this.sumValuesInt = new int[rolls];
        this.indexFailed = new double[rolls];
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String[] getSumValues() {
        return sumValues;
    }

    public void setSumValues(String[] sumValues) {
        this.sumValues = sumValues;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public double [] getIndexFailed() {
        return indexFailed;
    }

    public void setIndexFailed(double[] indexFailed) {
        this.indexFailed = indexFailed;
    }

    public String getSumValuesTextChain() {
        return sumValuesTextChain;
    }

    public void setSumValuesTextChain(String sumValuesTextChain) {
        this.sumValuesTextChain = sumValuesTextChain;
    }

    public int[] getSumValuesInt() {
        return sumValuesInt;
    }

    public void setSumValuesInt(int[] sumValuesInt) {
        this.sumValuesInt = sumValuesInt;
    }

    @Override
    public String toString() {
        return "CalculatedValues{" +
                "average=" + average +
                ", mode=" + mode +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
