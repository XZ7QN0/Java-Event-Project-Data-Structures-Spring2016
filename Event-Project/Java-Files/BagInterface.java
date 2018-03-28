package projectevents;
public interface BagInterface<T>{

    public int getCurrentSize(); //new
    
    public boolean isFull();
    
    public boolean isEmpty();
    
    public boolean add(T newEntry);
    
    public T remove();
    
    public boolean remove(T anEntry);
    
    public void clear();

    public int getFrequencyOf(T anEntry); //new

    public boolean contains(T anEntry); //new

    public T[] toArray(); //new
}