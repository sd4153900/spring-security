package com.study.springSecurity.security;

import com.study.springSecurity.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserService myUserService;

    @Autowired
    public SpringSecurityConfig(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

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
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/js/**","/css/**","/images/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Spring security 5.0中新增了多种加密方式，也改变了密码的格式
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //inMemoryAuthentication 从内存中获取
        auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder)
                .withUser("admin").password(bCryptPasswordEncoder.encode("123456")).roles("ADMIN");
        auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder)
                .withUser("zhangjian").password(bCryptPasswordEncoder.encode("zhangjian")).roles("ADMIN");
        auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder)
                .withUser("demo").password(bCryptPasswordEncoder.encode("demo")).roles("USER");

        //通过service获取
        auth.userDetailsService(myUserService).passwordEncoder(bCryptPasswordEncoder);
        //通过数据库获取  数据库表 users.ddl
        auth.jdbcAuthentication().usersByUsernameQuery("").authoritiesByUsernameQuery("").passwordEncoder(bCryptPasswordEncoder);
    }
}
