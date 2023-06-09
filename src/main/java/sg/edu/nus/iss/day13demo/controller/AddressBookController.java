package sg.edu.nus.iss.day13demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.day13demo.model.Contact;
import sg.edu.nus.iss.day13demo.utility.Utility;

@Controller
@RequestMapping(path = "/")
public class AddressBookController {

    @Autowired
    Utility utility;
    
    // request method to load landing page
    @GetMapping
    public String showAddressBook(Model model) {
        model.addAttribute("contact", new Contact());
        return "addressBook";
    }

    // post method
    @PostMapping("/contact")
    public String saveAddressBook(@Valid Contact contact, BindingResult result) {
        
        System.out.println("Name: " + contact.getName());
        System.out.println("E-mail: " + contact.getEmail());
        System.out.println("Phone Number: " + contact.getPhoneNumber());

        if (result.hasErrors()) {
            return "addressBook";
        }

        // custom data validation to check if email is unique and return message if so
        if (!utility.isUniqueEmail(contact.getEmail())) {
            ObjectError err = new ObjectError("globalError", "%s is not available".formatted(contact.getEmail()));
            result.addError(err);
        }

        return "addressBook";
    }

}
