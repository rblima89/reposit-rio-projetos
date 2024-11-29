package com.fag.infra.console;

import java.util.Scanner;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserInterface;

public class ConsoleUserInterface implements IUserInterface {

    private Scanner input = new Scanner(System.in);

    @Override
    public Integer showInitialScreenMenu() {
        System.out.println("|----------BANCO LIMA--------|");
        System.out.println("|[1] Login                   |");
        System.out.println("|[2] Cadastro                |");
        System.out.println("|[3] Sair                    |");
        System.out.println("|____________________________|");
        Integer escolha = input.nextInt();
        input.nextLine();
        return escolha;
    }

    @Override
    public LoginDTO getLoginData() {
        LoginDTO data = new LoginDTO();
        

        System.out.println("Informe seu documento:");
        String document = input.next();

        System.out.println("Informe sua senha:");
        String password = input.nextLine();

        data.setDocument(document);
        data.setPassword(password);
        input.nextLine();

        return data;
    }

    @Override
    public UserAccountDTO getRegisterUser() {
      UserAccountDTO data = new UserAccountDTO();
      
      System.out.println("informe seu documento");
      String document = input.nextLine();
      
      System.out.println("informe seu email");
      String email = input.nextLine();

      System.out.println("informe seu nome");
      String name = input.nextLine();

      System.out.println("informe sua senha");
      String password = input.nextLine();

      data.setDocument(document);
        data.setEmail(email);
            data.setName(name);
                data.setPassword(password);
            return data;
    }

    @Override
    public Integer showHomeMenu(String userName) {
        System.out.println("Bem Vindo" + userName);
        System.out.println("[1] Consulta boleto");
        System.out.println("[2] Pagamento boleto");
        System.out.println("[3] Gerar QR Code Pix");
        System.out.println("[4] Logout");

        Integer option = input.nextInt();
        input.nextLine();
        return option;
    }

    @Override
    public void showErrorMsg(String msg) {
        System.out.println("ERRO:  "+ msg);
        
    }

    @Override
    public void showExitMessage() {
       System.out.println("Obrigado Por Utilizar os Bancos Lima");
}

@Override
public String getBarcode() {
    System.out.println("Insira o código de barras:");
    String barcode = input.nextLine();

    return barcode;
}

@Override
public BankslipDTO getPaymentBankslipInfo() {
    BankslipDTO bankslipDTO = new BankslipDTO();

    System.out.println("Insira o código de barras:");
    String barcode = input.nextLine();

    System.out.println("Insira o identificador de pagamento:");
    String id = input.nextLine();

    System.out.println("Informe o Valor");
    String valor = input.nextLine();

    bankslipDTO.setBarcode(barcode);
    bankslipDTO.setTransactionId(id);
    bankslipDTO.setValor(Double.parseDouble(valor)); 

    return bankslipDTO;
}

@Override
public void showBankslipData(String data) {
    System.out.println("Dados do boleto: " + data);
}

@Override
public Double getPixData() {
    System.out.println("Insira valor do PIX:");
    Double amount = input.nextDouble();

    return amount;
}

@Override
public void ShowPixData(String data) {
    System.out.println("Dados do PIX: " + data);
}
}