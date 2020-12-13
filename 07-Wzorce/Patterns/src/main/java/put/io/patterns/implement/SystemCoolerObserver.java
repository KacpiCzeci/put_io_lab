package put.io.patterns.implement;

public class SystemCoolerObserver implements SystemStateObserver {
    SystemState state = null;

    @Override
    public void update(SystemMonitor monitor) {
        state = monitor.getLastSystemState();
        Cooler();
    }

    public void Cooler() {

        // Increase CPU cooling if the temperature is to high
        if (state.getCpuTemp() > 60.00) {
            System.out.println("> Increasing cooling of the CPU...");
        }
    }


}
