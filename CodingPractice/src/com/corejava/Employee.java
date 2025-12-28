package com.corejava;

public class Employee implements Comparable<Employee> {
    private int employee_id ;
    private String name ;
    private String country ;

    public Employee(int employee_id, String name, String country) {
        this.employee_id = employee_id;
        this.name = name;
        this.country = country;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int compareTo(Employee o) {
        return o.getEmployee_id();
    }
    @Override
    public String toString(){
        System.out.println("");
        return ": id : "+employee_id+" name : "+name+" country : "+country;
    }
}
