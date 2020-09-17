package ru.geekbrains.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.stereotype.Service;
import ru.geekbrains.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class UserRoleMapper {

    private Connection connection;

    public UserRoleMapper(@Autowired DataSource dataSource) {
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException ex) {
            ex.getStackTrace();
        }
    }

    public User findById(Long id) throws SQLException, NotFoundException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT user_id, role_id FROM users_roles WHERE id = ?");
        statement.setLong(1, id);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                return user;
            }
        }
        throw new NotFoundException("User is not found");
    }
}
