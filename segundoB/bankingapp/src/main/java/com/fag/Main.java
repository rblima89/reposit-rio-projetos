package com.fag;


import com.fag.domain.dto.LoginDTO;
import com.fag.domain.dto.UserAccountDTO;
import com.fag.infra.celcoin.CelcoinBassRepository;
import com.fag.infra.console.ConsoleUserInterface;
import com.fag.infra.pg.PgSupabase;
import com.fag.infra.pg.PostgresConnection;
import com.fag.infra.swing.SwingUserInterface;
import com.fag.infra.testedb.UserTestdb;
import com.fag.services.BankingService;

public class Main {
    public static void main(String[] args) throws Exception {
        ConsoleUserInterface consoleUI = new ConsoleUserInterface();
        SwingUserInterface swing = new SwingUserInterface();
       // UserTestdb userTestdb = new UserTestdb();
        CelcoinBassRepository celcoinBassRepository = new CelcoinBassRepository();
        PgSupabase pg = new PgSupabase();

       // PostgresConnection.getInstance();

        BankingService bankingService = new BankingService(swing, pg,celcoinBassRepository);
       while (true) {
    
       
        Integer opcao = bankingService.showMenu();

        switch (opcao) {
        case 1:
            LoginDTO loginDTO = bankingService.loginDTO(); 
            UserAccountDTO userAccountDTO = bankingService.findUser(loginDTO);
            if (userAccountDTO != null) {
                bankingService.login(userAccountDTO);
            }
                break;
            
        case 2:
                UserAccountDTO data = bankingService.getRegisterUser();
                bankingService.create(data);
                bankingService.login(data);
                
                    break;
        case 3:
            bankingService.showExitMessage();
            System.out.println("Sair");
                        

               return;         
          

        }

        System.out.println(opcao);
}
}
}