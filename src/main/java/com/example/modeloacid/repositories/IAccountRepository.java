package com.example.modeloacid.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.modeloacid.entities.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> { }