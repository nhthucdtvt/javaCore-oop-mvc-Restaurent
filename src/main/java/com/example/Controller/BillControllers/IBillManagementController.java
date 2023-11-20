package com.example.Controller.BillControllers;

import com.example.Model.BillModels.BillManagementModel;

public interface IBillManagementController {
    public void updateBillItem(BillManagementModel bill);
    public void addToBill();
    public void deleteBillItem(BillManagementModel bill);
}
