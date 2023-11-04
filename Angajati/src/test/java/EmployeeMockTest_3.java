import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import AngajatiApp.repository.EmployeeMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest_3 {

    private EmployeeMock employeeMock;

    @BeforeEach
    void setUp() {
        employeeMock = new EmployeeMock();
    }


    @Test
    void validModifyEmployeeFunction_should_save() {
        Employee Ionel = employeeMock.getEmployeeList().get(0);
        employeeMock.modifyEmployeeFunction(Ionel, DidacticFunction.LECTURER);
        Employee modifiedIonel = employeeMock.getEmployeeList().get(0);
        assertEquals(DidacticFunction.LECTURER, modifiedIonel.getFunction());
    }

    @Test
    void invalidModifyEmployeeFunction_should_notSave() {
        Employee Mircea = null;
        List<Employee> beforeList = employeeMock.getEmployeeList();

        employeeMock.modifyEmployeeFunction(Mircea, DidacticFunction.LECTURER);
        List<Employee> afterList = employeeMock.getEmployeeList();

        assertIterableEquals(beforeList, afterList);
    }
}