package port.sport.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.w3c.dom.stylesheets.LinkStyle;
import port.sport.dto.MemberLoginDto;
import port.sport.entitiy.Member;
import port.sport.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member longinCheck(MemberLoginDto loginDto) {
        return memberRepository.findByLoginIdAndPassword(loginDto.getLonginId(), loginDto.getPassword());
    }

    public Member save(@ModelAttribute Member member) {
        memberRepository.save(member);
        return member;
    }

    public void sss() {
        List<Integer> list= new ArrayList<>();
    }
}
