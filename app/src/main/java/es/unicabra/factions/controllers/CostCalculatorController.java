package es.unicabra.factions.controllers;

import es.unicabra.factions.pojos.values.CostCalculatorResults;
import es.unicabra.factions.pojos.values.CostCalculatorValues;

public class CostCalculatorController {
    private static CostCalculatorValues values;
    private static CostCalculatorResults resultValues;

    public static CostCalculatorResults getResults(CostCalculatorValues initialValues) {
        resultValues = new CostCalculatorResults();
        values = initialValues;
        //TODO: CALL HERE SEVERAL METHODS TO FILL RESULTS VALUES WITH INITIAL VALUES OPERATIONS
        calculateEnergy();
        calculateLimitation();
        calculatePs();
        calculateAttack();
        calculateDefense();
        calculatePm();
        calculatePa();
        calculateHability1();
        calculateHability2();
        calculateHability3();
        calculatePassives();
        return resultValues;
    }

    private static void calculatePassives() {
        int totalPassives = (values.getPassives()[0]*3+values.getPassives()[1]*10)+10;
        resultValues.setPassives(totalPassives);
    }

    private static void calculateHability1() {
        //TODO: IMPLEMENT HERE THE RIGHT OPERATION TO THIS ACTION
        int totalH1=0;
        int pa = values.getHability1().getPaValue();
        int r = values.getHability1().getrValue();
        int a = values.getHability1().getaValue();
        int f = values.getHability1().getfValue();
        int d10=values.getHability1().getD10();
        resultValues.setHability1(totalH1);
    }
    private static void calculateHability2() {
        //TODO: IMPLEMENT HERE THE RIGHT OPERATION TO THIS ACTION
        int totalH2=0;
        int pa = values.getHability2().getPaValue();
        int r = values.getHability2().getrValue();
        int a = values.getHability2().getaValue();
        int f = values.getHability2().getfValue();
        int d10=values.getHability2().getD10();
        resultValues.setHability2(totalH2);
    }
    private static void calculateHability3() {
        //TODO: IMPLEMENT HERE THE RIGHT OPERATION TO THIS ACTION
        int totalH3=0;
        int pa = values.getHability3().getPaValue();
        int r = values.getHability3().getrValue();
        int a = values.getHability3().getaValue();
        int f = values.getHability3().getfValue();
        int d10=values.getHability3().getD10();
        resultValues.setHability3(totalH3);
    }

    private static void calculatePa() {
        resultValues.setPa(values.getPa()*5);
    }

    private static void calculatePm() {
        resultValues.setPm(values.getPm()*5);
    }

    private static void calculateDefense() {
        int defense = (values.getDefense()[0] * 3) + (values.getDefense()[1] * 10);
        resultValues.setDefense(defense);
    }

    private static void calculateAttack() {
        int attack = (values.getAttack()[0] * 3) + (values.getAttack()[1] * 10);
        resultValues.setAttack(attack);
    }

    private static void calculateLimitation() {
        resultValues.setLimitation(values.getLimitation() * 5);
    }

    private static void calculateEnergy() {
        resultValues.setEnergy(values.getEnergy() * -5);
    }

    private static void calculatePs() {
        resultValues.setPs(values.getPs());
    }

}
