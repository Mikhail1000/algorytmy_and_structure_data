package com.company;

import java.util.Random;

public class Main {


    static String[] manufacturers = new String[]{"Lenovo", "Asus", "MacNote", "Aser", "Xiaomi"};
    static int[] numberOperateMember = new int[]{4, 8, 12};

    public static void main(String[] args) {

        int n = 5000;
        Notebook[] notebooks = new Notebook[n];
        Notebook[] notebooksSortManufacturer;
        Notebook[] notebooksSortOperateMember;
        Notebook[] notebooksSortPrice;
        Random random = new Random();

        for (int i = 0; i < n; i++) {

            notebooks[i] = new Notebook((random.nextInt(16) * 100) + 500, (random.nextInt(3) + 1) * 4, manufacturers[random.nextInt(5)]);
        }

        notebooksSortManufacturer = sortManufacturer(notebooks);
        notebooksSortOperateMember = sortOperateMember(notebooksSortManufacturer);
        notebooksSortPrice = sortPrice(notebooksSortOperateMember);

        for (int i = 0; i < notebooksSortPrice.length; i++) {
            System.out.println(notebooksSortPrice[i].toString());
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

    private static Notebook[] sortPrice(Notebook[] notebooks) {
        for (int i = 1; i < notebooks.length; i++) {
            Notebook tempNotebook = notebooks[i];
            int j = i - 1;
            while (j >= 0 && notebooks[j].getPrice() > tempNotebook.getPrice()) {
                notebooks[j + 1] = notebooks[j];
                j--;
            }
            notebooks[j + 1] = tempNotebook;
        }
        return notebooks;
    }


}
