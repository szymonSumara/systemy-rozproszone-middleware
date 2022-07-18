
#ifndef CALC_ICE
#define CALC_ICE

module SmartHome
{

    enum DevicesTypes {
        BULBULATOR,
        KETTLE,
        STOVE,
        COOKER
    };

    enum KettleTypes{
        SMALLKETTLE,
        NORMALKETTLE,
        BIGKETTLE,
    };

    enum StoveFuel{
        CORAL,
        WOOD,
        GAS
    };

    enum CookerTypes{
        NOOVEN2BURNERS,
        NOOVEN4BURNERS,
        NOOVEN6BURNERS,
        HASOVEN4BURNERS,
        HASOVEN6BURNERS,
    };


    //Kettle exceptions
    exception KettleOverflow {};
    exception NotEnoughtWater {};
    //Stove exceptions
    exception InvalidFuelType {};
    exception InvalidPortionSize {};
    //Cooker exceptions
    exception InvalidBurnerNumber {};
    exception BurnerOccupied {};
    exception CookerDontHaveOven {};
    exception OvenOccupied {};

    //Structures

    struct SmartDeviceInfo{
        string name;
        string category;
        DevicesTypes type;
    };

    struct Water{
        float volume;
        float temperature;
    };

    struct StoveFuelPortion{
        StoveFuel type;
        float amount;
    };

    struct KettleInfo{
        KettleTypes type;
        float capacity;
        float minRequiredWaterLevel;
        Water water;
    };

    struct StoveInfo{
        StoveFuel fuelType;
        float fuelLevel;
    };

    struct CookerInfo{
        CookerTypes type;
        bool burner1Avaible;
        bool burner2Avaible;
        bool burner3Avaible;
        bool burner4Avaible;
        bool burner5Avaible;
        bool burner6Avaible;
        bool ovenAvaible;
    };

    //Sequecens
    sequence<SmartDeviceInfo> Devices;
    sequence<int> ListOfInts;

    //Interfaces

    interface ManageSystem{
        Devices getDevicesList();
        void addKettle(KettleTypes kettleType, string description);
        void addBulbulator(string description);
        void addStove(StoveFuel fuelType, string description);
        void addCooker(CookerTypes cookerType, string description);
    };

    interface SmartDevice{
        string getManual();
        string getDescription();
        DevicesTypes getType();
    };

    interface Bulbulator extends SmartDevice{
        string bulbul();
    };

    interface Kettle extends SmartDevice{
        KettleInfo getInfo();
        void putWater(Water water) throws KettleOverflow;
        void boilWater() throws NotEnoughtWater;
        Water getWater(float volume) throws NotEnoughtWater;
    };

    interface Stove extends SmartDevice{
        StoveInfo getInfo();
        void addFuel(StoveFuelPortion portion) throws InvalidFuelType, InvalidPortionSize ;
        void fire();
    };

    interface Cooker extends SmartDevice{
        CookerInfo getInfo();
        void putOnBurner(int burnerNumber) throws InvalidBurnerNumber, BurnerOccupied;
        void getFromBurner(int burnerNumber);
        void putInOven() throws CookerDontHaveOven, OvenOccupied;
        void getFromOven() throws CookerDontHaveOven;
    };

};

#endif
