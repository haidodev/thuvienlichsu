package com.app.thuvienlichsu.base;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.app.thuvienlichsu.util.JavaFXGenerator.createWrappedLabel;

public class NhanVatModel extends Model
{
    private List<List<String>> thongTin;
    private Set<String> cacNhanVatLienQuan;
    private Set<String> cacDiTichLienQuan;
    private Set<String> cacThoiKyLienQuan;


    public NhanVatModel(String tenModel, List<String> moTa, String code, List<List<String>> thongTin
            , Set<String> cacNhanVatLienQuan, Set<String> cacDiTichLienQuan, Set<String> cacThoiKyLienQuan)
    {
        super(tenModel, moTa);
        setCode(code);
        setThongTin(thongTin);
        setCacNhanVatLienQuan(cacNhanVatLienQuan);
        setCacDiTichLienQuan(cacDiTichLienQuan);
        setCacThoiKyLienQuan(cacThoiKyLienQuan);
    }
    public NhanVatModel(String tenModel)
    {
        super(tenModel);
        setCode(new String());
        setMoTa(new ArrayList<>());
        setThongTin(new ArrayList<>());
        setCacNhanVatLienQuan(new HashSet<>());
        setCacDiTichLienQuan(new HashSet<>());
        setCacThoiKyLienQuan(new HashSet<>());
    }

    public List<List<String>> getThongTin() {
        return thongTin;
    }
    public Set<String> getCacNhanVatLienQuan() {
        return cacNhanVatLienQuan;
    }
    public Set<String> getCacThoiKyLienQuan() {
        return cacThoiKyLienQuan;
    }
    public Set<String> getCacDiTichLienQuan() {
        return cacDiTichLienQuan;
    }
    public void setThongTin(List<List<String>> thongTin) {
        this.thongTin = thongTin;
    }

    public void setCacNhanVatLienQuan(Set<String> cacNhanVatLienQuan) {
        this.cacNhanVatLienQuan = cacNhanVatLienQuan;
    }

    public void setCacDiTichLienQuan(Set<String> cacDiTichLienQuan) {
        this.cacDiTichLienQuan = cacDiTichLienQuan;
    }

    public void setCacThoiKyLienQuan(Set<String> cacThoiKyLienQuan) {
        this.cacThoiKyLienQuan = cacThoiKyLienQuan;
    }

    public GridPane getInfoTable(){

        if (this.thongTin == null) return null;
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        // Create column constraints
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPrefWidth(80);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPrefWidth(160);


        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPrefWidth(160);


        // Apply column constraints to the GridPane
        gridPane.getColumnConstraints().addAll(column1, column2, column3);
        int rowCnt = 0;
        for (List<String> row : thongTin){
            Label fieldName = null, sourceNKS = null, sourceWiki = null;
            if (row.size() >= 1) {
                fieldName = createWrappedLabel(row.get(0));
            }
            if (row.size() >= 2)
                sourceNKS = createWrappedLabel(row.get(1));
            if (row.size() >= 3)
                sourceWiki = createWrappedLabel(row.get(2));
            if (row.size() == 1) GridPane.setColumnSpan(fieldName, 3);
            if (row.size() == 2) GridPane.setColumnSpan(sourceNKS, 2);
            if (fieldName != null) gridPane.add(fieldName, 0, rowCnt);
            if (sourceNKS != null) gridPane.add(sourceNKS, 1, rowCnt);
            if (sourceWiki != null) gridPane.add(sourceWiki, 2, rowCnt);
            rowCnt += 1;
        }
        return gridPane;

    }
}
