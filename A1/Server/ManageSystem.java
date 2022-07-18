import Devices.Bulbulator;
import Devices.Cooker;
import Devices.Kettle;
import Devices.Stove;
import SmartHome.*;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Value;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ManageSystem implements SmartHome.ManageSystem{

    List<SmartDeviceInfo> devices = new CopyOnWriteArrayList<>();
    ObjectAdapter adapter;
    private int devCounter;

    public ManageSystem(ObjectAdapter adapter) {
        this.adapter = adapter;
    }

    public void addDevice( String category, SmartDevice device){
        System.out.println("Add device " + device.getType(new Current()) );

        devices.add( new SmartDeviceInfo("dev" + devCounter, category, device.getType(null)));
        adapter.add(device, new Identity("dev" + devCounter, category));
        devCounter++;
    }


    @Override
    public SmartDeviceInfo[] getDevicesList(Current current) {
        System.out.println("Get devices list");
        return devices.toArray(new SmartDeviceInfo[1]);
    }

    @Override
    public void addKettle(KettleTypes kettleType,String description, Current current) {
        System.out.println("Add kettle " + kettleType + " " + description);
        addDevice("kettle", new Kettle(kettleType, description));
    }

    @Override
    public void addBulbulator(String description,  Current current) {
        System.out.println("Add bulbulator  " + description);
        addDevice("bulbulator", new Bulbulator(description));
    }

    @Override
    public void addStove(StoveFuel fuelType,String description, Current current) {
        System.out.println("Add Stove " + fuelType + " " + description);
        addDevice("stove", new Stove(fuelType, description));
    }

    @Override
    public void addCooker(CookerTypes cookerType,String description, Current current) {
        System.out.println("Add Cooker " + cookerType + " " + description);
        addDevice("cooker", new Cooker(cookerType, description));
    }

}
