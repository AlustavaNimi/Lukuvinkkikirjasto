package database;

import domain.Blogipostaus;
import domain.Kirja;
import domain.Lukuvinkki;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LukuvinkkiDao implements Tietokanta {

    private String tietokantaOsoite;

    public LukuvinkkiDao(String tietokantaOsoite) {
        this.tietokantaOsoite = tietokantaOsoite;
        luoTaulut();
    }

    @Override
    public ArrayList<Lukuvinkki> haeLukuvinkit() {
        ArrayList<Lukuvinkki> lukuvinkit = new ArrayList<>();
        try (Connection conn = luoTietokantaYhteys()) {
            ResultSet result = luoResultSet(conn, "SELECT * FROM Lukuvinkki");
            while (result.next()) {
                lisaaLukuvinkkiResultSetista(result,lukuvinkit);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lukuvinkit;
    }

    private Connection luoTietokantaYhteys() throws SQLException {
        return DriverManager.getConnection(tietokantaOsoite);
    }
    

    private void lisaaLukuvinkkiResultSetista(ResultSet result, ArrayList<Lukuvinkki> lukuvinkit) throws SQLException {
        String tyyppi = result.getString("tyyppi");
        if (tyyppi.equals("kirja")) {
            lisaaKirjaResultSetista(result,lukuvinkit);
        } else if (tyyppi.equals("blogi")) {
            lisaaBlogiResultSetista(result,lukuvinkit);
        }
    }

    private ResultSet luoResultSet(Connection conn, String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    private void luoTaulut() { // Tässä ratkaisussa Lukuvinkki-taulu sisältää kaikkien alaluokkien attribuutit
        //Lukuvinkki
        ArrayList<String> attribuutit = new ArrayList<>();
        attribuutit.add("kirjoittaja VARCHAR(255)");
        attribuutit.add("otsikko VARCHAR(255)");
        attribuutit.add("kurssi VARCHAR(255)");
        attribuutit.add("kuvaus VARCHAR(255)");
        attribuutit.add("julkaisuvuosi integer");
        attribuutit.add("isbn VARCHAR(255)");
        attribuutit.add("url VARCHAR(255)");
        attribuutit.add("tyyppi VARCHAR(255)");
        luoTaulu("Lukuvinkki", attribuutit);
        
        //Tagi
        attribuutit = new ArrayList<>();
        attribuutit.add("nimi VARCHAR(255)");
        luoTaulu("Tagi", attribuutit);
        
        //LukuvinkkiTagi
        attribuutit = new ArrayList<>();
        attribuutit.add("tagi_id integer");
        attribuutit.add("lukuvinkki_id integer");
        attribuutit.add("FOREIGN KEY (tagi_id) REFERENCES Tagi(id)");
        attribuutit.add("FOREIGN KEY (lukuvinkki_id) REFERENCES Lukuvinkki(id)");
        luoTaulu("Lukuvinkkitagi", attribuutit);
    }

    private void luoTaulu(String nimi, ArrayList<String> attribuutit) {
        try (Connection conn = luoTietokantaYhteys()) {
            String sql = "CREATE TABLE IF NOT EXISTS "+ nimi + " ("
                    + "id integer PRIMARY KEY, ";
            for (int i = 0; i < attribuutit.size(); i++) {
                sql += attribuutit.get(i);
                if (i < attribuutit.size()-1) sql += ", ";
            }
            sql += ");";
            //System.out.println(sql);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void lisaaKirjaResultSetista(ResultSet result, ArrayList<Lukuvinkki> lukuvinkit) throws SQLException {
        String kirjailija = result.getString("kirjoittaja");
        String otsikko = result.getString("otsikko");
        String kurssi = result.getString("kurssi");
        String kuvaus = result.getString("kuvaus");
        int julkaisuvuosi = result.getInt("julkaisuvuosi");
        String isbn = result.getString("isbn");
        Kirja kirja = new Kirja(otsikko, kirjailija, isbn, kuvaus, julkaisuvuosi, kurssi);
        lukuvinkit.add(kirja);
    }

    private void lisaaBlogiResultSetista(ResultSet result, ArrayList<Lukuvinkki> lukuvinkit) throws SQLException {
        String otsikko = result.getString("otsikko");
        String kurssi = result.getString("kurssi");
        String kuvaus = result.getString("kuvaus");
        int julkaisuvuosi = result.getInt("julkaisuvuosi");
        String url = result.getString("isbn");
        String kirjoittaja = result.getString("kirjoittaja");
        Blogipostaus blogi = new Blogipostaus(url, otsikko, kuvaus, kurssi, kirjoittaja, julkaisuvuosi);
        lukuvinkit.add(blogi);
    }
    
    @Override
    public void lisaaKirja(Lukuvinkki lukuvinkki) {
        Kirja kirja = (Kirja) lukuvinkki;
        try (Connection conn = luoTietokantaYhteys()) {
            String sql = "INSERT INTO Lukuvinkki (kirjoittaja, otsikko, kurssi,"
                    + "kuvaus, julkaisuvuosi, isbn, tyyppi) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kirja.getKirjoittaja());
            stmt.setString(2, kirja.getOtsikko());
            stmt.setString(3, kirja.getKurssi());
            stmt.setString(4, kirja.getKuvaus());
            stmt.setInt(5, kirja.getJulkaisuVuosi());
            stmt.setString(6, kirja.getISBN());
            stmt.setString(7, "kirja");
            stmt.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void lisaaBlogi(Lukuvinkki lukuvinkki) {
        Blogipostaus blogi = (Blogipostaus) lukuvinkki;
        try (Connection conn = luoTietokantaYhteys()) {
            String sql = "INSERT INTO Lukuvinkki (kirjoittaja, otsikko, kurssi,"
                    + "kuvaus, julkaisuvuosi, url, tyyppi) values (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, blogi.getKirjoittaja());
            stmt.setString(2, blogi.getOtsikko());
            stmt.setString(3, blogi.getKurssi());
            stmt.setString(4, blogi.getKuvaus());
            stmt.setInt(5, blogi.getJulkaisuVuosi());
            stmt.setString(6, blogi.getUrl());
            stmt.setString(7, "blogi");
            stmt.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}