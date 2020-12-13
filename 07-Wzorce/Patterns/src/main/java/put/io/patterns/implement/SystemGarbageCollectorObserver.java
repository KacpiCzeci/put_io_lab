package put.io.patterns.implement;

public class SystemGarbageCollectorObserver implements SystemStateObserver{

    SystemState state = null;

    @Override
    public void update(SystemMonitor monitor) {
        state = monitor.getLastSystemState();
        GarbageCollector();
    }

    public void GarbageCollector() {
        // Run garbage collector when out of memory
        if (state.getAvailableMemory() < 200.00) {
            System.out.println("> Running garbage collector...");
        }

    }


}
