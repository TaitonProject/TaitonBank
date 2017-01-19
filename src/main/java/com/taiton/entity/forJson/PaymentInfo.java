package com.taiton.entity.forJson;

import com.taiton.entity.CardEntity;
import com.taiton.entity.CategoryEntity;
import com.taiton.entity.OrganizationEntity;
import com.taiton.entity.PaymentEntity;

/**
 * Created by Taiton on 1/19/2017.
 */
/*
$scope.payment = {
        category: '',
        organization: '',
        card: '',
        info: '',
        amount: ''
        };
*/

public class PaymentInfo {
    private CategoryEntity category;
    private OrganizationEntity organization;
    private CardEntity card;
    private PaymentEntity payment;

    public PaymentInfo() {
    }

    public PaymentInfo(CategoryEntity categoryEntity, OrganizationEntity organizationEntity, CardEntity cardEntity, PaymentEntity paymentEntity) {
        this.category = categoryEntity;
        this.organization = organizationEntity;
        this.card = cardEntity;
        this.payment = paymentEntity;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public OrganizationEntity getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationEntity organization) {
        this.organization = organization;
    }

    public CardEntity getCard() {
        return card;
    }

    public void setCard(CardEntity card) {
        this.card = card;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }
}
