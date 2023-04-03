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
import ma.fstt.model.Produit;
import ma.fstt.model.ProduitDAO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class ProductViewController implements Initializable{
    @FXML
    private TextField nomprod ;

    @FXML
    private TextField cat ;
    @FXML
    private TextField pr ;
    @FXML
    private TextField des ;

    @FXML
    private TableView<Produit> table ;


    @FXML
    private TableColumn<Produit ,Long> colo_id ;

    @FXML
    private TableColumn <Produit ,String> col_nompr ;

    @FXML
    private TableColumn <Produit ,String> col_cat ;
    @FXML
    private TableColumn <Produit,String> col_pr ;
    @FXML
    private TableColumn <Produit,String> col_des ;


    @FXML
    protected void OnSaveButtonClick() {

        // accees a la bdd

        try {
            ProduitDAO produitDAO = new ProduitDAO();

            Produit prod = new Produit(0L, nomprod.getText() , cat.getText(), pr.getText(),des.getText());

            produitDAO.save(prod);


            UpdateTable();




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void UpdateTable(){
        colo_id.setCellValueFactory(new PropertyValueFactory<Produit,Long>("id_produit"));
        col_nompr.setCellValueFactory(new PropertyValueFactory<Produit,String>("nom_produit"));
        col_cat.setCellValueFactory(new PropertyValueFactory<Produit,String>("categorie"));
        col_pr.setCellValueFactory(new PropertyValueFactory<Produit,String>("prix"));
        col_des.setCellValueFactory(new PropertyValueFactory<Produit,String>("description"));

       table.setItems(this.getDataProduits());
    }

    public static ObservableList<Produit> getDataProduits(){

        ProduitDAO produitDAO = null;

        ObservableList<Produit> listfx = FXCollections.observableArrayList();

        try {
            produitDAO = new ProduitDAO();
            for (Produit ettemp : produitDAO.getAll())
                listfx.add(ettemp);

        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listfx ;
    }

    public void oneditButtonClick(){

    }
    public void deleteButton(){
        Produit selectedProduit = table.getSelectionModel().getSelectedItem();

        if (selectedProduit == null) {
            // None selected,  error message
            System.out.println("Error: no item selected for deletion");

            return;
        }

        try {
            ProduitDAO produitDAO = new ProduitDAO();
            produitDAO.delete(selectedProduit);
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
