package io.eddie.formbased.view;

import io.eddie.formbased.dto.SignUpRequest;
import io.eddie.formbased.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ViewController {

    private final MemberService memberService;

    @GetMapping("/login-page")
    public String showSignInPage() {
        return "sign_in";
    }

    @GetMapping("/sign-up")
    public String showSignUpPage() {
        return "sign_up";
    }

    @PostMapping("/sign-up")
    public String doSignUpPage(SignUpRequest request) {

        memberService.save(request);

        return "redirect:/login";
    }

}
