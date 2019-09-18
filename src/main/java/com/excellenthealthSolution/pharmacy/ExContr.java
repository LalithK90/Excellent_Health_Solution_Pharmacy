package com.excellenthealthSolution.pharmacy;

import com.excellenthealthSolution.pharmacy.asset.commonAsset.Enum.Gender;
import com.excellenthealthSolution.pharmacy.asset.commonAsset.Enum.Title;
import com.excellenthealthSolution.pharmacy.asset.employee.entity.Employee;
import com.excellenthealthSolution.pharmacy.asset.employee.entity.Enum.CivilStatus;
import com.excellenthealthSolution.pharmacy.asset.employee.entity.Enum.Designation;
import com.excellenthealthSolution.pharmacy.asset.employee.entity.Enum.EmployeeStatus;
import com.excellenthealthSolution.pharmacy.asset.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class ExContr {
    @Autowired
    private UserService userService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleService roleService;

    @GetMapping
    public User find() {

        Employee employee = new Employee();
        employee.setNumber("PB0001");
        employee.setTitle(Title.MR);
        employee.setName("Sammera Banda");
        employee.setCallingName("sameera");
        employee.setGender(Gender.MALE);
        employee.setNic("900600900V");
        employee.setDateOfBirth(LocalDate.now());
        employee.setCivilStatus(CivilStatus.UNMARRIED);
        employee.setEmail("asaderc@gmail.com");
        employee.setMobile("0772350400");
        employee.setLand("");
        employee.setAddress("hahahhaha");
        employee.setDesignation(Designation.MANAGER);
        employee.setEmployeeStatus(EmployeeStatus.WORKING);
        employee.setDateOfAssignment(LocalDate.now());

        List<Role> roles = new ArrayList<>();

        Role role = new Role();
        role.setRoleName("MANAGER");
        roles.add(role);
        Role role1 = new Role();
        role1.setRoleName("CASHIER");
        roles.add(role1);
        Role role2 = new Role();
        role2.setRoleName("GRV");
        roles.add(role2);


        User user = new User();
        user.setEmployee(employee);
        user.setUsername("sameera");
        user.setCreatedDate(LocalDate.now());
        user.setEnabled(true);
        user.setRoles(roles);
        user.setPassword("12345");



        return userService.persist(user);


    }
}
