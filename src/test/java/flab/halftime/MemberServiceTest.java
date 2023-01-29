package flab.halftime;

import flab.halftime.domain.MemberDTO;
import flab.halftime.repository.MemoryMemberRepository;
import flab.halftime.service.MemberSevice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MemberServiceTest {

    MemberSevice memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberSevice(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void 회원가입() throws Exception {
        // Given
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail("inmoy@naver.com");

        // when
        Long saveId = memberService.join(memberDTO);

        // Then
        MemberDTO findMember = memberRepository.findById(saveId).get();
        assertEquals(memberDTO.getMemberEmail(), findMember.getMemberEmail());
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // Given
        MemberDTO member1 = new MemberDTO();
        member1.setMemberEmail("inmoy@naver.com");

        MemberDTO member2 = new MemberDTO();
        member2.setMemberEmail("inmoy@naver.com");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2)); // 예외 발생
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
