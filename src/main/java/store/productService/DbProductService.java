package store.productService;

import store.DatabaseConnection.DbConnection;
import store.model.Product;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbProductService implements ProductService {
    private final DbConnection dbConnection;

    public DbProductService() {
        dbConnection = new DbConnection();
    }

    @Override
    public Product getProductById(int id) {
        try (final PreparedStatement statement = dbConnection.getConnection().prepareStatement("select * from products where id_products = ?")) {
            statement.setInt(1, id);
            final ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int idP = rs.getInt("id_products");
                String name = rs.getString("name");
                int cost = rs.getInt("cost");
                boolean isDisc = rs.getBoolean("isDiscount");
                return new Product(idP, name, cost, isDisc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() throws IOException {
        dbConnection.close();
    }
}
