package ru.yandex.steps;

import java.util.HashMap;
import java.util.Map;

public class StepTracker {
    HashMap<Integer, HashMap<Integer, Integer>> table = new HashMap<>();
    HashMap<Integer, Integer> month = new HashMap<>();
    private int goal = 10000;

    public StepTracker() {
        for (int i = 1; i <= 12; i++) {
            HashMap<Integer, Integer> month = new HashMap<>();
            int daysInMonth = getDaysInMonth(i);
            for (int j = 1; j <= daysInMonth; j++) {
                // day: steps
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

    public void printFullData(){
        for (Map.Entry<Integer, HashMap<Integer, Integer>> entry: table.entrySet()){
            System.out.println("\n" +getNameOfMonth( entry.getKey()) +":\n");
            for (Map.Entry<Integer, Integer> day : entry.getValue().entrySet()){
                System.out.println(day.getKey()+"день: пройдено шагов "+ day.getValue());

            }

        }
    }
    public void updateValueInTable(int month, int day, int steps){
        table.get(month).put(day, steps);
    }
    private int getDaysInMonth(int month) {
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31; // Months with 31 days
            case 4, 6, 9, 11 -> 30; // Months with 30 days
            case 2 -> 28; // February with 28 days (assuming non-leap year)
            default -> throw new IllegalStateException("Unexpected value: " + month);
        };
    }
    private String getNameOfMonth(int n){
        return switch(n){
            case 1 ->"Январь";
            case 2 ->"Февраль";
            case 3 ->"Март";
            case 4 ->"Апрель";
            case 5 ->"Май";
            case 6 ->"Июнь";
            case 7 ->"Июль";
            case 8 ->"Август";
            case 9 ->"Сентябрь";
            case 10 ->"Октябрь";
            case 11 ->"Ноябрь";
            case 12 ->"Декабрь";
            default -> throw new IllegalStateException("Unexpected value: " + n);
        };
    }

    public void printMonthData(int month) {
        HashMap<Integer, Integer> monthData = table.get(month);

        int totalSteps= 0;
        int achieveGoals = 0;
        for (Map.Entry<Integer, Integer> entry : monthData.entrySet()){
            totalSteps += entry.getValue();
            if (entry.getValue() >= goal){
                achieveGoals+=1;
            }

            System.out.println(entry.getKey()+" - "+ entry.getValue()+" шагов");
        }
        System.out.println("Всего шагов "+ totalSteps +" | Цель достигнута "+achieveGoals+" раз(a)");
    }
}
