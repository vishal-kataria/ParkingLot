package models;

public class Operator extends BaseModel{
    private String name;

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    private int empID;



}
