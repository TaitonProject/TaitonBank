package com.taiton.entity.forJson;

import com.taiton.entity.TransferEntity;

/**
 * Created by Taiton on 1/21/2017.
 */
public class CardTransfer {

    private TransferEntity transfer;
    private String cardTo;
    private String cardFrom;

    public CardTransfer(TransferEntity transfer, String cardTo, String cardFrom) {
        this.transfer = transfer;
        this.cardTo = cardTo;
        this.cardFrom = cardFrom;
    }

    public CardTransfer() {
    }

    public TransferEntity getTransfer() {
        return transfer;
    }

    public void setTransfer(TransferEntity transfer) {
        this.transfer = transfer;
    }

    public String getCardTo() {
        return cardTo;
    }

    public void setCardTo(String cardTo) {
        this.cardTo = cardTo;
    }

    public String getCardFrom() {
        return cardFrom;
    }

    public void setCardFrom(String cardFrom) {
        this.cardFrom = cardFrom;
    }
}
