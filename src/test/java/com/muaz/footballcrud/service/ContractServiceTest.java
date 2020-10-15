package com.muaz.footballcrud.service;

import com.muaz.footballcrud.entity.Contract;
import com.muaz.footballcrud.repository.ContractRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ContractServiceTest {

    @InjectMocks
    private ContractService contractService;

    @Mock
    private ContractRepository contractRepository;

    @Test
    public void shouldSaveContractWhenGivenContract() {
        Contract contract = new Contract();
        contractService.makeContract(contract);

        verify(contractRepository).save(contract);
    }
}
