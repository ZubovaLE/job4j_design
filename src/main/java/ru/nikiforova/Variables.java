package ru.nikiforova;

public class Variables {
    public static void main(String[] args) {

        byte age = 23; //8 bits. from -128 to 127
        System.out.println(age);

        char gender = 'М'; //16 bits. you can choose 'М' or 'Ж'
        System.out.println(gender);

        float height = 1.78F; //32 bits.(expressed in metres)
        System.out.println(height);

        short numberOfBricks = 3000; //16 bits. from -32,768 to 32,767. Количество кирпичей для постройки дома 100 кв.м
        System.out.println(numberOfBricks);

        long numberOfBacteria = 10000000000L; //64 bits. from -9223372036854775808L to 9223372036854775807L
        System.out.println(numberOfBacteria);

        int distance = 778547200 ; //32 bits. from -2147483648 to  2147483647. distance to the Jupiter
        System.out.println(distance);

        boolean workPermit = false; //1 bit. true or false
        System.out.println(workPermit);

        double number = 100500.969; //64 bits
        System.out.println(number);

        long fileSize = 16000; //64 bits
        System.out.println(fileSize);

        Variables variables = new Variables();
        variables.sayHello("Luba");
    }

    public void sayHello(String name){
        System.out.println(String.format("Hello %s", name));
    }
}
