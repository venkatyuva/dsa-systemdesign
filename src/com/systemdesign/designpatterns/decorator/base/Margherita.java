package com.systemdesign.designpatterns.decorator.base;

import com.systemdesign.designpatterns.decorator.Pizza;

public class Margherita implements Pizza {
    @Override
    public int getCost() {
        return 200;
    }

    @Override
    public String getDescription() {
        return Margherita.class.getSimpleName();
    }
}
