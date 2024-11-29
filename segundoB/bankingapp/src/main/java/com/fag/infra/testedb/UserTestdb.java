package com.fag.infra.testedb;

import java.util.ArrayList;
import java.util.List;

import com.fag.domain.dto.UserAccountDTO;
import com.fag.domain.repositories.IUserRepository;

public class UserTestdb implements IUserRepository{
    private List<UserAccountDTO> users = new ArrayList<>();


    @Override
    public UserAccountDTO createUser(UserAccountDTO dto) {
        users.add(dto);

        return dto;
       
    }

    @Override
    public UserAccountDTO findUserBy(String document) {
        for(UserAccountDTO user : users){
            if (user.getDocument().equals(document)) {
                
                return user;
            }
        }
        return null;
    }
    
}
