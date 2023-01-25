package flab.halftime.dto;

public class MemberDTO {
    private Long id;
    private String memberEmail;
    private int certificationNumber;
    private String memberPassword;
    private String memberConfirmPassword;
    private String memberName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public int getCertificationNumber() {
        return certificationNumber;
    }

    public void setCertificationNumber(int certificationNumber) {
        this.certificationNumber = certificationNumber;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
//        패스워드 보안성 검증
        this.memberPassword = memberPassword;
    }

    public String getMemberConfirmPassword() {
        return memberConfirmPassword;
    }

    public void setMemberConfirmPassword(String memberConfirmPassword) {
//        입력한 패스워드가 올바르게 입력되었는지 검증
        this.memberConfirmPassword = memberConfirmPassword;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberEmail='" + memberEmail + '\'' +
                ", certificationNumber=" + certificationNumber +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberConfirmPassword='" + memberConfirmPassword + '\'' +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}
