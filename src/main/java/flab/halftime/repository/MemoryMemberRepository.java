package flab.halftime.repository;

import flab.halftime.domain.MemberDTO;

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
    public Optional<MemberDTO> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<MemberDTO> findByEmail(String email) {
        return store.values().stream().filter(memberDTO -> memberDTO.getMemberEmail().equals(email)).findAny();
    }

    @Override
    public Optional<MemberDTO> findByName(String name) {
        return store.values().stream().filter(memberDTO -> memberDTO.getMemberName().equals(name)).findAny();
    }

    @Override
    public List<MemberDTO> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
