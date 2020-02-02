package es.unicabra.factions.pojos.values;

import java.io.Serializable;
import java.util.Arrays;

/**
 * <b>InitialValues Class</b>
 * This class is maded to storage all the initial values in the formula of attack and defense to
 * liberate the fragment of calculable values. in this parameters we storage the attack and
 * defense values of the monsters
 * @see: RollSimulatorFragment
 * @author: David Bermejo Simón.
 */
public class InitialValues implements Serializable {
    private int rolls;
    private int dices;
    private int attackFixedValue;
    private int defenseFixedValue;
    private int defenseVariableValue;
    private int attackVariableValue;

    private int[][]matrixValues;

    public InitialValues(int rolls, int dices) {
        this.rolls = rolls;
        this.dices = dices;
        this.matrixValues = new int[rolls][dices];
    }

    public int getRolls() {
        return rolls;
    }

    public void setRolls(int rolls) {
        this.rolls = rolls;
    }

    public int getDices() {
        return dices;
    }

    public void setDices(int dices) {
        this.dices = dices;
    }

    public int getAttackFixedValue() {
        return attackFixedValue;
    }

    public void setAttackFixedValue(int attackFixedValue) {
        this.attackFixedValue = attackFixedValue;
    }

    public int getDefenseFixedValue() {
        return defenseFixedValue;
    }

    public void setDefenseFixedValue(int defenseFixedValue) {
        this.defenseFixedValue = defenseFixedValue;
    }

    public int getDefenseVariableValue() {
        return defenseVariableValue;
    }

    public void setDefenseVariableValue(int defenseVariableValue) {
        this.defenseVariableValue = defenseVariableValue;
    }

    public int getAttackVariableValue() {
        return attackVariableValue;
    }

    public void setAttackVariableValue(int attackVariableValue) {
        this.attackVariableValue = attackVariableValue;
    }

    public int[][] getMatrixValues() {
        return matrixValues;
    }

    public void setMatrixValues(int[][] matrixValues) {
        this.matrixValues = matrixValues;
    }

    @Override
    public String toString() {
        return "InitialValues{" +
                "rolls=" + rolls +
                ", dices=" + dices +
                ", attackFixedValue=" + attackFixedValue +
                ", defenseFixedValue=" + defenseFixedValue +
                ", defenseVariableValue=" + defenseVariableValue +
                ", attackVariableValue=" + attackVariableValue +
                ", matrixValues=" + Arrays.toString(matrixValues) +
                '}';
    }
}
