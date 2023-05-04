package LibraryManagementSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMLDocumentController {

    //The reference of inputText will be injected by the FXML loader
    //Employees Reference
    @FXML
    private TextField tfEmployeeId;
    @FXML
    private TextField tfEmployeeName;
    @FXML
    private TextField tfEmployeeAge;
    @FXML
    private TableView<Librarian> tvEmployees;
    @FXML
    private TableColumn<Librarian, Integer> colEmployeeId;
    @FXML
    private TableColumn<Librarian, String> colEmployeeName;
    @FXML
    private TableColumn<Librarian, Double> colEmployeeAge;
    @FXML
    private Button btnEmployeeInsert;
    @FXML
    private Button btnEmployeeUpdate;
    @FXML
    private Button btnEmployeeDelete;
    @FXML
    private Button btnEmployeeDisplay;

    //The reference of inputText will be injected by the FXML loader
    //Books Reference
    @FXML
    private TextField tfBookBarCode;
    @FXML
    private TextField tfBookTitle;
    @FXML
    private TextField tfBookAuthor;
    @FXML
    private TextField tfBookPrice;
    @FXML
    private TableView<Book> tvBooks;
    @FXML
    private TableColumn<Book, Integer> colBookBarCode;
    @FXML
    private TableColumn<Book, String> colBookTitle;
    @FXML
    private TableColumn<Book, String> colBookAuthor;
    @FXML
    private TableColumn<Book, Double> colBookPrice;
    @FXML
    private Button btnBookInsert;
    @FXML
    private Button btnBookUpdate;
    @FXML
    private Button btnBookDelete;
    @FXML
    private Button btnBookDisplay;

    //The reference of inputText will be injected by the FXML loader
    //Authors Reference
    @FXML
    private TextField tfAuthorID;
    @FXML
    private TextField tfAuthorName;
    @FXML
    private TextField tfAuthorAge;
    @FXML
    private TableView<Author> tvAuthor;
    @FXML
    private TableColumn<Author, String> colAuthorName;
    @FXML
    private TableColumn<Author, Integer> colAuthorID;
    @FXML
    private TableColumn<Author, Double> colAuthorAge;
    @FXML
    private Button btnAuthorInsert;
    @FXML
    private Button btnAuthorUpdate;
    @FXML
    private Button btnAuthorDelete;
    @FXML
    private Button btnAuthorDisplay;

    //The reference of inputText will be injected by the FXML loader
    //Members Reference
    @FXML
    private TableView<Member> tvMember;
    @FXML
    private TableColumn<Member, String> colMemberName;
    @FXML
    private TableColumn<Member, Integer> colMemberID;
    @FXML
    private TableColumn<Member, Double> colMemberAge;
    @FXML
    private TableColumn<Member, String> colMemberEmail;
    @FXML
    private TableColumn<Member, String> colMemberPhoneNum;
    @FXML
    private Button btnMemberDisplay;

    //The reference of inputText will be injected by the FXML loader
    //Personal Reference
    @FXML
    private TableView tvPersonal;
    @FXML
    private TableColumn<personel, String> colPersonel;
    @FXML
    private Button btnPersonalDisplay;
    @FXML
    private Label LoginStatusLabel;
    @FXML
    private TextField adminusertf;
    @FXML
    private PasswordField passwordtf;

    //Objects created 
    private Stage stage;
    private Scene scene;
    private Parent root;

//Switching scenes (switching between pages)    
//First page "Welcome page"
    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Create the Scene
        scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Display the Stage
        stage.show();
    }

//Switching scene to the "Login page"
    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Create the Scene
        scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Display the Stage
        stage.show();
    }

//Switching scene to the "Library page"    
    public void switchToScene3(ActionEvent event) throws IOException {
        String adminUser = adminusertf.getText();
        String userPassword = passwordtf.getText();

        MainConnection connectinObj = new MainConnection();
        connectinObj.Login(adminUser, userPassword);

        //check for password length
        if (userPassword.length() <= 4) {
            LoginStatusLabel.setText("Login Failed!");
        } else {
            LoginStatusLabel.setText("Login Successful");

            root = FXMLLoader.load(getClass().getResource("Library.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            // Create the Scene
            scene = new Scene(root);
            // Set the Scene to the Stage
            stage.setScene(scene);
            // Set the Title to the Stage
            stage.setTitle("Library");
            // Display the Stage
            stage.show();
        }
    }

//Switching scene to the "Employee page"
    public void switchToScene4(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Employee.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Create the Scene
        scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("Employees");
        // Display the Stage
        stage.show();
    }

//Switching scene to the "Book page"
    public void switchToScene5(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Books.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Create the Scene
        scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("Books");
        // Display the Stage
        stage.show();
    }

//Switching scene to the "Authors page"
    public void switchToScene6(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Authors.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Create the Scene
        scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("Authors");
        // Display the Stage
        stage.show();
    }

//Switching scene to the "Members page"
    public void switchToScene7(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Member.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Create the Scene
        scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("Members");
        // Display the Stage
        stage.show();
    }

//Switching scene to the "Personel page"
    public void switchToScene8(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Personel.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Create the Scene
        scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("Personel");
        // Display the Stage
        stage.show();
    }

//Going back functions    
//Going back to the previous page "Welcome Page"
    public void goBackToWelcomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("WelcomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();// Create the Scene
        scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Display the Stage
        stage.show();
    }

//Going back to the previous page "Login Page"    
    public void goBackToLoginPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Create the Scene
        scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Display the Stage
        stage.show();
    }

//Going back to the previous page "Library Page"  
    public void goBackToLibraryPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Library.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Create the Scene
        scene = new Scene(root);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("Library");
        // Display the Stage
        stage.show();
    }

//Handle Button that takes action from th button when the user click on it    
    public void handleEmployeeButtonAction(ActionEvent event) {

        if (event.getSource() == btnEmployeeInsert) {
            insertEmployeeRecord();
        } else if (event.getSource() == btnEmployeeUpdate) {
            updateEmployeeRecord();
        } else if (event.getSource() == btnEmployeeDelete) {
            deleteEmployeeButton();
        } else if (event.getSource() == btnEmployeeDisplay) {
            DisplayEmployeeRecord();
        }
    }

//Handle Button that takes action from th button when the user click on it   
    public void handleBookButtonAction(ActionEvent event) {

        if (event.getSource() == btnBookInsert) {
            insertBookRecord();
        } else if (event.getSource() == btnBookUpdate) {
            updateBookRecord();
        } else if (event.getSource() == btnBookDelete) {
            deleteBookButton();
        } else if (event.getSource() == btnBookDisplay) {
            DisplayBookRecord();
        }
    }

//Handle Button that takes action from th button when the user click on it   
    public void handleAuthorButtonAction(ActionEvent event) {

        if (event.getSource() == btnAuthorInsert) {
            insertAuthorRecord();
        } else if (event.getSource() == btnAuthorUpdate) {
            updateAuthorRecord();
        } else if (event.getSource() == btnAuthorDelete) {
            deleteAuthorButton();
        } else if (event.getSource() == btnAuthorDisplay) {
            DisplayAuthorRecord();
        }
    }

//Handle Button that takes action from th button when the user click on it   
    public void handleMemberButtonAction(ActionEvent event) {

        if (event.getSource() == btnMemberDisplay) {
            displayMemberRecord();
        }
    }

//Handle Button that takes action from th button when the user click on it   
    public void handlePersonelButtonAction(ActionEvent event) {

        if (event.getSource() == btnPersonalDisplay) {
            displayPersonalRecord();
        }
    }
//Java program is loading jdbc driver to esteblish database connection
//To connect java application with the mysql database, mysqlconnector.jar file is required to be loaded

    public Connection getConnection() {
        Connection conn;
        try {
//The forName() method of Class class is used to register the driver class
            Class.forName("com.mysql.cj.jdbc.Driver");
//Open a connection            
//The connection URL for the mysql database here library is database name, root is username and password is 123456789 
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "123456789");
            return conn;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
//Creating SQL or MySQL statements
//Executing SQL or MySQL queries in the database
//Viewing & Modifying the resulting records
//ObservableList is a list that enables listeners to track changes when they occur

    public ObservableList<Librarian> getEmployeesList() {
        ObservableList<Librarian> employeeList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "select * from library.employee";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Librarian librarian;
            //Extract data from result set
            while (rs.next()) {
                librarian = new Librarian(rs.getString("fullName"),
                        rs.getDouble("age"), rs.getInt("workID"));
                employeeList.add(librarian);
                System.out.println(rs.getInt("workID") + ", "
                        + rs.getString("fullName") + ", "
                        + rs.getDouble("age"));
            }
        } catch (SQLException ex) {
        }
        return employeeList;
    }

    public void showEmployees() {
        ObservableList<Librarian> list = getEmployeesList();
//Retrieve by column name
        colEmployeeName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colEmployeeAge.setCellValueFactory(new PropertyValueFactory<>("Age"));
        colEmployeeId.setCellValueFactory(new PropertyValueFactory<>("workID"));

        tvEmployees.setItems(list);
    }

    public void DisplayEmployeeRecord() {
        showEmployees();
    }

    public void insertEmployeeRecord() {
// Execute a query
//Requires using an object of type Statement for building and submitting 
//an SQL statement to insert records into a table
        String query = "INSERT INTO library.employee VALUES ("
                + tfEmployeeId.getText() + ",'"
                + tfEmployeeName.getText() + "',"
                + tfEmployeeAge.getText() + ")";
        executeQuery(query);
        showEmployees();
    }

    public void updateEmployeeRecord() {
        // Execute a query
        //Requires using an object of type Statement for building and submitting 
//an SQL statement to update records in a table
        String query = "UPDATE  library.employee SET fullName  = '"
                + tfEmployeeName.getText()
                + "',age = " + tfEmployeeAge.getText()
                + " WHERE workID = " + tfEmployeeId.getText();
//This Query makes use of the WHERE clause to select records with workID
        executeQuery(query);
        showEmployees();
    }

    public void deleteEmployeeButton() {
        // Execute a query
        //Requires using an object of type Statement for building and submitting 
//an SQL statement to delete records from a table
        String query = "DELETE FROM library.employee WHERE workID = "
                + tfEmployeeId.getText();
//This Query makes use of the WHERE clause to select records with workID
        executeQuery(query);
        showEmployees();
    }
//Creating SQL or MySQL statements
//Executing SQL or MySQL queries in the database
//Viewing & Modifying the resulting records
//ObservableList is a list that enables listeners to track changes when they occur

    public ObservableList<Book> getBooksList() {
        ObservableList<Book> bookList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "select * from library.books";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Book book;
            //Extract data from result set
            while (rs.next()) {
                book = new Book(rs.getString("title"), rs.getString("author"),
                        rs.getDouble("price"), rs.getInt("BarCode"));
                bookList.add(book);
                System.out.println(rs.getInt("BarCode") + ", "
                        + rs.getString("title") + ", "
                        + rs.getString("author") + ", "
                        + rs.getDouble("price"));
            }

        } catch (SQLException ex) {
        }
        return bookList;
    }

    public void showBooks() {
        ObservableList<Book> list = getBooksList();
// Retrieve by column name
        colBookBarCode.setCellValueFactory(new PropertyValueFactory<>("BarCode"));
        colBookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colBookAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colBookPrice.setCellValueFactory(new PropertyValueFactory<>("Price"));

        tvBooks.setItems(list);
    }

    public void DisplayBookRecord() {
        showBooks();
    }

    public void insertBookRecord() {
        // Execute a query
        //Requires using an object of type Statement for building and submitting 
//an SQL statement to insert records into a table
        String query = "INSERT INTO library.books VALUES ("
                + tfBookBarCode.getText() + ", '"
                + tfBookTitle.getText() + "', '"
                + tfBookAuthor.getText() + "', "
                + tfBookPrice.getText() + ")";
        executeQuery(query);
        showBooks();
    }

    public void updateBookRecord() {
        // Execute a query
        //Requires using an object of type Statement for building and submitting 
//an SQL statement to update records in a table
        String query = "UPDATE  library.books SET title  = '"
                + tfBookTitle.getText()
                + "', author = '" + tfBookAuthor.getText()
                + "', price = " + tfBookPrice.getText()
                + " WHERE BarCode = " + tfBookBarCode.getText();
//This Query makes use of the WHERE clause to select records with BarCode
        executeQuery(query);
        showBooks();
    }

    public void deleteBookButton() {
        // Execute a query
        //Requires using an object of type Statement for building and submitting 
//an SQL statement to delete records from a table
        String query = "DELETE FROM library.books WHERE BarCode = "
                + tfBookBarCode.getText();
//This Query makes use of the WHERE clause to select records with BarCode
        System.out.println(tfBookBarCode.getText());
        executeQuery(query);
        showBooks();
    }
//Creating SQL or MySQL statements
//Executing SQL or MySQL queries in the database
//Viewing & Modifying the resulting records
//ObservableList is a list that enables listeners to track changes when they occur

    public ObservableList<Author> getAuthorList() {
        ObservableList<Author> AuthorList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "select * from library.author";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Author author;
            //Extract data from result set
            while (rs.next()) {
                author = new Author(rs.getString("fullName"),
                        rs.getDouble("Age"), rs.getInt("authorID"));
                AuthorList.add(author);
                System.out.println(rs.getInt("authorID") + ", "
                        + rs.getString("fullName") + ", "
                        + rs.getDouble("Age"));
            }

        } catch (SQLException ex) {
        }
        return AuthorList;
    }

    public void showAuthor() {
        ObservableList<Author> list = getAuthorList();
// Retrieve by column name
        colAuthorID.setCellValueFactory(new PropertyValueFactory<>("authorID"));
        colAuthorName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colAuthorAge.setCellValueFactory(new PropertyValueFactory<>("Age"));

        tvAuthor.setItems(list);
    }

    public void DisplayAuthorRecord() {
        showAuthor();
    }

    public void insertAuthorRecord() {
        // Execute a query
        //Requires using an object of type Statement for building and submitting 
//an SQL statement to insert records into a table
        String query = "INSERT INTO library.author VALUES ("
                + tfAuthorID.getText() + ", '"
                + tfAuthorName.getText() + "', "
                + tfAuthorAge.getText() + ")";
        executeQuery(query);
        showAuthor();
    }

    public void updateAuthorRecord() {
// Execute a query
//Requires using an object of type Statement for building and submitting 
//an SQL statement to update records in a table
        String query = "UPDATE  library.author SET fullName  = '"
                + tfAuthorName.getText()
                + "', age = " + tfAuthorAge.getText()
                + " WHERE authorID = " + tfAuthorID.getText();
//This Query makes use of the WHERE clause to select records with authorID
        executeQuery(query);
        showAuthor();
    }

    public void deleteAuthorButton() {
// Execute a query
//Requires using an object of type Statement for building and submitting 
//an SQL statement to delete records from a table
        String query = "DELETE FROM library.author WHERE authorID = "
                + tfAuthorID.getText();
//This Query makes use of the WHERE clause to select records with authorID
        executeQuery(query);
        showAuthor();
    }
//Creating SQL or MySQL statements
//Executing SQL or MySQL queries in the database
//Viewing & Modifying the resulting records
//ObservableList is a list that enables listeners to track changes when they occur

    public ObservableList<Member> getMemberList() {
        ObservableList<Member> MemberList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "select * from library.member";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Member member;
            //Extract data from result set
            while (rs.next()) {
                member = new Member(rs.getString("fullName"),
                        rs.getDouble("Age"), rs.getString("email"),
                        rs.getString("phoneNum"), rs.getInt("memberID"));
                MemberList.add(member);
                System.out.println(rs.getInt("memberID") + ", "
                        + rs.getString("fullName") + ", "
                        + rs.getDouble("Age") + ", "
                        + rs.getString("email") + ", "
                        + rs.getString("phoneNum"));
            }

        } catch (SQLException ex) {
        }
        return MemberList;
    }

    public void showMember() {
        ObservableList<Member> list = getMemberList();
// Retrieve by column name
        colMemberID.setCellValueFactory(new PropertyValueFactory<>("memberID"));
        colMemberName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colMemberAge.setCellValueFactory(new PropertyValueFactory<>("Age"));
        colMemberEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colMemberPhoneNum.setCellValueFactory(new PropertyValueFactory<>("phoneNum"));

        tvMember.setItems(list);
    }

    public void displayMemberRecord() {
        showMember();
    }

    public void showPersonel(ObservableList<personel> personel) {
// Retrieve by column name
        colPersonel.setCellValueFactory(new PropertyValueFactory<>("fullName"));

        tvPersonal.setItems(personel);
    }

    public void displayPersonalRecord() {
// Execute a query
//Requires using an object of type Statement for building and submitting 
//an SQL statement to display all the record from a table
        String query = "SELECT library.employee.fullName FROM library.employee "
                + "UNION ALL SELECT library.author.fullname FROM library.author "
                + "UNION ALL SELECT library.member.fullname FROM library.member;";
        showPersonel(executePersonelQuery(query));
    }
//The executeQuery() method of Statement interface is used to execute queries to the database    
    public void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
//The createStatement() method of Connection interface is used to create statement           
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
        }
    }
//The executePersonelQuery() method of Statement interface is used to execute queries to the database 
//Execute Query for the personel class
//To get all the fullName records (employees, authors and members)    
    public ObservableList<personel> executePersonelQuery(String query) {
        ObservableList<personel> personel = FXCollections.observableArrayList();
        Connection conn = getConnection();
        Statement st;
        try {
//The createStatement() method of Connection interface is used to create statement           
            st = conn.createStatement();
            //return object from class ResultSet
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                personel pr = new personel();
                pr.setFullName(result.getObject("fullName").toString());
                personel.add(pr);
                System.out.println(result.getObject("fullName").toString());
            } 
        } catch (SQLException ex) {
        }
        return personel;
    }
//Created a new inner class personel
    public static class personel {

        private String fullName;

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }
    }

}
