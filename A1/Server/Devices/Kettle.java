package Devices;

import SmartHome.*;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.LocatorPrx;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Kettle implements SmartHome.Kettle {

    Lock lock = new ReentrantLock();
    KettleInfo info = new KettleInfo();
    static public String manual = """
            -----------Kettle Manual-----------
            This is water container that can increase water temperature.
            
            Kettle have two parameters:
                - capacity - number of maximum water in kettle
                - minimal water level - secure water level
            
            --------------Methods--------------
            KettleInfo getInfo() - returns info about kettle
            void putWater(Water water) throws KettleOverflow - returns minimal water level to boil water
            void boilWater() throws NotEnoughtWater - increase putted water temperature to 100 deg
            Water getWater(float volume) - return water from kettle
            
            
            ----------Used Structures----------
            
            Water
                float temperature - temperature of water
                float volume - amount of water
            """;

    String description;
    @Override
    public String getDescription(Current current) {return description;}


    public Kettle(KettleTypes type, String description) {
        if(type == KettleTypes.SMALLKETTLE){
            this.info.capacity = 1.5f;
            this.info.minRequiredWaterLevel = 0.2f;
        }else if(type == KettleTypes.NORMALKETTLE){
            this.info.capacity = 2.5f;
            this.info.minRequiredWaterLevel = 0.4f;
        }else if(type == KettleTypes.BIGKETTLE){
            this.info.capacity = 4f;
            this.info.minRequiredWaterLevel = 0.7f;
        }

        this.info.water = new Water();
        this.info.water.volume = 0;
        this.info.water.temperature = 0;
        this.description = description;
    }

    @Override
    public KettleInfo getInfo(Current current) {
        return info;
    }

    @Override
    public void putWater(Water water, Current current) throws KettleOverflow {
        System.out.println("Cooker( " + description +" ).putWater( "+ water +" ) called");

        lock.lock();
        try {
            info.water.temperature = (
                    info.water.temperature * info.water.volume
                            + water.temperature * water.volume
            ) / (info.water.volume + water.volume);

            info.water.volume += water.volume;
            if (info.water.volume > info.capacity) {
                info.water.volume = info.capacity;
                throw new KettleOverflow();
            }
        }finally {
            lock.unlock();
        }

        return;
    }

    @Override
    public void boilWater(Current current) throws NotEnoughtWater {
        System.out.println("Cooker( " + description +" ).boilWater(  ) called");

        lock.lock();
        try{
            if(info.water.volume < info.minRequiredWaterLevel)
                throw new NotEnoughtWater();

            info.water.temperature = 100;
        }finally {
            lock.unlock();

        }
    }

    @Override
    public DevicesTypes getType(Current current) {
        return DevicesTypes.KETTLE;
    }

    @Override
    public Water getWater(float volume, Current current) {
        System.out.println("Cooker( " + description +" ).boilWater( "+volume+" ) called");

        lock.lock();
        Water toReturn = new Water();
        toReturn.temperature = info.water.temperature;
        toReturn.volume = Math.min(info.water.volume, volume);
        info.water.volume -= toReturn.volume;
        lock.unlock();
        return toReturn;
    }

    @Override
    public String getManual(Current current) {
        return manual;
    }
}
