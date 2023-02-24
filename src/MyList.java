public class MyList<T> {
    private int capacity;
    private int index = 0;
    T[] array;

    public MyList() {
        this.capacity = 10;
        this.array = (T[]) new Object[this.capacity];
    }

    public MyList(int capacity) {
        this.setCapacity(capacity);
        this.array = (T[]) new Object[this.capacity];
    }

    public int size() {
        int counter = 0;
        for (T a : array) {
            if (a != null) {
                counter++;
            }
        }
        return counter;
    }

    public void add(T data) {
        if (getIndex() < capacity) {
            this.array[getIndex()] = data;
        } else {
            setCapacity(getCapacity() * 2);
            T[] array = (T[]) new Object[getCapacity()];
            System.arraycopy(this.array, 0, array, 0, this.array.length);
            array[getIndex()] = data;
            this.setArray(array);
        }
        this.setIndex(getIndex() + 1);
    }

    public T get(int index) {
        return this.getArray()[index];
    }

    public void remove(int index) {
        if (index >= this.size() || index < 0) {
        } else {
            for (int i = index; i < this.array.length; i++) {
                if (i == this.array.length - 1) {
                    this.array[i] = null;
                    break;
                } else {
                    this.array[i] = this.array[i + 1];
                }
            }
        }
        this.setIndex(getIndex() - 1);

    }

    public String toString(){
        System.out.print("[ ");
        for (int i = 0; i < this.size(); i++){
            if (this.array[i] == null){
                break;
            }else {
                System.out.print(this.array[i]);
            }
            if (!(i == this.size() - 1)) {
                System.out.print(", ");
            }
        }
        return "]";
    }

    public int indexOf(T data){
        for (int i = 0; i < this.size(); i++){
            if (this.array[i] == data){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        for (int i = this.size()-1; i >= 0; i--){
            if (this.array[i] == data){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        for (T t : this.array){
            if ( t == null){
                return true;
            }
        }
        return false;
    }
    public T[] toArray() {
        return this.array;
    }

    public void clear(){
        for (int i = 0; i < this.array.length; i++){
            this.array[i] = null;
        }
    }
    public MyList<T> subList(int start,int finish) {
        MyList<T> list = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            list.add(this.array[i]);
        }
        return list;
    }

    public boolean contains(T data){
        for (T t: this.array){
            if (t == data){
                return true;
            }
        }
        return false;
    }

    public void set(int index, T data){
        this.array[index] = data;
    }
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }
}
