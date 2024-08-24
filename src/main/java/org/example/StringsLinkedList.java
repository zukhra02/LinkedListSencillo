package org.example;

public class StringsLinkedList {
    Node first = new Node();  // Nodo ficticio inicial
    Node last = new Node();   // Nodo ficticio final

    public StringsLinkedList() {
        // Inicializar first y last para que apunten a null en una lista vacía
        first.next = null;
        last.prev = null;
    }

    public void printAll() {
        Node currentElement = first.next;  // Empezar después del nodo ficticio inicial
        while (currentElement != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public void add(String value) {
        Node node = new Node();  // Crear un nuevo nodo
        node.value = value;

        if (first.next == null) {  // Lista vacía, añadir el primer elemento
            first.next = node;
            node.prev = first;
            last.prev = node;
        } else {
            Node lastNode = last.prev;  // Último nodo real (antes del ficticio final)
            lastNode.next = node;
            node.prev = lastNode;
            last.prev = node;  // Actualizar la referencia de 'last' al nuevo nodo
        }
    }

    public static class Node {
        Node prev;  // Referencia al nodo anterior
        String value;  // Valor del nodo
        Node next;  // Referencia al siguiente nodo
    }

    public static void main(String[] args) {
        StringsLinkedList list = new StringsLinkedList();

        list.add("Hello");
        list.add("World");
        list.add("This");
        list.add("Is");
        list.add("A");
        list.add("Test");

        list.printAll();  // Debería imprimir: Hello, World, This, Is, A, Test
    }
}