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

    public void setToChucLanDau(String toChucLanDau)
    {
        this.toChucLanDau = toChucLanDau.equals("") ? Config.nullRepresentation : toChucLanDau;
    }

    public void setNhanVatLienQuan(String nhanVatLienQuan)
    {
        this.nhanVatLienQuan = nhanVatLienQuan.equals("") ? Config.nullRepresentation : nhanVatLienQuan;
    }

    public void setDiaDiem(String diaDiem)
    {
        this.diaDiem = diaDiem.equals("") ? Config.nullRepresentation : diaDiem;
    }

    public void setThoiGian(String thoiGian)
    {
        this.thoiGian = thoiGian.equals("") ? Config.nullRepresentation : thoiGian;
    }

    public void setDiaDanhCode(String diaDanhCode)
    {
        this.diaDanhCode = diaDanhCode;
    }
    public String getDiaDanhCode() {
        return diaDanhCode;
    }

    @Override
    public String toHTML()
    {
        StringBuilder htmlBuilder = new StringBuilder();

        // Start the HTML structure
        htmlBuilder.append("<html>");
        htmlBuilder.append("<head>");
        htmlBuilder.append("</head>");
        htmlBuilder.append("<body contenteditable=\"true\">");
        htmlBuilder.append("<meta charset=\"UTF-8\">");
        // htmlBuilder.append("<title>").append(getName()).append("</title>");
        htmlBuilder.append("<style>");
        htmlBuilder.append("body { font-family:'lucida grande', tahoma, verdana, arial, sans-serif;font-size:14px; }");
        htmlBuilder.append("</style>");

        // Add the name as a heading
        // htmlBuilder.append("<h1>").append("NHÂN VẬT").append("</h1>");
        // htmlBuilder.append("<h1>").append(getName()).append("</h1>");

        // Add the code
        // htmlBuilder.append("<p><strong>Code:</strong> ").append(getCode()).append("</p>");

        // Add the infobox
        htmlBuilder.append("<h2>Tên Lễ Hội</h2>");
        htmlBuilder.append("<p>").append(this.tenModel).append("</p>");

        htmlBuilder.append("<h2>Địa điểm</h2>");
        htmlBuilder.append("<p>").append(this.diaDiem).append("</p>");

        htmlBuilder.append("<h2>Thời gian</h2>");
        htmlBuilder.append("<p>").append(this.thoiGian).append("</p>");

        htmlBuilder.append("<h2>Tổ chức lần đầu</h2>");
        htmlBuilder.append("<p>").append(this.toChucLanDau).append("</p>");

        htmlBuilder.append("<h2>Miêu tả</h2>");
        // Add the description
        for (String desc : this.moTa) {
            htmlBuilder.append("<p>").append(desc).append("</p>");
        }

        // Add the related figures
//        if (this.nhanVatLienQuan != null)
//        {
//            htmlBuilder.append("<h2>Nhân Vật Liên Quan</h2>");
//            htmlBuilder.append("<ul>");
//            htmlBuilder.append("<li>").append(this.nhanVatLienQuan).append("</li>");
//            htmlBuilder.append("</ul>");
//        }
//
//        if (this.diTichLienQuan != null)
//        {
//            htmlBuilder.append("<h2>Di Tích Liên Quan</h2>");
//            htmlBuilder.append("<ul>");
//            for (String diTich : this.diTichLienQuan)
//            {
//                htmlBuilder.append("<li>").append(diTich).append("</li>");
//            }
//            htmlBuilder.append("</ul>");
//        }

        // Close the HTML structure
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
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
        if (this.thoiGian.equals("")) gridPane.add(createWrappedLabel("Không rõ"), 1, 0);
        else gridPane.add(createWrappedLabel(this.thoiGian), 1, 0);

        gridPane.add(createWrappedLabel("Địa điểm"), 0, 1);
        if (this.diaDiem.equals("")) gridPane.add(createWrappedLabel("Không rõ"), 1, 1);
        else gridPane.add(createWrappedLabel(this.diaDiem), 1, 1);

        gridPane.add(createWrappedLabel("Kết quả"), 0, 2);
        if (this.toChucLanDau.equals("")) gridPane.add(createWrappedLabel("Không rõ"), 1, 2);
        else gridPane.add(createWrappedLabel(this.toChucLanDau), 1, 2);

        return gridPane;

    }

    private Label createWrappedLabel(String text) {
        Label label = new Label();
        label.setTextAlignment(TextAlignment.JUSTIFY);
        label.setWrapText(true);

        TextFlow textFlow = new TextFlow();
        Text textNode = new Text(text);
        textFlow.getChildren().add(textNode);
        label.setGraphic(textFlow);

        return label;
    }
    @Override
    public String toString()
    {
        return  "{ \t\"Id\": \"" + this.id + "\", \n\t"
                + "\"Tên\": \"" + this.tenModel + "\",\n\t"
                + "\"Thời Gian\": \"" + this.thoiGian + "\",\n\t"
                + "\"Địa điểm\": \"" + this.diaDiem + "\",\n\t"
                + "\"Nhân Vật Lịch Sử Liên Kết\": \"" + this.nhanVatLienQuan + "\",\n\t"
                + "\"Lần Đầu Tổ Chức\": \"" + this.toChucLanDau + "\",\n\t"
                + "\"Thông Tin Khác\": \"" + this.moTa.toString() + "\",\n\t"
                + "\"Địa điểm code\": \"" + this.diaDanhCode + "\" }\n";
    }
}
