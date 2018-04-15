package main.com.epam.task1;

import main.com.epam.task1.model.Jewel;
import main.com.epam.task1.model.Necklace;
import main.com.epam.task1.util.NecklaceUtil;
import main.com.epam.task1.util.PriceUtil;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine;

        Necklace necklace = new Necklace();

        showHelp();
        separatorLine();
        System.out.println("Waiting for user input...");

        while (!(inputLine = scanner.nextLine()).equals("exit")){
            String trimmedIn = inputLine.trim();

            if ("help".equals(trimmedIn)){
                showHelp();
                separatorLine();
            }
            if ("list".equals(trimmedIn)){
                printJewels(necklace);
                separatorLine();
            }
            if ("price".equals(trimmedIn)){
                System.out.println("Summary price is "
                        + PriceUtil.centsToDollars(NecklaceUtil.summaryPrice(necklace)) + "$");
                separatorLine();
            }
            if ("weight".equals(trimmedIn)){
                System.out.println("Summary weight is " + NecklaceUtil.summaryWeight(necklace) + " ct");
                separatorLine();
            }
            if ("sort".equals(trimmedIn)){
                NecklaceUtil.sortByPrice(necklace);
                System.out.println("Jewels sorted by price:");
                printJewels(necklace);
                separatorLine();
            }
            if ("add".equals(trimmedIn)){
                add(scanner, necklace);
            }
            if ("find".equals(trimmedIn)){
                find(scanner, necklace);
            }

            System.out.println("Waiting for user input...");
        }
    }

    private static void add(Scanner scanner, Necklace necklace) {
        try {
            System.out.println("Type name and press enter:");
            String name = scanner.nextLine();

            System.out.println("Type weight and press enter:");
            double weight = scanner.nextDouble();

            System.out.println("Type price in $ and press enter:");
            long price = PriceUtil.dollarsToCents(scanner.nextDouble());

            System.out.println("Type refractive index and type enter:");
            double refractiveIndex = scanner.nextDouble();

            Jewel jewel = new Jewel(name, weight, price, refractiveIndex);
            necklace.addJewel(jewel);

            System.out.println(jewel + " successfully added.");
            separatorLine();

        } catch (InputMismatchException ex){
            System.out.println("Input data is incorrect!");
            separatorLine();
        }
    }

    private static void find(Scanner scanner, Necklace necklace) {
        try {
            System.out.println("Type refractive index from value:");
            double from = scanner.nextDouble();

            System.out.println("Type refractive index to value:");
            double to = scanner.nextDouble();

            List<Jewel> result = NecklaceUtil.findByRefractiveIndexBetween(necklace, from, to);

            if (result.size() != 0){
                result.forEach(System.out::println);
            } else {
                System.out.println("Necklace has no jewels with refractive index between " + from + " and " + to);
            }
            separatorLine();

        } catch (InputMismatchException ex){
            System.out.println("Input data is incorrect!");
            separatorLine();
        }
    }

    private static void printJewels(Necklace necklace) {
        if (necklace.getJewels().size() != 0) {
            necklace.getJewels().forEach(System.out::println);
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

    private static void separatorLine(){
        System.out.println("------------------------------------\n");
    }

}
