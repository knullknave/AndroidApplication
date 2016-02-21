package org.dani.medicbook.base;

public class Centro
{
    private int id;
    private String name;
    private float positionx;
    private float positiony;
    private String icon;

    public Centro()
    {

    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public float getPositionx()
    {
        return positionx;
    }

    public void setPositionx(float positionx)
    {
        this.positionx = positionx;
    }

    public float getPositiony()
    {
        return positiony;
    }

    public void setPositiony(float positiony)
    {
        this.positiony = positiony;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }
}