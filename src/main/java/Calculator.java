public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }
    public static int divide(int a, int b) {
        return a / b;
    }
    public static String getGreeting(String name) {
        if(name.isEmpty()) return null;
        return "Hello, " + name + "!";
    }
    public static int generateRandomNumber(
            int min,
            int max
    ){
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
