package put.io.patterns.implement;

public class SystemInfoObserver implements SystemStateObserver{

    private SystemState state;

    @Override
    public void update(SystemMonitor monitor) {
        state = monitor.getLastSystemState();
        Info();
    }

    public void Info(){
        // Print information to the console
        System.out.println("============================================");
        System.out.println(String.format("CPU Load: %2.2f%%", state.getCpu()));
        System.out.println(String.format("CPU temperature: %.2f C", state.getCpuTemp()));
        System.out.println(String.format("Available memory: %.2f MB", state.getAvailableMemory()));
        System.out.println(String.format("USB devices: %d", state.getUsbDevices()));
    }
}
