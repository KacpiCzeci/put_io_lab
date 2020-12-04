package put.io.patterns.implement;

public class SystemUSBDeviceObserver implements SystemStateObserver{
    SystemState curState = null;
    SystemState formState = null;

    @Override
    public void update(SystemMonitor monitor) {
        formState = curState;
        curState = monitor.getLastSystemState();
        if(formState == null){
            formState = curState;
        }
        USBDevice();
    }

    public void USBDevice() {
        // Run garbage collector when out of memory
        if (curState.getUsbDevices() > formState.getUsbDevices()) {
            System.out.println("new usb device connected");
        }
        if (curState.getUsbDevices() < formState.getUsbDevices()){
            System.out.println("some usb device disconnected");
        }

    }
}
