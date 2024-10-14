public interface ArrayADT  {
    void fill();
    void display();
    int getSize();
    int getLength();
    int search(int key);
    void append(int newItem);
    void insert(int index, int newItem);
    void delete(int index);
}
