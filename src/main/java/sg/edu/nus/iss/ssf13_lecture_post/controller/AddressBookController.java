package sg.edu.nus.iss.ssf13_lecture_post.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.nus.iss.ssf13_lecture_post.model.Contact;

@Controller
@RequestMapping (path = "/")
public class AddressBookController {
    
    @GetMapping
    public String getAddressBook(Model model) {
        model.addAttribute("contact", new Contact());
        return "addressBook";
    }

    @PostMapping("/contact")
    public String saveAddressBook(Contact contact, Model model) {
        System.out.println(contact.getName());
        System.out.println(contact.getEmail());
        System.out.println(contact.getTelNo());
        return "addressBook";
    }

}
