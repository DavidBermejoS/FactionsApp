package es.unicabra.factions.controllers;
import java.util.Arrays;
import java.util.Random;
import es.unicabra.factions.pojos.values.CalculatedValues;
import es.unicabra.factions.pojos.values.InitialValues;
import es.unicabra.factions.pojos.values.Values;

/**
 * <b>ToolsController</b>
 * This class contains all the methods to calculate all the parameters
 * that the user needs to adapt the monsters attributes.
 * This class is used by ToolsFragment like controller with the
 * purpose of keep the code clean and respect the MVC architecture.
 *
 * @see es.unicabra.factions.ui.tools.ToolsFragment
 * @author David Bermejo Simón
 */
public class ToolsController {

    private InitialValues initialValues;
    private CalculatedValues calculatedValues;

    private Values allValues;

    int[][] matrix;
    int[] vector;

    public ToolsController(InitialValues initialValues,
                           CalculatedValues calculatedValues) {
        this.initialValues = initialValues;
        this.calculatedValues = calculatedValues;
        this.allValues = new Values(initialValues, calculatedValues);
    }

    public ToolsController(int rolls, int dices) {
        this.initialValues = new InitialValues(rolls, dices);
        this.calculatedValues = new CalculatedValues(rolls,dices);
        this.allValues = new Values(initialValues, calculatedValues);
    }


    /**
     * This method contains all the calls to other methods that are responsible of
     * the data generation.
     *
     * @throws Exception
     */
    public void throwsRollsAction() throws Exception {
        rollDices();
        calculateSum();
        calculateAverage();
        calculateMode();
        calculateMax();
        calculateMin();
        calculateMedian();
        calculateIndexFailed();
    }

    /**
     * This method starts at the moment that the user push the roll button.
     * This method contains all the code relative to the dices results.
     *
     * @throws Exception: added to control all kind of fails.
     */
    private void rollDices() {
        matrix = this.initialValues.getMatrixValues();
        Random random = new Random();
        int attackResult, defenseResult;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                attackResult = initialValues.getAttackFixedValue() +
                        initialValues.getAttackVariableValue() * (random.nextInt(10) + 1);
                defenseResult = initialValues.getDefenseFixedValue() +
                        initialValues.getDefenseVariableValue() * (random.nextInt(10) + 1);
                matrix[i][j] = attackResult - defenseResult;
            }
        }
        initialValues.setMatrixValues(matrix);
        //only for debug purpousse
        System.out.println("\n\n\n MATRIZ DE RESULTADOS");
        for (int[] vector : matrix) {
            System.out.println(Arrays.toString(vector));
        }
    }

    /**
     * In this method will be calculated all the sums results per matrix row and
     * will be stored in the calculatedValues object (int[]sumValues)
     */
    private void calculateSum() {
        matrix = this.initialValues.getMatrixValues();
        String [] vectorSumText = this.calculatedValues.getSumValues();
        vector = this.calculatedValues.getSumValuesInt();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    vector[i] += matrix[i][j];
                    vectorSumText[i]=String.valueOf(vector[i]);
                }
            }
        }
        calculatedValues.setSumValues(vectorSumText);
        calculatedValues.setSumValuesTextChain(Arrays.toString(calculatedValues.getSumValues()));
        //only for debug purpousse
        System.out.println("\n\n\n VECTOR DE SUMAS");
        System.out.println(Arrays.toString(calculatedValues.getSumValues()));
    }

    /**
     * In this method will be calculated the arithmetic average of all the results alocated in the
     * sum vector (int[] sumValues in CalculatedValues object).
     */
    private void calculateAverage() {
        vector = this.calculatedValues.getSumValuesInt();
        int sum = 0;
        for (int i = 0; i < vector.length; i++) {
            sum += vector[i];
        }
        calculatedValues.setAverage(sum / this.initialValues.getRolls());
        //only for debug purpousse
        System.out.println("\n\n\n MEDIA ARITMÉTICA");
        System.out.println(calculatedValues.getAverage());
    }

    /**
     * In this method will be calculated the mode of the results storaged in the
     * sum vector (int[] sumValues in CalculatedValues object).
     */
    private void calculateMode() {
        vector = this.calculatedValues.getSumValuesInt();
        int maxValue, maxCount;
        maxCount = 0;
        maxValue = 0;
        for (int i = 0; i < vector.length; ++i) {
            int count = 0;
            for (int j = 0; j < vector.length; ++j) {
                if (vector[j] == vector[i]) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = vector[i];
            }
        }
        calculatedValues.setMode(maxValue);
        //only for debug purpousse
        System.out.println("\n\n\n MODA");
        System.out.println(calculatedValues.getMode());
    }

    /**
     * In this method will be calculated the max value of all the results storaged in the
     * sum vector (int[] sumValues in CalculatedValues object).
     */
    private void calculateMax() {
        vector = this.calculatedValues.getSumValuesInt();
        int maxValue = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] > maxValue) {
                maxValue = vector[i];
            }
        }
        this.calculatedValues.setMax(maxValue);
        //only for debug purpousse
        System.out.println("\n\n\n MAXIMO");
        System.out.println(calculatedValues.getMax());
    }

    /**
     * In this method will be calculated the min value of all the results storaged in the
     * sum vector (int[] sumValues in CalculatedValues object).
     */
    private void calculateMin() {
        vector = this.calculatedValues.getSumValuesInt();
        //ponemos como inicio minimo el maximo, para que así
        int minValue = calculatedValues.getMax();
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < minValue) {
                minValue = vector[i];
            }
        }
        this.calculatedValues.setMin(minValue);
        //only for debug purpousse
        System.out.println("\n\n\n MINIMO");
        System.out.println(calculatedValues.getMin());
    }

    /**
     * In this method will be calculated the median value of all the results storaged in the
     * sum vector (int[] sumValues in CalculatedValues object).
     */
    private void calculateMedian() {
        vector = this.calculatedValues.getSumValuesInt();
        Arrays.sort(vector);
        double median;
        if (vector.length % 2 == 0)
            median = ((double)vector[vector.length/2] + (double)vector[vector.length/2 - 1])/2;
        else
            median = (double) vector[vector.length/2];
        this.calculatedValues.setMedian(median);
        System.out.println("\n\n\n MEDIANA");
        System.out.println(calculatedValues.getMedian());
    }


    private void calculateIndexFailed() {
        matrix = this.initialValues.getMatrixValues();
        double[] indexFailed = new double[matrix.length];
        int counter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] <= 0) {
                    matrix[i][j]=0;
                    counter++;
                }
            }
            indexFailed[i]=counter*100/matrix[i].length;
            counter=0;
        }
        this.calculatedValues.setIndexFailed(indexFailed);
    }

    //GETTERS Y SETTERS

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

    public Values getAllValues() {
        return allValues;
    }

    public void setAllValues(Values allValues) {
        this.allValues = allValues;
    }
}
