package es.unicabra.factions.controllers;

import android.widget.Toast;

import es.unicabra.factions.pojos.values.CostCalculatorResults;
import es.unicabra.factions.pojos.values.CostCalculatorValues;

public class CostCalculatorController {
    private static CostCalculatorValues values;
    private static CostCalculatorResults resultValues;

    public static CostCalculatorResults getResults(CostCalculatorValues initialValues) throws NullPointerException{
        resultValues = new CostCalculatorResults();
        values = initialValues;
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
        calculateTotal();
        return resultValues;
    }

    private static void calculateTotal() throws NullPointerException{
        resultValues.setTotal(
                resultValues.getAttack() + resultValues.getDefense() + resultValues.getHability1()
                        + resultValues.getHability2() + resultValues.getHability3()
                        + resultValues.getPassives() + resultValues.getPa()
                        + resultValues.getPm() + resultValues.getPs()
                        + resultValues.getEnergy() + resultValues.getLimitation()
        );
    }

    private static void calculatePassives()  throws NullPointerException{
        int totalPassives=0;
        if(values.getPassives()[0]!=0 || values.getPassives()[1]!=0){
            totalPassives = (values.getPassives()[0] * 3 + values.getPassives()[1] * 10) + 10;
        }
        resultValues.setPassives(totalPassives);
    }

    private static void calculateHability1()  throws NullPointerException{
        int pa = values.getHability1().getPaValue() * -5;
        int r = values.getHability1().getrValue() * 7;
        int a = values.getHability1().getaValue() * 10;
        int f = values.getHability1().getfValue() * 3;
        int d10 = values.getHability1().getD10() * 10;
        int totalH1 = pa + r + a + f + d10;
        resultValues.setHability1(totalH1);
    }

    private static void calculateHability2()  throws NullPointerException{
        int pa = values.getHability2().getPaValue() * -5;
        int r = values.getHability2().getrValue() * 7;
        int a = values.getHability2().getaValue() * 10;
        int f = values.getHability2().getfValue() * 3;
        int d10 = values.getHability2().getD10() * 10;
        int totalH2 = pa + r + a + f + d10;
        resultValues.setHability2(totalH2);
    }

    private static void calculateHability3() throws NullPointerException {
        int pa = values.getHability3().getPaValue() * -5;
        int r = values.getHability3().getrValue() * 7;
        int a = values.getHability3().getaValue() * 10;
        int f = values.getHability3().getfValue() * 3;
        int d10 = values.getHability3().getD10() * 10;
        int totalH3 = pa + r + a + f + d10;
        resultValues.setHability3(totalH3);
    }

    private static void calculatePa() throws NullPointerException {
        resultValues.setPa(values.getPa() * 5);
    }

    private static void calculatePm()  throws NullPointerException{
        resultValues.setPm(values.getPm() * 5);
    }

    private static void calculateDefense()  throws NullPointerException{
        int defense = (values.getDefense()[0] * 3) + (values.getDefense()[1] * 10);
        resultValues.setDefense(defense);
    }

    private static void calculateAttack()  throws NullPointerException{
        int attack = (values.getAttack()[0] * 3) + (values.getAttack()[1] * 10);
        resultValues.setAttack(attack);
    }

    private static void calculateLimitation()  throws NullPointerException{
        resultValues.setLimitation(values.getLimitation() * 5);
    }

    private static void calculateEnergy()  throws NullPointerException{
        resultValues.setEnergy(values.getEnergy() * -5);
    }

    private static void calculatePs()  throws NullPointerException{
        resultValues.setPs(values.getPs());
    }

}
