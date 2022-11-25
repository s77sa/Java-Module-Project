//import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        System.out.println("Привет!");
        Calculator calc = new Calculator();
        // Запрашиваем количество персон у пользователя
        int person = calc.addPerson();
        // Запрашиваем список продуктов со стоимостью
        double costAll = calc.summProducts();
        double cost = costAll / person;
        String dialog = "Каждый из друзей должен заплатить: %.2f %s";
        dialog = String.format(dialog, cost, calc.getEnding(cost));
        System.out.println(dialog);

        System.out.println("Завершено!");
    }




}
