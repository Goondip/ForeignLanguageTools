/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing;

import DataModel.LanguagePair;
import DataModel.Utils;
import Logic.ActualAPI;
import UI.Components.Model;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Ethan Swistak
 */
public class TestComponents extends Application {
    
    Model model = Model.getInstance();
    ActualAPI api = ActualAPI.getInstance();
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        List<LanguagePair> pairs = api.getLangPair();
        model.availableLanguagesProperty().addAll(pairs);
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("UI/Components/UITest.fxml"));
        Scene scene = loader.load();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Utils.load();      
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TestComponents.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(TestComponents.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TestComponents.class.getName()).log(Level.SEVERE, null, ex);
        }
        launch(args);
    }
    
}
