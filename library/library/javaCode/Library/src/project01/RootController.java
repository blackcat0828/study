package project01;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {
	@FXML private TableView<Book> tableView;
	@FXML private Button btnAdd;
	@FXML private Button btnHome;
	@FXML private TextField searchField;
	@FXML private Button btnSearch;
	@FXML private Label labelTest;
	private String searchValue;
	
	libraryDAO dao = new libraryDAO();
	private ObservableList<Book> list;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		
		list = dao.bookSelectAll();
		
		TableColumn tc = tableView.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory("id"));
		tc.setStyle("-fx-alignment: CENTER;");
		
		tc = tableView.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory("title"));
		tc.setStyle("-fx-alignment: CENTER;");
		
		tc = tableView.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory("rent"));
		tc.setStyle("-fx-alignment: CENTER;");
		
		tc = tableView.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory("contact"));
		tc.setStyle("-fx-alignment: CENTER;");
		
		tc = tableView.getColumns().get(4);
		tc.setCellValueFactory(new PropertyValueFactory("rentDate"));
		tc.setStyle("-fx-alignment: CENTER;");
		
		tc = tableView.getColumns().get(5);
		tc.setCellValueFactory(new PropertyValueFactory("overDate"));
		tc.setStyle("-fx-alignment: CENTER;");
		
		tableView.setItems(list);
		tableView.setOnMouseClicked(event->handleMouseClicked(event));
		
		searchField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                searchValue = newValue;
                
            }
        });
		

		
		btnSearch.setOnAction(event->handleBtnSearchAction(event, searchValue));
		
		btnAdd.setOnAction(event->handleBtnAddAction(event));
		btnHome.setOnAction(event->handlebtnHomeAction(event));
	}
	
	//책 추가 Action
	private void handleBtnAddAction(ActionEvent event) {
		try {		
			
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(btnAdd.getScene().getWindow());
			dialog.setTitle("추가");
		
			Parent parent = FXMLLoader.load(getClass().getResource("addForm.fxml"));
			
			Button btnFormAdd = (Button) parent.lookup("#btnFormAdd");
			btnFormAdd.setOnAction(e->{
				TextField bookTitle = (TextField) parent.lookup("#bookTitle");
				int result = 0;
				result = dao.addBook(bookTitle.getText());
				
				if(result==1) {
				list.add(dao.searchLastAdd());
				}
				dialog.close();
			});
			
			Button btnFormCancel = (Button) parent.lookup("#btnFormCancel");
			btnFormCancel.setOnAction(e->dialog.close());
			
			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.setResizable(false);	
			dialog.show();	
		} catch (IOException e) {}
	}

	
	//리스트 마우스 더블클릭 Event
	private void handleMouseClicked(MouseEvent event) {
		if (event.getClickCount() != 2) return;
		
		try {		
			
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(btnAdd.getScene().getWindow());
			dialog.setTitle("추가");
		
			Parent parent = FXMLLoader.load(getClass().getResource("bookForm.fxml"));
			Book book = tableView.getSelectionModel().getSelectedItem();
			Label id = (Label) parent.lookup("#txtId");
			Label title = (Label) parent.lookup("#txtTitle");
			TextField rent = (TextField) parent.lookup("#txtRent");
			TextField contact = (TextField) parent.lookup("#txtContact");
			
			id.setText(Integer.toString(book.getId()));
			title.setText(book.getTitle());
			rent.setText(book.getRent());
			
			
			Button btnDelete = (Button) parent.lookup("#btnDelete");
			btnDelete.setOnAction(e->{
				
				int result = 0;
				result = dao.bookDelete(id.getText());
				
				
				//리스트 화면 새로고침
				
				list.clear();
				
				try {
					Parent root;
					root = (Parent)FXMLLoader.load(getClass().getResource("root.fxml"));
					Scene scene = new Scene(root);
					Stage primaryStage = (Stage)tableView.getScene().getWindow();
					primaryStage.setScene(scene);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				dialog.close();
			});
			
			
			//반환
			Button btnReturn = (Button) parent.lookup("#btnReturn");
			btnReturn.setOnAction(e->{
				
				int result = 0;
				result = dao.returnBook(id.getText());
				
				
				//리스트 화면 새로고침
				
				list.clear();
				
				try {
					Parent root;
					root = (Parent)FXMLLoader.load(getClass().getResource("root.fxml"));
					Scene scene = new Scene(root);
					Stage primaryStage = (Stage)tableView.getScene().getWindow();
					primaryStage.setScene(scene);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				dialog.close();
			});
			
			
			//대여
			Button btnRent = (Button) parent.lookup("#btnRent");
			btnRent.setOnAction(e->{
				book.setRent(rent.getText());
				book.setContact(contact.getText());
				SimpleDateFormat dateFormat = new SimpleDateFormat ( "yyyy-MM-dd");
				Date time = new Date();
				String timeString = dateFormat.format(time);
				System.out.println(timeString);
				book.setRentDate(timeString);
				int result = 0;
				try {
					result = dao.rentBook(book);
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				//리스트 화면 새로고침
				
				list.clear();
				
				try {
					Parent root;
					root = (Parent)FXMLLoader.load(getClass().getResource("root.fxml"));
					Scene scene = new Scene(root);
					Stage primaryStage = (Stage)tableView.getScene().getWindow();
					primaryStage.setScene(scene);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				dialog.close();
			});
			
			
			
			
			Button btnFormCancel = (Button) parent.lookup("#btnFormCancel");
			btnFormCancel.setOnAction(e->dialog.close());
			
			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.setResizable(false);	
			dialog.show();	
		} catch (IOException e) {}
	}
	
	
	private void handleBtnSearchAction(ActionEvent event, String searchValue) {
		list.clear();
		ObservableList<Book> searchList = dao.bookSearch(searchValue);
		for(Book search : searchList) {
			list.add(search);
		}
	
}
		
	
	
	
	private void handlebtnHomeAction(ActionEvent event) {
			
			try {
				Parent root;
				root = (Parent)FXMLLoader.load(getClass().getResource("root.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = (Stage)tableView.getScene().getWindow();
				primaryStage.setScene(scene);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
	}
}







