//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.7
//
// <auto-generated>
//
// Generated from file `smarthome.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package SmartHome;

public class NotEnoughtWater extends com.zeroc.Ice.UserException
{
    public NotEnoughtWater()
    {
    }

    public NotEnoughtWater(Throwable cause)
    {
        super(cause);
    }

    public String ice_id()
    {
        return "::SmartHome::NotEnoughtWater";
    }

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::SmartHome::NotEnoughtWater", -1, true);
        ostr_.endSlice();
    }

    /** @hidden */
    @Override
    protected void _readImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        istr_.endSlice();
    }

    /** @hidden */
    public static final long serialVersionUID = 932665603016592731L;
}
