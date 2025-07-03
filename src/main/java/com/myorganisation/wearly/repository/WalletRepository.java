package com.myorganisation.wearly.repository;

import com.myorganisation.wearly.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
