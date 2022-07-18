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

public class SmartDeviceInfo implements java.lang.Cloneable,
                                        java.io.Serializable
{
    public String name;

    public String category;

    public DevicesTypes type;

    public SmartDeviceInfo()
    {
        this.name = "";
        this.category = "";
        this.type = DevicesTypes.BULBULATOR;
    }

    public SmartDeviceInfo(String name, String category, DevicesTypes type)
    {
        this.name = name;
        this.category = category;
        this.type = type;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        SmartDeviceInfo r = null;
        if(rhs instanceof SmartDeviceInfo)
        {
            r = (SmartDeviceInfo)rhs;
        }

        if(r != null)
        {
            if(this.name != r.name)
            {
                if(this.name == null || r.name == null || !this.name.equals(r.name))
                {
                    return false;
                }
            }
            if(this.category != r.category)
            {
                if(this.category == null || r.category == null || !this.category.equals(r.category))
                {
                    return false;
                }
            }
            if(this.type != r.type)
            {
                if(this.type == null || r.type == null || !this.type.equals(r.type))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::SmartHome::SmartDeviceInfo");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, name);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, category);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, type);
        return h_;
    }

    public SmartDeviceInfo clone()
    {
        SmartDeviceInfo c = null;
        try
        {
            c = (SmartDeviceInfo)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeString(this.name);
        ostr.writeString(this.category);
        DevicesTypes.ice_write(ostr, this.type);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.name = istr.readString();
        this.category = istr.readString();
        this.type = DevicesTypes.ice_read(istr);
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, SmartDeviceInfo v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public SmartDeviceInfo ice_read(com.zeroc.Ice.InputStream istr)
    {
        SmartDeviceInfo v = new SmartDeviceInfo();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<SmartDeviceInfo> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, SmartDeviceInfo v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<SmartDeviceInfo> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(SmartDeviceInfo.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final SmartDeviceInfo _nullMarshalValue = new SmartDeviceInfo();

    /** @hidden */
    public static final long serialVersionUID = -8079711706870247654L;
}
