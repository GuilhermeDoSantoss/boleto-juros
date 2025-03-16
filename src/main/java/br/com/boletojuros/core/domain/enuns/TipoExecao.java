package br.com.boletojuros.core.domain.enuns;

public enum TipoExecao {
    BOLETO_INVALIDO{
        @Override
        public String getMensagemErro() {
            return "O boleto encontrado é inválido!!";
        }
    },
    TIPO_BOLETO_INVALIDO{
        @Override
        public String getMensagemErro() {
            return "Infelizmente só podemos calclar o juros dos boletos XPTO";
        }
    },
    BOLETO_NAO_VENCIDO{
        @Override
        public String getMensagemErro() {
            return "O boleto informado ainda não está vencido";
        }
    };

    public abstract String getMensagemErro();
}
