import java.util.List;
import java.util.LinkedList;

/**
 * A hash table of strings.
 * 
 * @author Stefan Nilsson
 * @version 2010-07-21
 */
public class HashSet implements StringDictionary { 
    private List<String>[] table;

    /**
     * Creates a hash table with the given capacity.
     * 
     * @throws IllegalArgumentException if capacity &lt;= 0.
     */
    public HashSet(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity=" + capacity);

        // We want to do the following:
        //
        //     table = new LinkedList<String>[capacity];
        //
        // However, that won't compile ("generic array creation")
        // since Java generics and arrays don't get along very well.
        // Instead we need to do the following:
        //
        //     table = new LinkedList[capacity];
        //
        // The above will compile, but with a warning. The proper
        // approach is to document why the warning can be safely
        // ignored and then suppress the warning. Thus:

        /* 
         * This array will contain only LinkedList<String>
         * instances, all created in the add method. This
         * is sufficient to ensure type safety.
         */
        @SuppressWarnings("unchecked") // for this declaration only
        List<String>[] t = new LinkedList[capacity];
        
        table = t;
    }

    /**
     * Adds the given string to this dictionary.
     * Returns <code>true</code> if the dictionary
     * did not already contain the given string.
     *
     * Complexity: O(1) expected time.
     */
    @Override
    public boolean add(String s) {
        if(s == null || contains(s)) {
            return false;
        }
        int index = getListIndex(s);
        List<String> list = table[index];
        if(list == null) {
            list = table[index] = new LinkedList<String>();
        }
        list.add(0,s);
        return true;
    }

    /**
     * Removes the given string from this dictionary
     * if it is present. Returns <code>true</code> if
     * the dictionay contained the specified element.
     *
     * Complexity: O(1) expected time.
     */
    @Override
    public boolean remove(String s) {
        if(s == null || !contains(s)) {
            return false;
        }
        List<String> list = getList(s);
        if(list == null) {
            return false;
        }
        boolean didRemove = list.remove(s);
        assert didRemove;
        return didRemove;
    }

    /**
     * Returns <code>true</code> if the string is
     * in this dictionary.
     *
     * Complexity: O(1) expected time.
     */
    @Override
    public boolean contains(String s) {
        if(s == null) {
            return false;
        }
        List<String> list = getList(s);
        if(list == null) {
            return false;
        }
        boolean contains = list.contains(s);
        return contains;
    }

    private List<String> getList(String s) {
        int index = getListIndex(s);
        List<String> list = table[index]; 
        return list;      
    }
    private int getHashCode(String s) {
        int hashCode = 0;
        int l = s.length();
        int multiplier = 1;
        for(int i = l; i > 0; i--) {
            int val = s.charAt(i-1)*multiplier;
            hashCode += val;
            multiplier *= 31;
        }
        return hashCode;
    }

    private int getListIndex(String s) {
        int hashCode = getHashCode(s);
        int n = table.length;
        return Math.abs(hashCode % n);
    }
 }