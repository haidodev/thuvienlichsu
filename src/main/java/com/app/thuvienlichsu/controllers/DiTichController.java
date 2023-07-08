package com.app.thuvienlichsu.controllers;

import com.app.thuvienlichsu.base.DiTichModel;
import com.app.thuvienlichsu.base.Model;
import com.app.thuvienlichsu.base.NhanVatModel;
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


public class DiTichController extends GeneralController implements Initializable {
    public FlowPane cacNhanVatLienQuan;
    public Label nhanVatLienQuanLabel;
    public Label thoiKyLienQuanLabel;
    public Label leHoiLienQuanLabel;
    public FlowPane cacThoiKyLienQuan;
    public FlowPane cacLeHoiLienQuan;
    public VBox tableContent;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Model temp : database.getDiTich()) {
            objectList.add(temp.getTenModel());
        }
        listView.setItems(objectList);
    }
    public void preloadDiTich(String diTichName) {
        listView.getSelectionModel().select(diTichName);
        showDiTichDetail(diTichName);
    }
    @FXML
    public void showDiTichDetail() {
        DiTichModel item = (DiTichModel) getModelFromDatabase((ArrayList<Model>) database.getDiTich());
        showDiTichInformation(item);
        showDanhSachLienQuan(item);
    }
    public void showDiTichDetail(String diTichName) {
        DiTichModel item = (DiTichModel) getModelFromDatabase((ArrayList<Model>) database.getDiTich(), diTichName);
        showDiTichInformation(item);
        showDanhSachLienQuan(item);
    }
    private void showDiTichInformation(DiTichModel diTich){
        tableContent.getChildren().clear();
        Label label = new Label(diTich.getTenModel());
        label.setPadding(new Insets(0, 0, 10, 10));
        label.setFont(new Font(20));
        tableContent.getChildren().add(label);
        TextFlow description = diTich.getDescription();
        if (description != null)
            tableContent.getChildren().add(description);
    }
    @FXML
    public void diTichSearchFieldAction(){
        searchFieldAction((ArrayList<Model>) database.getDiTich());
    }
    @FXML
    private void showDanhSachLienQuan(DiTichModel item){
        resetDanhSachLienQuan();
        if (item == null) return;
        if (item.getCacThoiKyLienQuan().size() > 0) thoiKyLienQuanLabel.setVisible(true);
        cacThoiKyLienQuan.getChildren().addAll(GeneralController.thoiKyLienQuanButtons(item.getCacThoiKyLienQuan(), database.getThoiKy()));
        if (item.getCacNhanVatLienQuan().size() > 0) nhanVatLienQuanLabel.setVisible(true);
        cacNhanVatLienQuan.getChildren().addAll(GeneralController.nhanVatLienQuanButtons(item.getCacNhanVatLienQuan(), database.getNhanVat()));
        if (item.getCacLeHoiLienQuan().size() > 0) leHoiLienQuanLabel.setVisible(true);
        cacLeHoiLienQuan.getChildren().addAll(GeneralController.leHoiLienQuanButtons(item.getCacLeHoiLienQuan(), database.getLeHoi()));
    }
    private void resetDanhSachLienQuan(){
        nhanVatLienQuanLabel.setVisible(false);
        cacNhanVatLienQuan.getChildren().clear();
        thoiKyLienQuanLabel.setVisible(false);
        cacThoiKyLienQuan.getChildren().clear();
        leHoiLienQuanLabel.setVisible(false);
        cacLeHoiLienQuan.getChildren().clear();
    }
}
