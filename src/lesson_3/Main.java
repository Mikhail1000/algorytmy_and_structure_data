package lesson_3;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16};

        /*int missElement = findMissElementBinary(array);
        System.out.println("Потерянный элемент = " + missElement);*/

        DequeMy deque = new DequeMy(10);
        deque.insertRight(1);
        deque.insertRight(3);
        deque.display();
        deque.insertLeft(0);
        deque.display();
        deque.removeLeft();
        deque.display();
    }

    private static int findMissElementBinary(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start <= end) {
            int base = (start + end) / 2;

            if (array[base] - base == 1) {
                start = base + 1;
            } else {
                end = base - 1;
            }
        }
        return start + 1;
    }

    /*private static int findMissElementBinary(int[] array) {
        int start = 0;
        int end = array.length - 1;
        System.out.println("Длина массива " + end);
        int base;
        //int i = 0;
        int missElement = -1;
        //int middleArray = array.length/2;

        while (missElement == -1){

            base = (start + end) / 2;
            System.out.println("Base " + base);

            if (array[base - 1] == base + 1 && array[base - 2] == base - 1) {
                missElement = base;
                System.out.println("missElement " + missElement);
            } else if (array[base + 1] - array[base] != 1) {
                missElement = base + 2;
                System.out.println("missElement " + missElement);
            }

            else if (array[base - 1] == base) {
                start = base + 1;
                System.out.println("Start " + start);
            }
            else if (array[base - 1] > base) {
                end = base - 1;
                System.out.println("End " + end);
            }

        }

        return missElement;
    }*/

}
