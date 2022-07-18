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

public class StoveFuelPortion implements java.lang.Cloneable,
                                         java.io.Serializable
{
    public StoveFuel type;

    public float amount;

    public StoveFuelPortion()
    {
        this.type = StoveFuel.CORAL;
    }

    public StoveFuelPortion(StoveFuel type, float amount)
    {
        this.type = type;
        this.amount = amount;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        StoveFuelPortion r = null;
        if(rhs instanceof StoveFuelPortion)
        {
            r = (StoveFuelPortion)rhs;
        }

        if(r != null)
        {
            if(this.type != r.type)
            {
                if(this.type == null || r.type == null || !this.type.equals(r.type))
                {
                    return false;
                }
            }
            if(this.amount != r.amount)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::SmartHome::StoveFuelPortion");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, type);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, amount);
        return h_;
    }

    public StoveFuelPortion clone()
    {
        StoveFuelPortion c = null;
        try
        {
            c = (StoveFuelPortion)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        StoveFuel.ice_write(ostr, this.type);
        ostr.writeFloat(this.amount);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.type = StoveFuel.ice_read(istr);
        this.amount = istr.readFloat();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, StoveFuelPortion v)
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

    static public StoveFuelPortion ice_read(com.zeroc.Ice.InputStream istr)
    {
        StoveFuelPortion v = new StoveFuelPortion();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<StoveFuelPortion> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, StoveFuelPortion v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<StoveFuelPortion> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(StoveFuelPortion.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final StoveFuelPortion _nullMarshalValue = new StoveFuelPortion();

    /** @hidden */
    public static final long serialVersionUID = -4930683531761409735L;
}