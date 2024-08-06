import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Timer;

public class HelloWorld {
    public static void main(String[] args) {
        MeterRegistry registry = new SimpleMeterRegistry();

        Counter helloCounter = Counter.builder("hello_count")
                .description("Number of hello messages")
                .register(registry);

        Timer helloTimer = Timer.builder("hello_timer")
                .description("Time taken to process hello message")
                .register(registry);

        helloCounter.increment();
        helloTimer.start();
        // Simulate some work
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        helloTimer.stop();

        System.out.println("Hello, World!");
    }
}
