package lesson_3;

public class DequeMy<E> implements DequeInterface<E> {

    private int maxSize;
    private E[] data;
    private final int FRONT_DEFAULT = 0;
    private final int REAR_DEFAULT = -1;

    private int front;
    private int rear;
    private int size;

    public DequeMy(int maxSize) {
        this.maxSize = maxSize;
        this.data = (E[]) new Object[maxSize];
        this.front = FRONT_DEFAULT;
        this.rear = REAR_DEFAULT;
        this.size = 0;
    }

    @Override
    public boolean insertLeft(E value) {
        if (isFull()) {
            return false;
        }
        if (front == 0) {
            front = maxSize;
        }
        data[--front] = value;
        size++;
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        if(isFull()) {
            return false;
        }
        data[++rear] = value;
        size++;
        return true;
    }

    @Override
    public E removeLeft() {
        if (isEmpty()) {
            return null;
        }
        E value = data[front++];
        if (front == maxSize) {
            front = 0;
        }
        size--;
        return value;
    }

    @Override
    public E removeRight() {
        return null;
    }

    @Override
    public E peekFront() {
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean isFull() {
        return (size == maxSize);
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("--> [");
        int tempFront = front;

        while (tempFront != rear + 1) {
            if (tempFront == maxSize) {
                tempFront = 9;
            }
            sb.append(data[tempFront]);
            if (tempFront != rear) {
                sb.append(", ");
            }

            if (tempFront == maxSize - 1) {
                tempFront = 0;
                continue;
            }
            tempFront++;
        }
        sb.append("]");

        return sb.toString();
    }
}
