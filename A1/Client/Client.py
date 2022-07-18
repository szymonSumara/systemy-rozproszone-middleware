import sys, Ice
import SmartHome


def getDeviceProxy(deviceType, base):
    if deviceType == SmartHome.DevicesTypes.BULBULATOR:
        return SmartHome.BulbulatorPrx.checkedCast(base)
    if deviceType == SmartHome.DevicesTypes.KETTLE:
        return SmartHome.KettlePrx.checkedCast(base)
    if deviceType == SmartHome.DevicesTypes.STOVE:
        return SmartHome.StovePrx.checkedCast(base)
    if deviceType == SmartHome.DevicesTypes.COOKER:
        return SmartHome.CookerPrx.checkedCast(base)

def handle_kettle(device, user_input):
    try:
        if user_input == "getInfo":
            return device.getInfo()
        if user_input == "putWater":
            water = SmartHome.Water()
            water.temperature = float(input("Insert water temperature:"))
            water.volume = float(input("Insert water volume:"))
            return device.putWater(water)
        if user_input == "boilWater":
            return device.boilWater()
        if user_input == "getWater":
            volume = input("Insert water volume:")
            return device.getWater(float(volume))
    except SmartHome.KettleOverflow:
        return "get SmartHome.KettleOverflow exception"
    except SmartHome.NotEnoughtWater:
        return "get SmartHome.NotEnoughtWater exception"
    except:
        print("other exception")

    return "invalid method name"

def handle_stove(device, user_input):
    try:
        if user_input == "getInfo":
            return device.getInfo()
        if user_input == "addFuel":
            portion = SmartHome.StoveFuelPortion()
            type_number = float(input("Insert fuel type ( CORAL = 0, WOOD = 1, GAS = 2 ):"))
            if type_number == 0:
                portion.type = SmartHome.StoveFuel.CORAL
            elif type_number == 1:
                portion.type = SmartHome.StoveFuel.WOOD
            elif type_number == 2:
                portion.type = SmartHome.StoveFuel.GAS
            else:
                return "invalid type"
            portion.amount = float(input("Insert fuel amount:"))
            return device.addFuel(portion)
        if user_input == "fire":
            return device.fire()
    except SmartHome.InvalidFuelType:
        return "get SmartHome.InvalidFuelType exception"
    except SmartHome.InvalidPortionSize:
        return "get SmartHome.InvalidPortionSize exception"
    return "invalid method name"


def handle_bulbulator(device, user_input):
    if user_input == "bulbul":
        return device.bulbul()
    return "invalid method name"

def handle_cooker(device, user_input):
    try:
        if user_input == "getInfo":
            return device.getInfo()
        if user_input == "putOnBurner":
            burner_number = int(input("Insert burner number:"))
            return device.putOnBurner(burner_number)
        if user_input == "getFromBurner":
            burner_number = int(input("Insert burner number:"))
            return device.getFromBurner(burner_number)
        if user_input == "putInOven":
            return device.putInOven()
        if user_input == "getFromOven":
            return device.getFromOven()
    except SmartHome.InvalidBurnerNumber:
        return "get SmartHome.InvalidBurnerNumber exception"
    except SmartHome.BurnerOccupied:
        return "get SmartHome.BurnerOccupied exception"
    except SmartHome.CookerDontHaveOven:
        return "get SmartHome.CookerDontHaveOven exception"
    except SmartHome.OvenOccupied:
        return "get SmartHome.OvenOccupied exception"

    return "invalid method name"




class Devices:
    def __init__(self, server, manager):
        self.server = server
        self.devicesCollection = {}
        self.serverManager = manager

    def updateDevices(self):
        devicesList = self.serverManager.getDevicesList()
        for device in devicesList:
            ref = device.category + "/" + device.name + " :" + self.server
            base = communicator.stringToProxy(ref)
            self.devicesCollection[device.name] = getDeviceProxy(device.type, base)

    def getDevices(self):
        device_type = input("Insert device type ()")
        print("Add device")

        return self.devicesCollection.values()

    def add_bulbulator(self):
        desc = input("Insert bulbulator description")
        self.serverManager.addBulbulator(desc)

    def add_kettle(self):
        type_number = float(input("Insert kettle type ( SMALL = 0, NORMAL = 1, BIG = 2 ):"))
        desc = input("Insert kettle description")
        if type_number == 0:
            kettle_type = SmartHome.KettleTypes.SMALLKETTLE
        elif type_number == 1:
            kettle_type = SmartHome.KettleTypes.NORMALKETTLE
        elif type_number == 2:
            kettle_type = SmartHome.KettleTypes.BIGKETTLE
        else:
            return "invalid type"
        print(kettle_type)
        self.serverManager.addKettle(kettle_type, desc)

    def add_stove(self):
        type_number = float(input("Insert stove fuel type ( CORAL = 0, WOOD = 1, GAS = 2 ):"))
        desc = input("Insert kettle description")
        if type_number == 0:
            fuel_type = SmartHome.StoveFuel.CORAL
        elif type_number == 1:
            fuel_type = SmartHome.StoveFuel.WOOD
        elif type_number == 2:
            fuel_type = SmartHome.StoveFuel.GAS
        else:
            return "invalid type"
        self.serverManager.addStove(fuel_type, desc)

    def add_cooker(self):
        type_number = float(input("Insert kettle type ( NOOVEN2BURNERS = 0, NOOVEN4BURNERS = 1, NOOVEN6BURNERS = 2 , HASOVEN4BURNERS = 3, HASOVEN6BURNERS = 4):"))
        desc = input("Insert kettle description")
        if type_number == 0:
            cooker_type = SmartHome.CookerTypes.NOOVEN2BURNERS
        elif type_number == 1:
            cooker_type = SmartHome.CookerTypes.NOOVEN4BURNERS
        elif type_number == 2:
            cooker_type = SmartHome.CookerTypes.NOOVEN6BURNERS
        elif type_number == 3:
            cooker_type = SmartHome.CookerTypes.HASOVEN4BURNERS
        elif type_number == 4:
            cooker_type = SmartHome.CookerTypes.HASOVEN6BURNERS
        else:
            return "invalid type"
        self.serverManager.addCooker(cooker_type, desc)


    def getDevice(self, name):
        print(name)
        return self.devicesCollection.get(name)

    def printDevicesList(self):
        for k, v in self.devicesCollection.items():
            print(k, v.getType(), v.getDescription())


if __name__ == '__main__':

    with Ice.initialize(sys.argv) as communicator:

        server_a_connected = True
        server_b_connected = True

        try:
            manage_base_A = communicator.propertyToProxy("ManageA.Proxy")
            manage_A = SmartHome.ManageSystemPrx.checkedCast(manage_base_A)
            devA = Devices("tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z", manage_A)
            devA.updateDevices()
        except:
            server_a_connected = False


        try:
            manage_base_B = communicator.propertyToProxy("ManageB.Proxy")
            manage_B = SmartHome.ManageSystemPrx.checkedCast(manage_base_B)
            devB = Devices("tcp -h 127.0.0.2 -p 10002 -z : udp -h 127.0.0.2 -p 10002 -z", manage_B)
            devB.updateDevices()
        except:
            server_b_connected = False



        user_input = None
        devices = None
        selectedDevice = None
        device_name = None
        print(server_a_connected, server_b_connected)

        while True:
            user_input = input("[server scope] ==> ")
            if user_input == "exit":
                break

            if user_input != 'A' and user_input != 'B':
                print("Not valid server name")
                continue

            if user_input == 'A':
                if not server_a_connected:
                    print("Server A is not connected")
                    continue
                devices = devA
            else:
                if not server_b_connected:
                    print("Server B is not connected")
                    continue
                devices = devB
            try:
                while True:
                    user_input = input("[devices scope] ==> ")

                    if user_input == "exit":
                        break

                    if user_input == "help":
                        print("\tlist - list available devices\n"
                              "\tchose {device} - chose device with name {device}\n"
                              "\tadd {device type} - add device to server."
                              "")
                        continue

                    if user_input == "list":
                        devices.printDevicesList()
                        continue

                    if user_input.split(' ')[0] == "add":
                        if user_input.split(' ')[1] == "kettle":
                            print(devices.add_kettle())
                        elif user_input.split(' ')[1] == "bulbulator":
                            print(devices.add_bulbulator())
                        elif user_input.split(' ')[1] == "stove":
                            print(devices.add_stove())
                        elif user_input.split(' ')[1] == "cooker":
                            print(devices.add_cooker())
                        else:
                            print("invalid device name")

                        continue

                    if user_input.split(' ')[0] == "update":
                        devices.updateDevices()
                        continue
                    if user_input.split(' ')[0] == "chose":
                        if user_input.split(' ')[1] is None:
                            print("Device name is required")
                            continue

                        device = devices.getDevice(user_input.split(' ')[1])
                        device_name = user_input.split(' ')[1]
                        if device == None:
                            print("device with given name doesnt exist")
                            continue

                        while True:
                            user_input = input("" + device_name + "(" + str(device.getType()) + ") ==> ")
                            if user_input == "exit":
                                break

                            if user_input == "help":
                                print("man - show device manual"
                                      "exit - exit to upper scope"
                                      "")
                                continue

                            if user_input == "man":
                                print(device.getManual())
                                continue

                            if device.getType() == SmartHome.DevicesTypes.KETTLE:
                                print(handle_kettle(device, user_input))
                            if device.getType() == SmartHome.DevicesTypes.BULBULATOR:
                                print(handle_bulbulator(device, user_input))
                            if device.getType() == SmartHome.DevicesTypes.STOVE:
                                print(handle_stove(device, user_input))
                            if device.getType() == SmartHome.DevicesTypes.COOKER:
                                print(handle_cooker(device, user_input))
            except:
                print("Server disconnected")
                if devices == devA:
                    server_a_connected = False
                if devices == devB:
                    server_b_connected = False

