package com.example.startup2;
import java.text.DecimalFormat;
public class Interest_Calc {

        private double principal;       // The initial amount of money invested or borrowed
        private double interestRate;    // The annual interest rate (in decimal)
        private double months;          // The time period in months


        // Constructor to initialize the principal and annual interest rate
        public Interest_Calc(double principal, double interestRate,int months) {
            this.principal = principal;
            this.interestRate = interestRate;
            this.months = months;

        }

        // Method to calculate the total interest earned or paid after a given number of months
        public String calculateProfit(double months) {
            // Convert the annual interest rate to a monthly interest rate
            double monthlyRate = interestRate / 12.0;
            // Calculate the total interest earned or paid over the given number of months
            double totalInterest = principal * monthlyRate * months;
            // Calculate the tax on the total interest (20% tax rate)
            double tax = 0.20 * totalInterest;
            // Subtract the tax from the total interest to get the net profit
            double netProfit = totalInterest - tax;
            //print the total value of the account
            double finalTotal = principal + netProfit;
            DecimalFormat df = new DecimalFormat("#.##");
            String FinalTotal = df.format(finalTotal);
            // Print the total interest, tax, and net profit
            System.out.println("Total Interest after " + months + " months: " + totalInterest);
            System.out.println("Tax (20%): " + tax);
            System.out.println("Net Profit: " + netProfit);
            System.out.println(FinalTotal);
            return String.valueOf(FinalTotal) ;
        }
    }

