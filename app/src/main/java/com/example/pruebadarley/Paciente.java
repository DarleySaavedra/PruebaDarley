package com.example.pruebadarley;

public class Paciente {

    String nombre;
    int  dni;
    String hobbie;

    Paciente(){

    }
    public Paciente(String nombre, int dni, String hobbie){
    this.nombre = nombre;
    this.dni = dni;
    this.hobbie = hobbie;

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getHobbie() {
        return hobbie;
    }

    public void setHobbie(String hobbie) {
        this.hobbie = hobbie;
    }





}
