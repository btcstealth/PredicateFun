package model;

public class Employee {

    private final String name;
    private int age;
    private final String gender;
    private double monthlySalary;

    public Employee(String name, int age, String gender, double monthlySalary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.monthlySalary = monthlySalary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", monthlySalary=").append(monthlySalary);
        sb.append('}');
        return sb.toString();
    }
}
