package com.nchash;

import com.nchash.controller.Controller;
import com.nchash.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        showMainApplication();
    }

    public void showMainApplication(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/MainView.fxml"));
            MainController mainController = new MainController();
            loader.setController(mainController);
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
            primaryStage.setTitle("NC-Hash Application");
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Shows Bon's code. This is the debug window
     */
    public void showDebugScreen(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/Sample.fxml"));

            Controller controller = new Controller();
            loader.setController(controller);

            BorderPane debugScreenView = (BorderPane)loader.load();
            Scene scene = new Scene(debugScreenView);
            //Gives a reference to the primary stage.
            controller.setMainApp(this);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
