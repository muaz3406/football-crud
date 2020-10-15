package com.muaz.footballcrud.service;

import com.muaz.footballcrud.entity.Contract;
import com.muaz.footballcrud.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    public void makeContract(Contract contract) {
        contractRepository.save(contract);
    }
}
