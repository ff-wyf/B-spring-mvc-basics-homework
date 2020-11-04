package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = "[A-Za-z0-9_]{2,11}", message = "用户名不合法")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^.{5,12}$", message = "密码不合法")
    private String password;

    @Email(message = "邮箱不合法")
    private String email;
}
