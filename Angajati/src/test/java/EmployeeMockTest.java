import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import AngajatiApp.repository.EmployeeMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {

    private EmployeeMock employeeMock;

    @BeforeEach
    void setUp() {
        employeeMock = new EmployeeMock();
    }

    @AfterEach
    void tearDown() {
        employeeMock = null;
    }

    @Test
    void addEmployee_allAttributesValid() {
        Employee employee = new Employee("Pop", "Mihaela",
                "1960101160012", DidacticFunction.ASISTENT, 3200d);
        employeeMock.addEmployee(employee);
        assertTrue(employeeMock.getEmployeeList().contains(employee));
    }

    @Test
    void addEmployee_invalidLastName() {
        Employee employee = new Employee("Mircea", "Mi!",
                "1950101160012", DidacticFunction.ASISTENT, 4500d);

        employeeMock.addEmployee(employee);
        assertFalse(employeeMock.getEmployeeList().contains(employee));
    }

    @Test
    void addEmployee_invalidFirstName() {
        Employee employee = new Employee("Pr@", "Mihai",
                "1960101160012", DidacticFunction.TEACHER, 5000d);

        employeeMock.addEmployee(employee);
        assertFalse(employeeMock.getEmployeeList().contains(employee));
    }

    @Test
    void addEmployee_invalidSalary() {
        Employee employee = new Employee("Mihai", "Wesd",
                "1950101160012", DidacticFunction.TEACHER, 0d);

        employeeMock.addEmployee(employee);
        assertFalse(employeeMock.getEmployeeList().contains(employee));
    }
}