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

public class KettleInfo implements java.lang.Cloneable,
                                   java.io.Serializable
{
    public KettleTypes type;

    public float capacity;

    public float minRequiredWaterLevel;

    public Water water;

    public KettleInfo()
    {
        this.type = KettleTypes.SMALLKETTLE;
        this.water = new Water();
    }

    public KettleInfo(KettleTypes type, float capacity, float minRequiredWaterLevel, Water water)
    {
        this.type = type;
        this.capacity = capacity;
        this.minRequiredWaterLevel = minRequiredWaterLevel;
        this.water = water;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        KettleInfo r = null;
        if(rhs instanceof KettleInfo)
        {
            r = (KettleInfo)rhs;
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
            if(this.capacity != r.capacity)
            {
                return false;
            }
            if(this.minRequiredWaterLevel != r.minRequiredWaterLevel)
            {
                return false;
            }
            if(this.water != r.water)
            {
                if(this.water == null || r.water == null || !this.water.equals(r.water))
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
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::SmartHome::KettleInfo");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, type);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, capacity);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, minRequiredWaterLevel);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, water);
        return h_;
    }

    public KettleInfo clone()
    {
        KettleInfo c = null;
        try
        {
            c = (KettleInfo)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        KettleTypes.ice_write(ostr, this.type);
        ostr.writeFloat(this.capacity);
        ostr.writeFloat(this.minRequiredWaterLevel);
        Water.ice_write(ostr, this.water);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.type = KettleTypes.ice_read(istr);
        this.capacity = istr.readFloat();
        this.minRequiredWaterLevel = istr.readFloat();
        this.water = Water.ice_read(istr);
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, KettleInfo v)
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

    static public KettleInfo ice_read(com.zeroc.Ice.InputStream istr)
    {
        KettleInfo v = new KettleInfo();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<KettleInfo> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, KettleInfo v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<KettleInfo> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(KettleInfo.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final KettleInfo _nullMarshalValue = new KettleInfo();

    /** @hidden */
    public static final long serialVersionUID = 3062987513195044301L;
}