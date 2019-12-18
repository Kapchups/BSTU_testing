package project.models;


import java.util.ArrayList;
import java.util.Collections;

public class PriceSorter {
    ArrayList<Price> priceArrayList = new ArrayList<>();

    public PriceSorter(ArrayList<Price> priceArrayList) {
        this.priceArrayList = priceArrayList;
    }
    public ArrayList<Price> getSortedPriceBefore() {
        Collections.sort(priceArrayList, Price.priceComparatorbefore);
        return priceArrayList;
    }

    public ArrayList<Price> getSortedPriceAfter() {
        Collections.sort(priceArrayList, Price.priceComparatorafter);
        return priceArrayList;
    }
}
