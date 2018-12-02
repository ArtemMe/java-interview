package patterns.iterator;

public class IteratorApp {
    public static void main(String[] args) {
        ConcretteCollection c = new ConcretteCollection();
        Iterator i = c.getIterator();
        while (i.hasNext())
            System.out.println((String)i.next());
    }
}
interface Iterator{
    boolean hasNext();
    Object next();
}
interface SomeCollection{
    Iterator getIterator();
}

class ConcretteCollection implements SomeCollection{
    private String [] tasks = {"построить дом","посадить дерево","вырастить сына"};
    @Override
    public Iterator getIterator() {
        return new ConcretteIterator();
    }
    private class ConcretteIterator implements Iterator{
        private int index;
        @Override
        public boolean hasNext() {
            return index<tasks.length;
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}

