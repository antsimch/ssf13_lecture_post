package sg.edu.nus.iss.ssf13_lecture_post.controller;

import org.apache.coyote.http11.filters.GzipOutputFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import sg.edu.nus.iss.ssf13_lecture_post.model.Contact;
import sg.edu.nus.iss.ssf13_lecture_post.utility.Utility;

@Controller
@RequestMapping (path = "/")
public class AddressBookController {

    @Autowired
    Utility utility;
    
    @GetMapping
    public String getAddressBook(Model model) {
        model.addAttribute("contact", new Contact());
        return "addressBook";
    }

    // @PostMapping(consumes = "application/x-www-form-urlencoded", path = "/contact")
    // public String saveAddressBook(Contact contact) {
    //     System.out.println("Name: " + contact.getName());
    //     System.out.println("Email: " + contact.getEmail());
    //     System.out.println("Tel No.: " + contact.getTelNo());
    //     return "addressBook";
    // }

    // @PostMapping(consumes = "application/x-www-form-urlencoded", path = "/contact")
    // public String saveAddressBook(@RequestBody MultiValueMap<String, String> form, Model model) {

    //     String name = form.getFirst("name");
    //     String email = form.getFirst("email");
    //     String telNo = form.getFirst("telNo");

    //     System.out.println("using MultiValueMap: " + name);
        
    //     return "addressBook";
    // }

    @PostMapping(consumes = "application/x-www-form-urlencoded", path = "/contact")
    public String saveAddressBook(@Valid Contact contact, BindingResult bindingResult, Model model) {
        System.out.println("Name: " + contact.getName());
        System.out.println("Email: " + contact.getEmail());
        System.out.println("Tel No.: " + contact.getTelNo());

        if (bindingResult.hasErrors()) {
            // System.out.println("No. of errors: " + bindingResult.getErrorCount());
            // String errorMessage = "Error in validating attribute";
            // model.addAttribute("errorMessage", errorMessage);
            return "addressBook";
        }

        if (!utility.isUniqueEmail(contact.getEmail())) {
            ObjectError error = new ObjectError("globalError", "%s is not available".formatted(contact.getEmail()));
            bindingResult.addError(error);
            return "addressBook";
        }

        return "addressBook";
    }

}
