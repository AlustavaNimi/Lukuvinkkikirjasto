package database;

import domain.Kirja;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KirjaDao implements Tietokanta {
    private String tietokantaOsoite;

    public KirjaDao(String tietokantaOsoite) {
        this.tietokantaOsoite = tietokantaOsoite;
        luoTaulu();
    }
    
    private void luoTaulu() {
        try {
            String sql = "CREATE TABLE IF NOT EXISTS kirja (" +
                         "id integer PRIMARY KEY, " +
                         "kirjoittaja VARCHAR(255), " +
                         "otsikko VARCHAR(255), " +
                         "kurssi VARCHAR(255), " +
                         "kuvaus VARCHAR(255), " +
                         "julkaisuvuosi integer, " +
                         "isbn VARCHAR(255));";
            Connection conn = DriverManager.getConnection(tietokantaOsoite);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void lisaa(Kirja kirja) {
        try {
            String sql = "INSERT INTO kirja (kirjoittaja, otsikko, kurssi," +
                         "kuvaus, julkaisuvuosi, isbn) values (?, ?, ?, ?, ?, ?)";
            Connection conn = DriverManager.getConnection(tietokantaOsoite);
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kirja.getKirjailija());
            stmt.setString(2, kirja.getOtsikko());
            stmt.setString(3, kirja.getKurssi());
            stmt.setString(4, kirja.getKuvaus());
            stmt.setInt(5, kirja.getJulkaisuVuosi());
            stmt.setString(6, kirja.getISBN());
            stmt.execute();
            conn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Kirja> haeLukuvinkit() {
        try {
            Connection conn = DriverManager.getConnection(tietokantaOsoite);
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM kirja");
            ArrayList<Kirja> kirjat = new ArrayList<>();
            while (result.next()) {
                String kirjailija = result.getString("kirjoittaja");
                String otsikko = result.getString("otsikko");
                String kurssi = result.getString("kurssi");
                String kuvaus = result.getString("kuvaus");
                int julkaisuvuosi = result.getInt("julkaisuvuosi");
                String isbn = result.getString("isbn");
                Kirja kirja = new Kirja(otsikko, kirjailija, isbn, kuvaus, julkaisuvuosi, kurssi);
                kirjat.add(kirja);
            }
            conn.close();
            return kirjat;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }
}
