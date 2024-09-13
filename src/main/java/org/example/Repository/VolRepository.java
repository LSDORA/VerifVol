package org.example.Repository;

import org.example.Model.Vol;
import org.example.Model.Billet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class VolRepository extends SearchRepository {

    private static String driver = "mysql";
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    private static String host = "localhost";
    private static String port = "3306";
    private static String database = "airfrance";
    private static String user = "root";
    private static String password = "";
    private static String serverTimezone = "Europe/Paris";

    private Map<Integer, Vol> vols;
    private Map<Integer, ArrayList<Billet>> billetsParVol;

    public VolRepository() {
        vols = new HashMap<>();
        billetsParVol = new HashMap<>();
        loadData();
    }

    @Override
    protected void loadData() {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + database + "?serverTimezone=" + serverTimezone;
        String query = "SELECT v.id_vol AS vol_id, v.numero_vol AS vol_num, b.id_billet AS billet_id, b.ref_billet AS billet_ref " +
                "FROM Vol v LEFT JOIN Billet b ON v.id_vol = b.id_vol";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int volId = resultSet.getInt("vol_id");
                String volNum = resultSet.getString("vol_num");
                int billetId = resultSet.getInt("billet_id");
                String billetRef = resultSet.getString("billet_ref");


                Vol vol = vols.get(volId);
                if (vol == null) {
                    vol = new Vol(volId, volNum);
                    vols.put(volId, vol);
                    billetsParVol.put(volId, new ArrayList<>());
                }


                if (billetId != 0 && billetRef != null) {
                    Billet billet = new Billet(billetId, billetRef, volId);
                    billetsParVol.get(volId).add(billet);
                    billet.setIdVol(volId);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Vol> getVol() {
        return new ArrayList<>(vols.values());
    }

    @Override
    public ArrayList<Billet> getBillets() {
        ArrayList<Billet> allBillets = new ArrayList<>();
        for (ArrayList<Billet> billets : billetsParVol.values()) {
            allBillets.addAll(billets);
        }
        return allBillets;
    }
}
