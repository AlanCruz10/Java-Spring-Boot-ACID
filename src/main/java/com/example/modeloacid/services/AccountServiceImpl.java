package com.example.modeloacid.services;

import com.example.modeloacid.controllers.dtos.requests.UpdateAccountRequest;
import com.example.modeloacid.controllers.dtos.responses.BaseResponse;
import com.example.modeloacid.controllers.dtos.responses.GetAccountResponse;
import com.example.modeloacid.controllers.dtos.responses.UpdateAccountResponse;
import com.example.modeloacid.entities.Account;
import com.example.modeloacid.repositories.IAccountRepository;
import com.example.modeloacid.services.interfaces.IAccountService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.module.FindException;

@Service
@Transactional
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository repository;

    @Override
    public BaseResponse getAccount(Long id) {
        Account account = repository.findById(id).orElseThrow(FindException::new);
        return BaseResponse.builder()
                .data(from(account))
                .message("Account obtained")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(HttpStatus.ACCEPTED.hashCode()).build();
    }

    @Override
    public BaseResponse updateAccount(UpdateAccountRequest request) {
        Account account = repository.findById(request.getId()).orElseThrow(FindException::new);
        Account updateAccount = update(account, request);
        return BaseResponse.builder()
                .data(fromToUpdateAccountResponse(updateAccount))
                .message("Account updated")
                .success(Boolean.TRUE)
                .httpStatus(HttpStatus.ACCEPTED)
                .statusCode(HttpStatus.ACCEPTED.hashCode()).build();
    }

    private Account update(Account account, UpdateAccountRequest request) {
        account.setAccount(account.getAccount() + request.getAccount());
        Account accountNew = repository.save(account);
        return accountNew;
    }

    private GetAccountResponse from(Account account) {
        return new GetAccountResponse(
                account.getId(),
                account.getAccount()
        );
    }

    private UpdateAccountResponse fromToUpdateAccountResponse(Account account) {
        return new UpdateAccountResponse(
                account.getId(),
                account.getAccount()
        );
    }

}