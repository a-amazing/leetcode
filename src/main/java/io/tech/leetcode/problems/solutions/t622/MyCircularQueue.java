package io.tech.leetcode.problems.solutions.t622;

/**
 * @author:wangyi
 * @Date:2022/8/2
 */
class MyCircularQueue {

    private int first;
    private int last;
    private int k;
    private int[] array;

    public MyCircularQueue(int k) {
        array = new int[k];
        first = -1;
        last = -1;
        this.k = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        if (first == -1) {
            array[0] = value;
            first = 0;
            last = 0;
        } else {
            last++;
            array[last] = value;
        }
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        if (last == first && last != -1) {
            last = -1;
            first = -1;
        } else {
            if (last == 0) {
                last = k - 1;
            } else {
                last--;
            }
        }

        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return array[first];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return array[last];
    }

    public boolean isEmpty() {
        return first == last && last == -1;
    }

    public boolean isFull() {
        return (last == first - 1) ||(first == 0 && last == k - 1);
    }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(8);
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(9));
        System.out.println(queue.enQueue(5));
        System.out.println(queue.enQueue(0));

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.Rear());
        System.out.println(queue.Rear());
        System.out.println(queue.deQueue());
    }
}