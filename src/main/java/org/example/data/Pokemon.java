package org.example.data;

import java.util.EnumSet;
import java.util.LinkedList;

public class Pokemon {
    private String imagePath;
    private int level;
    private String name;
    private EnumSet<Type> types;
    private EnumSet<Type> weaknesses;
    private Move[] abilities;
    private int hp;
    private double defense;
    private int dmg;
    private LinkedList<String> evolutions;
    private int evoStage;

    public Pokemon(String imagePath, int level, String name, EnumSet<Type> types, Move[] abilities, int hp, double defense, int dmg, EnumSet<Type> weaknesses, LinkedList<String> evolutions, int evoStage) {
        this.level = level;
        this.name = name;
        this.types = types;
        this.abilities = abilities;
        this.hp = hp;
        this.defense = defense;
        this.dmg = dmg;
        this.weaknesses = weaknesses;
        this.evolutions = evolutions;
        this.evoStage = evoStage;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnumSet<Type> getTypes() {
        return types;
    }

    public void setTypes(EnumSet<Type> types) {
        this.types = types;
    }

    public Move[] getAbilities() {
        return abilities;
    }

    public void setAbilities(Move[] abilities) {
        this.abilities = abilities;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public EnumSet<Type> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(EnumSet<Type> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public LinkedList<String> getEvolutions() {
        return evolutions;
    }

    public void setEvolutions(LinkedList<String> evolutions) {
        evolutions = evolutions;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getEvoStage() {
        return evoStage;
    }

    public void setEvoStage(int evoStage) {
        this.evoStage = evoStage;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
