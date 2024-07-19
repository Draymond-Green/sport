package port.sport.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import port.sport.dto.MemberLoginDto;
import port.sport.entitiy.Member;
import port.sport.service.LoginService;
import port.sport.sessionConst.SessionConst;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm() {
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute MemberLoginDto loginDto, BindingResult bindingResult, HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            return "login/loginForm";
        }

        Member member = loginService.longinCheck(loginDto);
        if (member == null) {
            return "login/loginForm";
        }

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, member);
        return "redirect:/";
    }

    @GetMapping("/login/save")
    public String joinMembershipForm() {
        return "login/save";
    }

    @PostMapping("login/save")
    public String joinMembership(@Validated @ModelAttribute Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login/save";
        }

        loginService.save(member);

        return "redirect:/";
    }
}
