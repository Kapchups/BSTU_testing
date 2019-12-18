package project.models;

import java.util.Comparator;

public class Price{

    private int pricebefore;

    public int getPricebefore() {
        return pricebefore;
    }

    public void setPricebefore(int pricebefore) {
        this.pricebefore = pricebefore;
    }

    private int priceafter;

    public int getPriceafter() {
        return priceafter;
    }

    public void setPriceafter(int priceafter) {
        this.priceafter = priceafter;
    }



/*    @Override
    public int compareTo(Price price) {
        return (this.getPrice() < price.getPrice() ? -1 :
                (this.getPrice() == price.getPrice() ? 0 : 1));
    }*/


    public static Comparator<Price> priceComparatorbefore = new Comparator<Price>() {
        @Override
        public int compare(Price jc1, Price jc2) {
            return (jc2.getPricebefore() < jc1.getPricebefore() ? -1 :
                    (jc2.getPricebefore() == jc1.getPricebefore() ? 0 : 1));
        }
    };

    public static Comparator<Price> priceComparatorafter = new Comparator<Price>() {
        @Override
        public int compare(Price jc1, Price jc2) {
            return (jc2.getPriceafter() < jc1.getPriceafter() ? -1 :
                    (jc2.getPriceafter() == jc1.getPriceafter() ? 0 : 1));
        }
    };
}
