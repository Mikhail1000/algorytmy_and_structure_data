package com.company;

import java.util.Random;

public class Main {


    static String[] manufacturers = new String[]{"Lenovo", "Asus", "MacNote", "Aser", "Xiaomi"};
    static int[] numberOperateMember = new int[]{4, 8, 12};

    public static void main(String[] args) {

        int n = 20;
        Notebook[] notebooks = new Notebook[n];
        Notebook[] notebooksSortManufacturer = new Notebook[n];
        Notebook[] notebooksSortOperateMember = new Notebook[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {

            notebooks[i] = new Notebook(random.nextInt(1500) + 500, (random.nextInt(3) + 1) * 4, manufacturers[random.nextInt(5)]);
        }

        notebooksSortManufacturer = sortManufacturer(notebooks);
        notebooksSortOperateMember = sortOperateMember(notebooksSortManufacturer);

        for (int i = 0; i < notebooksSortOperateMember.length; i++) {
            System.out.println(notebooksSortOperateMember[i].toString());
        }

    }

    private static Notebook[] sortManufacturer(Notebook[] notebooks) {
        int j = 0;

        Notebook[] sortNotebooks = new Notebook[notebooks.length];
        for (int i = manufacturers.length - 1; i >= 0; i--) {
            for (int k = 0; k < notebooks.length; k++) {
                if (notebooks[k].getManufacturer().equals(manufacturers[i])) {
                    sortNotebooks[j] = notebooks[k];
                    j++;
                }
            }
        }
        return sortNotebooks;
    }

    private static Notebook[] sortOperateMember(Notebook[] notebooks) {
        int j = 0;

        Notebook[] sortNotebooks = new Notebook[notebooks.length];
        for (int i = numberOperateMember.length - 1; i >= 0; i--) {
            for (int k = 0; k < notebooks.length; k++) {
                if (notebooks[k].getSizeOperateMember() == numberOperateMember[i]) {
                    sortNotebooks[j] = notebooks[k];
                    j++;
                }
            }
        }
        return sortNotebooks;
    }


}
