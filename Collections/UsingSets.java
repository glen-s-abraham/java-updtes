package Collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class UsingSets {
    public static void main(String[] args) {
        // factoryMethods();
        treeSet();
        hashSet();
        linkedHashSet();
    }

    public static void factoryMethods() {
        Set<String> of = Set.of("a", "b", "c");
        Set<String> copy = Set.copyOf(of);

        of.add("d"); // UnsupportedOperationException
        copy.add("d");// UnsupportedOperationException
        of.remove("a");// UnsupportedOperationException

    }

    public static void treeSet() {
        Set<String> names = new TreeSet<>();
        names.add("John");
        names.add("John");
        names.add("Helen");
        names.add("Ann");

        System.out.println(names);

        Set<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(Integer.valueOf("21"));
        numbers.add(Integer.valueOf("11"));
        numbers.add(99);

        System.out.println(numbers);
    }

    public static void hashSet() {
        Set<Contact> contactsHS = new HashSet<>();
        contactsHS.add(new Contact("John", 25));
        contactsHS.add(new Contact("John", 25));
        contactsHS.add(new Contact("John", 25));
        contactsHS.add(new Contact("alice", 34));
        contactsHS.add(new Contact("Andrew", 35));
        contactsHS.add(new Contact("Brian", 36));

        for (Contact contact : contactsHS) {
            System.out.println(contact);
        }
        System.out.println();
    }

    public static void linkedHashSet() {
        Set<Contact> contactsHS = new LinkedHashSet<>();
        contactsHS.add(new Contact("John", 25));
        contactsHS.add(new Contact("John", 25));
        contactsHS.add(new Contact("John", 25));
        contactsHS.add(new Contact("alice", 34));
        contactsHS.add(new Contact("Andrew", 35));
        contactsHS.add(new Contact("Brian", 36));

        for (Contact contact : contactsHS) {
            System.out.println(contact);
        }
    }
}

class Contact {
    private int age;
    private String name;

    // Constructor
    public Contact(String name, int age) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.age = age;
        this.name = name;
    }

    // hashCode
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + (name == null ? 0 : name.hashCode());
        return result;
    }

    // equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Contact other = (Contact) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            return other.name == null;
        } else {
            return name.equals(other.name);
        }
    }

    // toString
    @Override
    public String toString() {
        return "Contact [age=" + age + ", name=" + name + "]";
    }
}
