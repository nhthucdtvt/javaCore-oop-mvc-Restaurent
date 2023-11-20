package com.example.Model.BillModels;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BillManagementModel {
    private ArrayList<BillItem> listBillItems;
    private double totalPrice;
    private LocalDateTime orderTime;

    private static BillManagementModel billManagementModel;
    private BillManagementModel(){
        listBillItems = new ArrayList<>();
    }
    public static BillManagementModel getInstance () {
        if (billManagementModel == null) {
            billManagementModel = new BillManagementModel();
        }
        return billManagementModel;
    }
    public LocalDateTime getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public ArrayList<BillItem> getListBillItems() {
        return listBillItems;
    }
    public void setListBillItems(ArrayList<BillItem> listBillItems) {
        this.listBillItems = listBillItems;
    }
}
