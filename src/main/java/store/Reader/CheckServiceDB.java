package store.Reader;

import store.DatabaseConnection.DbConnection;
import store.model.Paycheck;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckServiceDB extends DecoratorCheckService{
    public CheckServiceDB(CheckService checkReader) {
        super(checkReader);
    }

    @Override
    public Paycheck readArgs(String[] args) {
        try (DbConnection dbConnection = new DbConnection()){
            String s = readLineFromDb(dbConnection.getConnection());
            String[] s1 = s.trim().split(" ");
            return super.readArgs(s1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readLineFromDb(Connection connection) {
        try (final PreparedStatement statement = connection.prepareStatement("select * from checks")) {
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String name = rs.getString("params");
                String card = rs.getString("card");
                if (card == null) {
                    return name;
                }
                return name + " " + "card-" + card;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public void writeCheckToFile(Paycheck paycheck) throws IOException {
        super.writeCheckToFile(paycheck);
    }
}
