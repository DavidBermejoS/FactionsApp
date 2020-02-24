package es.unicabra.factions.pojos.values;
/**
 * <b>CostCalculatorValues</b>
 * Here are contained the results calculated from CostCalculatorValues parameters values.
 */
public class CostCalculatorResults {
    private int energy=0;
    private int limitation=0;
    private int ps=0;
    private  int attack=0;
    private int defense=0;
    private int pm=0;
    private int pa=0;
    private int hability1=0;
    private int hability2=0;
    private int hability3=0;
    private int passives=0;
    private int total=0;

    public CostCalculatorResults() {
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

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
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

    public int getHability1() {
        return hability1;
    }

    public void setHability1(int hability1) {
        this.hability1 = hability1;
    }

    public int getHability2() {
        return hability2;
    }

    public void setHability2(int hability2) {
        this.hability2 = hability2;
    }

    public int getHability3() {
        return hability3;
    }

    public void setHability3(int hability3) {
        this.hability3 = hability3;
    }

    public int getPassives() {
        return passives;
    }

    public void setPassives(int passives) {
        this.passives = passives;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "CostCalculatorResults{" + "\n"+
                "energy=" + energy +"\n"+
                ", limitation=" + limitation +"\n"+
                ", ps=" + ps +"\n"+
                ", attack=" + attack +"\n"+
                ", defense=" + defense +"\n"+
                ", pm=" + pm +"\n"+
                ", pa=" + pa +"\n"+
                ", hability1=" + hability1 +"\n"+
                ", hability2=" + hability2 +"\n"+
                ", hability3=" + hability3 +"\n"+
                ", passives=" + passives +"\n"+
                ", total=" + total +"\n"+
                '}';
    }
}
