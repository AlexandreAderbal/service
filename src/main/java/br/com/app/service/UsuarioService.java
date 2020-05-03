package br.com.app.service;

import br.com.app.entity.Permissao;
import br.com.app.entity.Usuario;
import br.com.app.exception.CustomException;
import br.com.app.payload.LoginRequest;
import br.com.app.payload.LoginResponse;
import br.com.app.repository.UsuarioRepository;
import br.com.app.service.generic.GenericServiceImpl;
import br.com.app.utils.AppUtil;
import br.com.app.utils.JwtUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioService extends GenericServiceImpl<Usuario,UsuarioRepository> {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private PermissaoService permissaoService;

    @Autowired
    private EmailService emailService;

    @Override
    public void save(Usuario entity) {
        try {
            boolean enviarEmailSenha = false;

            if(entity.getId() == null) {
                enviarEmailSenha = true;
                String senha = AppUtil.gerarSenha();
                entity.setSenha(senha);
            }

            if(!AppUtil.validateCPF(entity.getCpf())){
                throw new CustomException("O CPF é inválido.");
            }

            super.save(entity);

            if(enviarEmailSenha)
                emailService.sendSenhaMail(entity.getEmail(),entity.getSenha());

        } catch (Exception e) {
            logger.error("Ocorreu um erro ao tentar registrar o usuario: " + entity.getEmail());
            throw new CustomException(e);
        }
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Optional<Usuario> findByEmail(String email) {
        try {

            return usuarioRepository.findByEmail(email);

        } catch (Exception e) {
            logger.error("Não foi encontrado o usuario com email " + email,e);
            throw new CustomException(e);
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveAdm() {

        try {

            Usuario usuario = this.findByEmail("alexandre.aderbal@outlook.com.br").orElse(new Usuario());

            if(usuario != null && usuario.getId() == null){

                String senha = AppUtil.gerarSenha();

                usuario.setNome("Alexandre Aderbal Dias");
                usuario.setCpf("31992270074");
                usuario.setEmail("alexandre.aderbal@outlook.com.br");
                usuario.setSenha(encoder.encode(senha));
                super.save(usuario);

                this.emailService.sendSenhaMail(usuario.getEmail(),senha);
            }

        } catch (Exception e) {
            logger.error("Erro ao criar o usuario administrador.");
            throw new CustomException(e);
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateSenha(String senha,Long id) {
        try{

            Usuario usuario = this.findById(id).orElseThrow(
                    ()->  new CustomException("O usuário com o id -" + id + "não foi encontrado."));

            if(encoder.matches(usuario.getSenha(),senha))
                throw new CustomException("Informe uma senha diferente da anterior.");

            if(AppUtil.validateSize(senha,5,10))
                throw new CustomException("{senha.size}");

            this.usuarioRepository.updateSenha(senha,usuario.getId());

        }catch (Exception e){
            logger.error("Erro ao tentar alterar a senha:");
            throw new CustomException(e);
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public LoginResponse autenticacao(LoginRequest loginRequest){

        LoginResponse loginResponse = new LoginResponse();

        try{

            Authentication authentication  = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                                                            loginRequest.getSenha()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            loginResponse.setToken(jwtUtils.generateJwtToken(authentication));

            loginResponse.setUsuario(this.findByEmail(loginRequest.getEmail()).orElse(new Usuario()));

        }catch (Exception e){
            logger.error("Erro na autenticação:");
            throw new CustomException(e);
        }

        return loginResponse;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateUsuarioPermissao(Long idUsuario, Long idPermissao){

        try{

            Permissao permissao = permissaoService.findById(idPermissao)
                    .orElseThrow(
                            ()-> new CustomException("A permissão com o codigo " + idPermissao + " não foi encontrada."));

            Usuario usuario = usuarioRepository.findById(idUsuario)
                    .orElseThrow(
                            ()-> new CustomException("O usuário com o codigo " + idUsuario + " não foi encontrado."));

            Boolean canAdd = !usuario.getPermissoes().stream().anyMatch( p -> p.getId() == permissao.getId());

            if(canAdd){
                usuario.getPermissoes().add(permissao);
            }else{
                usuario.getPermissoes().remove(permissao);
            }

            this.save(usuario);

        }catch (Exception e){
            logger.error("Erro vincular permisão ao usuario:");
            throw new CustomException(e);
        }
    }
}
