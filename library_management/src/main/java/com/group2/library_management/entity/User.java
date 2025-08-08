package com.group2.library_management.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends Auditable implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDate dob;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @Column(length = 20)
    private String phone;

    @Column(columnDefinition = "TEXT")
    private String address;

    @Column(nullable = false)
    private Integer role;

    @Column(nullable = false)
    private Integer status; // 0: inactive, 1: active

    @OneToMany(mappedBy = "user")
    private List<Follow> follows;

    @OneToMany(mappedBy = "user")
    private List<BorrowingReceipt> borrowingReceipts;

    @OneToMany(mappedBy = "user")
    private List<Rating> ratings;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        RoleType roleType = RoleType.fromValue(this.role);
        return List.of(new SimpleGrantedAuthority(roleType.getAuthority()));
    }
    
    public String getRoleString() {
        RoleType roleType = RoleType.fromValue(this.role);
        return roleType.getAuthority();
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.status != 0; 
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.status != 0;
    }
}
