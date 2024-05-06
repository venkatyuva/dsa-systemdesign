package com.systemdesign.designpatterns.decorator.toppings;

import com.systemdesign.designpatterns.decorator.Pizza;

public class Paneer implements Pizza {

    private final Pizza pizza;

    public Paneer(Pizza pizza) {
        this.pizza = pizza;
    }
    @Override
    public int getCost() {
        return pizza != null ? pizza.getCost() + 60 : 60;
    }

    @Override
    public String getDescription() {
        return pizza != null ? pizza.getDescription() + " + " + Paneer.class.getSimpleName() : Paneer.class.getSimpleName();
    }
}
