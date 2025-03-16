package br.com.boletojuros.core.exceptions;

import br.com.boletojuros.core.domain.enuns.TipoExecao;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException{
    private TipoExecao tipoExecao;
}
