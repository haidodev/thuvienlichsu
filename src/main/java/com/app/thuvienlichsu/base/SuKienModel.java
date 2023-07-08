package com.app.thuvienlichsu.base;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;

import java.util.List;
import java.util.Set;

public class SuKienModel extends Model {
    private String thoiGian;
    private String diaDiem;
    private String ketQua;
    private List<List<String>> thongTin;
    private Set<String> cacNhanVatLienQuan;
    private Set<String> cacDiTichLienQuan;
    public List<List<String>> getThongTin() {
        return thongTin;
    }
    public Set<String> getCacNhanVatLienQuan() {
        return this.cacNhanVatLienQuan;
    }
    public Set<String> getCacDiTichLienQuan() { return this.cacDiTichLienQuan; }
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

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public void setKetQua(String ketQua) {
        this.ketQua = ketQua;
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

    @Override
    public String toHTML() {
        StringBuilder htmlBuilder = new StringBuilder();

        // Start the HTML structure
        htmlBuilder.append("<html>");
        htmlBuilder.append("<i>").append(this.tenModel).append("</i>");
        htmlBuilder.append("<head>");
        htmlBuilder.append("</head>");
        htmlBuilder.append("<body contenteditable=\"true\">");
        htmlBuilder.append("<meta charset=\"UTF-8\">");
        // htmlBuilder.append("<title>").append(getName()).append("</title>");
        htmlBuilder.append("<style>");
        htmlBuilder.append("body { font-family:'lucida grande', tahoma, verdana, arial, sans-serif;font-size:14px; }");
        htmlBuilder.append("table { font-family:'lucida grande', tahoma, verdana, arial, sans-serif;font-size:14px; }");
        htmlBuilder.append(".table-container { text-align: left; }");
        htmlBuilder.append("</style>");



        // Add the name as a heading
        // htmlBuilder.append("<h1>").append("NHÂN VẬT").append("</h1>");
        // htmlBuilder.append("<h1>").append(getName()).append("</h1>");

        // Add the code
        // htmlBuilder.append("<p><strong>Code:</strong> ").append(getCode()).append("</p>");


        // Add the description
        htmlBuilder.append("<h2>Mô tả</h2>");
        htmlBuilder.append("<p>").append(this.thoiGian).append("</p>");
        htmlBuilder.append("<p>").append(this.diaDiem).append("</p>");
        htmlBuilder.append("<p>").append(this.ketQua).append("</p>");


//        // Add the related figures
//        htmlBuilder.append("<h2>Related Figures</h2>");
//        if (this.cacNhanVatLienQuan != null) {
//            htmlBuilder.append("<ul>");
//            for (String figure : this.cacNhanVatLienQuan) {
//                htmlBuilder.append("<li>").append(figure).append("</li>");
//            }
//            htmlBuilder.append("</ul>");
//        }
//
//
//        // Add the related places
//        htmlBuilder.append("<h2>Related Places</h2>");
//        if (this.cacDiTichLienQuan != null) {
//            htmlBuilder.append("<ul>");
//            for (String place : this.cacDiTichLienQuan) {
//                htmlBuilder.append("<li>").append(place).append("</li>");
//            }
//            htmlBuilder.append("</ul>");
//        }


        // Close the HTML structure
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
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
    public String toString() {
        return  "\n{ \"id\":\"" + this.id + "\", "
                + "\n\"tenModel\":\"" + this.tenModel + "\", "
                + "\n\"thoiGian\":\"" + this.thoiGian + "\", "
                + "\n\"diaDiem\":\"" + this.diaDiem + "\", "
                + "\n\"ketQuan\":\"" + this.ketQua + "\", "
                + "\n\"cacNhanVatLienQuan\":\"" + this.cacNhanVatLienQuan + "\", "
                + "\n\"cacDiTichLienQuan\":\"" + this.cacDiTichLienQuan + "\" }" + "\n";
    }
}
