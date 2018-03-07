package modelPredicates;

import model.Employee;

import java.util.function.Predicate;

public class EmployeeValidatorPredicates {

    private EmployeePredicates employeePredicates;

    public EmployeeValidatorPredicates() {
        this.employeePredicates = new EmployeePredicates();
    }

    public Predicate<Employee> isEmployeeValid() {
        return hasValidName()
                .and(employeePredicates.isMale().or(employeePredicates.isFemale()))
                .and(employeePredicates.hasValidAge())
                .and(hasValidSalary());
    }

    private Predicate<Employee> hasValidName() {
        return e -> (e.getName() != null) ? !e.getName().equals("")
                : false;
    }

    private Predicate<Employee> hasValidSalary() {
        return e -> e.getMonthlySalary() >= 0;
    }

    public Predicate<Employee> isAdultMale() {
        return e -> e.getAge() >= 18 && e.getGender().equals("M");
    }
}
