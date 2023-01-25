package flab.halftime.service;

import flab.halftime.repository.MemberMapperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberSerivce {
    private final MemberMapperRepository memberMapperRepository;

    @Autowired
    public MemberSerivce(MemberMapperRepository memberMapperRepository) {
        this.memberMapperRepository = memberMapperRepository;
    }
}
