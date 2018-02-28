package com.max.arrays;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.Scanner;

public class FinanceReport {

    Payment payments[];

    InputStream in = System.in;
    OutputStream out = System.out;

    public FinanceReport(Payment[] payments) {
        this.payments = payments;
    }

    public FinanceReport(int l) {payments = new Payment[l];
    }
    public void input(InputStream  in) {
        // this
    }

    public FinanceReport() {
        payments = new Payment[10];
    }

    public FinanceReport(FinanceReport fr) {
        this.payments = fr.payments.clone();
    }


    public void read(InputStream in) throws IOException {
        Payment p[] = new Payment[];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String s = br.readLine();
            int l = Integer.parseInt(s);
            p = new Payment[l];
            int i = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String words[] = line.split(" ");
                p[i] = new Payment();
                p[i].setName(words[0] + words[1] + words[2]);
                p[i].setDay(Integer.parseInt(words[3]));
                p[i].setMonth(Integer.parseInt(words[4]));
                p[i].setYear(Integer.parseInt(words[5]));
                p[i].setAmount(Integer.parseInt(words[6]));
                i++;
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            payments = p;
        }
        payments = p;
    }


    public void write(OutputStream out) throws IOException {
        for(int i = 0;i < payments.length;i++){
            Payment p = payments[i];
            String o = String.format("Плательщик: %s дата: %d.%d.%d сумма: %d руб. %d коп.\n",
                    p.name,p.day,p.month,p.year,p.amount/100,p.amount%100);
            out.write(o.getBytes());
        }
    }

    public void found(char c) throws IOException {
        for(int i = 0;i < payments.length;i++){
            if(payments[i].name.charAt(0) == c) {
                Payment p = payments[i];
                String o = String.format("Плательщик: %s дата: %d.%d.%d сумма: %d руб. %d коп.\n",
                        p.name,p.day,p.month,p.year,p.amount/100,p.amount%100);
                out.write(o.getBytes());
            }
        }
    }

    public int sumDate(String date){
        int result = 0;
        String s[] = date.split("\\.");
        int d = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]) - 1;
        int y = Integer.parseInt(s[2]);
        for(int i = 0;i < payments.length;i++){
            if((payments[i].day == d) && (payments[i].month == m) && (payments[i].year == y)) {
                result += payments[i].amount;
            }
        }
        return result;
    }

    public void foundLess(int sum) throws IOException {
        for(int i = 0;i < payments.length;i++){
            if(payments[i].amount < sum) {
                Payment p = payments[i];
                String o = String.format("Плательщик: %s дата: %d.%d.%d сумма: %d руб. %d коп.\n",
                        p.name,p.day,p.month,p.year,p.amount/100,p.amount%100);
                out.write(o.getBytes());
            }
        }
    }

    public String[] getMonthsWithOutP(int y){
        String r[] = {"Январь",	"Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};
        boolean t[] = new boolean[13];
        for(int i = 0;i < payments.length;i++){
            if(payments[i].year == y) t[payments[i].month] = true;
        }

        int lel = 0;
        for(int i = 0;i <= 12;i++){
            if(t[i] == true) lel++;
        }

        int k = 0;
        String s[] = new String[lel];
        if(lel != 0) {
            for (int i = 0; i < 12; i++) {
                if(t[i]) {
                    s[k] = r[i];
                    k++;
                }
            }
        }

        return s;
    }


    public int countPayments(){
        return payments.length;
    }

    public Payment get(int i){
        return payments[i];
    }

    public void set(int i,Payment p){
        payments[i] = p;
    }
}
