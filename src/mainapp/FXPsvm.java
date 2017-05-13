package mainapp;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FXPsvm extends Application {


    private AnchorPane gridRoot;
    private GridPane gridRootBack;
    private Stage primaryStage;
    private StringProperty field1 = new SimpleStringProperty("");
    private StringProperty field2 = new SimpleStringProperty("");
    private StringProperty field3 = new SimpleStringProperty("");
    private StringProperty field4 = new SimpleStringProperty("");
    private StringProperty field5 = new SimpleStringProperty("");
    private StringProperty field6 = new SimpleStringProperty("");
    private StringProperty field7 = new SimpleStringProperty("");
    private StringProperty field8 = new SimpleStringProperty("");
    private StringProperty field9 = new SimpleStringProperty("");
    public static StringProperty title = new SimpleStringProperty("XoXo Gaming");


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.titleProperty().bind(title);
        createScene();


    }


    private void createScene() {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FXPsvm.class.getResource("view/SceneBuilder.fxml"));
            gridRoot = loader.load();
            Scene scene = new Scene(gridRoot);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}


