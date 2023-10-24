package com.jpa.shop.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.jpa.shop.domain.member.Member;
import com.jpa.shop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원가입() {
        // given
        Member member = new Member("kim", null);

        // when
        Long savedMemberId = memberService.join(member);

        // then
        assertThat(member).isEqualTo(memberRepository.findById(savedMemberId));
    }

    @Test
    void 중복_회원_예외() {
        // given
        Member member1 = new Member("Kim1", null);
        Member member2 = new Member("Kim1", null);
        memberService.join(member1);

        // when & then
        assertThatThrownBy(() -> memberService.join(member2))
            .hasMessage("이미 존재하는 회원입니다.");

    }

}
