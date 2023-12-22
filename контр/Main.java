/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. 
Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и 
выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например:
“Введите цифру, соответствующую необходимому критерию:
1 - Оперативная память RAM
2 - Объем Жеского Диска SSD
3 - Операционная система OC
4 - Цвет …
6 - 
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации 
можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
 */

package контр;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
       
        Set<Laptop> Laptops = new HashSet<>();
        Laptops.add(new Laptop("Apple MacBook Air", 8, 256, "macOS", "silver"));
        Laptops.add(new Laptop("Apple MacBook Pro", 16, 512, "MacOS", "black"));
        Laptops.add(new Laptop("HUAWEI MateBook", 8, 512, "Windows", "Gray"));
        Laptops.add(new Laptop("HIPER NOTEBOOK", 8, 256, "Windows", "silver"));
        Laptops.add(new Laptop("Acer Aspire", 16, 512, "Linux", "pink"));
        Laptops.add(new Laptop("Irbis", 32, 1024, "Linux", "blue"));

      
        Map<String, Object> filters = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите критерии для фильтрации: ");
        System.out.println("1 - Название ");
        System.out.println("2 - Оперативная память RAM ");
        System.out.println("3 - Объем Жеского Диска SSD ");
        System.out.println("4 - Операционная система OC ");
        System.out.println("5 - Цвет ");
        System.out.println("0 - Показать отфильтрованные ноутбуки: ");

        int choice;
        while (true) {
            choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Выберите марку ноутбука Apple, HUAWEI, HIPER, Acer, Irbis");
                    filters.put("name", scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Объем оперативной памяти 8, 16, 32?");
                    filters.put("ram", scanner.nextInt());
                    break;
                case 3:
                    System.out.println(" Объем Жесткого диска 256, 512, 1024 ?");
                    filters.put("sdd", scanner.nextInt());
                    break;
                case 4:
                    System.out.println("Операционная система Windows, Linux, MacOS?");
                    filters.put("oc", scanner.next());
                    break;
                case 5:
                    System.out.println("Цвет silver, black, Gray, pink, blue?");
                    filters.put("color", scanner.next());
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

        Set<Laptop> filteredLaptops = Laptops.stream()
                .filter(laptop -> filters.getOrDefault("ram", 0) instanceof Integer && laptop.ram >= (int) filters.getOrDefault("ram", 0))
                .filter(laptop -> filters.getOrDefault("hdd", 0) instanceof Integer && laptop.sdd >= (int) filters.getOrDefault("sdd", 0))
                .filter(laptop -> filters.getOrDefault("os", "").equals("") || laptop.oc.equalsIgnoreCase((String) filters.getOrDefault("oc", "")))
                .filter(laptop -> filters.getOrDefault("color", "").equals("") || laptop.color.equalsIgnoreCase((String) filters.getOrDefault("color", "")))
                .collect(Collectors.toSet());

        System.out.println("Отфильтрованные ноутбуки:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }
}
    
       