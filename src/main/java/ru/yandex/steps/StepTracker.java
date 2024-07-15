package ru.yandex.steps;

import java.util.HashMap;
import java.util.Map;

public class StepTracker {
    // month: {day: steps}
    HashMap<Integer, HashMap<Integer, Integer>> table = new HashMap<>();

    // day: steps
    HashMap<Integer, Integer> month = new HashMap<>();
    private int goal = 10000;

    public StepTracker() {
        for (int i = 1; i <= 12; i++) {
            HashMap<Integer, Integer> month = new HashMap<>();
            int daysInMonth = getDaysInMonth(i);
            for (int j = 1; j <= daysInMonth; j++) {

                month.put(j, 0);
            }
            table.put(i, month);
        }
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public void printFullData() {
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry : table.entrySet()) {
            System.out.println("\n" + getNameOfMonth(entry.getKey()) + ":\n");
            for (Map.Entry<Integer, Integer> day : entry.getValue().entrySet()) {
                System.out.println(day.getKey() + "день: пройдено шагов " + day.getValue());

            }

        }
    }

    public void updateValueInTable(int month, int day, int steps) {
        table.get(month).put(day, steps);
    }

    private int getDaysInMonth(int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31; // Months with 31 days
            case 4, 6, 9, 11 -> 30; // Months with 30 days
            case 2 -> 28; // February with 28 days (assuming non-leap year)
            default -> throw new IllegalStateException("Нет месяца : " + month);
        };
    }

    private String getNameOfMonth(int n) {
        return switch (n) {
            case 1 -> "Январь";
            case 2 -> "Февраль";
            case 3 -> "Март";
            case 4 -> "Апрель";
            case 5 -> "Май";
            case 6 -> "Июнь";
            case 7 -> "Июль";
            case 8 -> "Август";
            case 9 -> "Сентябрь";
            case 10 -> "Октябрь";
            case 11 -> "Ноябрь";
            case 12 -> "Декабрь";
            default -> throw new IllegalStateException("Нет месяца : " + n);
        };
    }

    public void printMonthData(int month) {
        HashMap<Integer, Integer> monthData = table.get(month);
        StringBuilder res = new StringBuilder();
        int totalSteps = 0;
        int achieveGoals = 0;
        int maxSteps =0;

        for (Map.Entry<Integer, Integer> entry : monthData.entrySet()) {

            int steps = entry.getValue();
            totalSteps += steps;
            if (steps >= goal) {
                achieveGoals += 1;

            }
            if (steps > maxSteps){
                maxSteps = steps;
            }
            res.append(entry.getKey()).append(" день: ").append(entry.getValue()).append(" шагов").append(", ");
        }
        int totalKkl = (totalSteps * 50)/1000;
        System.out.println("Статистика за "+ getNameOfMonth(month));
        System.out.println(res.substring(0, res.length()-1));
        System.out.println(
                "Всего шагов " + totalSteps
                 + " | максимально пройдено "+ maxSteps
                 + " | Среднее к-во шагов " + (totalSteps/30)
                +" | Пройдено км "+ (totalSteps * 0.75)
                + " | К-во сожженных калорий "+ totalKkl
                + " | Лучшая серия: "+  (0) + " дней"
                + " | Цель достигнута " + achieveGoals + " раз(a)");
    }
}
