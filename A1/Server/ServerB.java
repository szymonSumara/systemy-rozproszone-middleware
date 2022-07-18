
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
import SmartHome.CookerTypes;
import SmartHome.KettleTypes;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

public class ServerB
{
	public void t1(String[] args)
	{
		int status = 0;
		Communicator communicator = null;

		try	{
			communicator = Util.initialize(args);

			ObjectAdapter adapter = communicator.createObjectAdapter("Adapter1");

			Bulbulator calcServant1 = new Bulbulator("Very rare bulbulator");
			Kettle kettle1 = new Kettle(KettleTypes.SMALLKETTLE, "Really small kettle");
			ManageSystem manageSystem = new ManageSystem(adapter);
			Cooker cooker = new Cooker(CookerTypes.HASOVEN6BURNERS, "Small cooker with no oven");


			manageSystem.addDevice("kettle",  kettle1);
			manageSystem.addDevice("bublulator",  calcServant1);
			manageSystem.addDevice("cooker",  cooker);

			adapter.add(manageSystem, new Identity("manageSystem", "manageSystem"));
			adapter.addDefaultServant(manageSystem, "defoult");

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
		ServerB app = new ServerB();
		app.t1(args);
	}
}
