package com.patterns.singleton;

/**
 * Created by Mihir.Desai on 2/19/2016.
 */
public class ChocolateController {
    public static void main(String[] args) {
        ChocolateBoiler boiler = ChocolateBoiler.getInstance();
        boiler.fill();
        boiler.boil();
        boiler.drain();

        ChocolateBoiler boilder2 = ChocolateBoiler.getInstance();

        //will retrun existing instance
    }
}
