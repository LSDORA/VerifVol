package org.example.Repository;

import org.example.Model.Vol;
import org.example.Model.Billet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VolRepository extends SearchRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/airfrance?serverTimezone=Europe/Paris";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    @Override
    protected void loadData() {
        String query = "SELECT v.id_vol AS vol_id, v.numero_vol AS vol_num, b.id_billet AS billet_id, b.ref_billet AS billet_ref " +
                "FROM Vol v LEFT JOIN Billet b ON v.id_vol = b.id_vol";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int volId = resultSet.getInt("vol_id");
                String volNum = resultSet.getString("vol_num");
                int billetId = resultSet.getInt("billet_id");
                String billetRef = resultSet.getString("billet_ref");


                Vol vol = getVolById(volId);
                if (vol == null) {
                    vol = new Vol(volId, volNum);
                    vols.put(volId, vol);
                    billetsParVol.put(volId, new ArrayList<>());
                }

                if (billetId != 0 && billetRef != null) {
                    Billet billet = new Billet(billetId, billetRef, volId);
                    billetsParVol.get(volId).add(billet);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
