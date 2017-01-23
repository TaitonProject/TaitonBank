package com.taiton.controller;

import com.taiton.entity.AccountEntity;
import com.taiton.entity.CardEntity;
import com.taiton.entity.TransferEntity;
import com.taiton.entity.forJson.CardTransfer;
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
    ResponseEntity<String> addTransfer(@RequestBody CardTransfer cardTransfer){
        try {
            TransferEntity transferEntity = new TransferEntity();
            CardEntity findCardFrom = cardService.findByCardNumber(cardTransfer.getCardFrom());
            CardEntity findCardTo = cardService.findByCardNumber(cardTransfer.getCardTo());
            AccountEntity accFrom  = null;
            AccountEntity accTo = null;
            double money = 0;
            if (findCardTo != null){
                transferEntity.setCardTo(findCardTo.getId());
                transferEntity.setCardFrom(findCardFrom.getId());
                transferEntity.setAmount(cardTransfer.getAmount());
                accFrom  = accountService.find(findCardFrom.getAccountId());
                accTo = accountService.find(findCardTo.getAccountId());
                //money = accountService.find(transferEntity.getCardFrom()).getAccountBalance() - cardTransfer.getAmount();
                if (accFrom != null && accTo != null){
                    money = accFrom.getAccountBalance() - cardTransfer.getAmount();
                }
            }


            if (findCardFrom == null) {
                return new ResponseEntity<>(" Карты отправителя не существует.", HttpStatus.BAD_REQUEST);
            } else if (accountService.find(findCardFrom.getAccountId()) == null) {
                return new ResponseEntity<>(" Счета отправителя не существует.", HttpStatus.BAD_REQUEST);
            } else if (findCardTo == null) {
                return new ResponseEntity<>(" Карты получателя не существует.", HttpStatus.BAD_REQUEST);
            } else if (accountService.find(findCardTo.getAccountId()) == null) {
                return new ResponseEntity<>(" Счета получателя не существует.", HttpStatus.BAD_REQUEST);
            } else if (transferEntity.getAmount() <= 0) {
                return new ResponseEntity<>(" Некорректная сумма.", HttpStatus.BAD_REQUEST);
            } else if (money < 0) {
                return new ResponseEntity<>(" На карте недостаточно средств.", HttpStatus.BAD_REQUEST);
            } else if (findCardFrom.getId() == findCardTo.getId()) {
                return new ResponseEntity<>(" Нельзя переводить деньги на одну и ту же карту.", HttpStatus.BAD_REQUEST);
            } else if (accountService.find(findCardFrom.getAccountId()).getId() == accountService.find(findCardTo.getAccountId()).getId()) {
                return new ResponseEntity<>(" Нельзя переводить деньги на один и тот же счет.", HttpStatus.BAD_REQUEST);
            } else if (findCardTo.getDateOfExpiry().getTime() < new Date(System.currentTimeMillis()).getTime()) {
                return new ResponseEntity<>(" Срок карты получателя истек.", HttpStatus.BAD_REQUEST);
            } else if (findCardFrom.getDateOfExpiry().getTime() < new Date(System.currentTimeMillis()).getTime()) {
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
        AccountEntity accCardFrom = accountService.find(cardService.find(transfer.getCardFrom()).getAccountId());
        AccountEntity accCardTo = accountService.find(cardService.find(transfer.getCardTo()).getAccountId());
        double minus = accCardFrom.getAccountBalance() - transfer.getAmount();
        double plus = accCardTo.getAccountBalance() + transfer.getAmount();
        accCardFrom.setAccountBalance(minus);
        accCardTo.setAccountBalance(plus);
        accountService.save(accCardFrom);
        accountService.save(accCardTo);
        int idCardFrom = cardService.find(transfer.getCardFrom()).getId();
        int idCardTo = cardService.find(transfer.getCardTo()).getId();
        transfer.setCardFrom(idCardFrom);
        transfer.setCardTo(idCardTo);
        transferService.save(transfer);
    }

}