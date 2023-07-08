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
    private List<List<String>> thongTin;
    private Set<String> cacNhanVatLienQuan;
    private Set<String> cacDiTichLienQuan;

    public Set<String> getCacNhanVatLienQuan() {
        return this.cacNhanVatLienQuan;
    }
    public List<String> getcacDiTichLienQuan() {
        return new ArrayList<>(this.cacDiTichLienQuan);
    }

    public Set<String> getCacDiTichLienQuan() {
        return cacDiTichLienQuan;
    }
    public List<List<String>> getThongTin() {
        return thongTin;
    }
    public ThoiKyModel(String name, List<String> moTa, String code, Set<String> cacNhanVatLienQuan
            , Set<String> cacDiTichLienQuan)
    {
        super(name, moTa);
        setCode(code);
        setcacNhanVatLienQuan(cacNhanVatLienQuan);
        setcacDiTichLienQuan(cacDiTichLienQuan);
    }
    
    public void setcacNhanVatLienQuan(Set<String> cacNhanVatLienQuan) {
        this.cacNhanVatLienQuan = cacNhanVatLienQuan;
    }

    public void setcacDiTichLienQuan(Set<String> cacDiTichLienQuan) {
        this.cacDiTichLienQuan = cacDiTichLienQuan;
    }
    public void setThongTin(List<List<String>> thongTin) {
        this.thongTin = thongTin;
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
        htmlBuilder.append("<i>").append(this.tenModel).append("</i>");
        htmlBuilder.append("<meta charset=\"UTF-8\">");
        // htmlBuilder.append("<title>").append(getName()).append("</title>");
        htmlBuilder.append("<style>");
        htmlBuilder.append("body { background-color:#f2f3f5; font-family:'lucida grande', tahoma, verdana, arial, sans-serif;font-size:14px; }");
        htmlBuilder.append("</style>");

        // Add the name as a heading
        // htmlBuilder.append("<h1>").append("NHÂN VẬT").append("</h1>");
        // htmlBuilder.append("<h1>").append(getName()).append("</h1>");

        // Add the code
        // htmlBuilder.append("<p><strong>Code:</strong> ").append(getCode()).append("</p>");

        // Add the infobox
        htmlBuilder.append("<h2>Thông tin thời kỳ</h2>");

        // Add the description
        if (this.moTa != null) {
            for (String desc : this.moTa) {
                htmlBuilder.append("<p>").append(desc).append("</p>");
            }
        }


        // Add the related figures

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
        return "\n{ \"tenModel\":\"" + this.tenModel + "\", "
                + "\n\"moTa\":\"" + this.moTa + "\", "
                + "\n\"cacNhanVatLienQuan\":\"" + this.cacNhanVatLienQuan + "\" }" + "\n";
    }
}