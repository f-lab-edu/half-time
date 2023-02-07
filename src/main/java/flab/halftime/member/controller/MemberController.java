package flab.halftime.member.controller;

import flab.halftime.member.domain.MemberDTO;
import flab.halftime.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signUp")
    public String signup(MemberCreateForm form) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail(form.getMemberEmail());
        memberDTO.setMemberName(form.getMemberName());
        memberService.join(memberDTO);

        return "redirect:/";
    }

    @GetMapping("member/signup")
    public String signUpForm() {
        return "signup";
    }

    @GetMapping("member/user")
    public String findUserForm() {
        return "user";
    }

    @Autowired
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }
}
