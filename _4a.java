create database userDetails;
use userDetails;
create table myuser(id int, name varchar(45), age int);
insert into myuser(1, "Tushar",41);
insert into myuser values (2. "Sonali", 40);
insert into myuser values (3,"Yashashree",11);
insert into myuser values (4, "Vedshree",7);
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Pr5a extends JFrame
{
private JTable table;
private DefaultTableModel model;
public Pr5a()
{
setTitle("Database Table Display");
setSize(300, 200); 
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
model new DefaultTableModel(); table new JTable(model); 
JScrollPane scrollPane new JScrollPane(table);
add(scrollPane, BorderLayout.CENTER);
try
{
Connection connection DriverManager.getConnection 
("jdbc:mysql://localhost:3306/userDetails", "root", 
"root"); 
Statement statement connection.createStatement();
String query = "SELECT FROM myuser"; // Use your 
table name ResultSet resultSet 
statement.executeQuery(query);
int columnCount = 
resultSet.getMetaData().getColumnCount(); 
for (int i=1; i < columnCount; i++)
{
model.addColumn(resultSet.getMetaData().getC
olumnName(i));
}
while (resultSet.next())
{
Object[] row new Object[columnCount]; 
for (int i = 1; i <= columnCount; i++)
{
row[i-1] = resultSet.getObject(i);
}
model.addRow(row);
}
resultSet.close(); 
statement.close();
connection.close();
}
catch (SQLException e)
{
e.printStackTrace();
}
}
public static void main(String[] args)
{
SwingUtilities.invokeLater(()-> {
( Pr5a app new Pr5a();
app.setVisible(true);
});
}
}
