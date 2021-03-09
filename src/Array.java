public class Array {

    // BUILD DYNAMIC FROM SCRATCH
    private int[] items;
    private int count;

    // 1, Constructor function
    public Array(int length){
        items = new int[length];
    }

    // 2, Print function
    public void print(){
        for(int i=0;i<count;i++)
            System.out.println(items[i]);
    }

    // 3, Insert function
    public void insert(int item){
        // If array is full
        resizeArray();
        // Insert into last
        items[count++] = item;
    }

    // 4, InsertAt function
    public void insertAt(int item,int index){
        // Validate index
        if(index < 0 || index >= count)
            throw new IllegalArgumentException();

        // If array is full
        resizeArray();

        // Insert item
        for(int i=count-1;i>=index;i--)
            items[i + 1] = items[i];

        items[index] = item;
        count++;
    }

    // 5, IndexOf function
    public int indexOf(int item){
        // O(n)
        for(int i=0;i<count;i++){
            if(items[i] == item)
                return i;
        }
        return -1;
    }

    // 6, Max funtion
    public int max(){
        int max=0;
        for(int i=0;i<count;i++)
            if(items[i] > max) max = items[i];
        return max;
    }

    // 7, Min funtion
    public int min(){
        int min=0;
        for(int i=0;i<count;i++)
            if(items[i] < min) min = items[i];
        return min;
    }

    // 8, Reverse funtion
    public void reverse(){
        int[] newItems = new int[count];

        for(int i=0; i<count;i++){
            newItems[i] = items[count - 1 - i];
        }

        items = newItems;
    }

    // 9, Intersect funtion
    public Array intersect(Array other){
        var intersect = new Array(count);

        for(int item: items){
            if(other.indexOf(item) >= 0)
                other.insert(item);
        }

        return intersect;
    }

    // Helper funtion
    public void resizeArray(){
        if(items.length == count) {
            // Create new a array (size by two)
            int[] newItems = new int[count * 2];

            // Copy all value of items in new array
            for(int i=0;i<count;i++)
                newItems[i] = items[i];

            // Assign new array to items
            items = newItems;
        }
    }
}
