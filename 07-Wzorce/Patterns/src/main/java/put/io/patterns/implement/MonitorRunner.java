package put.io.patterns.implement;

public class MonitorRunner {

    public static void main(String args[]){
        SystemMonitor monitor = new SystemMonitor();

        SystemStateObserver infObserver = new SystemInfoObserver();
        monitor.addSystemStateObserver(infObserver);

        SystemStateObserver CoolerObserver = new SystemCoolerObserver();
        monitor.addSystemStateObserver(CoolerObserver);

        SystemStateObserver GarbageCollectorObserver = new SystemGarbageCollectorObserver();
        monitor.addSystemStateObserver(GarbageCollectorObserver);

        SystemStateObserver USBDeviceObserver = new SystemUSBDeviceObserver();
        monitor.addSystemStateObserver(USBDeviceObserver);


        while (true) {

            monitor.probe();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
