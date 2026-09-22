package javastream;

public class Employees {
    int employeeId;
    String employeeName;
    String gender;
    private int Salary;
    String department;

    public Employees(int employeeId, String employeeName, String gender, int salary, String department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.gender = gender;
        Salary = salary;
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getSalary() {
        return Salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeId=" + employeeId +
                ", gender='" + gender + '\'' +
                ", Salary=" + Salary +
                '}';
    }

    public void setSalary(int salary) {
        Salary = salary;
    }
}
