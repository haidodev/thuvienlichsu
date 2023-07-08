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
    private List<List<String>> thongTin;
    private Set<String> cacNhanVatLienQuan;
    private Set<String> cacThoiKyLienQuan;
    private List<String> cacLeHoiLienQuan;

    public DiTichModel(String tenModel, List<String> moTa, String code, Set<String> cacNhanVatLienQuan)
    {
        super(tenModel, moTa);
        setCode(code);
        setCacNhanVatLienQuan(cacNhanVatLienQuan);
        setCacThoiKyLienQuan(new HashSet<>());
        setCacLeHoiLienQuan(new ArrayList<>());
    }
    public List<List<String>> getThongTin() {
        return thongTin;
    }
    public void setThongTin(List<List<String>> thongTin) {
        this.thongTin = thongTin;
    }
    public void setCacLeHoiLienQuan(List<String> cacLeHoiLienQuan) {
        this.cacLeHoiLienQuan = cacLeHoiLienQuan;
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

    public List<String> getCacLeHoiLienQuan() {
        return cacLeHoiLienQuan;
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

        if (this.cacThoiKyLienQuan != null)
        {
            htmlBuilder.append("<h2>Thời kỳ liên quan</h2>");
            htmlBuilder.append("<ul>");

            for (String desc : this.cacThoiKyLienQuan) {
                htmlBuilder.append("<li>").append(desc).append("</li>");
            }

            htmlBuilder.append("</ul>");
        }

        if (this.cacLeHoiLienQuan != null)
        {
            htmlBuilder.append("<h2>Lễ hội liên quan</h2>");
            htmlBuilder.append("<ul>");

            for (String desc : this.cacLeHoiLienQuan) {
                htmlBuilder.append("<li>").append(desc).append("</li>");
            }

            htmlBuilder.append("</ul>");
        }

        {
            htmlBuilder.append("<h2>Mô tả</h2>");
            for (String desc : this.moTa) {
                htmlBuilder.append("<p>").append(desc).append("</p>");
            }
        }

//        // Add the related figures
//        if (this.cacNhanVatLienQuan != null)
//        {
//            htmlBuilder.append("<h2>Related Figures</h2>");
//            htmlBuilder.append("<ul>");
//            for (String figure : this.cacNhanVatLienQuan) {
//                htmlBuilder.append("<li>").append(figure).append("</li>");
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
        return  "\n{ \"Id\":\"" + this.id + "\", "
                + "\n\"Địa danh\":\"" + this.tenModel + "\", "
                + "\n\"Code\":\"" + this.code + "\", "
                + "\n\"Miêu tả\":\"" + this.moTa + "\", "
                + "\n\"Nhân vật liên quan code\":\"" + this.cacNhanVatLienQuan + "\" }" + "\n";
    }
}
