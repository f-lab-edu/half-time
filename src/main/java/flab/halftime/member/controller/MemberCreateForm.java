package flab.halftime.member.controller;

public class MemberCreateForm {
    private String memberEmail;
    private String memberPassword;
    private String memberConfirmPassword;
    private String memberName;

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberConfirmPassword() {
        return memberConfirmPassword;
    }

    public void setMemberConfirmPassword(String memberConfirmPassword) {
        this.memberConfirmPassword = memberConfirmPassword;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
