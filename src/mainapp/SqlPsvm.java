package mainapp;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mainapp.view.SqlController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SqlPsvm extends Application {

    private AnchorPane gridRoot;
    private Stage primaryStage;
    public static Connection connect;
    public static StringProperty title = new SimpleStringProperty("XoXo Gaming");
    private SqlController sqlController;
    Scene scene;
    ImageView pause;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        createConnect();
        createScene();


    }


    private void createScene() throws Exception {

        try {

            this.primaryStage.titleProperty().bind(title);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(FXPsvm.class.getResource("view/SqlSceneBuilder.fxml"));
            gridRoot = loader.load();
            Scene scene = new Scene(gridRoot);
            this.scene = scene;
            SqlController sqlControllerconroller = loader.getController();
            sqlControllerconroller.sqlSync();
            sqlControllerconroller.setSqlPsvm(this);
            primaryStage.setScene(scene);
            sqlControllerconroller.sqlSync();
            createPause();
            SyncToBase st = new SyncToBase();
            st.setSqlController(sqlControllerconroller);
            st.sync();
            primaryStage.show();





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
        alert.setContentText("'" + who + "' has won the game! Nice!");
        alert.showAndWait();
        Thread.sleep(1000);
        Statement st = connect.createStatement();
        st.executeUpdate("UPDATE xoxo SET figure = ' '");
        st.close();
    }

    public void draw() throws Exception {
        Statement st = connect.createStatement();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Draw.");
        alert.setHeaderText("");
        alert.setContentText("Draw, Draw, iDraw!");
        alert.showAndWait();
        Thread.sleep(1000);
        st.executeUpdate("UPDATE xoxo SET figure = ' '");
        st.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public AnchorPane getGridRoot() {
        return gridRoot;
    }

    private static synchronized void createConnect() throws Exception {
        try {

            Connection cn = null;


            String url = "jdbc:sqlserver://mssql2.gear.host";
            String name = "luldb";
            String pass = "Cd0zjV6__g65";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(url, name, pass);
            SqlPsvm.connect = cn;

        } catch (Exception ex) {

            connect.close();
            ex.printStackTrace();


        }

    }

    private void createWait() throws Exception{



    }
    public Scene getScene(){
        return scene;
    }

    public AnchorPane getGrid(){
        return gridRoot;
    }

    public void createPause(){

        pause = new ImageView(new Image("mainapp/view/imjes/RicardoMoris!.gif"));
        pause.fitHeightProperty().bind(scene.heightProperty());
        pause.fitWidthProperty().bind(scene.widthProperty());
        pause.setVisible(true);
        pause.toFront();


    }
    public ImageView getPause(){
        return pause;
    }
    public void pauseShow(){
        gridRoot.getChildren().add(pause);


    }

    public void pauseHide(){
        gridRoot.getChildren().remove(pause);





    }
}


