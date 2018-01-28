import java.sql.*;

public class SQLMain {
    private static final String DBURL="sprzedaz.db";
    public static void main(String[] args){
        System.out.println("Lącze z bazą: "+DBURL+"...");
        try(Connection con= DriverManager.getConnection("jdbc:sqlite:" + DBURL)){
            System.out.println("ok");
            System.out.println("---------------------------------");


            Statement st= con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM wojewodztwa");

            printResultSetColumn(rs,"nazwa");
            System.out.println("---------------------------------");

            rs=st.executeQuery("SELECT * FROM klienci");
            printResultSetColumn(rs,"nazwa");
            System.out.println("---------------------------------");

           // DodajDolnoslaskie(st);
            rs=st.executeQuery("SELECT * FROM wojewodztwa");
            printResultSetColumn(rs,"nazwa");
            System.out.println("---------------------------------");


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private static void printResultSetColumn(ResultSet rs , String ColName) throws SQLException {
        while (rs.next())
            System.out.println(rs.getString(ColName));

    }

    private static void DodajDolnoslaskie(Statement st) throws SQLException {
        String insertSQL="insert into wojewodztwa (nazwa) values ('dolnośląskie')";
        int rowCount =st.executeUpdate(insertSQL);
        System.out.println("Dodano : " + rowCount + " rekordow");
    }


}
