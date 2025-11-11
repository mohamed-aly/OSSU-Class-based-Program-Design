package com.northeastern.module6;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
class Person implements IAncestorTree {
    private String name;
    private int yob;
    private boolean isMale;
    private IAncestorTree mom;
    private IAncestorTree dad;

    @Override
    public int countAnc() {
        return this.mom.countAsParent() + this.dad.countAsParent();
    }

    @Override
    public int countAsParent() {
        return 1 + this.countAnc();
    }

    @Override
    public int countFemaleAnc() {
        return this.mom.countFemaleAncAsParent() + this.dad.countFemaleAncAsParent();
    }

    @Override
    public int countFemaleAncAsParent() {
        if (this.isMale) {
            return countFemaleAnc();
        }

        return 1 + countFemaleAnc();
    }

    @Override
    public boolean wellFormed() {
        return this.mom.wellFormedAsParent(this.yob)
               && this.dad.wellFormedAsParent(this.yob)
               && this.mom.wellFormed() && this.dad.wellFormed();
    }

    @Override
    public boolean wellFormedAsParent(int childYob) {
        return this.yob < childYob;
    }

    @Override
    public IAncestorTree youngestPersonAtGen(int gen) {
        if (gen == 0) {
            return this;
        }

        return this.mom.youngestPersonAtGen(gen - 1).youngerIAT(this.dad.youngestPersonAtGen(gen - 1));
    }

    @Override
    public IAncestorTree youngerIAT(IAncestorTree other) {
        return other.youngerIATHelper(this, this.yob);
    }

    @Override
    public IAncestorTree youngerIATHelper(IAncestorTree other, int otherYob) {
        if (otherYob > this.yob) {
            return other;
        }
        return this;
    }


}
