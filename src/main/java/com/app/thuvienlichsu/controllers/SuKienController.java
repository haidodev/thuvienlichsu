package com.app.thuvienlichsu.controllers;

import com.app.thuvienlichsu.base.Model;
import com.app.thuvienlichsu.base.NhanVatModel;
import com.app.thuvienlichsu.base.SuKienModel;
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

public class SuKienController extends GeneralController implements Initializable {
    public FlowPane cacNhanVatLienQuan;
    public FlowPane cacDiTichLienQuan;
    public Label nhanVatLienQuanLabel;
    public Label diTichLienQuanLabel;
    public VBox tableContent;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Model temp : database.getSuKien()) {
            objectList.add(temp.getTenModel());
        }
        listView.setItems(objectList);
    }
    public void preloadSuKien(String suKienName) {
        listView.getSelectionModel().select(suKienName);
        showSuKienDetail(suKienName);
    }
    @FXML
    private void showSuKienDetail() {
        SuKienModel item = (SuKienModel) getModelFromDatabase((ArrayList<Model>) database.getSuKien());
        showSuKienInformation(item);
        showDanhSachLienQuan(item);
    }
    private void showSuKienDetail(String suKienName) {
        SuKienModel item = (SuKienModel) getModelFromDatabase((ArrayList<Model>) database.getSuKien(), suKienName);
        showSuKienInformation(item);
        showDanhSachLienQuan(item);
    }
    private void showSuKienInformation(SuKienModel suKien){
        tableContent.getChildren().clear();
        Label label = new Label(suKien.getTenModel());
        label.setPadding(new Insets(0, 0, 0, 10));
        label.setFont(new Font(20));
        tableContent.getChildren().add(label);
        tableContent.getChildren().add(suKien.getInfoTable());
    }
    @FXML
    private void suKienSearchFieldAction(){
        searchFieldAction((ArrayList<Model>) database.getSuKien());
    }
    private void showDanhSachLienQuan(SuKienModel suKien){
        resetDanhSachLienQuan();
        if (suKien == null) return;

        List<Button> nhanVatBtns = JavaFXGenerator.nhanVatLienQuanButtons(suKien.getCacNhanVatLienQuan(), database.getNhanVat());
        List<Button> diTichBtns = JavaFXGenerator.diTichLienQuanButtons(suKien.getCacDiTichLienQuan(), database.getDiTich());

        if (nhanVatBtns.size() > 0) nhanVatLienQuanLabel.setVisible(true);
        cacNhanVatLienQuan.getChildren().addAll(nhanVatBtns);
        if (diTichBtns.size() > 0) diTichLienQuanLabel.setVisible(true);
        cacDiTichLienQuan.getChildren().addAll(diTichBtns);
    }
    private void resetDanhSachLienQuan(){
        nhanVatLienQuanLabel.setVisible(false);
        diTichLienQuanLabel.setVisible(false);

        cacNhanVatLienQuan.getChildren().clear();
        cacDiTichLienQuan.getChildren().clear();
    }
}
