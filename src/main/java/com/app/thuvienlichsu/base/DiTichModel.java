package com.app.thuvienlichsu.base;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiTichModel extends Model{
    private Set<String> cacNhanVatLienQuan;
    private Set<String> cacThoiKyLienQuan;
    private Set<String> cacLeHoiLienQuan;

    public DiTichModel(String tenModel, List<String> moTa, String code, Set<String> cacNhanVatLienQuan)
    {
        super(tenModel, moTa);
        setCode(code);
        setCacNhanVatLienQuan(cacNhanVatLienQuan);
        setCacThoiKyLienQuan(new HashSet<>());
        setCacLeHoiLienQuan(new HashSet<>());
    }
    public Set<String> getCacNhanVatLienQuan() {
        return cacNhanVatLienQuan;
    }

    public void setCacNhanVatLienQuan(Set<String> cacNhanVatLienQuan) {
        this.cacNhanVatLienQuan = cacNhanVatLienQuan;
    }

    public Set<String> getCacThoiKyLienQuan() {
        return cacThoiKyLienQuan;
    }

    public void setCacThoiKyLienQuan(Set<String> cacThoiKyLienQuan) {
        this.cacThoiKyLienQuan = cacThoiKyLienQuan;
    }

    public Set<String> getCacLeHoiLienQuan() {
        return cacLeHoiLienQuan;
    }
    public void setCacLeHoiLienQuan(Set<String> cacLeHoiLienQuan) {
        this.cacLeHoiLienQuan = cacLeHoiLienQuan;
    }
}
