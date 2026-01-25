import java.util.concurrent.atomic.AtomicLong;

public class MonotonicCounter {
    private final AtomicLong value = new AtomicLong(0);

    public long next() {
        return value.incrementAndGet();
    }
}