//package mainapp;
//
//import javafx.application.Platform;
//import javafx.concurrent.Task;
//import mainapp.view.SqlController;
//
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.Arrays;
//
//public class Checker {
//
//    private boolean isdif = false;
//
//    private SqlPsvm sqlPsvm;
//    private SqlController sqlController;
//    private SqlController.FxGameStatus fxGameStatus;
//
//    public void check() {
//
//        Thread thread = new Thread(task);
//        thread.setDaemon(true);
//        thread.start();
//    }
//
//
//    public Checker(SqlPsvm sqlPsvm) {
//        this.sqlPsvm = sqlPsvm;
//    }
//
//    Task<Void> task = new Task<Void>() {
//
//
//        @Override
//        protected Void call() throws Exception {
//
//
//            try {
//
//                System.out.println("checker started.");
//                String[] tempAfter = new String[10];
//                Statement statement = SqlPsvm.connect.createStatement();
//
//
//                while (!isdif) {
//
//                    ResultSet rs = statement.executeQuery("SELECT * FROM xoxo");
//
//                    int ie = 0;
//
//                    while (rs.next()) {
//
//                        tempAfter[ie] = rs.getString(2);
//                        ie++;
//                    }
//
//                    System.out.println(Arrays.toString(tempAfter));
//
//
//                    if (!Arrays.equals(SqlController.tempBefore, tempAfter)) {
//
//                        System.out.println("yeap!");
//
//                        isdif = true;
//                    }
//
//                    Thread.sleep(1000);
//
//                }
//
//
//
//                sqlController.sqlSync();
//                Platform.runLater(() -> sqlPsvm.pauseHide());
//                task.cancel();
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//
//            }
//
//            return null;
//        }
//    };
//
//    public void setSqlController(SqlController sqlController) {
//        this.sqlController = sqlController;
//    }
//
//    public void setSqlPsvm(SqlPsvm sqlPsvm) {
//        this.sqlPsvm = sqlPsvm;
//    }
//
//    public void setFxGameStatus(SqlController.FxGameStatus fxGameStatus) {
//        this.fxGameStatus = fxGameStatus;
//    }
//}
//
//
//
//
//
