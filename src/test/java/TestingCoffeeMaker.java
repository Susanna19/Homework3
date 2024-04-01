import org.junit.Assert;
import java.io.ByteArrayInputStream;

public class TestingCoffeeMaker {
    public static void main(String[] args) {
        testChooseYourCoffee();
        testEspressoChoice();
        testMilkType();
        testMilkTypeCount();
        testChooseTopping();
        testTheResults();

    }


    /*
    To ensure that the method handles invalid inputs correctly, I test each valid input (1-4) as well as an invalid input(5) followed by a valid input(1).
    For each coffee choice, I check that the method returns the expected string through a test assertion.
     */
    public static void testChooseYourCoffee() {
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        String resultEspresso = coffeeMaker.chooseYourCoffee();
        Assert.assertEquals("Espresso: exactly 1 shot of espresso", resultEspresso);

        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
        String resultCappuccino = coffeeMaker.chooseYourCoffee();
        Assert.assertEquals("Cappuccino: 2 shots of espresso, 1 part foamed milk, cacao powder", resultCappuccino);

        System.setIn(new ByteArrayInputStream("3\n".getBytes()));
        String resultLatte = coffeeMaker.chooseYourCoffee();
        Assert.assertEquals("Latte: 1 shot of espresso, 2 parts steamed milk", resultLatte);

        System.setIn(new ByteArrayInputStream("4\n".getBytes()));
        String resultFrappuccino = coffeeMaker.chooseYourCoffee();
        Assert.assertEquals("Frappuccino : 3 shots of espresso, 1.5 parts of oat milk, caramel topping", resultFrappuccino);

        System.setIn(new ByteArrayInputStream("5\n1\n".getBytes()));
        String resultInvalid = coffeeMaker.chooseYourCoffee();
        Assert.assertEquals("Espresso: exactly 1 shot of espresso", resultInvalid);
    }




    /*
    I ran three tests to check the espresso shots. The first test has 2 shots,
    the second test had no shots, and the third test had an invalid input(-1) followed by a valid input(3).
    Each test checked if the method returned the correct number of espresso shots.
     */
    public static void testEspressoChoice() {
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
        int resultValid = coffeeMaker.espressoChoice();
        Assert.assertEquals(2, resultValid);

        System.setIn(new ByteArrayInputStream("0\n".getBytes()));
        int resultZero = coffeeMaker.espressoChoice();
        Assert.assertEquals(0, resultZero);

        System.setIn(new ByteArrayInputStream("-1\n3\n".getBytes()));
        int resultInvlid = coffeeMaker.espressoChoice();
        Assert.assertEquals(3, resultInvlid);
    }



    /*
To ensure the method handles invalid inputs correctly, I test each valid input between the range of 1 to 4.
 I also test an invalid input followed by a valid input.
 Each test assertion confirms that the method returns the expected string for every milk type choice.
     */
    public static void testMilkType() {
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        String resultFoamed = coffeeMaker.milkType();
        Assert.assertEquals("You chose foamed milk", resultFoamed);

        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
        String resultOat = coffeeMaker.milkType();
        Assert.assertEquals("You chose oat milk", resultOat);

        System.setIn(new ByteArrayInputStream("3\n".getBytes()));
        String resultSteamed = coffeeMaker.milkType();
        Assert.assertEquals("You chose steamed milk", resultSteamed);

        System.setIn(new ByteArrayInputStream("4\n".getBytes()));
        String resultNone = coffeeMaker.milkType();
        Assert.assertEquals("You did not add milk", resultNone);

        System.setIn(new ByteArrayInputStream("5\n1\n".getBytes()));
        String resultInvalid = coffeeMaker.milkType();
        Assert.assertEquals("You chose foamed milk", resultInvalid);
    }



    /*
 I set CoffeeMaker.milkType to a valid value ("Foamed milk") before running the tests, as milkTypeCount() depends on the value of milkType.
During testing, I checked three scenarios: a valid input (2 shots), an input of 0 shots, and an invalid input(-1) followed by a valid input(1).
For each scenario, I checked if the method returned the expected number of milk shots. I used the assertEquals method to make this comparison.
I also used the delta parameter which determines the maximum tolerance between the expected and actual values.
     */
    public static void testMilkTypeCount() {
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        CoffeeMaker.milkType = "Foamed milk";

        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
        double resultValid = coffeeMaker.milkTypeCount();
        Assert.assertEquals(2.0, resultValid, 0.01);

        System.setIn(new ByteArrayInputStream("0\n".getBytes()));
        double result0 = coffeeMaker.milkTypeCount();
        Assert.assertEquals(0.0, result0, 0.01);

        System.setIn(new ByteArrayInputStream("-1\n1\n".getBytes()));
        double resultInvalid = coffeeMaker.milkTypeCount();
        Assert.assertEquals(1.0, resultInvalid, 0.01);
    }



    /*
I test each valid input (1-3) and also test an invalid input(4) followed by a valid input(1) to ensure that the method handles invalid inputs correctly.
Each test assertion checks that the method returns the expected string for each topping choice.
     */
    public static void testChooseTopping() {
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        String resultCacao = coffeeMaker.chooseTopping();
        Assert.assertEquals("You chose cacao powder", resultCacao);

        System.setIn(new ByteArrayInputStream("2\n".getBytes()));
        String resultCaramel = coffeeMaker.chooseTopping();
        Assert.assertEquals("You chose caramel syrup", resultCaramel);

        System.setIn(new ByteArrayInputStream("3\n".getBytes()));
        String resultNone = coffeeMaker.chooseTopping();
        Assert.assertEquals("You did not choose a topping", resultNone);

        System.setIn(new ByteArrayInputStream("4\n1\n".getBytes()));
        String resultInvalid = coffeeMaker.chooseTopping();
        Assert.assertEquals("You chose cacao powder", resultInvalid);
    }



    /*
    To simulate a successful coffee-making scenario, I first set the accurate and actual values to be the same.
    Following that, I test theResults() method to ensure that it returns the expected success message.
    In contrast, if I alter one of the actual values to simulate a failed scenario where the user creates coffee incorrectly,
    I test that theResults() method returns the expected failure message.
     */
    public static void testTheResults() {
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        CoffeeMaker.accurateMilkType = "Foamed milk";
        CoffeeMaker.milkType = "Foamed milk";
        CoffeeMaker.accurateMilkCounter = 2.0;
        CoffeeMaker.milkCounter = 2.0;
        CoffeeMaker.accurateTopping = "Cacao powder";
        CoffeeMaker.topping = "Cacao powder";
        CoffeeMaker.accurateEspresso = 2;
        CoffeeMaker.espressoCounter = 2;

        String resultSuccess = coffeeMaker.theResults();
        Assert.assertEquals("You successfully created your coffee", resultSuccess);

        CoffeeMaker.espressoCounter = 1;
        String resultFailure = coffeeMaker.theResults();
        Assert.assertEquals("You failed in creating your coffee", resultFailure);
    }
}
