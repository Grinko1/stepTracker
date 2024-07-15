package ru.yandex.steps;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker stepTracker  = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int action = scanner.nextInt();

        while (action != 0) {
            switch (action) {
                case 1 -> {
                    System.out.println("Введите цель по шагам: ");
                    int goal = scanner.nextInt();
                    stepTracker.setGoal(goal);
                    System.out.println("Новая цель по к-ву шагов " + goal);
                }
                case 2 -> {
                    System.out.println("Введите дату и к-во шагов (формата \"ДД.ММ ШАГИ\"): ");
                    scanner.nextLine();
                    String input = scanner.nextLine();
                    String[] parts = input.split(" ");
                    String[] dateParts = parts[0].split("\\.");
                    int day = Integer.parseInt(dateParts[0]);
                    int month = Integer.parseInt(dateParts[1]);
                    int steps = Math.abs(Integer.parseInt(parts[1]));
                    stepTracker.updateValueInTable(month, day, steps);
                    System.out.println("Значение обновлено " +0+ day + "/" + 0+month +" - "+ steps+" шагов");
                }
                case 3 -> {
                    System.out.println("Введите месяц (от 1 до 12): ");
                    int month = scanner.nextInt();
                    stepTracker.printMonthData(month);
                }
                case 4 -> stepTracker.printFullData();
                default -> System.out.println("Неверное значение. Попробуйте ввести другое значение.");
            }
            printMenu();
            action = scanner.nextInt();
        }
        scanner.close();
        System.out.println("Завершение работы");
    }
    public  static void printMenu(){
        System.out.println("\nВведи цифру действия");
        System.out.println("1: ввести цель по шагам | 2: ввести пройденные шаги | 3: получить статистику за месяц | 4: получить статистику за год | 0: завершить");
    }
}
