package store.cardService;

import store.DatabaseConnection.DbConnection;

import java.io.Closeable;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbCardService implements CardService, Closeable {
    private final DbConnection dbConnection;
    public DbCardService () {
        dbConnection = new DbConnection();
    }

    @Override
    public int getDiscountAmountByName(String name) {
        try (final PreparedStatement statement = dbConnection.getConnection().prepareStatement("select percent from discount_card where name = ?")) {
            statement.setString(1, name);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return rs.getInt("percent");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void close() throws IOException {
        dbConnection.close();
    }
}
