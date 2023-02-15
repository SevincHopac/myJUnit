package singletonpattern;

public class Singleton1 {

    private static Singleton1 instance= null;

    private Singleton1() {
        System.out.println("Singleton1 olustu.");
    }


    public static Singleton1 getInstance() {
        if (instance==null){
            instance=new Singleton1();
        }
        return instance;
    }
}

//   Singleton1 Tasarım Deseni genellikle cache, dosya işlemleri, veritabanı işlemleri gibi
//   tek nesneye ihtiyaç duyulan ve program boyunca
//   bu nesne üzerinden tüm işlemlerin yapılmasını sağlayan bir yapıdır.