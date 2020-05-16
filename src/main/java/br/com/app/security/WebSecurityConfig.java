package br.com.app.security;

import br.com.app.enums.PermissaoEnum;
import br.com.app.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowCredentials(true);
        config.applyPermitDefaultValues();

        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/auth/**").permitAll()

//                //Rotina de usuario
//                .antMatchers("/usuario/save","/usuario/update/**").hasAuthority(PermissaoEnum.ROLE_USUARIO_DELETAR.toString())
//                .antMatchers("/usuario/find/**","/usuario/by/email").hasAuthority(PermissaoEnum.ROLE_USUARIO_CONSULTAR.toString())
//                .antMatchers("/usuario/delete").hasAuthority(PermissaoEnum.ROLE_USUARIO_DELETAR.toString())
//
//                //Rotina de permissão
//                .antMatchers("/permissao/save").hasAuthority(PermissaoEnum.ROLE_PERMISSAO_REGISTRAR.toString())
//                .antMatchers("/permissao/find/**","/permissao/lista").hasAuthority(PermissaoEnum.ROLE_PERMISSAO_CONSULTAR.toString())
//                .antMatchers("/permissao/delete").hasAuthority(PermissaoEnum.ROLE_PREMISSAO_DELETAR.toString())
//
//                //Rotina de cidade
//                .antMatchers("/cidade/save").hasAuthority(PermissaoEnum.ROLE_CIDADE_REGISTRAR.toString())
//                .antMatchers("/cidade/find/**").hasAuthority(PermissaoEnum.ROLE_CIDADE_CONSULTAR.toString())
//                .antMatchers("/cidade/delete").hasAuthority(PermissaoEnum.ROLE_CIDADE_DELETAR.toString())
//
//                //Rotina de estado
//                .antMatchers("/estado/save").hasAuthority(PermissaoEnum.ROLE_ESTADO_REGISTRAR.toString())
//                .antMatchers("/estado/find/**").hasAuthority(PermissaoEnum.ROLE_ESTADO_CONSULTAR.toString())
//                .antMatchers("/estado/delete").hasAuthority(PermissaoEnum.ROLE_ESTADO_DELETAR.toString())
//
//                //Rotina de fornecedor
//                .antMatchers("/fornecedor/save").hasAuthority(PermissaoEnum.ROLE_FORNECEDOR_REGISTRAR.toString())
//                .antMatchers("/fornecedor/find/**").hasAuthority(PermissaoEnum.ROLE_FORNECEDOR_CONSULTAR.toString())
//                .antMatchers("/fornecedor/delete").hasAuthority(PermissaoEnum.ROLE_FORNECEDOR_DELETAR.toString())
//
//                //Rotina de produto
//                .antMatchers("/produto/save").hasAuthority(PermissaoEnum.ROLE_PRODUTO_REGISTRAR.toString())
//                .antMatchers("/produto/find/**").hasAuthority(PermissaoEnum.ROLE_PRODUTO_CONSULTAR.toString())
//                .antMatchers("/produto/delete").hasAuthority(PermissaoEnum.ROLE_PRODUTO_DELETAR.toString())
//
//                //Rotina de tipo embalagem
//                .antMatchers("/tipo/embalagem/save").hasAuthority(PermissaoEnum.ROLE_TIPO_EMBALAGEM_REGISTRAR.toString())
//                .antMatchers("/tipo/embalagem/find/**").hasAuthority(PermissaoEnum.ROLE_TIPO_EMBALAGEM_CONSULTAR.toString())
//                .antMatchers("/tipo/embalagem/delete").hasAuthority(PermissaoEnum.ROLE_TIPO_EMBALAGEM_DELETAR.toString())

                .anyRequest().authenticated();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class)
        ;
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}
