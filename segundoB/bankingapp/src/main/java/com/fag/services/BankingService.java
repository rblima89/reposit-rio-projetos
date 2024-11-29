package com.fag.services;

import java.time.LocalDateTime;
import java.util.UUID;
import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IBassRepository;
import com.fag.domain.repositories.IUserInterface;
import com.fag.domain.repositories.IUserRepository;

public class BankingService {
   private IUserInterface gui;
   private Integer accountNumber =1;
   private IUserRepository userDB;
   private IBassRepository bassRepository;
   
   

   public BankingService(IUserInterface gui, IUserRepository userDB, IBassRepository bassRepository){
   this.gui = gui;
   this.userDB = userDB;
   this.bassRepository=bassRepository;
}

public Integer showMenu(){
    return gui.showInitialScreenMenu();
}
public LoginDTO loginDTO(){
    return gui.getLoginData();
}
public UserAccountDTO getRegisterUser(){
    UserAccountDTO data = gui.getRegisterUser();
    String uuid = UUID.randomUUID().toString();


    data.setId(uuid);
    data.setAccountNumber(accountNumber.toString());
    data.setCreatedAt(LocalDateTime.now());

    return data;   
}
public void showExitMessage(){
   gui.showExitMessage();
}
public void login (UserAccountDTO user) throws Exception{
    while (true) {
        
    Integer option = gui.showHomeMenu(user.getName());
    switch (option) {
        case 1:
        String barcode =gui.getBarcode();
        String consultaResponse = bassRepository.consultarBoleto(barcode);
        gui.showBankslipData(consultaResponse);
        break;
        case 2:
        BankslipDTO bankslipDTO = gui.getPaymentBankslipInfo();
        String pagarResponse = bassRepository.pagarBoleto(bankslipDTO);
        gui.showBankslipData(pagarResponse);
        break;
        case 3:
        Double amount = gui.getPixData();
        String responseqr = bassRepository.gerarQrcode(amount);
        gui.ShowPixData(responseqr);

        break;
        case 4:
        gui.showExitMessage();
            return;
    }
 }
}
public UserAccountDTO findUser(LoginDTO loginDTO){
    UserAccountDTO user = userDB.findUserBy(loginDTO.getDocument());
    if (user == null) {
        gui.showErrorMsg("Usuário não encontrado");
        return null;
    }
    if (!user.getPassword().equals(loginDTO.getPassword())) {
        gui.showErrorMsg("Credencial Invalida");
        return null;
    }
    return user;

}
public UserAccountDTO create(UserAccountDTO user){
    return userDB.createUser(user);
}
}