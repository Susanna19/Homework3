import java.util.Scanner;
public class CoffeeMaker {
    public static int accurateEspresso;
    public static String accurateMilkType = new String();
    public static double accurateMilkCounter;
    public static String accurateTopping = new String();
    public static int espressoCounter;
    public static String milkType = new String();
    public static double milkCounter;
    public static String topping = new String();


    public static void main(String[] args) {
        System.out.println( chooseYourCoffee());
        espressoChoice();
        System.out.println( milkType());
        milkTypeCount();
        System.out.println(chooseTopping());
        System.out.println(theResults());
    }

    public static String chooseYourCoffee() {
        System.out.println("Choose your coffee:");
        System.out.println("1. Espresso");
        System.out.println("2. Cappuccino");
        System.out.println("3. Latte");
        System.out.println("4. Frappuccino");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while(choice <1 || choice >4){
            System.out.println("Please provide a valid choice");
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1:
                accurateEspresso = 1;
                accurateMilkCounter = 0;
                accurateTopping = "None";
                accurateMilkType = "None";
                return "Espresso: exactly 1 shot of espresso";
            case 2:
                accurateEspresso = 2;
                accurateMilkCounter = 1;
                accurateTopping = "Cacao powder";
                accurateMilkType = "Foamed milk";
                return  "Cappuccino: 2 shots of espresso, 1 part foamed milk, cacao powder";
            case 3:
                accurateEspresso = 1;
                accurateMilkCounter = 2;
                accurateTopping = "None";
                accurateMilkType = "Steamed milk";
                return "Latte: 1 shot of espresso, 2 parts steamed milk";
            case 4:
                accurateEspresso = 3;
                accurateMilkCounter = 1.5;
                accurateTopping = "Caramel syrup";
                accurateMilkType = "Oat milk";
                return "Frappuccino : 3 shots of espresso, 1.5 parts of oat milk, caramel topping";
        }
        return "a";
    }

    public static int espressoChoice(){
        System.out.println("How many shots of espresso would you like to add?");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        espressoCounter = choice;
        while (espressoCounter <0 || espressoCounter >3){
            espressoCounter = 0;
            System.out.println("Input valid number please");
            choice = scanner.nextInt();
            espressoCounter = choice;
        }
        if (espressoCounter == 0){
            System.out.println("You did not add espresso");
            return espressoCounter;
        }
        if(espressoCounter>= 1 && espressoCounter <=3){
            System.out.println("You added "+ espressoCounter+" shots of espresso");
            return espressoCounter;
        }
        return 0;
    }

    public static String milkType() {
        System.out.println("Please choose the type of milk you want");
        System.out.println("1. Foamed milk");
        System.out.println("2. Oat milk");
        System.out.println("3. Steamed milk");
        System.out.println("4. None");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while (choice < 1 || choice > 4) {
            System.out.println("Please provide a valid choice");
            choice = scanner.nextInt();
        }

        switch (choice) {
            case 1:
                milkType = "Foamed milk";
                return "You chose foamed milk";
            case 2:
                milkType = "Oat milk";
                return "You chose oat milk";
            case 3:
                milkType ="Steamed milk";
                return "You chose steamed milk";
            case 4:
                milkType ="None";
                return "You did not add milk";
        }
      return null;
    }

    public static double milkTypeCount(){
        if (!milkType.equals("None")){
        System.out.println("Now please provide the number of shots");
        Scanner scanner = new Scanner(System.in);
        double choice2 = scanner.nextDouble();
        milkCounter = choice2;

        while (milkCounter <0 || milkCounter >3){
            System.out.println("You cannot input invalid numbers, input valid number");
            choice2 = scanner.nextDouble();
            milkCounter = choice2;
        }

        if (milkCounter == 0){
            System.out.println("You did not add Milk");
            return milkCounter;
        }

        if(milkCounter>= 1 && milkCounter<=2){
            System.out.println("You added "+ milkCounter+" shots of milk");
            return milkCounter;

        }
        }
        return 0;
    }
    public static String chooseTopping(){
        System.out.println("Please choose your topping");
        System.out.println("1. Cacao powder");
        System.out.println("2. Caramel syrup");
        System.out.println("3. None");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println("Please provide a valid choice");
            choice = scanner.nextInt();
        }
        switch (choice) {
            case 1:
                topping = "Cacao powder";
                return "You chose cacao powder";
            case 2:
                topping = "Caramel syrup";
                return "You chose caramel syrup";
            case 3:
                topping = "None";
                return "You did not choose a topping";
        }
        return "";
    }
    public static String theResults(){
        if(accurateMilkType.equals(milkType) && accurateMilkCounter == milkCounter && accurateTopping.equals(topping) && accurateEspresso == espressoCounter){
                return "You successfully created your coffee";
            } else {
            return "You failed in creating your coffee";
        }
    }
}
