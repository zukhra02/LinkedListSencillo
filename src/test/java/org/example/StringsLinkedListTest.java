package org.example;


import org.junit.Test;

import static org.junit.Assert.*;

public class StringsLinkedListTest {

    private StringsLinkedList list;

    @Test
    public void testEmptyList() {
        StringsLinkedList list = new StringsLinkedList();
        assertNull(list.first.next); // La lista debe estar vacía inicialmente
        assertNull(list.last.prev);  // No se han añadido elementos
    }

    @Test
    public void testAddSingleElement() {
        StringsLinkedList list = new StringsLinkedList();
        list.add("OnlyOne");

        assertEquals("OnlyOne", list.first.next.value);
        assertEquals("OnlyOne", list.last.prev.value);
        assertNull(list.first.next.next);  // Después del único elemento, no debe haber nada
    }

    @Test
    public void testAddMultipleElements() {
        StringsLinkedList list = new StringsLinkedList();
        list.add("First");
        list.add("Second");
        list.add("Third");

        StringsLinkedList.Node firstNode = list.first.next;
        assertEquals("First", firstNode.value);
        assertEquals("Second", firstNode.next.value);
        assertEquals("Third", firstNode.next.next.value);
        assertNull(firstNode.next.next.next); // El siguiente después del último debe ser null
    }

    @Test
    public void testListSize() {
        StringsLinkedList list = new StringsLinkedList();
        list.add("One");
        list.add("Two");

        // Contar manualmente los nodos para verificar el tamaño
        int size = 0;
        StringsLinkedList.Node current = list.first.next;
        while (current != null) {
            size++;
            current = current.next;
        }

        assertEquals(2, size); // El tamaño debe coincidir con el número de elementos añadidos
    }
}


