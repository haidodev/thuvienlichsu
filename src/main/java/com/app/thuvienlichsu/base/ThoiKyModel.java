package com.app.thuvienlichsu.base;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ThoiKyModel extends Model
{
    private Set<String> cacNhanVatLienQuan;
    private Set<String> cacDiTichLienQuan;
    public ThoiKyModel(String name, List<String> moTa, String code, Set<String> cacNhanVatLienQuan
            , Set<String> cacDiTichLienQuan)
    {
        super(name, moTa);
        setCode(code);
        setCacNhanVatLienQuan(cacNhanVatLienQuan);
        setCacDiTichLienQuan(cacDiTichLienQuan);
    }
    
    public void setCacNhanVatLienQuan(Set<String> cacNhanVatLienQuan) {
        this.cacNhanVatLienQuan = cacNhanVatLienQuan;
    }

    public void setCacDiTichLienQuan(Set<String> cacDiTichLienQuan) {
        this.cacDiTichLienQuan = cacDiTichLienQuan;
    }
    public Set<String> getCacNhanVatLienQuan() {
        return this.cacNhanVatLienQuan;
    }
    public List<String> getcacDiTichLienQuan() {
        return new ArrayList<>(this.cacDiTichLienQuan);
    }

    public Set<String> getCacDiTichLienQuan() {
        return cacDiTichLienQuan;
    }
    @Override
    public String toString() {
        return "\n{ \"tenModel\":\"" + this.tenModel + "\", "
                + "\n\"moTa\":\"" + this.moTa + "\", "
                + "\n\"cacNhanVatLienQuan\":\"" + this.cacNhanVatLienQuan + "\" }" + "\n";
    }
}