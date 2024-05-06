package com.systemdesign.designpatterns.decorator.toppings;

import com.systemdesign.designpatterns.decorator.Pizza;

public class Tomato implements Pizza {

    private final Pizza pizza;

    public Tomato(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public int getCost() {
        return pizza != null ? pizza.getCost() + 30 : 30;
    }

    @Override
    public String getDescription() {
        return pizza != null ? pizza.getDescription() + " + " + Tomato.class.getSimpleName() : Tomato.class.getSimpleName();
    }
}
