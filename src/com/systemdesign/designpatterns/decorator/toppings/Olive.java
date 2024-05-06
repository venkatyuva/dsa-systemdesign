package com.systemdesign.designpatterns.decorator.toppings;

import com.systemdesign.designpatterns.decorator.Pizza;

public class Olive implements Pizza {

    private final Pizza pizza;

    public Olive(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza != null ? pizza.getCost() + 20 : 20;
    }

    @Override
    public String getDescription() {
        return pizza != null ? pizza.getDescription() + " + " + Olive.class.getSimpleName() : Olive.class.getSimpleName();
    }
}
