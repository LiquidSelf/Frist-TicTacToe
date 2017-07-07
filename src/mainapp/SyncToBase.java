package mainapp;

import javafx.application.Platform;
import javafx.concurrent.Task;
import mainapp.view.SqlController;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class SyncToBase {


    private boolean isdif = false;

    private SqlPsvm sqlPsvm;
    private SqlController sqlController;
    private SqlController.FxGameStatus fxGameStatus;

    public void sync() {

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }


    Task<Void> task = new Task<Void>() {


        @Override
        protected Void call() throws Exception {


            try {

                System.out.println("sync started.");


                while (true) {

                    sqlController.sqlSync();
                    System.out.println("sync!");

                    Platform.runLater(() -> {
                        try {
                           sqlController.isEnd();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });  ;

                    Thread.sleep(1000);
                    if(SqlController.isend){Thread.sleep(30000);}
                }


            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("sync stopped!");
            }
            return null;

        }
    };


    public void setSqlController(SqlController sqlController) {
        this.sqlController = sqlController;
    }

    public void setSqlPsvm(SqlPsvm sqlPsvm) {
        this.sqlPsvm = sqlPsvm;
    }

    public void setFxGameStatus(SqlController.FxGameStatus fxGameStatus) {
        this.fxGameStatus = fxGameStatus;
    }
}











