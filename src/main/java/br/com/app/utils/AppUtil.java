package br.com.app.utils;

import java.util.Random;

public class AppUtil {

    public static  boolean validateNotEmpty(String valor){

        if(valor == null) return  false;
        if(valor.length() > 0) return true;
        return  false;
    }

    static public boolean validateCPF (String strCpf ){

        if(strCpf == null) return false;

        int     d1, d2;
        int     digito1, digito2, resto;
        int     digitoCPF;
        String  nDigResult;

        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;

        for (int nCount = 1; nCount < strCpf.length() -1; nCount++)
        {
            digitoCPF = Integer.valueOf (strCpf.substring(nCount -1, nCount)).intValue();

            d1 = d1 + ( 11 - nCount ) * digitoCPF;//multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.

            d2 = d2 + ( 12 - nCount ) * digitoCPF;//para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
        };

        resto = (d1 % 11);//Primeiro resto da divisão por 11.

        if (resto < 2)//Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
            digito1 = 0;
        else
            digito1 = 11 - resto;

        d2 += 2 * digito1;

        resto = (d2 % 11);//Segundo resto da divisão por 11.

        if (resto < 2)  //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
            digito2 = 0;
        else
            digito2 = 11 - resto;

        String nDigVerific = strCpf.substring (strCpf.length()-2, strCpf.length()); //Digito verificador do CPF que está sendo validado.

        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);//Concatenando o primeiro resto com o segundo.

        return nDigVerific.equals(nDigResult);//comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
    }

    public static String gerarSenha(){

        String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ0123456789";

        Random random = new Random();

        String armazenaChaves = "";
        int index = -1;
        for( int i = 0; i <= 4; i++ ) {
            index = random.nextInt( letras.length() );
            armazenaChaves += letras.substring( index, index + 1 );
        }

        return  armazenaChaves;
    }


    public static boolean validateSize(String senha, int min, int max) {

        if(senha == null || max == 0) return false;
        if(senha.length() <= min) return false;
        if(senha.length() >= max) return false;

        return  true;
    }
}
