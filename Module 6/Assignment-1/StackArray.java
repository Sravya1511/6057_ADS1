class StackArray {
    int[] array;
    int size;

    StackArray(int n) {
        array = new int[n];
        size = 0;
    }

    public void push(int item) {
        array[size++] = item;
    }

    public int pop() {
        if(size == 0) {
            return 0;
        }
        int a = array[size-1];
        size--;
        return a;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public int peek() {
        int a = size-1;
        return array[a];
    }
    public int size() {
        return size;
    }

}
