package bdaytemplate.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import bdaytemplate.dto.EmailRequest;
import bdaytemplate.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired(required=true)
	private JavaMailSender mailSender;

	@Autowired
	private EmailService emailService;


	@PostMapping("/error")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping("/emailwithimage")
	public String sendHTMLEmailWithInlineImage1(Model model) throws MessagingException {
		emailService.sendEmailWithInlineImage();
	    model.addAttribute("message", "An HTML email with inline image has been sent");
	    return "result";
	}

	@Scheduled(cron = "0 02 13 * * ?", zone = "Asia/Kolkata")
	// Daily at 10:10 AM IST
	public void sendHTMLEmailWithInlineImageDaily() throws MessagingException, IOException {
		emailService.sendEmailWithInlineImage();
	}
/////////////////////////////////////////////////////////add and save//////////////////
	@GetMapping("/add")
	public ModelAndView addEmployeeDetail() {
		ModelAndView modelAndView = new ModelAndView("addEmployee");
		System.out.println("Inside add employee");
		return modelAndView;
	}

	@RequestMapping(value="add-Inventryitem",method = RequestMethod.POST)
	public ModelAndView saveEmployee(HttpServletRequest request) {
		EmailRequest employee=new EmailRequest(Integer.parseInt(request.getParameter("employeeid")), request.getParameter("name"), request.getParameter("birthdate"), request.getParameter("email"), request.getParameter("reporting_manager"));
		emailService.saveEmployee(employee) ;
		//	List<EmailRequest> list = emailService.getListOfAllInventory();

		ModelAndView model=new ModelAndView();
		//model.addObject("list",list);
		System.out.println("Inside saveEmployee controller");

		model.setViewName("addEmployee");
		return model;
	}

////////////////////////////////////////get employee  by id return///////////////
	@GetMapping("/employee/{id}")
	public EmailRequest getEmployeeById(@PathVariable int id) {
		return emailService.getEmployeeById(id);
	}
	//////////////////////////////get  all employee return///////////////////
	@GetMapping("/getAllEmployee")
//	@Operation(summary = "CUSTOMER PROCESS--Get LIST OF ALL Inventry item")
	public ModelAndView getListOfAllEmployee() {
		List<EmailRequest> list  = emailService.getListOfAllEmployee();
		System.out.println(list);
		ModelAndView       model =new ModelAndView();
		model.addObject("list",list);
		model.setViewName("getEmployee");
		return model;
	}
	////////////////////////////////////////////////////////

	@GetMapping("/delete/{id}")
//	@Operation(summary = "ADMIN PROCESS--DELETE  Inventory item ")
	public ModelAndView deleteProductById(@PathVariable int id) {
		emailService.deleteEmployeeById(id);
		List<EmailRequest> list= emailService.getListOfAllEmployee();

		ModelAndView model=new ModelAndView();
		model.addObject("list",list);

		model.setViewName("getEmployee");
		return model;
	}


	///////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "update/employee/{employeeid}", method = RequestMethod.GET)
	public ModelAndView updatePage(@PathVariable("employeeid") int employeeid) {
//        userModel.addAttribute("productId", productId);
//        userModel.addAttribute("inventory", inventoryService.getInventryProductById(productId));

		ModelAndView model=new ModelAndView("updateEmployee");

		model.addObject("employeeid",employeeid);
		model.addObject("employee", emailService.getEmployeeById(employeeid));

//        model.setViewName("updateEmployee");
		return model;

	}
	@RequestMapping(value = "update/user", method = RequestMethod.POST)
	public ModelAndView updateUser(@RequestParam int employeeid, @RequestParam(value = "name", required = true) String name,
								   @RequestParam(value = "birthdate", required = true) String birthdate, @RequestParam(value = "email", required = true) String email, @RequestParam(value = "reporting_manager", required = true) String reporting_manager) {
		EmailRequest userDetail = new EmailRequest();
		userDetail.setEmployeeid(employeeid);
		userDetail.setName(name);
		userDetail.setBirthdate(birthdate);
		userDetail.setEmail(email);
		userDetail.setReporting_manager(reporting_manager);

		int resp = emailService.updateEmployee(userDetail);
		System.out.println("ffffffffffffffffffffffffffffffffffffffffffff"+resp);
		ModelAndView model=new ModelAndView();
		model.addObject("employeeid",employeeid);

//        userModel.addAttribute("productId", productId);
		if (resp > 0) {

			model.addObject("msg", "User with id : " + employeeid + " updated successfully.");
			model.addObject("list", emailService.getListOfAllEmployee());
			model.setViewName("getEmployee");
//
//            userModel.addAttribute("msg", "User with id : " + productId + " updated successfully.");
//            userModel.addAttribute("userDetail", inventoryService.getListOfAllInventory());
			return model;
		} else {
			model.addObject("msg", "User with id : " + employeeid + " updation failed.");
			model.addObject("userDetail", emailService.getEmployeeById(employeeid));
			model.setViewName("updateEmployee");
//            userModel.addAttribute("msg", "User with id : " + productId + " updation failed.");
//            userModel.addAttribute("userDetail", inventoryService.getInventryProductById(productId));
			return model;
		}
	}

}
