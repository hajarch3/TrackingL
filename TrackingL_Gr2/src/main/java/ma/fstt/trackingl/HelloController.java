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
import ma.fstt.model.Livreur;
import ma.fstt.model.LivreurDAO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    @FXML
    private TextField nom ;


    @FXML
    private TextField tele ;
    @FXML
    private TextField matricule ;

    @FXML
    private TableView<Livreur> mytable ;


    @FXML
    private TableColumn<Livreur ,Long> col_id ;

    @FXML
    private TableColumn <Livreur ,String> col_nom ;

    @FXML
    private TableColumn <Livreur ,String> col_tele ;
    @FXML
    private TableColumn <Livreur ,String> col_mat ;



    @FXML
    protected void onSaveButtonClick() {

        // accees a la bdd

        try {
            LivreurDAO livreurDAO = new LivreurDAO();

            Livreur liv = new Livreur(0L, nom.getText() , tele.getText(), matricule.getText());

            livreurDAO.save(liv);


            UpdateTable();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void UpdateTable(){
        col_id.setCellValueFactory(new PropertyValueFactory<Livreur,Long>("id_livreur"));
        col_nom.setCellValueFactory(new PropertyValueFactory<Livreur,String>("nom"));

        col_tele.setCellValueFactory(new PropertyValueFactory<Livreur,String>("telephone"));
        col_mat.setCellValueFactory(new PropertyValueFactory<Livreur,String>("matricule"));



        mytable.setItems(this.getDataLivreurs());
    }

    public static ObservableList<Livreur> getDataLivreurs(){

        LivreurDAO livreurDAO = null;

        ObservableList<Livreur> listfx = FXCollections.observableArrayList();

        try {
            livreurDAO = new LivreurDAO();
            for (Livreur ettemp : livreurDAO.getAll())
                listfx.add(ettemp);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }

    public void oneditButtonClick(){

    }
    public void deleteButton(){
        Livreur selectedLivreur = mytable.getSelectionModel().getSelectedItem();

        if (selectedLivreur == null) {
            // None selected,  error message
            System.out.println("Error: no item selected for deletion");

            return;
        }

        try {
            LivreurDAO livreurDAO = new LivreurDAO();
            livreurDAO.delete(selectedLivreur);
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