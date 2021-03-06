package org.uirebels.grapheditor;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.uirebels.grapheditor.controller.JFXGraphEditorViewController;
import org.uirebels.grapheditor.view.SimpleTaskVertexView;
import org.uirebels.grapheditor.controller.SimpleTaskController;
import org.uirebels.grapheditor.controller.AbstractGraphController;
import org.uirebels.grapheditor.view.SimplePolyEdgeView;
import static javafx.application.Application.launch;
import org.uirebels.grapheditor.constants.StringConstant;

public class JFXGraphEditor extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        AbstractGraphController graphController = new SimpleTaskController();
        graphController.newGraph();
        graphController.setGraphAttribute(StringConstant.GRAPH_TYPE, "SimpleTask");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/JFXGraphEditorView.fxml"));
        Parent root = loader.load();

        JFXGraphEditorViewController mainController = loader.<JFXGraphEditorViewController>getController();
        mainController.setGraphController(graphController);

        SimpleTaskVertexView.setGraphController(graphController);
        SimplePolyEdgeView.setGraphController(graphController);

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("JavaFX and Tinkerpop3 Together");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    @Override
    public void stop() {
        System.out.println("Graph Editor closing.");
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
