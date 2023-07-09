package com.app.thuvienlichsu.controllers;

import com.app.thuvienlichsu.base.LeHoiModel;
import com.app.thuvienlichsu.base.Model;
import com.app.thuvienlichsu.util.JavaFXGenerator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LeHoiController extends GeneralController implements Initializable {
    public VBox contentVBox;
    public VBox tableContent;
    public FlowPane cacDiTichLienQuan;
    public Label diTichLienQuanLabel;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (Model temp : database.getLeHoi()) {
            objectList.add(temp.getTenModel());
        }
        listView.setItems(objectList);
    }
    public void preloadLeHoi(String leHoiName) {
        listView.getSelectionModel().select(leHoiName);
        showLeHoiDetail(leHoiName);
    }
    @FXML
    public void showLeHoiDetail() {
        LeHoiModel item = (LeHoiModel) getModelFromDatabase((ArrayList<Model>) database.getLeHoi());
        showLeHoiInformation(item);
        showDanhSachLienQuan(item);
    }
    public void showLeHoiDetail(String leHoiName) {
        LeHoiModel item = (LeHoiModel) getModelFromDatabase((ArrayList<Model>) database.getLeHoi(), leHoiName);
        showLeHoiInformation(item);
        showDanhSachLienQuan(item);
    }
    private void showLeHoiInformation(LeHoiModel leHoi){
        tableContent.getChildren().clear();
        tableContent.getChildren().add(JavaFXGenerator.createWrappedTitle(leHoi.getTenModel()));
        GridPane infoTable = leHoi.getInfoTable();
        if (infoTable != null) {
            tableContent.getChildren().add(infoTable);
        }

        TextFlow description = leHoi.getDescription();
        if (description != null)
            tableContent.getChildren().add(description);
    }
    @FXML
    public void leHoiSearchFieldAction(){
        searchFieldAction((ArrayList<Model>) database.getLeHoi());
    }
    private void showDanhSachLienQuan(LeHoiModel leHoi){
        resetDanhSachLienQuan();

        if (leHoi == null) return;

        List<Button> diTichBtns = JavaFXGenerator.diTichLienQuanButtons(leHoi.getCacDiTichLienQuan(), database.getDiTich());

        if (diTichBtns.size() > 0) diTichLienQuanLabel.setVisible(true);
        cacDiTichLienQuan.getChildren().addAll(diTichBtns);
    }
    private void resetDanhSachLienQuan(){
        diTichLienQuanLabel.setVisible(false);

        cacDiTichLienQuan.getChildren().clear();
    }
}
