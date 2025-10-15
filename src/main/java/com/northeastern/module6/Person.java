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
        if (this.isMale){
            return countFemaleAnc();
        }

        return 1 + countFemaleAnc();
    }
}
