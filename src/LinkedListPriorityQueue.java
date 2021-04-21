import java.util.Iterator;

public class LinkedListPriorityQueue<T> implements PriorityQueue<T> {
  private Node<T> head;
  private int size = 0;

  @Override
  public void add(Double priority, T element) {
    if (head == null) {
      head = new Node<>(priority, element);
    } else if (head.getPriority() > priority) {
      prependNewNode(priority, element);
    } else {
      Node<T> predecessor = findPosition(priority);
      if (predecessor.getNext() != null) {
        disconnectAtAndAddNewNode(predecessor, priority, element);
      } else {
        appendNewNode(predecessor, priority, element);
      }
    }
  }

  private void prependNewNode(double priority, T element) {
    Node<T> newHead = new Node<>(priority, element);
    newHead.setNext(head);
    head = newHead;
  }

  private void disconnectAtAndAddNewNode(Node<T> predecessor, double priority, T element) {
    assert predecessor.getNext() != null;
    Node<T> successor = predecessor.getNext();
    Node<T> newNode = new Node<>(priority, element);
    predecessor.setNext(newNode);
    newNode.setNext(successor);
  }

  private void appendNewNode(Node<T> predecessor, double priority, T element) {
    assert predecessor.getNext() == null;
    predecessor.setNext(new Node<>(priority, element));
  }

  private Node<T> findPosition(Double priority) {
    assert head != null;
    Node<T> current = head;
    while (current.getPriority() < priority && current.getNext() != null) {
      current = current.getNext();
    }
    return current;
  }

  @Override
  public T dequeue() throws UnsupportedOperationException {
    T result = head.getValue();
    head = head.getNext();
    return result;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public Iterator iterator() {
    return null;
  }
}
