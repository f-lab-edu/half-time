package flab.halftime.member.repository;

import flab.halftime.member.domain.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;


@Mapper
public interface MemberMapperRepository {
    MemberDTO save(MemberDTO memberDTO);

    Optional<MemberDTO> findById(Long id);
    Optional<MemberDTO> findByEmail(String email);

    Optional<MemberDTO> findByName(String name);

    List<MemberDTO> findAll();
}
