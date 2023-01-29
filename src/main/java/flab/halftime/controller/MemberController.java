package flab.halftime.controller;

import flab.halftime.domain.MemberDTO;
import flab.halftime.service.MemberSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/member")
public class MemberController {

    private final MemberSevice memberSevice;

    //    @GetMapping("member/save")
    @GetMapping("/signup")
    public String signupForm() {
        return "signup";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO) {
        return "home";
    }

    @Autowired
    public MemberController(MemberSevice memberSevice) {
        this.memberSevice = memberSevice;
    }
}
