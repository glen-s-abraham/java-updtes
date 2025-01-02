package Collections;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Book {
    private String title;
    private Double price;

    public Book(String title, Double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public String toString() {
        return title + " " + price;
    }

}

public class UsingQueues {
    public static void main(String[] args) {
        linkedListQueue();
        arrayDeque();
        priorityQueueNaturalOrdering();
        priorityQueueDifferentOrdering();
    }

    private static void linkedListQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.offer(2);
        queue.add(3);
        queue.offer(4);

        System.out.println(queue.element());
        System.out.println(queue.peek());
        System.out.println(queue);

        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println(queue);
    }

    private static void arrayDeque() {
        Deque<Integer> numbers = new ArrayDeque<>();
        numbers.add(1);
        numbers.addFirst(2);
        numbers.offerFirst(3);
        System.out.println("Head: " + numbers.getFirst() + " . Head: " + numbers.peekFirst());

        numbers.addLast(4);
        numbers.offerLast(5);

        numbers.removeFirst();
        numbers.pollFirst();
        numbers.removeLast();
        numbers.pollLast();
        System.out.println(numbers);
    }

    public static void priorityQueueNaturalOrdering() {
        Queue<String> names = new PriorityQueue<>();
        names.add("V");
        names.add("P");
        names.add("A");

        Iterator itNames = names.iterator();

        while (itNames.hasNext()) {
            System.out.println(names.poll() + " ");
        }

        Queue<Integer> numbers = new PriorityQueue<>();
        numbers.add(11);
        numbers.add(5);
        numbers.add(2);

        Iterator itNumbers = numbers.iterator();

        while (itNumbers.hasNext()) {
            System.out.println(numbers.poll() + " ");
        }

    }

    public static void priorityQueueDifferentOrdering() {
        Comparator<Book> comparatorTitle = Comparator.comparing(book -> book.getTitle());

        Queue<Book> booksByTitle = new PriorityQueue<>(comparatorTitle);
        booksByTitle.add(new Book("Java", 55.0));
        booksByTitle.add(new Book("Python", 23.0));
        booksByTitle.add(new Book("C++", 99.0));

        Iterator itNames = booksByTitle.iterator();

        while (itNames.hasNext()) {
            System.out.println(booksByTitle.poll() + " ");
        }

    }

}
