package com.fag.domain.repositories;

import com.fag.domain.dto.BankslipDTO;

public interface IBassRepository {

    String consultarBoleto(String linhaDigitavel) throws Exception;

    String pagarBoleto(BankslipDTO dadosBoletoConsultado) throws Exception;

    String gerarQrcode(Double valorPix);
    
}
