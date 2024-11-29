package com.fag.domain.repositories;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;

public interface IUserInterface {
    String getBarcode();

    BankslipDTO getPaymentBankslipInfo();

    void showBankslipData(String data);

    Double getPixData();

    void ShowPixData (String data);

    
    Integer showInitialScreenMenu();

    Integer showHomeMenu(String userName);

    LoginDTO getLoginData();

    UserAccountDTO getRegisterUser();

    void showErrorMsg (String msg);

    void showExitMessage();
    
}
