package com.max.arrays;

public class Payment {
    String name;
    int year;
    int month;
    int day;

    int amount;

    public Payment() {
        name = "";
        year = 0;
        month = 0;
        day = 0;
        amount = 0;
    }


    public Payment(String name, int year, int month, int day, int amount) {
        this.name = name;
        this.year = year;
        this.month = month - 1;
        this.day = day;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;

        Payment payment = (Payment) o;

        if (getYear() != payment.getYear()) return false;
        if (getMonth() != payment.getMonth()) return false;
        if (getDay() != payment.getDay()) return false;
        if (getAmount() != payment.getAmount()) return false;
        return getName().equals(payment.getName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getYear();
        result = 31 * result + getMonth();
        result = 31 * result + getDay();
        result = 31 * result + getAmount();
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getAmount() {
        return amount;
    }
}
