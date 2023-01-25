package flab.halftime.service;

import flab.halftime.domain.MemberDTO;
import flab.halftime.repository.MemberMapperRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberSevice {
//    private final MemberMapperRepository memoryMemberRepository = new MemoryMemberRepository();

    private final MemberMapperRepository MemberMapperRepository;

    public MemberSevice(MemberMapperRepository MemberMapperRepository) {
        this.MemberMapperRepository = MemberMapperRepository;
    }


    /*
    회원가입
     */
    public Long join(MemberDTO memberDTO) {
        validateDuplicateMemberDTO(memberDTO); // 중복 회원 검증
        MemberMapperRepository.save(memberDTO);
        return memberDTO.getId();
    }

    private void validateDuplicateMemberDTO(MemberDTO memberDTO) {
        MemberMapperRepository.findByEmail(memberDTO.getMemberEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<MemberDTO> findMemberDTOs() {
        return MemberMapperRepository.findAll();
    }

    public Optional<MemberDTO> findOne(Long memberDTOId) {
        return MemberMapperRepository.findById(memberDTOId);
    }

}
