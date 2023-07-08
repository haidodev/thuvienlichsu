package com.app.thuvienlichsu.base;

import com.app.thuvienlichsu.util.Config;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.util.List;
import java.util.Set;

import static com.app.thuvienlichsu.util.JavaFXGenerator.createWrappedLabel;

public class SuKienModel extends Model {
    private String thoiGian;
    private String diaDiem;
    private String ketQua;
    private Set<String> cacNhanVatLienQuan;
    private Set<String> cacDiTichLienQuan;
    public SuKienModel(String tenModel, String code, List<String> moTa, String thoiGian, String diaDiem, String ketQua
            , Set<String> cacNhanVatLienQuan, Set<String> cacDiTichLienQuan) {
        super(tenModel, moTa);
        setCode(code);
        setThoiGian(thoiGian);
        setDiaDiem(diaDiem);
        setKetQua(ketQua);
        setCacNhanVatLienQuan(cacNhanVatLienQuan);
        setCacDiTichLienQuan(cacDiTichLienQuan);
    }
    public Set<String> getCacNhanVatLienQuan() {
        return this.cacNhanVatLienQuan;
    }
    public Set<String> getCacDiTichLienQuan() { return this.cacDiTichLienQuan; }
    public void setThoiGian(String thoiGian) {
        if (thoiGian.equals("")) this.thoiGian = "Không rõ";
        else this.thoiGian = thoiGian;
    }

    public void setDiaDiem(String diaDiem) {
        if (diaDiem.equals("")) this.diaDiem = "Không rõ";
        else this.diaDiem = diaDiem;
    }

    public void setKetQua(String ketQua) {
        if (ketQua.equals("")) this.ketQua = "Không rõ";
        else this.ketQua = ketQua;
    }
    public void setCacNhanVatLienQuan(Set<String> cacNhanVatLienQuan) {
        this.cacNhanVatLienQuan = cacNhanVatLienQuan;
    }

    public void setCacDiTichLienQuan(Set<String> cacDiTichLienQuan) {
        this.cacDiTichLienQuan = cacDiTichLienQuan;
    }

    public GridPane getInfoTable(){
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        // Create column constraints
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPrefWidth(80);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPrefWidth(320);



        // Apply column constraints to the GridPane
        gridPane.getColumnConstraints().addAll(column1, column2);
        gridPane.add(createWrappedLabel("Thời gian"), 0, 0);
        if (this.thoiGian.equals("")) gridPane.add(createWrappedLabel(Config.nullRepresentation), 1, 0);
        else gridPane.add(createWrappedLabel(this.thoiGian), 1, 0);

        gridPane.add(createWrappedLabel("Địa điểm"), 0, 1);
        if (this.diaDiem.equals("")) gridPane.add(createWrappedLabel(Config.nullRepresentation), 1, 1);
        else gridPane.add(createWrappedLabel(this.diaDiem), 1, 1);

        gridPane.add(createWrappedLabel("Kết quả"), 0, 2);
        if (this.ketQua.equals("")) gridPane.add(createWrappedLabel(Config.nullRepresentation), 1, 2);
        else gridPane.add(createWrappedLabel(this.ketQua), 1, 2);

        return gridPane;

    }
}
