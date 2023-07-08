package com.app.thuvienlichsu.base;

import com.app.thuvienlichsu.util.Config;
import javafx.geometry.Insets;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import java.util.List;
import java.util.Set;

import static com.app.thuvienlichsu.util.JavaFXGenerator.createWrappedLabel;

public class LeHoiModel extends Model
{
    private String thoiGian;
    private String diaDiem;
    private String nhanVatLienQuan;
    private String toChucLanDau;

    private String diaDanhCode;

    private Set<String> diTichLienQuan;

    public LeHoiModel(String tenModel, String thoiGian, String diaDiem,
                      String nhanVatLienQuan, String toChucLanDau, List<String> description, String diaDanhCode, String code)
    {
        super(tenModel, description);
        setThoiGian(thoiGian);
        setDiaDiem(diaDiem);
        setNhanVatLienQuan(nhanVatLienQuan);
        setToChucLanDau(toChucLanDau);
        setDiaDanhCode(diaDanhCode);
        setCode(code);
    }

    public void setDiTichLienQuan(Set<String> diTichLienQuan) {
        this.diTichLienQuan = diTichLienQuan;
    }

    public void setToChucLanDau(String toChucLanDau) {
        this.toChucLanDau = toChucLanDau.equals("") ? Config.nullRepresentation : toChucLanDau;
    }

    public void setNhanVatLienQuan(String nhanVatLienQuan) {
        this.nhanVatLienQuan = nhanVatLienQuan.equals("") ? Config.nullRepresentation : nhanVatLienQuan;
    }

    public void setDiaDiem(String diaDiem)
    {
        this.diaDiem = diaDiem.equals("") ? Config.nullRepresentation : diaDiem;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian.equals("") ? Config.nullRepresentation : thoiGian;
    }

    public void setDiaDanhCode(String diaDanhCode)
    {
        this.diaDanhCode = diaDanhCode;
    }
    public String getDiaDanhCode() {
        return diaDanhCode;
    }
    public GridPane getInfoTable(){
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(20);
        gridPane.setVgap(10);
        // Create column constraints
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPrefWidth(100);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPrefWidth(300);



        // Apply column constraints to the GridPane
        gridPane.getColumnConstraints().addAll(column1, column2);
        gridPane.add(createWrappedLabel("Thời gian"), 0, 0);
        if (this.thoiGian.equals("")) gridPane.add(createWrappedLabel("Không rõ"), 1, 0);
        else gridPane.add(createWrappedLabel(this.thoiGian), 1, 0);

        gridPane.add(createWrappedLabel("Địa điểm"), 0, 1);
        if (this.diaDiem.equals("")) gridPane.add(createWrappedLabel("Không rõ"), 1, 1);
        else gridPane.add(createWrappedLabel(this.diaDiem), 1, 1);

        gridPane.add(createWrappedLabel("Tổ chức lần đầu"), 0, 2);
        if (this.toChucLanDau.equals("")) gridPane.add(createWrappedLabel("Không rõ"), 1, 2);
        else gridPane.add(createWrappedLabel(this.toChucLanDau), 1, 2);

        return gridPane;

    }
}
