package com.apiboard.member;

import com.apiboard.entity.common.EntityDate;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends EntityDate{
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="member_Id")
private Long id;

@Column(nullable = false,length = 30, unique = true)
private String email;
private String password;

@Column(nullable = false,length = 20)
    private String username;

@Column(nullable = false, unique = true, length = 20)
    private String nickname;

@OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MemberRole> roles;

public Member(String email, String password, String username, String nickname, List<Role> roles){
    this.email = email;
    this.password = password;
    this.username = username;
    this.nickname = nickname;
    this.roles = roles.stream().map(r -> new MemberRole(this, r)).collect(toSet());
}

public void updateNickname(String nickname){
    this.nickname = nickname;
}

}
