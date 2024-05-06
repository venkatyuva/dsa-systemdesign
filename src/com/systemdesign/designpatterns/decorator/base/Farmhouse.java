package com.systemdesign.designpatterns.decorator.base;

import com.systemdesign.designpatterns.decorator.Pizza;

public class Farmhouse implements Pizza {

    @Override
    public int getCost() {
        return 150;
    }

    @Override
    public String getDescription() {
        return Farmhouse.class.getSimpleName();
    }
}
