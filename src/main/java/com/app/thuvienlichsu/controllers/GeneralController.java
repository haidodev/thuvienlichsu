package com.app.thuvienlichsu.controllers;

import com.app.thuvienlichsu.base.LoadData;
import com.app.thuvienlichsu.base.Model;

import com.app.thuvienlichsu.util.StringUtility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;

public class GeneralController implements Initializable {
    protected final ObservableList<String> objectList = FXCollections.observableArrayList();
    protected static LoadData database = new LoadData();

    @FXML
    protected ListView<String> listView;
    @FXML
    protected TextField searchField;
    @FXML
    private final ArrayList<Model> searchTemp = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
    public void setListViewItem(ArrayList<Model> resource) {
        objectList.clear();
        if (searchField.getText().equals("")) {
            searchTemp.clear();
            searchTemp.addAll(resource);
        }
        for (Model temp : searchTemp) {
            objectList.add(temp.getTenModel());
        }
        listView.setItems(objectList);
    }

    public void searchFieldAction(ArrayList<Model> resource) {
        searchTemp.clear();
        objectList.clear();
        String word = searchField.getText();
        int index = database.binaryLookup(0, resource.size() - 1, word, resource);
        updateWordInListView(word, index, resource, searchTemp);
        setListViewItem(resource);
    }
    public Model getModelFromDatabase(ArrayList<Model> resource) {
        return getModelFromDatabase(resource, listView.getSelectionModel().getSelectedItem());
    }
    public Model getModelFromDatabase(ArrayList<Model> resource, String spelling) {
        if (spelling == null) {
            return null;
        }
        int index = Collections.binarySearch(resource, new Model(spelling));
        return resource.get(index);
    }
    public void updateWordInListView(String word, int index, ArrayList<Model> res, ArrayList<Model> des) {
        if (index < 0) {
            return;
        }
        int j = index;
        while (j >= 0) {
            if (StringUtility.isContain(word, res.get(j).getTenModel()) == 0) {
                j--;
            } else {
                break;
            }
        }
        for (int i = j + 1; i <= index; i++) {
            Model temp = new Model(res.get(i).getTenModel());
            des.add(temp);
        }
        for (int i = index + 1; i < res.size(); i++) {
            if (StringUtility.isContain(word, res.get(i).getTenModel()) == 0) {
                Model temp = new Model(res.get(i).getTenModel());
                des.add(temp);
            } else {
                break;
            }
        }
    }
}