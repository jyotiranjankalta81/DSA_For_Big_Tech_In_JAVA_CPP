package HashMapAndTreeMap.Problems;
import java.util.*;
public class PriceCheck {


    public static int wrongCount(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice){


        int count=0;
        HashMap<String,Float> productsWithPrice = new HashMap<>();
        for(int i=0;i<products.size();i++){
            productsWithPrice.put(products.get(i),productPrices.get(i) );
        }

        for(int j=0;j<productSold.size();j++){
            Float expectedPrice = productsWithPrice.get(productSold.get(j));
            if (!soldPrice.get(j).equals(expectedPrice)) {
                count++;
            }
        }

        return  count;
    }

    public  static  void main (String[] args){
        List<String> products = Arrays.asList("eggs", "milk", "cheese");
        List<Float> productPrices = Arrays.asList(2.89f, 3.29f, 5.79f);

        List<String> productSold = Arrays.asList("eggs", "eggs", "cheese", "milk");
        List<Float> soldPrice = Arrays.asList(2.89f, 2.99f, 5.97f, 3.29f);

        System.out.println("List is Wrong Count++++++++++++++++++++ " + wrongCount(products,productPrices,productSold,soldPrice));
    }


}
