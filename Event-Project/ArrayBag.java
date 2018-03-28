package projectevents;
public class ArrayBag<T> implements BagInterface<T>{
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 5;
    private T[] bag;
    
    public ArrayBag()
    {
        numberOfEntries = 0;
        bag = (T[]) new Object[DEFAULT_CAPACITY];
    }
    
    @Override
    public int getCurrentSize()
    {
        return numberOfEntries;
    }
    
    @Override
    public boolean isFull()
    {
        return bag.length == numberOfEntries;
    }
    
    @Override
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }
        
    @Override
    public boolean add(T newEntry)
    {
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return false;
    }
    
    @Override
    public T remove()
    {
        T result = null;
        if (!isEmpty())
        {
            numberOfEntries--;
            result = bag[numberOfEntries];
            bag[numberOfEntries] = null;
        }
        return result;
    }
    
    @Override
    public boolean remove(T anEntry)
    {
        for(int i = 0; i < bag.length; i++)
        {
            if (anEntry == bag[i])
            {
                bag[i] = bag[numberOfEntries - 1];
                bag[numberOfEntries - 1] = null;
                numberOfEntries--;
            }
        }
        
        return true;
    }
    
    @Override
    public void clear()
    {
        while (!isEmpty())
            remove();
    }
    
    @Override
    public int getFrequencyOf(T anEntry)
    {
        int counter = 0;
        for(int index = 0; index < numberOfEntries; index++)
        {
            if(anEntry.equals(bag[index]))
                counter++;
        }
        return counter;
    }
    
    @Override
    public boolean contains(T anEntry)
    {
        boolean found = false;
        
        for(int index = 0; !found && (index < numberOfEntries); index++)
        {
            if (anEntry.equals(bag[index]))
                found = true;
        }
        return found;
    }
    
    @Override
    public T[] toArray()
    {
        T[] result = (T[]) new Object[numberOfEntries];
        for(int index = 0; index < numberOfEntries; index++)
            result[index] = bag[index];
        return result;
    }
    
    @Override
    public String toString()
    {
        String str = "";
        for(int i = 0; i < numberOfEntries; i++)
        {
            str = str + bag[i];
        }
        
        return str;
    }
}
