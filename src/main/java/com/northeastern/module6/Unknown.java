package com.northeastern.module6;

public class Unknown implements IAncestorTree{
    public Unknown(){

    }

    @Override
    public int countAnc() {
        return 0;
    }

    @Override
    public int countAsParent() {
        return 0;
    }

    @Override
    public int countFemaleAnc() {
        return 0;
    }

    @Override
    public int countFemaleAncAsParent() {
        return 0;
    }

    @Override
    public boolean wellFormed() {
        return true;
    }

    @Override
    public boolean wellFormedAsParent(int childYob) {
        return true;
    }

    @Override
    public IAncestorTree youngestPersonAtGen(int gen) {
        if(gen == 0){
            return this;
        }
        return new Unknown();
    }

    @Override
    public IAncestorTree youngerIAT(IAncestorTree other) {
        return other;
    }

    @Override
    public IAncestorTree youngerIATHelper(IAncestorTree other, int otherYob) {
        return other;
    }
}
