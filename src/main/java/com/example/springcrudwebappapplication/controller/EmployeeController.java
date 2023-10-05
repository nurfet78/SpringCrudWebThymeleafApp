package com.example.springcrudwebappapplication.controller;

import com.example.springcrudwebappapplication.model.Employee;
import com.example.springcrudwebappapplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {

    private EmployeeService service;

    @Autowired
    public void setService(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showHomePage(Model model) {
        List<Employee> employeeList = service.getAllEmployees();

        model.addAttribute("employeeList", employeeList);

        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());

        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee")Employee employee,
                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            if (employee.getId() == 0) {
                return "new_employee";
            } else {
                return "update_employee";
            }
        }
        service.saveEmployee(employee);

        return "redirect:/";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") long id, Model model) {
        Employee employee = service.getEmployeeById(id);
        model.addAttribute("employee", employee);

        return "update_employee";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam("id") long id) {
        service.deleteEmployeeById(id);

        return "redirect:/";
    }


}



























































































