package org.dani.medicbook.base;

import android.graphics.Bitmap;

import java.util.Date;

public class VisitasMedico
{
    private int id;
    private String nombre;
    private int idPaciente;
    private int idMedico;
    private Date fecha;
    private Bitmap foto;

    public VisitasMedico()
    {

    }

    public VisitasMedico(int id, String nombre, int idPaciente, int idMedico, Date fecha)
    {
        this.id = id;
        this.nombre = nombre;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.fecha = fecha;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getIdPaciente()
    {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente)
    {
        this.idPaciente = idPaciente;
    }

    public int getIdMedico()
    {
        return idMedico;
    }

    public void setIdMedico(int idMedico)
    {
        this.idMedico = idMedico;
    }

    public Date getFecha()
    {
        return fecha;
    }

    public void setFecha(Date fecha)
    {
        this.fecha = fecha;
    }

    public Bitmap getFoto()
    {
        return foto;
    }

    public void setFoto(Bitmap foto)
    {
        this.foto = foto;
    }
}