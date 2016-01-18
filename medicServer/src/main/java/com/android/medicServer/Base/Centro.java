package com.android.medicServer.Base;

import javax.persistence.*;

@Entity
@Table(name="centros")
public class Centro
{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "positionx")
    private float positionx;
    @Column(name = "positiony")
    private float positiony;
    @Column(name = "icon")
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
