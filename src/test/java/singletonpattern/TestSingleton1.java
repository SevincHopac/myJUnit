package singletonpattern;

public class TestSingleton1 {

    public static void main(String[] args) {

        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton1 singleton12 = Singleton1.getInstance();

        if (singleton1== singleton12){
            System.out.println("Same Object");
        }else {
            System.out.println("Different Object");
        }

    }
}
