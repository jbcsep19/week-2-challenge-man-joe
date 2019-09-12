/*
Write a program that will allow a robot to assemble 25 burritos. Use a random generator for each burrito option and
build a list of 25 burrito customizations:

Rice: white, brown, none, all
Meat: chicken, steak, carnidas, chorizo, sofritas, veggies, none, all
Beans: pinto, black, none
Salsa: mild, medium, hot, none, all
Veggies: lettuce, fajita veggies, none, all
Cheese: yes/no
Guac: yes/no
Queso: yes/no
Sour cream: yes/no

Randomly generate a number of ingredients per burrito. Each burrito should have a minimum of 5 ingredients and a
maximum of 9 ingredients. Save the finished burritos and display the contents.

Calculate and display a price for each burrito. Pricing will be $3.00 plus 0.50 for each additional ingredient.

If you're finished with above before 3pm, modify your program to use methods. For example, you can call a method
from main whose sole purpose is to calculate the price of the burrito.

Sample Output (Your actual output may vary):

Burrito 0: brown rice, chicken, pinto beans, no salsa, lettuce, fajita veggies, guac, queso, sour cream	 $7.00
Burrito 1: no rice, sofritas, no beans, medium salsa, fajita veggies	 $4.50
Burrito 2: brown rice, carnidas, no beans, medium salsa, fajita veggies, cheese, guac	 $6.00
Burrito 3: no rice, chicken, black beans, hot salsa, lettuce, fajita veggies	 $5.50
Burrito 4: brown rice, steak, pinto beans, no salsa, fajita veggies, sour cream	 $5.50
Burrito 5: brown rice, veggies, pinto beans, no salsa, fajita veggies, sour cream	 $5.50
Burrito 6: white rice, sofritas, black beans, hot salsa, fajita veggies, guac, queso, sour cream	 $7.00
Burrito 7: white rice, carnidas, no beans, medium salsa, lettuce, guac, queso	 $6.00
Burrito 8: white rice, steak, black beans, no salsa, lettuce, fajita veggies, queso, sour cream	 $6.50
Burrito 9: brown rice, carnidas, no beans, medium salsa, lettuce, queso	 $5.50
Burrito 10: no rice, chorizo, pinto beans, hot salsa, fajita veggies, cheese, queso	 $6.00
Burrito 11: no rice, steak, pinto beans, hot salsa, fajita veggies	 $5.00
Burrito 12: brown rice, veggies, no beans, hot salsa, fajita veggies, queso	 $5.50
Burrito 13: white rice, sofritas, black beans, mild salsa, no veggies, sour cream	 $5.50
Burrito 14: no rice, chicken, no beans, medium salsa, lettuce, fajita veggies, sour cream	 $5.50
Burrito 15: no rice, carnidas, pinto beans, mild salsa, medium salsa, hot salsa, fajita veggies, cheese, guac, queso	 $7.50
Burrito 16: brown rice, chicken, black beans, hot salsa, no veggies, queso, sour cream	 $6.00
Burrito 17: no rice, carnidas, pinto beans, mild salsa, medium salsa, hot salsa, fajita veggies, guac	 $6.50
Burrito 18: white rice, chicken, black beans, medium salsa, no veggies, cheese, guac, sour cream	 $6.50
Burrito 19: no rice, chicken, no beans, mild salsa, fajita veggies, queso, sour cream	 $5.50
Burrito 20: white rice, veggies, black beans, mild salsa, medium salsa, hot salsa, no veggies	 $6.00
Burrito 21: brown rice, chicken, pinto beans, mild salsa, lettuce, fajita veggies	 $6.00
Burrito 22: no rice, carnidas, black beans, no salsa, no veggies, cheese, guac, queso	 $5.50
Burrito 23: brown rice, carnidas, no beans, medium salsa, lettuce, fajita veggies, sour cream	 $6.00
Burrito 24: white rice, chorizo, no beans, mild salsa, no veggies	 $4.50
Burrito 25: white rice, chorizo, black beans, no salsa, lettuce, fajita veggies, queso	 $6.00
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class chipotlePlus {
    static Random rnd = new Random();
    static double totalCost = 3.0; // starting price

    static ArrayList<String> riceOptions  = new ArrayList<String>(Arrays.asList("white","brown","none","all"));
    static ArrayList<String> meatOptions = new ArrayList<String>(Arrays.asList("chicken", "steak", "carnidas", "chorizo",
                                                        "sofritas", "veggies", "none"));
    static ArrayList<String> beanOptions = new ArrayList<String>(Arrays.asList("pinto","black","none"));
    static ArrayList<String> salsaOptions = new ArrayList<String>(Arrays.asList("mild", "medium", "hot", "none", "all")); // Can count as 1 ingredient
    static ArrayList<String> veggieOptions = new ArrayList<String>(Arrays.asList("lettuce", "fajita veggies", "none", "all"));


    private static String chosenRice(int riceChoice){
        if(riceChoice == 2){ // choice is none
            return "no rice";
        } else if(riceChoice == 3) { //choice is all
            totalCost = totalCost + 1;
            return "white&brown rice";
        } else{
            totalCost = totalCost + .5;
            return riceOptions.get(riceChoice) +" rice";
        }
    }

    private static String chosenMeat(int meatChoice){
        if(meatChoice == 6){ // choice is none
            return "no meat";
        } else{
            totalCost = totalCost + .5;
            return meatOptions.get(meatChoice);
        }
    }

    private static String chosenBean(int beanChoice) {
        if(beanChoice == 2){
            return "no beans";
        } else {
            totalCost = totalCost + .5;
            return beanOptions.get(beanChoice);
        }
    }

    private static ArrayList<String> chosenSalsa(int salsaChoice) {
        ArrayList<String> salsaReturn = new ArrayList<>();

        if(salsaChoice == 3){
            salsaReturn.add("no salsa");
        } else if(salsaChoice == 4){
            totalCost = totalCost + 2;
            for(int i = 0; i < 3; i++)
                salsaReturn.add(salsaOptions.get(i) + " salsa");
        } else {
            totalCost = totalCost + .5;
            salsaReturn.add(salsaOptions.get(salsaChoice) + " salsa");
        }
        return salsaReturn;
    }

    //Fix this!!!!
    private static ArrayList<String> chosenVeggies(int veggieChoice) {
        ArrayList<String> veggiesReturn = new ArrayList<>();

        if(salsaChoice == 3){
            salsaReturn.add("no salsa");
        } else if(salsaChoice == 4){
            totalCost = totalCost + 2;
            for(int i = 0; i < 3; i++)
                salsaReturn.add(salsaOptions.get(i) + " salsa");
        } else {
            totalCost = totalCost + .5;
            salsaReturn.add(salsaOptions.get(salsaChoice) + " salsa");
        }

        return salsaReturn;
    }

    private static ArrayList<String> buildStandard() {
        ArrayList<String> tempList = new ArrayList<>();

        int riceChoice = rnd.nextInt(riceOptions.size());
        int meatChoice = rnd.nextInt(meatOptions.size());
        int beanChoice = rnd.nextInt(beanOptions.size());
        int salsaChoice = rnd.nextInt(salsaOptions.size());
        int veggieChoice = rnd.nextInt(veggieOptions.size());

        tempList.add(chosenRice(riceChoice));
        tempList.add(chosenMeat(meatChoice));
        tempList.add(chosenBean(beanChoice));
        tempList.addAll(chosenSalsa(salsaChoice));
        return tempList;
    }

    public static void main(String[] args) {
        ArrayList<String> chosenIngred = new ArrayList<>();



        int numOfIngredients = rnd.nextInt(5) + 5;

        //Build Standard burrito if numOfIngredients  == 5

        for(int i = 0; i < 25; i++) { // building 25 burritos

            if(numOfIngredients == 5){//standard burrito
                chosenIngred = buildStandard();
            }
        }

//
//        Cheese: yes/no
//        Guac: yes/no
//        Queso: yes/no
//        Sour cream: yes/no

    }
}