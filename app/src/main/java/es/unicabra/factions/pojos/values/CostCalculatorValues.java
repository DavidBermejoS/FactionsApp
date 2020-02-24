package es.unicabra.factions.pojos.values;

import java.util.Arrays;

/**
 * <b>CostCalculatorValues</b>
 * Here are contained the values introduced by the user
 * in the CostCalculator Graphic Interface.
 * The composed paremters are stored in arrays or his own Class pojos.
 *
 * @author David Bermejo Simón
 */
public class CostCalculatorValues {
    private int energy=0;
    private int limitation=0;
    private int ps=0;
    private  int[] attack={0,0};
    private int [] defense={0,0};
    private int pm=0;
    private int pa=0;
    private HabilityCostValues hability1 = new HabilityCostValues();
    private HabilityCostValues hability2= new HabilityCostValues();
    private HabilityCostValues hability3= new HabilityCostValues();
    private int [] passives={0,0};

    public CostCalculatorValues() {
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getLimitation() {
        return limitation;
    }

    public void setLimitation(int limitation) {
        this.limitation = limitation;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int[] getAttack() {
        return attack;
    }

    public void setAttack(int[] attack) {
        this.attack = attack;
    }

    public int[] getDefense() {
        return defense;
    }

    public void setDefense(int[] defense) {
        this.defense = defense;
    }

    public int getPm() {
        return pm;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    public int getPa() {
        return pa;
    }

    public void setPa(int pa) {
        this.pa = pa;
    }

    public HabilityCostValues getHability1() {
        return hability1;
    }

    public void setHability1(HabilityCostValues hability1) {
        this.hability1 = hability1;
    }

    public HabilityCostValues getHability2() {
        return hability2;
    }

    public void setHability2(HabilityCostValues hability2) {
        this.hability2 = hability2;
    }

    public HabilityCostValues getHability3() {
        return hability3;
    }

    public void setHability3(HabilityCostValues hability3) {
        this.hability3 = hability3;
    }

    public int[] getPassives() {
        return passives;
    }

    public void setPassives(int[] passives) {
        this.passives = passives;
    }

    @Override
    public String toString() {
        return "CostCalculatorValues{" +
                "energy=" + energy + "\n"+
                ", limitation=" + limitation +"\n"+
                ", ps=" + ps +"\n"+
                ", attack=" + Arrays.toString(attack) +"\n"+
                ", defense=" + Arrays.toString(defense) +"\n"+
                ", pm=" + pm +"\n"+
                ", pa=" + pa +"\n"+
                ", hability1=" + hability1.toString() +"\n"+
                ", hability2=" + hability2.toString() +"\n"+
                ", hability3=" + hability3.toString() +"\n"+
                ", passives=" + Arrays.toString(passives) +"\n"+
                '}'+"\n";
    }
}
