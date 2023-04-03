package ma.fstt.trackingl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.fstt.model.Commande;
import ma.fstt.model.CommandeDAO;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class CommandeViewController implements Initializable{
    @FXML
    private TextField datd ;

    @FXML
    private TextField datf ;
    @FXML
    private TextField km;
    @FXML
    private TextField cl;
    @FXML
    private TextField e ;

    @FXML
    private TableView<Commande> thetable ;


    @FXML
    private TableColumn<Commande,Long> colo_id ;

    @FXML
    private TableColumn <Commande ,String> col_debut ;

    @FXML
    private TableColumn <Commande ,String> col_fin;
    @FXML
    private TableColumn <Commande,String> col_k ;
    @FXML
    private TableColumn <Commande,String> col_cli ;
    @FXML
    private TableColumn <Commande,String> col_et ;


    @FXML
    protected void OnSaveButtonClick() {

        // accees a la bdd

        try {
            CommandeDAO commandeDAO = new CommandeDAO();

            Commande com = new Commande(0L, datd.getText() , datf.getText(), km.getText(),cl.getText(),e.getText());

            commandeDAO.save(com);


            UpdateTable();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void UpdateTable(){
        colo_id.setCellValueFactory(new PropertyValueFactory<Commande,Long>("id_commande"));
        col_debut.setCellValueFactory(new PropertyValueFactory<Commande,String>("date_debut"));
        col_fin.setCellValueFactory(new PropertyValueFactory<Commande,String>("date_fin"));
        col_k.setCellValueFactory(new PropertyValueFactory<Commande,String>("km"));
        col_cli.setCellValueFactory(new PropertyValueFactory<Commande,String>("client"));
        col_et.setCellValueFactory(new PropertyValueFactory<Commande,String>("etat"));

        thetable.setItems(this.getDataCommandes());
    }

    public static ObservableList<Commande> getDataCommandes(){

        CommandeDAO commandeDAO = null;

        ObservableList<Commande> listfx = FXCollections.observableArrayList();

        try {
            commandeDAO = new CommandeDAO();
            for (Commande ettemp : commandeDAO.getAll())
                listfx.add(ettemp);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }

    public void oneditButtonClick(){

    }
    public void deleteButton(){
        Commande selectedCommande = thetable.getSelectionModel().getSelectedItem();

        if (selectedCommande == null) {
            // None selected,  error message
            System.out.println("Error: no item selected for deletion");

            return;
        }

        try {
           CommandeDAO commandeDAO = new CommandeDAO();
            commandeDAO.delete(selectedCommande);
            UpdateTable();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();

    }
}

