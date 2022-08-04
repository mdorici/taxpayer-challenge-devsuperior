package application;

import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayerList = new ArrayList<>();

        System.out.print("How many contributor will you enter? ");
        int number = sc.nextInt();

        System.out.println();
        for(int i = 0; i < number; i++) {
            System.out.printf("Enter with contributor %d %n", i+1);
            System.out.print("Annual salary income: ");
            double salaryIncome = sc.nextDouble();
            System.out.print("Annual service income: ");
            double serviceIncome = sc.nextDouble();
            System.out.print("Annual capital income: ");
            double capitalIncome = sc.nextDouble();
            System.out.print("Health spending: ");
            double healthIncome = sc.nextDouble();
            System.out.print("Education spending: ");
            double educationIncome = sc.nextDouble();

            taxPayerList.add(new TaxPayer(salaryIncome, serviceIncome, capitalIncome, healthIncome, educationIncome));

            System.out.println();
        }

        System.out.println();
        for(TaxPayer taxPayer : taxPayerList) {
            System.out.printf("Summary of the contributor %d: %n", taxPayerList.indexOf(taxPayer) + 1);
            System.out.println(taxPayer);
        }

        sc.close();
    }
}
