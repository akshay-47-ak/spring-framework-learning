package com.example.springBootJPA;

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
