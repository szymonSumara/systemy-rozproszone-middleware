
// **********************************************************************
//
// Copyright (c) 2003-2019 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

import Devices.Bulbulator;
import Devices.Cooker;
import Devices.Kettle;
import Devices.Stove;
import SmartHome.CookerTypes;
import SmartHome.KettleTypes;
import SmartHome.StoveFuel;
import com.zeroc.Ice.*;

import java.lang.Exception;

public class ServerA
{
	public void t1(String[] args)
	{
		int status = 0;
		Communicator communicator = null;

		try	{
			// 1. Inicjalizacja ICE - utworzenie communicatora
			communicator = Util.initialize(args);

			// 2. Konfiguracja adaptera
			ObjectAdapter adapter = communicator.createObjectAdapter("Adapter1");

			// 3. Stworzenie serwanta/serwantów
			Kettle kettle1 = new Kettle(KettleTypes.BIGKETTLE, "Really big kettle");
			Stove stove2 = new Stove(StoveFuel.GAS, "Gas stove");
			Cooker cooker = new Cooker(CookerTypes.NOOVEN2BURNERS, "Small cooker with no oven");

			ManageSystem manageSystem = new ManageSystem(adapter);
			manageSystem.addDevice("kettle",  kettle1);
			manageSystem.addDevice( "stove", stove2);
			manageSystem.addDevice("cooker", cooker);

			adapter.add(manageSystem, new Identity("manageSystem", "manageSystem"));


			adapter.activate();

			System.out.println("Entering event processing loop...");
			
			communicator.waitForShutdown(); 		
			
		}
		catch (Exception e) {
			System.err.println(e);
			status = 1;
		}
		if (communicator != null) {
			try {
				communicator.destroy();
			}
			catch (Exception e) {
				System.err.println(e);
				status = 1;
			}
		}
		System.exit(status);
	}


	public static void main(String[] args)
	{
		ServerA app = new ServerA();
		app.t1(args);
	}
}
