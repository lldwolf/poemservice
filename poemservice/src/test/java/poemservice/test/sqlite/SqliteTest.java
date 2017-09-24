package poemservice.test.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class SqliteTest {

    @Test
    public void testSelect() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        Class.forName("org.sqlite.JDBC").newInstance();
        Connection con = DriverManager.getConnection("jdbc:sqlite:D:/workspace/poemservice/poemservice/target/classes/poem.db");
        Statement st = con.createStatement();
        String sql = "select * from poem limit 10";
        ResultSet rs = st.executeQuery(sql);
        ResultSetMetaData meta_data = rs.getMetaData();
        
        for(int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++)
        {
            System.out.print(meta_data.getColumnLabel(i_col) + "\t\t");
        }
        System.out.println();
        
        while(rs.next())
        {
            for(int i_col = 1; i_col <= meta_data.getColumnCount(); i_col++)
            {
                System.out.print(rs.getString(i_col) + "\t\t");
            }
            System.out.println();
        }
        rs.close();
        st.close();
    }
}
