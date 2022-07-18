package Devices;

import SmartHome.DevicesTypes;
import com.zeroc.Ice.Current;

public class Bulbulator implements SmartHome.Bulbulator {


    public String manual = """
            -----------Bulbulator Manual-----------
            Bulbulator is one of the most advanced devices in the world.
            
            ----------------Methods----------------
            string bulbul() - everyone knows what it does
       
            """;;
    public String description;

    @Override
    public String getDescription(Current current) {
        return description;
    }

    public Bulbulator(String description) {
        this.description = description;
    }

    @Override
    public String bulbul(Current current) {
        System.out.println("Bulbulator( " + description +" ).bulbul called");
        return "Bul Bul";
    }

    @Override
    public DevicesTypes getType(Current current) {
        return DevicesTypes.BULBULATOR;
    }

    @Override
    public String getManual(Current current) {
        return manual;
    }
}
