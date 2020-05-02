package br.com.app.service;

import br.com.app.entity.Permissao;
import br.com.app.entity.Usuario;
import br.com.app.enums.TipoPermissaoEnum;
import br.com.app.exception.CustomException;
import br.com.app.payload.ListaPermissao;
import br.com.app.repository.PermissaoRepository;
import br.com.app.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissaoService extends GenericServiceImpl<Permissao, PermissaoRepository> {

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

           /* permissoes.forEach( dto ->{
                dto.getPermissoes().forEach( p -> {
                    p.setSelecionado(u.getPermissoes().contains(p));
                });
            });*/

        }catch (Exception e){
            throw new CustomException(e);
        }

       return permissoes;
    }

}
