/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uirebels.grapheditor.view;

/**
 *
 * @author bnamestka
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.shape.Line;

public class SimpleEdgeView extends AbstractView {
    
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Group edgeGroup;

    @FXML
    private Line edgeLine;

    public SimpleEdgeView() {
        super("SimpleEdgeView");
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }        
    }

    @FXML
    void initialize() {
        viewModel.setEdgeView(edgeGroup);
//        assert edgeGroup != null : "fx:id=\"edgeGroup\" was not injected: check your FXML file 'SimpleEdgeView.fxml'.";
//        assert edgeLine != null : "fx:id=\"edgeLine\" was not injected: check your FXML file 'SimpleEdgeView.fxml'.";
    }
        
    @Override
    public Group getGraphic(){
        return edgeGroup;
    }
}