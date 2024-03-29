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

public class CookerInfo implements java.lang.Cloneable,
                                   java.io.Serializable
{
    public CookerTypes type;

    public boolean burner1Avaible;

    public boolean burner2Avaible;

    public boolean burner3Avaible;

    public boolean burner4Avaible;

    public boolean burner5Avaible;

    public boolean burner6Avaible;

    public boolean ovenAvaible;

    public CookerInfo()
    {
        this.type = CookerTypes.NOOVEN2BURNERS;
    }

    public CookerInfo(CookerTypes type, boolean burner1Avaible, boolean burner2Avaible, boolean burner3Avaible, boolean burner4Avaible, boolean burner5Avaible, boolean burner6Avaible, boolean ovenAvaible)
    {
        this.type = type;
        this.burner1Avaible = burner1Avaible;
        this.burner2Avaible = burner2Avaible;
        this.burner3Avaible = burner3Avaible;
        this.burner4Avaible = burner4Avaible;
        this.burner5Avaible = burner5Avaible;
        this.burner6Avaible = burner6Avaible;
        this.ovenAvaible = ovenAvaible;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        CookerInfo r = null;
        if(rhs instanceof CookerInfo)
        {
            r = (CookerInfo)rhs;
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
            if(this.burner1Avaible != r.burner1Avaible)
            {
                return false;
            }
            if(this.burner2Avaible != r.burner2Avaible)
            {
                return false;
            }
            if(this.burner3Avaible != r.burner3Avaible)
            {
                return false;
            }
            if(this.burner4Avaible != r.burner4Avaible)
            {
                return false;
            }
            if(this.burner5Avaible != r.burner5Avaible)
            {
                return false;
            }
            if(this.burner6Avaible != r.burner6Avaible)
            {
                return false;
            }
            if(this.ovenAvaible != r.ovenAvaible)
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
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::SmartHome::CookerInfo");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, type);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, burner1Avaible);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, burner2Avaible);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, burner3Avaible);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, burner4Avaible);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, burner5Avaible);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, burner6Avaible);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, ovenAvaible);
        return h_;
    }

    public CookerInfo clone()
    {
        CookerInfo c = null;
        try
        {
            c = (CookerInfo)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        CookerTypes.ice_write(ostr, this.type);
        ostr.writeBool(this.burner1Avaible);
        ostr.writeBool(this.burner2Avaible);
        ostr.writeBool(this.burner3Avaible);
        ostr.writeBool(this.burner4Avaible);
        ostr.writeBool(this.burner5Avaible);
        ostr.writeBool(this.burner6Avaible);
        ostr.writeBool(this.ovenAvaible);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.type = CookerTypes.ice_read(istr);
        this.burner1Avaible = istr.readBool();
        this.burner2Avaible = istr.readBool();
        this.burner3Avaible = istr.readBool();
        this.burner4Avaible = istr.readBool();
        this.burner5Avaible = istr.readBool();
        this.burner6Avaible = istr.readBool();
        this.ovenAvaible = istr.readBool();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, CookerInfo v)
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

    static public CookerInfo ice_read(com.zeroc.Ice.InputStream istr)
    {
        CookerInfo v = new CookerInfo();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<CookerInfo> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, CookerInfo v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<CookerInfo> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(CookerInfo.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final CookerInfo _nullMarshalValue = new CookerInfo();

    /** @hidden */
    public static final long serialVersionUID = -8205314023276826731L;
}
