package com.app.thuvienlichsu.base;

import com.app.thuvienlichsu.util.Config;
import com.app.thuvienlichsu.util.Encode;
import com.app.thuvienlichsu.util.StringUtility;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.ArrayList;
import java.util.List;

public class Model implements Comparable<Model>
{
    protected int id;
    protected String tenModel;
    protected List<String> moTa = new ArrayList<>();
    protected String code;
    public Model(String ten){
        this.tenModel = ten;
    }
    public Model(String ten, List<String> moTa)
    {
        setTenModel(ten);
        setMoTa(moTa);
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }


    public String getTenModel() {
        return tenModel;
    }
    public void setTenModel(String tenModel)
    {
        this.tenModel = tenModel.equals("") ? Config.nullRepresentation : tenModel;
    }

    public void setMoTa(List<String> moTa)
    {
        if (moTa == null)
        {
            moTa = new ArrayList<>();
            moTa.add(Config.nullRepresentation);
        }
        this.moTa = moTa;
    }
    public List<String> getMoTa(){
        return moTa;
    }
    public TextFlow getDescription()
    {
        if (this.moTa == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        for (String item : moTa) {
            stringBuilder.append(item).append("\n");
        }
        String description = stringBuilder.toString().trim();
        TextFlow textFlow = new TextFlow(new Text(description));
        textFlow.setMaxWidth(460);
        textFlow.setLineSpacing(2.0);
        textFlow.setPadding(new Insets(0, 0, 0, 10));
        return textFlow;
    }
    public int compareTo(Model o) {
        String searchingNormalized = StringUtility.generalizeVietnameseString(getTenModel());
        String oSearchingNormalized = StringUtility.generalizeVietnameseString(o.getTenModel());
        return searchingNormalized.compareTo(oSearchingNormalized);
    }
}

