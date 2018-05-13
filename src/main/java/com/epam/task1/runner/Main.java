package com.epam.task1.runner;

import com.epam.task1.model.Jewel;
import com.epam.task1.model.Necklace;
import com.epam.task1.util.NecklaceUtil;
import com.epam.task1.util.PriceUtil;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class);

    private static final String HELP = "\nType 'create' to create new necklace;\n" +
                                        "\t 'list' to print all jewels in necklace;\n" +
                                        "\t 'add' to add new jewel to necklace;\n" +
                                        "\t 'price' to print summary price of necklace;\n" +
                                        "\t 'weight' to print summary weight of necklace;\n" +
                                        "\t 'sort' to sort jewels by price and print them;\n" +
                                        "\t 'find' to find jewels by refractive index;\n" +
                                        "\t 'help' to show available commands;\n" +
                                        "\t 'exit' to quit.\n";

    public static void main(String[] args) {
        Scanner mainScanner = new Scanner(System.in);
        Scanner additionalScanner = new Scanner(System.in);
        String inputLine;

        Necklace necklace = new Necklace();
        NecklaceUtil necklaceUtil = new NecklaceUtil();

        showHelp();
        LOG.info("Waiting for user input...");

        while (!(inputLine = mainScanner.nextLine()).equals("exit")) {
            LOG.debug("User input - " + inputLine);
            try {
                Menu userIn = Menu.valueOf(inputLine.trim().toUpperCase());

                if (userIn == Menu.CREATE){
                        LOG.info("Enter name for new necklace:");
                        String name = additionalScanner.nextLine();

                        necklace = new Necklace(name);
                        necklaceUtil.setNecklace(necklace);

                        LOG.info("Necklace '" + name + "' created.");
                }
                if (userIn == Menu.HELP) {
                    showHelp();
                }
                if (userIn == Menu.LIST) {
                    printJewels(necklace.getJewels(), "Necklace has no jewels yet");
                }
                if (userIn == Menu.PRICE) {
                    LOG.info("Summary price is "
                            + PriceUtil.centsToDollars(necklaceUtil.summaryPrice()) + "$");
                }
                if (userIn == Menu.WEIGHT) {
                    LOG.info("Summary weight is " + necklaceUtil.summaryWeight() + " ct");
                }
                if (userIn == Menu.SORT) {
                    necklaceUtil.sortByPrice();
                    LOG.info("Jewels sorted by price:");
                    printJewels(necklace.getJewels(), "Necklace has no jewels.");
                }
                if (userIn == Menu.ADD) {
                    try {
                        LOG.info("Type name and press enter:");
                        String name = additionalScanner.nextLine();

                        LOG.info("Type weight and press enter:");
                        double weight = additionalScanner.nextDouble();

                        LOG.info("Type price in $ and press enter:");
                        long price = PriceUtil.dollarsToCents(additionalScanner.nextDouble());

                        LOG.info("Type refractive index and type enter:");
                        double refractiveIndex = additionalScanner.nextDouble();
                        add(name, weight, price, refractiveIndex, necklace);
                    } catch (InputMismatchException ex) {
                        LOG.error("Input data is incorrect!", ex);
                    }
                }
                if (userIn == Menu.FIND) {
                    try {
                        LOG.info("Type refractive index from value:");
                        double from = additionalScanner.nextDouble();

                        LOG.info("Type refractive index to value:");
                        double to = additionalScanner.nextDouble();
                        find(from, to, necklaceUtil);
                    } catch (InputMismatchException ex) {
                        LOG.error("Input data is incorrect!", ex);
                    }
                }
            } catch (IllegalArgumentException ex){
                LOG.error("Input data is incorrect!", ex);
            }

            LOG.info("Waiting for user input...");
        }
    }

    private static void add(String name, double weight, long price, double refractiveIndex, Necklace necklace) {
        Jewel jewel = new Jewel(name, weight, price, refractiveIndex);
        necklace.addJewel(jewel);

        LOG.info(jewel + " successfully added.");
    }

    private static void find(double from, double to, NecklaceUtil necklaceUtil) {
        List<Jewel> result = necklaceUtil.findByRefractiveIndexBetween(from, to);
        printJewels(result, "Necklace has no jewels with refractive index between " + from + " and " + to);
    }

    private static void printJewels(List<Jewel> jewels, String messageIfEmpty) {
        StringBuilder sb = new StringBuilder("\n");
        if (jewels.size() != 0) {
            for (Jewel jewel : jewels) {
                sb.append(jewel);
                sb.append("\n");
            }
        } else {
            sb.append(messageIfEmpty);
            sb.append("\n");
        }
        LOG.info(sb);
    }

    private static void showHelp() {
        LOG.info(HELP);
    }
}
