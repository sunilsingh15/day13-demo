package sg.edu.nus.iss.day13demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.day13demo.model.Contact;

@Controller
@RequestMapping(path = "/")
public class AddressBookController {
    
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

        return "addressBook";
    }

}
