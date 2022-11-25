import java.util.Scanner;


public class Calculator {
    // Метод добавления количества персон
    public int addPerson(){
        int person = -1;
        Scanner input = new Scanner(System.in);
        while (person <= 0) {
            System.out.println("Введите количество персон");
            if (input.hasNextInt()) {
                person = input.nextInt();
                if (person <= 0) {
                    System.out.println("Вы ввели не верное количесво персон");
                }
            } else {
                System.out.println("Вы ввели ошибочное значение");
                input.next(); // Сдвиг сканера, иначе бесконечный цикл
            }
        }
        return person;
    }

    private Product addProduct(){
        String name = null;
        double cost = -1;
        Product product;
        Scanner input = new Scanner(System.in);
        System.out.println("Введите название продукта");
        // В название принимается любое значение
        if(input.hasNext()) {
            name = input.next();
        }

        System.out.println("Введите стоимость продукта в формате \"рубли,копейки [10,45]\"");
        while (cost <= 0) {
            if (input.hasNextDouble()) {
                cost = input.nextDouble();
            }
            else {
                System.out.println("Вы ввели не корректную стоимость");
                input.next(); // Сдвиг
            }
        }
        System.out.println("Вы добавили товар: \"" + name + "\" стоимостью: " + cost);
        product = new Product(name,cost);
        return product;
    }

    //Получить список всех продуктов и финальную стоимость
    public double summProducts()
    {
        String productsAllPerson = "";
        double costAllPerson = 0;
        Scanner input = new Scanner(System.in);
        String answer;
        Product product;
        String strDialog;
        while(true) {
            System.out.println("Хотите ли Вы добавить новый продукт? (Да/Нет/Завершить)");
            if (input.hasNext()) {
                answer = input.next();
                if (answer.equalsIgnoreCase("да")) {
                    product = addProduct();
                    productsAllPerson = productsAllPerson  + product.productName + "\n";
                    costAllPerson = costAllPerson + product.cost;
                }
                if (answer.equalsIgnoreCase("нет") || answer.equalsIgnoreCase("завершить")) {
                    break;
                }
            }
        }
        strDialog = "Добавленные товары:\n%s\nОбщей стоимостью: %.2f %s";
        strDialog = String.format(strDialog, productsAllPerson, costAllPerson, getEnding(costAllPerson));
        System.out.println(strDialog);
    return costAllPerson;
    }

    // Склонение рубля
    public String getEnding(double cost){
        int preLast = (int)Math.floor(cost) % 100 / 10;
        if (preLast == 1){
            return "рублей";
        }

        switch ((int)Math.floor(cost) % 10){
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}

