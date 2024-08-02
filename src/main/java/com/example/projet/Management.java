package com.example.projet;

import java.sql.*;

public class Management {

    public void charger() throws SQLException {
//        DBConnection con=new DBConnection();
//        Connection connection=con.getConnection();
//        try {
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM personnes");
//            data.clear();
//            while (rs.next()) {
//                data.add(new Person(rs.getInt("id"), rs.getString("nom"), rs.getInt("age")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void inserer(String id,String nom, String type, String attributs) throws SQLException {
        DBConnection con=new DBConnection();
     Connection connection=con.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO vehicules (id,nom, type,attributs) VALUES (?,?,?,?)");
            stmt.setString(1,id);
            stmt.setString(2, nom);
            stmt.setString(3, type);
            stmt.setString(4, attributs);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void supprimer(String id) throws SQLException {
        DBConnection con=new DBConnection();
        Connection connection=con.getConnection();
        String sql = "DELETE FROM vehicules WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, id);
        int rowsAffected = preparedStatement.executeUpdate();
        connection.close();
    }

}
