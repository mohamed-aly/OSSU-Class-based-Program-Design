package com.northeastern.module6;

public interface IAncestorTree {

    int countAnc();

    int countAsParent();

    int countFemaleAnc();

    int countFemaleAncAsParent();

    boolean wellFormed();

    boolean wellFormedAsParent(int childYob);

    IAncestorTree youngestPersonAtGen(int gen);

    IAncestorTree youngerIAT(IAncestorTree other);

    IAncestorTree youngerIATHelper(IAncestorTree other, int otherYob);
}
