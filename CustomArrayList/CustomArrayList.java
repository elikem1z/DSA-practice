import java.util.Arrays;


//Make the class generic with <T>
public class CustomArrayList<T> { 
    private T[] elements;
    private int currentSize;
    private int capacity;

    //Default constructor with initial capacity of 10
    public CustomArrayList() {
        this(10);
    }

    //Constructor with specified initial capacity
    public CustomArrayList(int size) {
        this.elements = (T[]) new Object[size];
        this.currentSize = 0;
        this.capacity = size;
    }

    /**
     * Adds an element to the end of the list.
     * @param element The element to be added.
     */
    public void add(T element) {
        // Resize array if full
        if (currentSize == capacity) {
            resize();
        }
        elements[currentSize++] = element;
    }

    /**
     * Removes the element at the specified index.
     * @param index The index of the element to be removed.
     * @return The removed element.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        T removedElement = elements[index];
        // Shift elements to the left to fill the gap
        for (int i = index; i < currentSize - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--currentSize] = null; // Clear the last element
        return removedElement;
    }

    /**
     * Removes the specified element from the list.
     * @param element The element to be removed.
     * @return The removed element or null if not found.
     */
    public T remove(T element) {
        for (int i = 0; i < currentSize; i++) {
            if (elements[i].equals(element)) {
                return remove(i);
            }
        }
        return null; // Element not found
    }

    /**
     * Returns the element at the specified index.
     * @param index The index of the element to return.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public T get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        return elements[index];
    }

    /**
     * Returns the current size of the list.
     * @return The number of elements in the list.
     */
    public int size() {
        return currentSize;
    }

    /**
     * Checks if the list is empty.
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Displays the list contents in the format: [element1, element2,...]
     * @return A string representation of the list.
     */
    public String display() {
        StringBuilder displayString = new StringBuilder("[");
        for (int i = 0; i < currentSize; i++) {
            displayString.append(elements[i]);
            if (i < currentSize - 1) {
                displayString.append(", ");
            }
        }
        displayString.append("]");
        return displayString.toString();
    }

    /**
     * Modifies the element at the specified index.
     * @param index The index of the element to be modified.
     * @param element The new element to set.
     */
    public void set(int index, T element) {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        elements[index] = element;
    }

    //Private helper method to resize the internal array
    private void resize() {
        capacity *= 2; // Double the capacity
        elements = Arrays.copyOf(elements, capacity);
    }
}
