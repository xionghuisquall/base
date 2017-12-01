package com.leo.base.java8.lamda.demo1;

public class StrategyLamda {
    public interface TaxCalculator {
        float getTax(int baseSalary, float rate);
    }

    public static class MonthSalary {
        public void getSalary(int workDays, TaxCalculator calculator) {
            int salary = workDays * 300;
            salary -= calculator.getTax(salary, 0.1f);
            System.out.println(salary);
        }
    }

    public static void main(String[] args) {
        MonthSalary m = new MonthSalary();
        m.getSalary(30, (baseSalary, rate) -> baseSalary * rate);
    }
}
