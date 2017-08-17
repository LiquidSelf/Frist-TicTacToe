package mainapp.controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import mainapp.SqlPsvm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutionException;

public class SyncToBase {

    private SqlController sqlController;
    private SqlPsvm sqlPsvm;
    private final static String url = "jdbc:sqlserver://mssql2.gear.host";
    private final static String name = "luldb";
    private final static String pass = "Cd0zjV6__g65";

    public SyncToBase(SqlPsvm sqlPsvm, SqlController sqlController) throws ExecutionException, InterruptedException {
        this.sqlPsvm = sqlPsvm;
        this.sqlController = sqlController;
        loadJdbc();
        startSync();
    }


    public void startSync() throws ExecutionException, InterruptedException {
        Thread thread = new Thread(task);
        thread.setDaemon(false);
        thread.start();

    }


    Task<Integer> task = new Task<Integer>() {


        @Override
        protected Integer call() throws Exception {
            try (Connection con = DriverManager.getConnection(url, name, pass)) {
                SqlPsvm.connect = con;
                sqlController.sqlSync();
                System.out.println("sync started.");

                while (true) {

                    sqlController.sqlSync();

                    System.out.println("sync!");

                    Platform.runLater(() -> {
                        try {
                            sqlPsvm.setTitle(String.valueOf(sqlController.getWhosturn()));
                            sqlController.isEnd();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });

                    Thread.sleep(800);

                    if (SqlController.isend) {

                        Thread.sleep(30000);
                    }

                    if (!sqlPsvm.getPrimaryStage().isShowing()) {

                        SqlPsvm.resetFields();
                        System.out.println("thank you and good luck!");
                        System.exit(123);
                    }

                }

            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("sync stopped with exception!");
            }

            return null;

        }
    };


    private void loadJdbc() {

        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}




