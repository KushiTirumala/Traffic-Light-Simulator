public class CircularQueue {

    private TrafficLight[] queue;
    private int front = 0;
    private int rear = -1;
    private int size;

    public CircularQueue(int capacity) {
        queue = new TrafficLight[capacity];
        size = capacity;
    }

    public void enqueue(TrafficLight light) {
        rear = (rear + 1) % size;
        queue[rear] = light;
    }

    public TrafficLight dequeue() {
        TrafficLight light = queue[front];
        front = (front + 1) % size;
        return light;
    }
}
