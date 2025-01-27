import java.util.Scanner;

public class ShoppingCart {
    public static void main(String[] args) {
        String[] products = {"Хлеб", "Молоко", "Сыр", "Яблоки", "Картофель"};
        int[] prices = {50, 80, 200, 120, 30};
        int[] cart = new int[products.length];
        int sumProducts = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в магазин!");
        System.out.println("Список доступных продуктов:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " - " + prices[i] + " руб/шт");
        }

        while (true) {
            System.out.println("Введите номер продукта и количество через пробел или end для завершения: ");
            String inputString = scanner.nextLine().trim();

            if (inputString.equalsIgnoreCase("end")) {
                break;
            }

            try {
                String[] parts = inputString.split(" ");
                int productNumber = Integer.parseInt(parts[0]) - 1; // Приводим к индексу массива
                int productCount = Integer.parseInt(parts[1]);

                if (productNumber < 0 || productNumber >= products.length || productCount <= 0) {
                    System.out.println("Ошибка ввода. Проверьте номер продукта и количество.");
                    continue;
                }

                cart[productNumber] += productCount;
                int currentPrice = prices[productNumber] * productCount;
                sumProducts += currentPrice;

                System.out.println("Добавлено: " + productCount + " шт. продукта " + products[productNumber] + ".");
            } catch (Exception e) {
                System.out.println("Ошибка ввода. Попробуйте снова.");
            }
        }

        System.out.println("\nВаша корзина:");
        for (int i = 0; i < products.length; i++) {
            if (cart[i] > 0) {
                System.out.println(products[i] + " - " + cart[i] + " шт. (" + (cart[i] * prices[i]) + " руб.)");
            }
        }
        System.out.println("Итоговая сумма: " + sumProducts + " руб.");
    }
}
