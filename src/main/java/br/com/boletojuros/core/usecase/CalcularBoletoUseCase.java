package br.com.boletojuros.core.usecase;

import br.com.boletojuros.core.domain.Boleto;
import br.com.boletojuros.core.domain.BoletoCalculado;
import br.com.boletojuros.core.domain.enuns.TipoBoleto;
import br.com.boletojuros.core.domain.enuns.TipoExecao;
import br.com.boletojuros.core.exceptions.ApplicationException;
import br.com.boletojuros.core.port.in.CalculoBoletoPort;
import br.com.boletojuros.core.port.out.ComplementoBoletoPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CalcularBoletoUseCase implements CalculoBoletoPort {


    private final ComplementoBoletoPort complementoBoletoPort;

    public CalcularBoletoUseCase(ComplementoBoletoPort complementoBoletoPort) {
        this.complementoBoletoPort = complementoBoletoPort;
    }

    @Override
    public BoletoCalculado executar(String codigo, LocalDate dataPagamento) {
        var boleto = complementoBoletoPort.executar(codigo);
        validar(boleto);

        // TODO - validar boleto

        //TODO - calcular boleto

        // TODO - Salvar boleto

        return null;
    }

    private void validar(Boleto boleto) {
        if (boleto == null) {
            throw new ApplicationException((TipoExecao.BOLETO_INVALIDO));
        }

        if (boleto.getTipo() != TipoBoleto.XPTO) {
            throw new ApplicationException((TipoExecao.TIPO_BOLETO_INVALIDO));
        }

        if (boleto.getDataVencimento().isAfter(LocalDate.now())) {
            throw new ApplicationException((TipoExecao.BOLETO_NAO_VENCIDO));
        }
    }
}
