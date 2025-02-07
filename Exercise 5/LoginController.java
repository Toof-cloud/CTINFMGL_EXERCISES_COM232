
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class LoginController {

    @FXML
    Label usernameLabel;

    @FXML
    Label passwordLabel;
    
    @FXML
    TextField usernametextfield;

    @FXML
    TextField passwordtextfield;

    @FXML
    Button loginbutton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void loginbuttonHandler(ActionEvent event) throws IOException{

        System.out.println("Tyrone");

        String uname = usernametextfield.getText();
        String pword = passwordtextfield.getText();

        System.out.println("username: " +uname);
        System.out.println("password: " +pword);

        if(DatabaseHandler.validateLogin(uname, pword)){

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
            //System.out.println("Login successful");

            root = loader.load();

            HomeController homeController = loader.getController();
            // Pass username from textfield to displayName() method
            
            homeController.displayName(uname);

            // Load stage and scene
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        } else {
            //System.out.println("Login unsuccessful");
        }
    }
        
    


}
