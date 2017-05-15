package mainapp;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mainapp.view.Controller;

import java.io.IOException;

public class FXPsvm extends Application {


    private AnchorPane gridRoot;
    private Stage primaryStage;
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
            Controller conroller = loader.getController();
            conroller.setFxPsvm(this);
            primaryStage.setScene(scene);

            primaryStage.show();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void andWinnerIs(char who){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Gg Wp! ");
        alert.setHeaderText("");
        alert.setContentText("'"+ who+"' has won the game! Nice!");
        alert.showAndWait();
    }
    public void draw(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Draw.");
        alert.setHeaderText("");
        alert.setContentText("Draw, Draw, Draw!");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public AnchorPane getGridRoot(){
        return gridRoot;
    }

}


