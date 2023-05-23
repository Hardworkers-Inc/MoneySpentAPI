package com.hardworkers.moneyspent.Transfer;

import com.hardworkers.moneyspent.BaseCrudService;
import com.hardworkers.moneyspent.exceptions.EntityNotFoundException;
import com.hardworkers.moneyspent.exceptions.EntityValidationFailed;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransferService implements BaseCrudService<Transfer> {

    private final TransferRepository transferRepository;

    @Override
    public Iterable<Transfer> getAll() {
        return transferRepository.findAll();
    }

    @Override
    public Transfer getById(Long id) {
        return transferRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Transfer", id)
        );
    }

    @Override
    public Transfer create(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public Transfer update(Transfer transfer) {
        if (transfer.getId() == null) {
            throw new EntityValidationFailed("Id can't be null");
        }
        return transferRepository.save(transfer);
    }

    @Override
    public void delete(Long id) {
        transferRepository.deleteById(id);
    }
}
