package validation;

import model.Employee;
import modelPredicates.EmployeeValidatorPredicates;

public class EmployeeServiceValidator implements ServiceValidator<Employee> {

    private EmployeeValidatorPredicates employeeValidatorPredicates;

    public EmployeeServiceValidator() {
        super();
        employeeValidatorPredicates = new EmployeeValidatorPredicates();
    }

    @Override
    public void canAccess(Employee object) {
        // Check access credentials
    }

    @Override
    public void canCreate(Employee object) {
        if (!employeeValidatorPredicates.isEmployeeValid().test(object)) {
            throw new RuntimeException(String.format("Employee is not valid, Employee: %s", object.toString()));
        }
        else {
            System.out.println(String.format("Employee is valid, Employee: %s", object.toString()));
        }
    }

    @Override
    public void canUpdate(Employee object) {
        canAccess(object);
        if (!employeeValidatorPredicates.isEmployeeValid().test(object)) {
            throw new RuntimeException(String.format("Employee is not valid, Employee: %s", object.toString()));
        }
    }

    @Override
    public void canDelete(Employee object) {
        canAccess(object);
    }
}
