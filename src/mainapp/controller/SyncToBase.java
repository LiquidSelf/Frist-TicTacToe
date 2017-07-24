package mainapp.controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import mainapp.SqlPsvm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SyncToBase {


    private SqlController sqlController;
    private SqlPsvm sqlPsvm;

    final private String url = "jdbc:sqlserver://mssql2.gear.host";
    final private String name = "luldb";
    final private String pass = "Cd0zjV6__g65";

    public SyncToBase(){
        loadJdbc();
    }

    public void startSync() {

        Thread thread = new Thread(task);
        thread.setDaemon(false);
        thread.start();
    }


    Task<Void> task = new Task<Void>() {


        @Override
        protected Void call() throws Exception {


            try (Connection con = DriverManager.getConnection(url, name, pass)) {
                SqlPsvm.connect = con;
                sqlController.sqlSync();
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
                    });

                    Thread.sleep(1000);
                    if (SqlController.isend) {
                        Thread.sleep(30000);
                    }

                    if (!sqlPsvm.getPrimaryStage().isShowing()){

                        try (Statement st = SqlPsvm.connect.createStatement()) {
                            st.executeUpdate("UPDATE xoxo SET figure = ' '");
                            st.close();
                        }
                        catch (SQLException ex){ex.printStackTrace();}

                        finally {
                            if(SqlPsvm.connect!=null) {SqlPsvm.connect.close();}
                            System.out.println("connect closed in sync!");
                            System.exit(4);
                        }
                    }
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

        private void loadJdbc () {

            try {

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        }

    public void setSqlPsvm(SqlPsvm sqlPsvm) {
        this.sqlPsvm = sqlPsvm;
    }
}







