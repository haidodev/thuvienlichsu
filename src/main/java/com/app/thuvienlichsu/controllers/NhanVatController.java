package com.app.thuvienlichsu.controllers;

import com.app.thuvienlichsu.base.Model;
import com.app.thuvienlichsu.base.NhanVatModel;
import com.app.thuvienlichsu.util.JavaFXGenerator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class NhanVatController extends GeneralController implements Initializable {
    public FlowPane cacNhanVatLienQuan;
    public FlowPane cacDiTichLienQuan;
    public FlowPane cacThoiKyLienQuan;
    public Label diTichLienQuanLabel;
    public Label nhanVatLienQuanLabel;
    public Label thoiKyLienQuanLabel;
    public VBox tableContent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Model temp : database.getNhanVat()) {
            objectList.add(temp.getTenModel());
        }
        listView.setItems(objectList);

    }
    public void preloadNhanVat(String nhanVatName) {
        listView.getSelectionModel().select(nhanVatName);
        showNhanVatDetail(nhanVatName);

    }
    @FXML
    private void nhanVatSearchFieldAction() {
        searchFieldAction((ArrayList<Model>) database.getNhanVat());
    }
    @FXML
    private void showNhanVatDetail() {
        NhanVatModel nhanVat = (NhanVatModel) getModelFromDatabase((ArrayList<Model>) database.getNhanVat());
        showNhanVatInformation(nhanVat);
        showDanhSachLienQuan(nhanVat);
    }
    private void showNhanVatDetail(String nhanVatName) {
        NhanVatModel nhanVat = (NhanVatModel) getModelFromDatabase((ArrayList<Model>) database.getNhanVat(), nhanVatName);
        showNhanVatInformation(nhanVat);
        showDanhSachLienQuan(nhanVat);
    }
    private void showNhanVatInformation(NhanVatModel nhanVat){
        tableContent.getChildren().clear();
        Label label = new Label(nhanVat.getTenModel());
        label.setPadding(new Insets(0, 0, 0, 10));
        label.setFont(new Font(20));
        tableContent.getChildren().add(label);
        GridPane infoTable = nhanVat.getInfoTable();
        if (infoTable != null) {
            tableContent.getChildren().add(infoTable);
        }

        TextFlow description = nhanVat.getDescription();
        if (description != null)
            tableContent.getChildren().add(description);
    }
    private void showDanhSachLienQuan(NhanVatModel nhanVat) {
        resetDanhSachLienQuan();

        if (nhanVat == null) return;

        List<Button> thoiKyBtns = JavaFXGenerator.thoiKyLienQuanButtons(nhanVat.getCacThoiKyLienQuan(), database.getThoiKy());
        List<Button> nhanVatBtns = JavaFXGenerator.nhanVatLienQuanButtons(nhanVat.getCacNhanVatLienQuan(), database.getNhanVat());
        List<Button> diTichBtns = JavaFXGenerator.diTichLienQuanButtons(nhanVat.getCacDiTichLienQuan(), database.getDiTich());

        if (thoiKyBtns.size() > 0) thoiKyLienQuanLabel.setVisible(true);
        cacThoiKyLienQuan.getChildren().addAll(thoiKyBtns);
        if (nhanVatBtns.size() > 0) nhanVatLienQuanLabel.setVisible(true);
        cacNhanVatLienQuan.getChildren().addAll(nhanVatBtns);
        if (diTichBtns.size() > 0) diTichLienQuanLabel.setVisible(true);
        cacDiTichLienQuan.getChildren().addAll(diTichBtns);
    }
    private void resetDanhSachLienQuan(){
        nhanVatLienQuanLabel.setVisible(false);
        diTichLienQuanLabel.setVisible(false);
        thoiKyLienQuanLabel.setVisible(false);

        cacNhanVatLienQuan.getChildren().clear();
        cacDiTichLienQuan.getChildren().clear();
        cacThoiKyLienQuan.getChildren().clear();
    }
}
