package io.eddie.formbased.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/login-page")
    public String showSignInPage() {
        return "sign_in";
    }


}
