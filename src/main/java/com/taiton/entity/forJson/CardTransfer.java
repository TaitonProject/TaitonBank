package com.taiton.entity.forJson;

import com.taiton.entity.TransferEntity;

/**
 * Created by Taiton on 1/21/2017.
 */
public class CardTransfer {

    private TransferEntity transfer;
    private int cardTo;
    private int cardFrom;

    public CardTransfer(TransferEntity transfer, int cardTo, int cardFrom) {
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

    public int getCardTo() {
        return cardTo;
    }

    public void setCardTo(int cardTo) {
        this.cardTo = cardTo;
    }

    public int getCardFrom() {
        return cardFrom;
    }

    public void setCardFrom(int cardFrom) {
        this.cardFrom = cardFrom;
    }
}
