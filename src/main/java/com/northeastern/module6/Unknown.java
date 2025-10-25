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
}
