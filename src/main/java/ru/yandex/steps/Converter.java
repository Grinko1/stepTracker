package ru.yandex.steps;

public class Converter {
    public int countKkal(int steps) {
        return (steps * 50) / 1000;
    }

    public double countKm(int steps) {
        return steps * 0.75;
    }
}
