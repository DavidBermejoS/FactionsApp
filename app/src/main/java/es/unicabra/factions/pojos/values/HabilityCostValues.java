package es.unicabra.factions.pojos.values;

/**
 * <b>Class HabilityCostValues</b>
 * This class contains all the primitives values to calculate the cost of
 * the hability. The parameters inside this class are detailed here:
 * paValue:
 * rValue:
 * aValue:
 * fValue: the strenght of the monster
 * d10: the amount of d10 that will be throwed.
 */
public class HabilityCostValues {
    private int paValue;
    private int rValue;
    private int aValue;
    private int fValue;
    private int d10;


    public HabilityCostValues(int paValue, int rValue, int aValue, int f, int d10) {
        this.paValue = paValue;
        this.rValue = rValue;
        this.aValue = aValue;
        this.fValue = f;
        this.d10 = d10;
    }

    public HabilityCostValues() {
    }

    public int getPaValue() {
        return paValue;
    }

    public void setPaValue(int paValue) {
        this.paValue = paValue;
    }

    public int getrValue() {
        return rValue;
    }

    public void setrValue(int rValue) {
        this.rValue = rValue;
    }

    public int getaValue() {
        return aValue;
    }

    public void setaValue(int aValue) {
        this.aValue = aValue;
    }

    public int getfValue() {
        return fValue;
    }

    public void setfValue(int fValue) {
        this.fValue = fValue;
    }

    public int getD10() {
        return d10;
    }

    public void setD10(int d10) {
        this.d10 = d10;
    }

    @Override
    public String toString() {
        return "HabilityCostValues{" +"\n"+
                "paValue=" + paValue +"\n"+
                ", rValue=" + rValue +"\n"+
                ", aValue=" + aValue +"\n"+
                ", fValue=" + fValue +"\n"+
                ", d10=" + d10 +"\n"+"\n"+
                '}';
    }
}
