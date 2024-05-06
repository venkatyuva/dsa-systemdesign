package com.systemdesign.designpatterns.decorator.toppings;

import com.systemdesign.designpatterns.decorator.Pizza;

public class Cheese implements Pizza {

    private final Pizza pizza;

    public Cheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza != null ? pizza.getCost() + 80 : 80;
    }

    @Override
    public String getDescription() {
        return pizza != null ? pizza.getDescription() + " + " + Cheese.class.getSimpleName() : Cheese.class.getSimpleName();
    }
}
