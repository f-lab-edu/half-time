package flab.halftime;

import flab.halftime.member.domain.MemberDTO;
import flab.halftime.member.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        // given
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail("inmoy@naver.com");
        memberDTO.setMemberConfirmPassword("123123");
        memberDTO.setMemberName("inmoy");
        //when
        repository.save(memberDTO);

        //then
        MemberDTO result = repository.findById(memberDTO.getId()).get();
        assertThat(result).isEqualTo(memberDTO);
    }

    @Test
    public void findByEmail() {
        // given
        MemberDTO memberDTO1 = new MemberDTO();
        memberDTO1.setMemberEmail("test@naver.com");
        repository.save(memberDTO1);

        // when
        MemberDTO result = repository.findByEmail("test@naver.com").get();

//        then
        assertThat(result).isEqualTo(memberDTO1);
    }

    @Test
    public void findAll() {
//        given
        MemberDTO memberDTO1 = new MemberDTO();
        memberDTO1.setMemberEmail("test@naver.com");
        repository.save(memberDTO1);

        MemberDTO memberDTO2 = new MemberDTO();
        memberDTO2.setMemberEmail("test2@naver.com");
        repository.save(memberDTO2);

//        when
        List<MemberDTO> result = repository.findAll();

//        then
        assertThat(result.size()).isEqualTo(2);
    }
}
