package com.example.springBootJPA.Service;

import com.example.springBootJPA.Entity.Brothers;
import com.example.springBootJPA.Repository.BRepository;
import org.springframework.stereotype.Service;

@Service
public class BrotherService {

    BRepository bRepository;

   public BrotherService(BRepository bRepository){
       this.bRepository = bRepository;
   }

    public Brothers createUser(Brothers brothers){
        return bRepository.save(brothers);
    }

}
