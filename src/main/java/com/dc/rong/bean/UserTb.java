package com.dc.rong.bean;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_user")
public class UserTb {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(length = 20,name = "u_name")
    private String name;

    @Column(length = 50,name = "u_pass")
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private UserState userState;

    private LocalDate expireTime;

    private LocalDateTime createTime;

    @Transient
    private UserGroup userGroup;

    @Getter
    public static enum UserState{
        NEW("new"),
        UNIVERSAL("正常"),
        LOCKED("账户锁"),
        UNLOCKED("账户没有被锁"),
        EXPIRE("账户过期");
        private String stateMsg;
        private UserState(String stateMsg){
            this.stateMsg = stateMsg;
        }
    }
}
