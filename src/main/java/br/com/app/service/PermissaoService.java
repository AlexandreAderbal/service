package br.com.app.service;

import br.com.app.entity.Permissao;
import br.com.app.entity.Usuario;
import br.com.app.enums.PermissaoEnum;
import br.com.app.enums.TipoPermissaoEnum;
import br.com.app.exception.CustomException;
import br.com.app.payload.ListaPermissao;
import br.com.app.repository.PermissaoRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissaoService extends GenericServiceImpl<Permissao, PermissaoRepository> {

    private static final Logger logger = LoggerFactory.getLogger(PermissaoService.class);

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private  UsuarioService usuarioService;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public List<ListaPermissao> findAllListaPermissao(Long idUsuario){

        List<ListaPermissao> permissoes = new ArrayList<ListaPermissao>();

        try{

            ListaPermissao usuario = new ListaPermissao();
            usuario.setTitulo("Tela de usuário.");
            usuario.setPermissoes(permissaoRepository.findByTipo(TipoPermissaoEnum.USUARIO));
            permissoes.add(usuario);

            ListaPermissao permissao = new ListaPermissao();
            permissao.setTitulo("Modal de permissão.");
            permissao.setPermissoes(permissaoRepository.findByTipo(TipoPermissaoEnum.PERMISSAO));
            permissoes.add(permissao);

            Usuario u = usuarioService.findById(idUsuario).orElseThrow(
                    ()-> new Exception("O usuário com o codigo " + idUsuario + " não foi encontrado.")
            );

            permissoes.forEach( dto ->{
                dto.getPermissoes().forEach( p -> {
                    p.setSelecionado(u.getPermissoes().contains(p));
                });
            });

        }catch (Exception e){
            throw new CustomException(e);
        }

       return permissoes;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void inicializaPermissao(){
        try {

            List<Permissao> list = this.findAll();
            for (PermissaoEnum permissaoEnum : PermissaoEnum.values()) {
                boolean canAdd = true;
                for (Permissao permissao : list) {
                    if (permissao.getNome() == permissaoEnum) {
                        canAdd = false;
                        break;
                    }
                }
                if (canAdd) {

                    Permissao p = new Permissao();
                    p.setNome(permissaoEnum);
                    p.setDescricao(permissaoEnum.getValue());

                    switch (permissaoEnum) {
                        case ROLE_USUARIO_GRAVAR:
                        case ROLE_USUARIO_PESQUISAR:
                        case ROLE_USUARIO_DELETAR:
                            p.setTipo(TipoPermissaoEnum.USUARIO);
                            break;
                        case ROLE_PERMISSAO_GRAVAR:
                        case ROLE_PERMISSAO_PESQUISAR:
                        case ROLE_PREMISSAO_DELETAR:
                            p.setTipo(TipoPermissaoEnum.PERMISSAO);
                            break;
                    }

                    this.save(p);
                }

            }

        }catch (Exception e){
            logger.error("Erro ao inicializar as informações.",e.getMessage());
            throw new CustomException(e);
        }
    }

}
