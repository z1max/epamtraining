package com.epam.task1.runner;

import com.epam.task1.model.Jewel;
import com.epam.task1.model.Necklace;
import com.epam.task1.util.NecklaceUtil;
import com.epam.task1.util.PriceUtil;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine;

        Necklace necklace = new Necklace();
        NecklaceUtil necklaceUtil = new NecklaceUtil();
        necklaceUtil.setNecklace(necklace);

        showHelp();
        separatorLine();
        System.out.println("Waiting for user input...");

        while (!(inputLine = scanner.nextLine()).equals("exit")) {

            try {
                Menu userIn = Menu.valueOf(inputLine.trim().toUpperCase());

                if (userIn == Menu.HELP) {
                    showHelp();
                    separatorLine();
                }
                if (userIn == Menu.LIST) {
                    printJewels(necklace);
                    separatorLine();
                }
                if (userIn == Menu.PRICE) {
                    System.out.println("Summary price is "
                            + PriceUtil.centsToDollars(necklaceUtil.summaryPrice()) + "$");
                    separatorLine();
                }
                if (userIn == Menu.WEIGHT) {
                    System.out.println("Summary weight is " + necklaceUtil.summaryWeight() + " ct");
                    separatorLine();
                }
                if (userIn == Menu.SORT) {
                    necklaceUtil.sortByPrice();
                    System.out.println("Jewels sorted by price:");
                    printJewels(necklace);
                    separatorLine();
                }
                if (userIn == Menu.ADD) {
                    try {
                        System.out.println("Type name and press enter:");
                        String name = scanner.nextLine();

                        System.out.println("Type weight and press enter:");
                        double weight = scanner.nextDouble();

                        System.out.println("Type price in $ and press enter:");
                        long price = PriceUtil.dollarsToCents(scanner.nextDouble());

                        System.out.println("Type refractive index and type enter:");
                        double refractiveIndex = scanner.nextDouble();
                        add(name, weight, price, refractiveIndex, necklace);
                    } catch (InputMismatchException ex) {
                        System.out.println("Input data is incorrect!");
                        separatorLine();
                    }
                }
                if (userIn == Menu.FIND) {
                    try {
                        System.out.println("Type refractive index from value:");
                        double from = scanner.nextDouble();

                        System.out.println("Type refractive index to value:");
                        double to = scanner.nextDouble();
                        find(from, to, necklaceUtil);
                    } catch (InputMismatchException ex) {
                        System.out.println("Input data is incorrect!");
                        separatorLine();
                    }
                }
            } catch (IllegalArgumentException ex){
                System.out.println("Input data is incorrect!");
                separatorLine();
            }

            System.out.println("Waiting for user input...");
        }
    }

    private static void add(String name, double weight, long price, double refractiveIndex, Necklace necklace) {
        Jewel jewel = new Jewel(name, weight, price, refractiveIndex);
        necklace.addJewel(jewel);

        System.out.println(jewel + " successfully added.");
        separatorLine();
    }

    private static void find(double from, double to, NecklaceUtil necklaceUtil) {

        List<Jewel> result = necklaceUtil.findByRefractiveIndexBetween(from, to);

        if (result.size() != 0) {
            result.forEach(System.out::println);
        } else {
            System.out.println("Necklace has no jewels with refractive index between " + from + " and " + to);
        }
        separatorLine();

    }

    private static void printJewels(Necklace necklace) {
        if (necklace.getJewels().size() != 0) {
            for (Jewel jewel : necklace.getJewels()) {
                System.out.println(jewel);
            }
        } else {
            System.out.println("Necklace has no jewels yet.");
        }
    }

    private static void showHelp() {
        System.out.println("Type 'list' to print all jewels in necklace;");
        System.out.println("\t 'add' to add new jewel to necklace;");
        System.out.println("\t 'price' to print summary price of necklace;");
        System.out.println("\t 'weight' to print summary weight of necklace;");
        System.out.println("\t 'sort' to sort jewels by price and print them;");
        System.out.println("\t 'find' to find jewels by refractive index;");
        System.out.println("\t 'help' to show available commands;");
        System.out.println("\t 'exit' to quit.");
    }

    private static void separatorLine() {
        System.out.println("------------------------------------\n");
    }

}
