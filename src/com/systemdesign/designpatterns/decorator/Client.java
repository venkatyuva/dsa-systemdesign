package com.systemdesign.designpatterns.decorator;

import com.systemdesign.designpatterns.decorator.base.BBQChicken;
import com.systemdesign.designpatterns.decorator.toppings.Cheese;
import com.systemdesign.designpatterns.decorator.toppings.Paneer;
import com.systemdesign.designpatterns.decorator.toppings.Tomato;

public class Client {
    public static void main(String[] args) {
        Pizza pizza = new Paneer(new Cheese(new Tomato(new BBQChicken())));
        System.out.println(pizza.getCost());
        System.out.println(pizza.getDescription());
    }
}
