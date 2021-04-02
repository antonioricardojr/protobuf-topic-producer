package com.armj.kafka.protobuftopicproducer.mapper;


import com.armj.kafka.protobuftopicproducer.model.DeliveryAddress;
import com.armj.kafka.protobuftopicproducer.model.DeliveryAddressProto;
import com.armj.kafka.protobuftopicproducer.model.InvoiceProto;
import com.armj.kafka.protobuftopicproducer.model.PosInvoice;

public class PosInvoiceMapper {

    public static InvoiceProto.Invoice map(PosInvoice posInvoice) {

        DeliveryAddress posInvoiceAddress = posInvoice.getDeliveryAddress();

        DeliveryAddressProto.DeliveryAddress address = DeliveryAddressProto.DeliveryAddress.newBuilder()
                .setAddressLine(posInvoiceAddress.getAddressLine())
                .setCity(posInvoiceAddress.getCity())
                .setState(posInvoiceAddress.getState())
                .setPinCode(posInvoiceAddress.getPinCode())
                .setContactNumber(posInvoiceAddress.getContactNumber())
                .build();

        //TODO: check how to set Address


        InvoiceProto.Invoice invoice = InvoiceProto.Invoice.newBuilder()
                .setInvoiceNumber(posInvoice.getInvoiceNumber())
                .setCreatedTime(posInvoice.getCreatedTime())
                .setStoreID(posInvoice.getStoreID())
                .setPosID(posInvoice.getPosID())
                .setCashierID(posInvoice.getCashierID())
                .setCustomerType(posInvoice.getCustomerType())
                .setCustomerCardNo(posInvoice.getCustomerCardNo())
                .setTotalAmount(posInvoice.getTotalAmount())
                .setNumberOfItems(posInvoice.getNumberOfItems())
                .setPaymentMethod(posInvoice.getPaymentMethod())
                .setTaxableAmount(posInvoice.getTaxableAmount())
                .setCGST(posInvoice.getCGST())
                .setSGST(posInvoice.getSGST())
                .setCESS(posInvoice.getCESS())
                .setDeliveryType(posInvoice.getDeliveryType())
                .build();


        return invoice;
    }

}
