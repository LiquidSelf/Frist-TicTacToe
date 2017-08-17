package mainapp;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mainapp.controller.SqlController;
import mainapp.controller.SyncToBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlPsvm extends Application {
    private AnchorPane gridRoot;
    private Stage primaryStage;
    public static Connection connect;
    public StringProperty title = new SimpleStringProperty("XoXo Gaming");
    private SqlController sqlController;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        createScene();


    }


    private void createScene() throws Exception {

        try {

            this.primaryStage.titleProperty().bind(title);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SqlPsvm.class.getResource("view/SqlSceneBuilder.fxml"));
            gridRoot = loader.load();
            Scene scene = new Scene(gridRoot);
            SqlController sqlController = loader.getController();
            this.sqlController = sqlController;
            createSync();
            sqlController.setSqlPsvm(this);
            primaryStage.setScene(scene);
            primaryStage.show();
            scene.setCursor(Cursor.WAIT);
            while (connect == null) {
                Thread.sleep(100);
            }
            scene.setCursor(Cursor.HAND);


        } catch (IOException e) {

            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Exception.");
            alert.setHeaderText("");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }


    }

    public void andWinnerIs(char who) throws Exception {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Gg Wp! ");
        alert.setHeaderText("");
        alert.setContentText("'" + who + "' - player has won the game! Nice!");
        alert.showAndWait();
        Thread.sleep(1000);
        SqlPsvm.resetFields();
    }

    public void draw() throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Draw.");
        alert.setHeaderText("");
        alert.setContentText("Draw, Draw, iDraw!");
        alert.showAndWait();
        Thread.sleep(1000);
        SqlPsvm.resetFields();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public AnchorPane getGridRoot() {
        return gridRoot;
    }

    private void createSync() throws Exception {


        try {

            new SyncToBase(this, sqlController);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void resetFields() {
        try (Statement st = connect.createStatement()) {
            st.executeUpdate("UPDATE xoxo SET figure = ' '");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                    System.out.println("fields reseted!");
                } catch (SQLException sqlEx) {
                    sqlEx.printStackTrace();
                }
            }

        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;

    }

    public void setTitle(String title){
        this.title.setValue("It's '"+title+"' turn.");
    }
}

