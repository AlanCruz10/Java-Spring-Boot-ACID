package com.example.modeloacid.controllers.dtos;

import com.example.modeloacid.controllers.dtos.responses.BaseResponse;
import com.example.modeloacid.controllers.dtos.requests.UpdateAccountRequest;
import com.example.modeloacid.services.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService service;

    @PutMapping("/update")
    public ResponseEntity<BaseResponse> updateAccount(@RequestBody UpdateAccountRequest request) {
        return service.updateAccount(request).apply();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BaseResponse> getAccount(@PathVariable Long id) {
        return service.getAccount(id).apply();
    }

}