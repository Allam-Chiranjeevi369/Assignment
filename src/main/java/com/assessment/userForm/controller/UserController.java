package com.assessment.userForm.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.userForm.model.User;
import com.assessment.userForm.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(value = "/register")
	public String persist(@ModelAttribute User user, Model model) {
		
		 LocalDate dob = user.getDateOfBirth();
	     int age = calculateAge(dob);
	     int enteredAge = user.getAge();
	     
	     if (age == enteredAge) {
	    	 try {
	 			userService.persist(user);
	 			model.addAttribute("dataList",user);
	 			return "home";
	 		}catch(UnexpectedRollbackException e) {
	 			model.addAttribute("error", "This email is already registered..!");
	 			return "index";
	 		}
	     } else {
	    	 model.addAttribute("error", "Age and Date of birth Selected do not match");
	 		 return "index";
	     }
	     
		
	}
	
//	Edgw case to check whether date of birth selected == age entered.
	private int calculateAge(LocalDate dob) {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - dob.getYear();
        if (today.getMonthValue() < dob.getMonthValue()
                || (today.getMonthValue() == dob.getMonthValue() && today.getDayOfMonth() < dob.getDayOfMonth())) {
            age--;
        }
        return age;
    }
	
	@GetMapping("/allData")
	public String getAllUsers(Model model) {

		var users = userService.getAllUsers();
		model.addAttribute("dataList",users);
		return "data";
		
	}
	
}
