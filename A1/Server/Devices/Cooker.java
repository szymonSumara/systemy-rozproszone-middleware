package Devices;

import SmartHome.*;
import com.zeroc.Ice.Current;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cooker implements SmartHome.Cooker {

    String manual = """
            -----------Cooker Manual-----------
            We can put something on burner or put to oven.
            
            Cooker has 5 different types:
                2 burners
                2 burners with oven
                4 burners
                4 burners with oven
                6 burners
                6 burners and oven

            --------------Methods--------------
             CookerInfo getInfo();
             void putOnBurner(int burnerNumber) throws InvalidBurnerNumber, BurnerOccupied;
             void getFromBurner(int burnerNumber);
             void putInOven() throws CookerDontHaveOven, OvenOccupied;
             void getFromOven() throws CookerDontHaveOven;
         
              
                
            """;

    String description ="";
    Lock cookerLock = new ReentrantLock();


    CookerInfo info = new CookerInfo();

    public Cooker(CookerTypes type, String description) {
        info.type = type;
        info.burner1Avaible = true;
        info.burner2Avaible = true;
        if(type != CookerTypes.NOOVEN2BURNERS){
            info.burner3Avaible = true;
            info.burner4Avaible = true;
        }

        if(type == CookerTypes.HASOVEN6BURNERS || type == CookerTypes.NOOVEN6BURNERS){
            info.burner5Avaible = true;
            info.burner6Avaible = true;
        }

        if(type == CookerTypes.HASOVEN4BURNERS || type == CookerTypes.HASOVEN6BURNERS){
            info.ovenAvaible = true;
        }

        this.description = description;
    }

    @Override
    public CookerInfo getInfo(Current current) {
        return info;
    }

    @Override
    public void putOnBurner(int burnerNumber, Current current) throws BurnerOccupied, InvalidBurnerNumber {
        System.out.println("Cooker( " + description +" ).putOnBurner( "+burnerNumber+" ) called");
        cookerLock.lock();
        try{
            if(burnerNumber < 0 || burnerNumber >= 6 ) throw new InvalidBurnerNumber();
            if(info.type == CookerTypes.NOOVEN2BURNERS && burnerNumber >= 2) throw new InvalidBurnerNumber();
            if((info.type == CookerTypes.NOOVEN4BURNERS || info.type == CookerTypes.HASOVEN4BURNERS) && burnerNumber >= 4 )
                throw new InvalidBurnerNumber();

            if(burnerNumber == 0){
                if(info.burner1Avaible == false) throw new BurnerOccupied();
                info.burner1Avaible = false;
            }else if(burnerNumber == 1){
                if(info.burner2Avaible == false) throw new BurnerOccupied();
                info.burner2Avaible = false;
            }else if(burnerNumber == 2){
                if(info.burner3Avaible == false) throw new BurnerOccupied();
                info.burner3Avaible = false;
            }else if(burnerNumber == 3){
                if(info.burner4Avaible == false) throw new BurnerOccupied();
                info.burner4Avaible = false;
            }else if(burnerNumber == 4){
                if(info.burner5Avaible == false) throw new BurnerOccupied();
                info.burner5Avaible = false;
            }else if(burnerNumber == 5){
                if(info.burner6Avaible == false) throw new BurnerOccupied();
                info.burner6Avaible = false;
            }
        }finally {
            cookerLock.unlock();
        }


    }

    @Override
    public void getFromBurner(int burnerNumber, Current current) {
        System.out.println("Cooker( " + description +" ).getFromBurner( "+burnerNumber+" ) called");

        if(burnerNumber == 0)
            info.burner1Avaible = true;
        else if(burnerNumber == 1)
            info.burner2Avaible = true;
        else if(burnerNumber == 2)
            info.burner3Avaible = true;
        else if(burnerNumber == 3)
            info.burner4Avaible = true;
        else if(burnerNumber == 4)
            info.burner5Avaible = true;
        else if(burnerNumber == 5)
            info.burner6Avaible = true;
        return;
    }


    @Override
    public void putInOven(Current current) throws CookerDontHaveOven, OvenOccupied {
        System.out.println("Cooker( " + description +" ).putInOven(  ) called");

        cookerLock.lock();
        try{
            if(info.type == CookerTypes.NOOVEN2BURNERS
                    || info.type == CookerTypes.NOOVEN4BURNERS
                    || info.type == CookerTypes.NOOVEN6BURNERS)
                throw  new CookerDontHaveOven();

            if(info.ovenAvaible == false) throw new OvenOccupied();
            info.ovenAvaible = false;

        }finally {
            cookerLock.unlock();

        }


    }

    @Override
    public void getFromOven(Current current) throws CookerDontHaveOven {

        System.out.println("Cooker( " + description +" ).getFromOven(  ) called");

        cookerLock.lock();
        try{
            if(info.type == CookerTypes.NOOVEN2BURNERS
                    || info.type == CookerTypes.NOOVEN4BURNERS
                    || info.type == CookerTypes.NOOVEN6BURNERS)
                throw  new CookerDontHaveOven();
            info.ovenAvaible = true;
        }finally {
            cookerLock.unlock();

        }
    }

    @Override
    public String getManual(Current current) {
        return manual;
    }

    @Override
    public String getDescription(Current current) {
        return description;
    }

    @Override
    public DevicesTypes getType(Current current) {
        return DevicesTypes.COOKER;
    }
}
