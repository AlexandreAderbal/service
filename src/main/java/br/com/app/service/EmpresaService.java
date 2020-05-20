package br.com.app.service;

import br.com.app.entity.Empresa;
import br.com.app.exception.CustomException;
import br.com.app.repository.EmpresaRepository;
import br.com.app.service.generic.GenericServiceImpl;
import br.com.app.utils.AppUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpresaService extends GenericServiceImpl<Empresa, EmpresaRepository> {

    private static final Logger logger = LoggerFactory.getLogger(EmpresaService.class);

    @Autowired
    private EnderecoService enderecoService;

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void save(Empresa entity) {
        try {

            enderecoService.save(entity.getEndereco());

            super.save(entity);

        } catch (Exception e) {
            logger.error("Ocorreu um erro ao tentar registrar a empresa:");
            throw new CustomException(e);
        }

    }

    @Override
    public void validate(Empresa entity) {

        if(!AppUtil.isValidCNPJ(entity.getCnpj())){
            throw new CustomException("O CNPJ é inválido.");
        }

    }
}
