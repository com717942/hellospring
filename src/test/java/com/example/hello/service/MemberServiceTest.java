package com.example.hello.service;

import com.example.hello.domain.Member;
import com.example.hello.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {

    private MemberService memberService;
    private MemoryMemberRepository memberRepository;

    @BeforeEach
    public void setUp() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @Test
    void testJoin() {
        // given
        Member member = new Member();
        member.setName("John");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    @Test
    void testJoinDuplicateMember() {
        // given
        Member member1 = new Member();
        member1.setName("John");

        Member member2 = new Member();
        member2.setName("John");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        // then
        assertEquals("이미 존재하는 회원입니다.", e.getMessage());
    }

    @Test
    void testFindOne() {
        // given
        Member member = new Member();
        member.setName("John");
        Long saveId = memberService.join(member);

        // when
        Optional<Member> findMember = memberService.findOne(saveId);

        // then
        assertTrue(findMember.isPresent());
        assertEquals(member.getName(), findMember.get().getName());
    }

    @Test
    void testFindMembers() {
        // given
        Member member1 = new Member();
        member1.setName("John");
        memberService.join(member1);

        Member member2 = new Member();
        member2.setName("Jane");
        memberService.join(member2);

        // when
        List<Member> members = memberService.findMembers();

        // then
        assertEquals(2, members.size());
    }
}
