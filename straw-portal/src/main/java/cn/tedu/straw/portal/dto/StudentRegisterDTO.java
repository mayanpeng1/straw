package cn.tedu.straw.portal.dto;

import lombok.Data;

import java.io.Serializable;

//注册
@Data
public class StudentRegisterDTO implements Serializable {
    private String inviteCode;//验证码
    private String phone;
    private String nackName;
    private String passWorld;
}
