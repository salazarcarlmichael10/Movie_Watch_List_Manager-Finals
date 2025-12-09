public class Queue {
    private String[] queue;
    private int vacant;
    private int capacity;

    public Queue() {
        this.queue = new String[10];
        this.capacity = 10;
        this.vacant = 0;
    }

    public Queue(int capacity) {
        this.queue = new String[capacity];
        this.capacity = capacity;
        this.vacant = 0;
    }

    public void enqueue(String item) {
        if (vacant >= capacity) {
            resize(capacity * 2);
        }
        this.queue[this.vacant] = item;
        this.vacant++;
    }

    public String dequeue() {
        if (vacant == 0) return null;

        String servingItem = this.queue[0];
        moveForward();
        return servingItem;
    }

    private void moveForward() {
        for (int i = 0; i < this.vacant - 1; i++) {
            this.queue[i] = this.queue[i + 1];
        }
        this.queue[vacant - 1] = null;
        this.vacant--;
    }

    private void resize(int newCapacity) {
        String[] newQueue = new String[newCapacity];
        for (int i = 0; i < vacant; i++) newQueue[i] = queue[i];
        queue = newQueue;
        capacity = newCapacity;
    }

    public int size() {
        return vacant;
    }

    public boolean isEmpty() {
        return vacant == 0;
    }

    public String[] getAll() {
        String[] result = new String[vacant];
        for (int i = 0; i < vacant; i++) result[i] = queue[i];
        return result;
    }
}