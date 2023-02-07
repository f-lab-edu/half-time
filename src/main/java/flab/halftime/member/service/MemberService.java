package flab.halftime.member.service;

import flab.halftime.member.domain.MemberDTO;
import flab.halftime.member.repository.MemberMapperRepository;
import flab.halftime.member.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberMapperRepository memoryMemberRepository = new MemoryMemberRepository();

    /*
    회원가입
     */
    public Long join(MemberDTO memberDTO) {
        validateDuplicateMemberDTO(memberDTO); // 중복 회원 검증
        memoryMemberRepository.save(memberDTO);
        return memberDTO.getId();
    }

    private void validateDuplicateMemberDTO(MemberDTO memberDTO) {
        memoryMemberRepository.findByEmail(memberDTO.getMemberEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public void userProFile(MemberDTO memberDTO) {
        memoryMemberRepository.findByUserProfile(memberDTO);
    }
}
