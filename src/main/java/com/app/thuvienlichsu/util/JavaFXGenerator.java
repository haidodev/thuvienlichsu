package com.app.thuvienlichsu.util;

import com.app.thuvienlichsu.base.LoadData;
import com.app.thuvienlichsu.base.Model;
import com.app.thuvienlichsu.controllers.MainController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class JavaFXGenerator {
    public static Label createWrappedLabel(String text) {
        Label label = new Label();
        label.setTextAlignment(TextAlignment.JUSTIFY);
        label.setWrapText(true);

        TextFlow textFlow = new TextFlow();
        Text textNode = new Text(text);
        textFlow.getChildren().add(textNode);
        label.setGraphic(textFlow);

        return label;
    }
    public static Label createWrappedTitle(String text) {
        Label label = new Label(text);
        label.setPadding(new Insets(0, 0, 0, 10));
        label.setFont(new Font(20));
        label.setPrefWidth(450);
        label.setWrapText(true);
        return label;
    }
    public static List<Button> nhanVatLienQuanButtons(Set<String> nhanVatCodes, List<Model> nvL){
        List<Button> allBtns = new ArrayList<>();
        for (String nhanVat : nhanVatCodes) {
            int idx = LoadData.binaryLookupByCode(0, nvL.size() - 1, nhanVat, (ArrayList<Model>) nvL);
            if (idx < 0) continue;
            Button btn = new Button(nvL.get(idx).getTenModel());
            btn.setPrefWidth(140); // Set button width
            btn.setPrefHeight(30);
            btn.setOnAction(event -> {
                MainController.getInstance().linkNhanVatPane(((Button) event.getSource()).getText());
            });
            allBtns.add(btn);
        }
        return allBtns;
    }
    public static List<Button> thoiKyLienQuanButtons(Set<String> thoiKyCodes, List<Model> tkL){
        List<Button> allBtns = new ArrayList<>();
        for (String thoiKy : thoiKyCodes) {
            int idx = LoadData.binaryLookupByCode(0, tkL.size() - 1, thoiKy, (ArrayList<Model>) tkL);
            if (idx < 0) continue;
            Button btn = new Button(tkL.get(idx).getTenModel());
            btn.setPrefWidth(140); // Set button width
            btn.setPrefHeight(30);
            btn.setOnAction(event -> {
                MainController.getInstance().linkThoiKyPane(((Button) event.getSource()).getText());
            });
            allBtns.add(btn);
        }
        return allBtns;
    }
    public static List<Button> suKienLienQuanButtons(Set<String> suKienCodes, List<Model> skL){
        List<Button> allBtns = new ArrayList<>();
        for (String suKien : suKienCodes) {
            int idx = LoadData.binaryLookupByCode(0, skL.size() - 1, suKien, (ArrayList<Model>) skL);
            if (idx < 0) continue;
            Button btn = new Button(skL.get(idx).getTenModel());
            btn.setPrefWidth(140); // Set button width
            btn.setPrefHeight(30);
            btn.setOnAction(event -> {
                MainController.getInstance().linkNhanVatPane(((Button) event.getSource()).getText());
            });
            allBtns.add(btn);
        }
        return allBtns;
    }
    public static List<Button> diTichLienQuanButtons(Set<String> diTichCodes, List<Model> dtL){
        if (diTichCodes == null) return new ArrayList<>();;
        List<Button> allBtns = new ArrayList<>();
        for (String diTich : diTichCodes) {
            int idx = LoadData.binaryLookupByCode(0, dtL.size() - 1, diTich, (ArrayList<Model>) dtL);
            if (idx < 0) continue;
            Button btn = new Button(dtL.get(idx).getTenModel());
            btn.setPrefWidth(140); // Set button width
            btn.setPrefHeight(30);
            btn.setOnAction(event -> {
                MainController.getInstance().linkDiTichPane(((Button) event.getSource()).getText());
            });
            allBtns.add(btn);
        }
        return allBtns;
    }
    public static List<Button> leHoiLienQuanButtons(Set<String> leHoiCodes, List<Model> lhL){
        List<Button> allBtns = new ArrayList<>();
        for (String leHoi : leHoiCodes) {
            int idx = LoadData.binaryLookupByCode(0, lhL.size() - 1, leHoi, (ArrayList<Model>) lhL);
            if (idx < 0) continue;
            Button btn = new Button(lhL.get(idx).getTenModel());
            btn.setPrefWidth(140); // Set button width
            btn.setPrefHeight(30);
            btn.setOnAction(event -> {
                MainController.getInstance().linkLeHoiPane(((Button) event.getSource()).getText());
            });
            allBtns.add(btn);
        }
        return allBtns;
    }
}
