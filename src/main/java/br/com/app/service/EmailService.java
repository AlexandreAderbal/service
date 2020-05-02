package br.com.app.service;

import br.com.app.exception.CustomException;
import br.com.app.utils.TemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    @Transactional(readOnly = false, propagation = Propagation.SUPPORTS)
    public boolean sendSenhaMail(String email,String senha) {

        try {

            this.send(email,email,TemplateUtil.emailSenha(senha));

            return true;

        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new CustomException(e);
        }
    }

    private void send(String to,String from,String text){

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject("Senha de acesso ao sistema.");
            messageHelper.setText(text,true);
        };

        try {
            this.mailSender.send(messagePreparator);

        } catch (Exception e) {
            logger.error("Ocorreu um erro ao tentar enviar um email para o endereço:" + from);
            throw new CustomException(e);
        }
    }
}
