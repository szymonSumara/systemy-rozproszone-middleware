package Devices;

import SmartHome.*;
import com.zeroc.Ice.Current;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Stove implements SmartHome.Stove {

    Lock fireLock = new ReentrantLock();
    Lock stoveLock = new ReentrantLock();
    Fire fire = new Fire();
    StoveInfo info = new StoveInfo();
    String manual = """
            -----------Stove Manual-----------
            Stove can get fuel and burn it.
            
            Kettle have two parameters:
                - fuelType (StoveFuel) - number of maximum water in kettle
                - fuelLevel (float) - water level - secure water level
            
            --------------Methods--------------
            StoveFuel getInfo() - returns stove information (fuel type, fuel level)
            void addFuel(StoveFuelPortion portion, Current current) throws InvalidFuelType - add fuel portion to stove
            void fire() start burn fuel
         
            ----------Used Structures----------
            
            Enum StoveFuel
                GAS,
                CORAL,
                WOOD
                
            struct StoveFuelPortion
                - StoveFuel(type)
                - float(amount)
              
                
            """;
    String description = "";


    @Override
    public String getDescription(Current current) {
        return description;
    }

    public Stove(StoveFuel fuelType, String description) {
        this.info.fuelType = fuelType;
        this.info.fuelLevel = 0;
        this.description = description;
    }

    @Override
    public String getManual(Current current) {
        return manual;
    }

    @Override
    public StoveInfo getInfo(Current current) {
        return info;
    }

    @Override
    public void addFuel(StoveFuelPortion portion, Current current) throws InvalidFuelType, InvalidPortionSize {
        System.out.println("Stove( " + description +" ).addFuel( "+ portion+" ) called");

        System.out.println(portion);
        stoveLock.lock();
        try{
            if(portion.amount < 0) throw new InvalidPortionSize();
            if(portion.type != this.info.fuelType) throw new InvalidFuelType();
            this.info.fuelLevel += portion.amount;
        }finally {
            stoveLock.unlock();

        }
    }

    @Override
    public DevicesTypes getType(Current current) {
        return DevicesTypes.STOVE;
    }

    @Override
    public void fire(Current current) {
        System.out.println("Stove( " + description +" ).fire( ) called");

        fireLock.lock();
        System.out.println(fire.isAlive());
        if(!fire.isAlive()) {
            fire = new Fire();
            fire.start();
        }
        fireLock.unlock();
        return;
    }


    public class Fire extends Thread{
        public void run(){
            super.run();
            while(info.fuelLevel > 0){
                System.out.println("Stove burn 1 fuel" + info.fuelLevel);
                stoveLock.lock();
                info.fuelLevel-=1;
                if(info.fuelLevel < 0) info.fuelLevel = 0;
                stoveLock.unlock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
