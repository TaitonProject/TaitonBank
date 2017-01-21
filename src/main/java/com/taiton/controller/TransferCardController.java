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

import java.sql.Date;
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
        try {
            if (cardService.findByCardNumber(transferEntity.getCardFrom()) == null) {
                return new ResponseEntity<>(" Карты отправителя не существует.", HttpStatus.BAD_REQUEST);
            } else if (accountService.find(cardService.findByCardNumber(transferEntity.getCardFrom()).getAccountId()) == null) {
                return new ResponseEntity<>(" Счета отправителя не существует.", HttpStatus.BAD_REQUEST);
            } else if (cardService.findByCardNumber(transferEntity.getCardTo()) == null) {
                return new ResponseEntity<>(" Карты получателя не существует.", HttpStatus.BAD_REQUEST);
            } else if (accountService.find(cardService.findByCardNumber(transferEntity.getCardTo()).getAccountId()) == null) {
                return new ResponseEntity<>(" Счета получателя не существует.", HttpStatus.BAD_REQUEST);
            } else if (transferEntity.getAmount() <= 0) {
                return new ResponseEntity<>(" Некорректная сумма.", HttpStatus.BAD_REQUEST);
            } else if (accountService.find(cardService.findByCardNumber(transferEntity.getCardFrom()).getAccountId()).getAccountBalance() < transferEntity.getAmount()) {
                return new ResponseEntity<>(" На карте недостаточно средств.", HttpStatus.BAD_REQUEST);
            } else if (transferEntity.getCardFrom() == transferEntity.getCardTo()) {
                return new ResponseEntity<>(" Нельзя переводить деньги на тот же счет.", HttpStatus.BAD_REQUEST);
            } else if (cardService.findByCardNumber(transferEntity.getCardTo()).getDateOfExpiry().getTime() < new Date(System.currentTimeMillis()).getTime()) {
                return new ResponseEntity<>(" Срок карты получателя истек.", HttpStatus.BAD_REQUEST);
            } else if (cardService.findByCardNumber(transferEntity.getCardFrom()).getDateOfExpiry().getTime() < new Date(System.currentTimeMillis()).getTime()) {
                return new ResponseEntity<>(" Срок Вашей карты истек. Обратитесь в банк.", HttpStatus.BAD_REQUEST);
            } else {
                transferEntity.setDate(new Timestamp(System.currentTimeMillis()));
                transferFromToCard(transferEntity);
                return new ResponseEntity<>(" Средства успешно переведены.", HttpStatus.OK);
            }
        } catch (Exception e){
            return new ResponseEntity<>(" Некорректные данные.", HttpStatus.CONFLICT);
        }
    }

    @Transactional
    private void transferFromToCard(TransferEntity transfer){
        AccountEntity accCardFrom = accountService.find(cardService.findByCardNumber(transfer.getCardFrom()).getAccountId());
        AccountEntity accCardTo = accountService.find(cardService.findByCardNumber(transfer.getCardTo()).getAccountId());
        accCardFrom.setAccountBalance(accCardFrom.getAccountBalance() - transfer.getAmount());
        accCardTo.setAccountBalance(accCardTo.getAccountBalance() + transfer.getAmount());
        accountService.save(accCardFrom);
        accountService.save(accCardTo);
        int idCardFrom = cardService.findByCardNumber(transfer.getCardFrom()).getId();
        int idCardTo = cardService.findByCardNumber(transfer.getCardTo()).getId();
        transfer.setCardFrom(idCardFrom);
        transfer.setCardTo(idCardTo);
        transferService.save(transfer);
    }

}