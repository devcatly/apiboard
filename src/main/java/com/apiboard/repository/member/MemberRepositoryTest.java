package com.apiboard.repository.member;

import com.apiboard.member.Member;

public class MemberRepositoryTest {
    @Autowired MemberRepository memberRepository;
    @Autowired RoleRepository roleRepository;
    @PersistenceContext EntityManager em;

    @Test
    void createAndReadTest(){

        //given
        Member member = createMember();

        //when
        memberRepository.save(member);
        clear();

        // then
        Member foundMember = memberRepository.findById(member.getId()).orElseThrow(MemberNotFoundException::new);
        assertThat(foundMember.getId()).isEqualTo(member.getId());
    }


    }


}
