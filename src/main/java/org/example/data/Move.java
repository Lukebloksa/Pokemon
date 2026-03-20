package org.example.data;

public class Move {
    private String name;
    private Type type;
    private Double dmgAmplifier;
    private int pp;

    public Move(String name, Type type, int pp, Double dmgAmplifier) {
        this.name = name;
        this.type = type;
        this.pp = pp;
        this.dmgAmplifier = dmgAmplifier;
    }

    public Double getDmgAmplifier() {
        return dmgAmplifier;
    }

    public void setDmgAmplifier(Double dmgAmplifier) {
        this.dmgAmplifier = dmgAmplifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }
}
