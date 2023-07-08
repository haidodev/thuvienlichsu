package com.app.thuvienlichsu.controllers;

import com.app.thuvienlichsu.base.Model;
import com.app.thuvienlichsu.base.NhanVatModel;
import com.app.thuvienlichsu.base.ThoiKyModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;



public class ThoiKyController extends GeneralController implements Initializable {
    public FlowPane cacNhanVatLienQuan;
    public FlowPane cacDiTichLienQuan;
    public Label nhanVatLienQuanLabel;
    public Label diTichLienQuanLabel;
    public VBox tableContent;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Model temp : database.getThoiKy()) {
            objectList.add(temp.getTenModel());
        }
        listView.setItems(objectList);
    }
    public void preloadThoiKy(String thoiKyName) {
        listView.getSelectionModel().select(thoiKyName);
        showThoiKyDetail(thoiKyName);
    }
    @FXML
    public void showThoiKyDetail() {
        ThoiKyModel item = (ThoiKyModel) getModelFromDatabase((ArrayList<Model>) database.getThoiKy());
        showThoiKyInformation(item);
        showDanhSachLienQuan(item);
    }
    public void showThoiKyDetail(String thoiKyName) {
        ThoiKyModel item = (ThoiKyModel) getModelFromDatabase((ArrayList<Model>) database.getThoiKy(), thoiKyName);
        showThoiKyInformation(item);
        showDanhSachLienQuan(item);
    }
    private void showThoiKyInformation(ThoiKyModel thoiKy){
        tableContent.getChildren().clear();
        Label label = new Label(thoiKy.getTenModel());
        label.setPadding(new Insets(0, 0, 0, 10));
        label.setFont(new Font(20));
        tableContent.getChildren().add(label);
        GridPane infoTable = thoiKy.getInfoTable();
        if (infoTable != null) {
            tableContent.getChildren().add(infoTable);
        }

        TextFlow description = thoiKy.getDescription();
        if (description != null)
            tableContent.getChildren().add(description);
    }
    private void showDanhSachLienQuan(ThoiKyModel thoiKy){
        resetDanhSachLienQuan();

        if (thoiKy == null) return;

        if (thoiKy.getCacNhanVatLienQuan().size() > 0) nhanVatLienQuanLabel.setVisible(true);
        cacNhanVatLienQuan.getChildren().addAll(GeneralController.nhanVatLienQuanButtons(thoiKy.getCacNhanVatLienQuan(), database.getNhanVat()));

        if (thoiKy.getcacDiTichLienQuan().size() > 0) diTichLienQuanLabel.setVisible(true);
        cacDiTichLienQuan.getChildren().addAll(GeneralController.diTichLienQuanButtons(thoiKy.getCacDiTichLienQuan(), database.getDiTich()));

    }
    @FXML
    public void thoiKySearchFieldAction() {
        searchFieldAction((ArrayList<Model>) database.getThoiKy());
    }

    private void resetDanhSachLienQuan(){
        nhanVatLienQuanLabel.setVisible(false);
        diTichLienQuanLabel.setVisible(false);

        cacNhanVatLienQuan.getChildren().clear();
        cacDiTichLienQuan.getChildren().clear();
    }
}
