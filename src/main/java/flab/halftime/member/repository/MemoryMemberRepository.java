package flab.halftime.member.repository;

import flab.halftime.member.domain.MemberDTO;

import java.util.*;

public class MemoryMemberRepository implements MemberMapperRepository{

    private static Map<Long, MemberDTO> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public MemberDTO save(MemberDTO memberDTO) {
        memberDTO.setId(++sequence);
        store.put(memberDTO.getId(), memberDTO);
        return memberDTO;
    }

    @Override
    public Optional<MemberDTO> findByEmail(String email) {
        return store.values().stream()
                .filter(memberDTO -> memberDTO.getMemberEmail().equals(email)).findAny();
    }

    @Override
    public Optional<MemberDTO> findByUserProfile(MemberDTO dto) {
        Optional<MemberDTO> userEmail = store.values().stream()
                .filter(memberDTO -> memberDTO.getMemberEmail().equals(dto.getMemberEmail())).findAny();
        if (userEmail.isEmpty()) {
            return Optional.empty();
        } else{
            MemberDTO memberDTO = userEmail.get();
            if (memberDTO.getMemberName().equals(dto.getMemberName())) {
                return Optional.of(memberDTO);
            }else {
                return Optional.empty();
            }
        }
    }



    public void clearStore() {
        store.clear();
    }
}
