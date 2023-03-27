package com.example.modeloacid.services.interfaces;

import com.example.modeloacid.controllers.dtos.requests.UpdateAccountRequest;
import com.example.modeloacid.controllers.dtos.responses.BaseResponse;

public interface IAccountService {

    public BaseResponse getAccount(Long id);

    public BaseResponse updateAccount(UpdateAccountRequest request);

}