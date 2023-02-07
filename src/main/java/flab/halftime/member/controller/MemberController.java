package flab.halftime.member.controller;

import flab.halftime.member.domain.MemberDTO;
import flab.halftime.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @GetMapping("member/signup")
    public String signupForm() {
        return "signup";
    }

    @GetMapping("member/login")
    public String login(@ModelAttribute MemberDTO memberDTO) {
        return "login";
    }

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
