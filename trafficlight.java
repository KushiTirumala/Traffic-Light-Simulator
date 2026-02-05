public class TrafficLight implements Runnable {

    private String lightName;
    private int greenTime;

    public TrafficLight(String lightName, int greenTime) {
        this.lightName = lightName;
        this.greenTime = greenTime;
    }

    @Override
    public void run() {
        try {
            System.out.println(lightName + " is GREEN");
            Thread.sleep(greenTime);
            System.out.println(lightName + " is RED");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted for " + lightName);
        }
    }
}
