package com.example.modeloacid.controllers.dtos.requests;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @Builder
public class UpdateAccountRequest {

    private Long id;

    private Long account;

}