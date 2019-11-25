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
        try (Connection conn = luoTietokantaYhteys()) {
            String sql = "CREATE TABLE IF NOT EXISTS kirja ("
                    + "id integer PRIMARY KEY, "
                    + "kirjoittaja VARCHAR(255), "
                    + "otsikko VARCHAR(255), "
                    + "kurssi VARCHAR(255), "
                    + "kuvaus VARCHAR(255), "
                    + "julkaisuvuosi integer, "
                    + "isbn VARCHAR(255));";
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void lisaa(Kirja kirja) {
        try (Connection conn = luoTietokantaYhteys()) {
            String sql = "INSERT INTO kirja (kirjoittaja, otsikko, kurssi,"
                    + "kuvaus, julkaisuvuosi, isbn) values (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, kirja.getKirjailija());
            stmt.setString(2, kirja.getOtsikko());
            stmt.setString(3, kirja.getKurssi());
            stmt.setString(4, kirja.getKuvaus());
            stmt.setInt(5, kirja.getJulkaisuVuosi());
            stmt.setString(6, kirja.getISBN());
            stmt.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Kirja> haeLukuvinkit() {
        ArrayList<Kirja> kirjat = new ArrayList<>();
        try (Connection conn = luoTietokantaYhteys()) {
            ResultSet result = luoResultSet(conn, "SELECT * FROM kirja");
            while (result.next()) {
                lisaaLukuvinkkiResultSetista(result,kirjat);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return kirjat;
    }

    private Connection luoTietokantaYhteys() throws SQLException {
        return DriverManager.getConnection(tietokantaOsoite);
    }
    

    private void lisaaLukuvinkkiResultSetista(ResultSet result, ArrayList<Kirja> kirjat) throws SQLException {
        String kirjailija = result.getString("kirjoittaja");
        String otsikko = result.getString("otsikko");
        String kurssi = result.getString("kurssi");
        String kuvaus = result.getString("kuvaus");
        int julkaisuvuosi = result.getInt("julkaisuvuosi");
        String isbn = result.getString("isbn");
        Kirja kirja = new Kirja(otsikko, kirjailija, isbn, kuvaus, julkaisuvuosi, kurssi);
        kirjat.add(kirja);
    }

    private ResultSet luoResultSet(Connection conn, String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }
}
