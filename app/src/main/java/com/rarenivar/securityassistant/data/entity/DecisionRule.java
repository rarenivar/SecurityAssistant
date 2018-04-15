package com.rarenivar.securityassistant.data.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "DecisionRule")
public class DecisionRule {

    @PrimaryKey
    private int _id;

    @ColumnInfo(name = "number")
    private int number;

    @ColumnInfo(name = "ruleClass")
    private int ruleClass;

    @ColumnInfo(name = "probability")
    private float probability;

    public int get_id() {
        return _id;
    }

    public int getNumber() {
        return number;
    }

    public float getProbability() {
        return probability;
    }

    public int getRuleClass() {
        return ruleClass;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setRuleClass(int ruleClass) {
        this.ruleClass = ruleClass;
    }

    public void setProbability(float probability) {
        this.probability = probability;
    }

    public DecisionRule(int _id, int number, int ruleClass, float probability) {
        this._id = _id;
        this.number = number;
        this.ruleClass = ruleClass;
        this.probability = probability;
    }

}
