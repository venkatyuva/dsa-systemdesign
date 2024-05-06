package com.systemdesign.designpatterns.decorator.base;

import com.systemdesign.designpatterns.decorator.Pizza;

public class Pepperoni implements Pizza {
    @Override
    public int getCost() {
        return 180;
    }

    @Override
    public String getDescription() {
        return Pepperoni.class.getSimpleName();
    }
}
