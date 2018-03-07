package controller;

import javafx.util.Pair;
import model.Employee;
import modelPredicates.EmployeePredicates;
import modelPredicates.ModelPredicates;
import validation.EmployeeServiceValidator;
import validation.ServiceValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private EmployeePredicates employeePredicates;
    private ServiceValidator serviceValidator;
    //private ModelPredicates companyPredicates;

    public Main() {
        employeePredicates = new EmployeePredicates();
        serviceValidator = new EmployeeServiceValidator();
    }

    public static Predicate<Employee> isMale() {
        return e -> e.getGender().toLowerCase().equals("male");
    }

    public static void main(String[] args) {

        try {
            Main mainObj = new Main();
            List<Employee> employees = mainObj.createEmployees(10);

            List<Employee> isMaleEmployees =
                    employees.stream()
                             .filter(mainObj.employeePredicates.isMale())
                             .collect(Collectors.toList());

            //mainObj.employeePredicates.isAdult()

            List<Employee> isFemaleEmployees =
                    employees.stream()
                             .filter(e -> e.getGender().toLowerCase().equals("female"))
                             .collect(Collectors.toList());


            List<Employee> adultMalesWithSalaryOver25000 =
                    employees.stream()
                             .filter(mainObj.employeePredicates.isAdultMaleWithMinimumSalary(25000))
                             .collect(Collectors.toList());

            for (Employee employee : employees) {
                mainObj.serviceValidator.canCreate(employee);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private HashMap<Integer, Pair<String, String>> initializePeople() {
        HashMap<Integer, Pair<String, String>> peopleHashMap = new HashMap<>();
        peopleHashMap.put(0, new Pair<>("Bjarke","Male"));
        peopleHashMap.put(1, new Pair<>("Thomas","Male"));
        peopleHashMap.put(2, new Pair<>("Frederik","Male"));
        peopleHashMap.put(3, new Pair<>("Tobias","Male"));
        peopleHashMap.put(4, new Pair<>("Mathias","Male"));
        peopleHashMap.put(5, new Pair<>("Benny","Male"));
        peopleHashMap.put(6, new Pair<>("John","Male"));
        peopleHashMap.put(7, new Pair<>("Rebecca","Female"));
        peopleHashMap.put(8, new Pair<>("Sofie","Female"));
        peopleHashMap.put(9, new Pair<>("Marie","Female"));
        peopleHashMap.put(10, new Pair<>("Anne","Female"));
        return peopleHashMap;
    }

    private List<Employee> createEmployees(int numberEmployees) throws Exception {
        HashMap<Integer, Pair<String, String>> peopleHashMap = initializePeople();
        if (numberEmployees > peopleHashMap.size()) {
            throw new Exception(String.format("Currently only support up to numberEmployees: %d ", peopleHashMap.size()));
        }

        List<Employee> employeeList = new ArrayList<>();
        int ageIncrement = 0;
        for (int i : IntStream.range(0, numberEmployees).toArray()) {
            double salaryWeight = ThreadLocalRandom.current().nextDouble(0.8, 1.2);
            double baseSalary = ThreadLocalRandom.current().nextDouble(25000, 45000);
            employeeList.add(
                    new Employee(peopleHashMap.get(i).getKey(), 29+ageIncrement, peopleHashMap.get(i).getValue(), baseSalary*salaryWeight)
            );
        }
        return employeeList;
    }
}
