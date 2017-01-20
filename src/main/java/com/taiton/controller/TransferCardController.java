package com.taiton.controller;

import com.taiton.entity.AccountEntity;
import com.taiton.entity.TransferEntity;
import com.taiton.service.AccountService;
import com.taiton.service.CardService;
import com.taiton.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;

/**
 * Created by egordragun on 26.12.16.
 */

@Controller
@RequestMapping("/transaction")
public class TransferCardController {

    @Autowired
    private CardService cardService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransferService transferService;

    @RequestMapping("/transferCards")
    public String getCardTransactionPage() {
        return "transaction/transferCards";
    }

    @PostMapping("/addTransfer")
    public @ResponseBody
    ResponseEntity<String> addTransfer(@RequestBody TransferEntity transferEntity){
        if(cardService.findByCardNumber(transferEntity.getCardFrom()) == null) {
            return new ResponseEntity<>("Ошибка! Карты отправителя не существует.", HttpStatus.BAD_REQUEST);
        } else if(accountService.findByAccountNumber(cardService.findByCardNumber(transferEntity.getCardFrom()).getCardNumber()) == null){
            return new ResponseEntity<>("Ошибка! Счета отправителя не существует.", HttpStatus.BAD_REQUEST);
        } else if (cardService.findByCardNumber(transferEntity.getCardTo()) == null) {
            return new ResponseEntity<>("Ошибка! Карты отправителя не существует.", HttpStatus.BAD_REQUEST);
        } else if(accountService.findByAccountNumber(cardService.findByCardNumber(transferEntity.getCardFrom()).getCardNumber()) == null){
            return new ResponseEntity<>("Ошибка! Счета получателя не существует.", HttpStatus.BAD_REQUEST);
        } else if(transferEntity.getAmount() <= 0){
            return new ResponseEntity<>("Ошибка! Некорректная сумма.", HttpStatus.BAD_REQUEST);
        } else if(accountService.findByAccountNumber(cardService.findByCardNumber(transferEntity.getCardFrom()).getCardNumber()).getAccountBalance() < transferEntity.getAmount()){
            return new ResponseEntity<>("Ошибка! На карте недостаточно средств.", HttpStatus.BAD_REQUEST);
        } else {
            transferEntity.setDate(new Timestamp(System.currentTimeMillis()));
            transferFromToCard(transferEntity);
            return new ResponseEntity<>("Выполнено! Средства успешно переведены.", HttpStatus.OK);
        }
    }

    @Transactional
    private void transferFromToCard(TransferEntity transfer){
        AccountEntity accCardFrom = accountService.findByAccountNumber(cardService.findByCardNumber(transfer.getCardFrom()).getCardNumber());
        AccountEntity accCardTo = accountService.findByAccountNumber(cardService.findByCardNumber(transfer.getCardFrom()).getCardNumber());
        accCardFrom.setAccountBalance(accCardFrom.getAccountBalance() - transfer.getAmount());
        accCardTo.setAccountBalance(accCardTo.getAccountBalance() + transfer.getAmount());
        accountService.save(accCardFrom);
        accountService.save(accCardTo);
        int idCardFrom = cardService.findByCardNumber(transfer.getCardFrom()).getId();
        int idCardTo = cardService.findByCardNumber(transfer.getCardFrom()).getId();
        transfer.setCardFrom(idCardFrom);
        transfer.setCardTo(idCardTo);
        transferService.save(transfer);
    }

}