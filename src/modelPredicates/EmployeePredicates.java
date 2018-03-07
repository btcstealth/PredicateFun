package modelPredicates;

import model.Employee;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates implements ModelPredicates<Employee> {

    public Predicate<Employee> isAdult() {
        return e -> e.getAge() >= 18;
    }

    public Predicate<Employee> isMale() {
        return e -> e.getGender().toLowerCase().equals("male");
    }

    protected Predicate<Employee> isFemale() {
        return e -> e.getGender().toLowerCase().equals("female");
    }

    protected Predicate<Employee> hasValidAge() {
        return e -> 0 < e.getAge() && e.getAge() < 110;
    }

    protected Predicate<Employee> hasMinimumSalary(double minimumSalary) {
        return e -> e.getMonthlySalary() >= minimumSalary;
    }

    public Predicate<Employee> isAdultMaleWithMinimumSalary(double minimumSalary) {
        return isAdult()
                .and(isMale())
                .and(hasMinimumSalary(minimumSalary));
    }




    @Override
    public List<Employee> filter(List<Employee> collection, Predicate<Employee> predicate) {
        return collection.stream().filter(predicate).collect(Collectors.<Employee>toList());
    }
}
