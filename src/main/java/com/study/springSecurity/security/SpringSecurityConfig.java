package com.study.springSecurity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()//获取验证配置
                .antMatchers("/").permitAll()//不验证"/"请求
                .anyRequest().authenticated()//验证其他请求
                .and()
                .logout().permitAll()//不验证登出请求
                .and()
                .formLogin();//不验证表单登录请求
        http.csrf().disable();//关闭csrf认证
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring().antMatchers("/js/**","/css/**","/images/**");
    }
}
