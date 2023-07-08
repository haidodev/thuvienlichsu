package com.app.thuvienlichsu.controllers;

import com.app.thuvienlichsu.base.DiTichModel;
import com.app.thuvienlichsu.base.Model;

import com.app.thuvienlichsu.util.JavaFXGenerator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    private void showDiTichDetail() {
        DiTichModel item = (DiTichModel) getModelFromDatabase((ArrayList<Model>) database.getDiTich());
        showDiTichInformation(item);
        showDanhSachLienQuan(item);
    }
    private void showDiTichDetail(String diTichName) {
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
    private void diTichSearchFieldAction(){
        searchFieldAction((ArrayList<Model>) database.getDiTich());
    }
    @FXML
    private void showDanhSachLienQuan(DiTichModel diTich){
        resetDanhSachLienQuan();
        if (diTich == null) return;
        List<Button> thoiKyBtns = JavaFXGenerator.thoiKyLienQuanButtons(diTich.getCacThoiKyLienQuan(), database.getThoiKy());
        List<Button> nhanVatBtns = JavaFXGenerator.nhanVatLienQuanButtons(diTich.getCacNhanVatLienQuan(), database.getNhanVat());
        List<Button> leHoiBtns = JavaFXGenerator.leHoiLienQuanButtons(diTich.getCacLeHoiLienQuan(), database.getLeHoi());

        if (thoiKyBtns.size() > 0) thoiKyLienQuanLabel.setVisible(true);
        cacThoiKyLienQuan.getChildren().addAll(thoiKyBtns);
        if (nhanVatBtns.size() > 0) nhanVatLienQuanLabel.setVisible(true);
        cacNhanVatLienQuan.getChildren().addAll(nhanVatBtns);
        if (leHoiBtns.size() > 0) leHoiLienQuanLabel.setVisible(true);
        cacLeHoiLienQuan.getChildren().addAll(leHoiBtns);
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
