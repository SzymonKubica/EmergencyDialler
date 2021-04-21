import java.util.Iterator;

public interface PriorityQueue<T> extends Iterable<T> {
  void add(Double priority, T element);

  T dequeue() throws UnsupportedOperationException;

  boolean isEmpty();

  Iterator iterator();
}
