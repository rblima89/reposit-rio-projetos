package com.fag.infra.swing;

import javax.swing.JOptionPane;


import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserInterface;

public class SwingUserInterface implements IUserInterface {

    @Override
    public Integer showInitialScreenMenu() {
        String menu = "---------- BANCO LIMA ---------\n"
                .concat("|[1] Login\n")
                .concat("|[2] Cadastro\n")
                .concat("|[3] Sair");

        String escolha = JOptionPane.showInputDialog(
                null,
                menu,
                "🏦MENU BANCO LIMA",
                JOptionPane.INFORMATION_MESSAGE);

        return Integer.parseInt(escolha);
    }

    @Override
    public LoginDTO getLoginData() {
        LoginDTO data = new LoginDTO();

        String document = JOptionPane.showInputDialog(null,
                "Informe seu documento",
                "Informe os dados",
                0);

        String password = JOptionPane.showInputDialog(null,
                "Informe sua senha",
                "Informe os dados",
                0);

        data.setDocument(document);
        data.setPassword(password);

        return data;
    }

    @Override
    public UserAccountDTO getRegisterUser() {

       UserAccountDTO data = new UserAccountDTO();

        String document = JOptionPane.showInputDialog(null,
                "Informe seu documento",
                "Informe os dados",
                0);

        String email = JOptionPane.showInputDialog(null,
                "Informe seu email",
                "Informe os dados",
                0);

        String nome = JOptionPane.showInputDialog(null,
                "Informe seu nome",
                "Informe os dados",
                0);

        String senha = JOptionPane.showInputDialog(null,
                "Informe sua Senha",
                "Informe os dados",
                0);        

        data.setDocument(document);
        data.setEmail(email);
        data.setName(nome);
        data.setPassword(senha);
    

        return data;
    }

    @Override
    public Integer showHomeMenu(String userName) {
        String menu = "------- Bem Vindo "  + userName + "!----------- \n"
        .concat("|[1] Consulta Boleto\n")
        .concat("|[2] Pagamento de Boleto\n")
        .concat("|[3] Gerar QR Code Pix\n")
        .concat("|[4] Sair");

String escolha = JOptionPane.showInputDialog(
        null,
        menu,
        "🏦MENU BANCO LIMA",
        JOptionPane.INFORMATION_MESSAGE);

return Integer.parseInt(escolha); 
    }

    @Override
    public void showErrorMsg(String msg) {
        JOptionPane.showMessageDialog(null,
            "error:"+ msg,
            "ERROR",
            JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void showExitMessage() {
        JOptionPane.showMessageDialog(null,
        "Obrigado por Utilizar os Bancos Lima",
        "BANCO LIMA",
        JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String getBarcode() {
        String barcode = JOptionPane.showInputDialog(
                null,
                "Insira o código de barras a ser consultado",
                "Código de barras",
                JOptionPane.INFORMATION_MESSAGE);

        return barcode;
    }

    @Override
    public BankslipDTO getPaymentBankslipInfo() {
        BankslipDTO bankslipDTO = new BankslipDTO();

        String barcode = JOptionPane.showInputDialog(
                null,
                "Insira o código de barras a ser pago",
                "Código de barras",
                JOptionPane.INFORMATION_MESSAGE);
        String transactionId = JOptionPane.showInputDialog(
                null,
                "Insira o identificador de pagamento",
                "Identificador",
                JOptionPane.INFORMATION_MESSAGE);

        bankslipDTO.setBarcode(barcode);
        bankslipDTO.setTransactionId(transactionId);

        return bankslipDTO;
    }

    @Override
    public void showBankslipData(String data) {
        JOptionPane.showMessageDialog(
                null,
                data,
                "Dados boleto",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void ShowPixData(String data) {
        JOptionPane.showMessageDialog(
                null,
                data,
                "Dados PIX",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public Double getPixData() {
        String amount = JOptionPane.showInputDialog(
                null,
                "Insira o valor do PIX",
                "Valor transação",
                JOptionPane.INFORMATION_MESSAGE);

        return Double.parseDouble(amount);
    }


}
