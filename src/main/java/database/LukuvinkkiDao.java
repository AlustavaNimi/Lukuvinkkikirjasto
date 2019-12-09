package database;

import domain.Blogipostaus;
import domain.Kirja;
import domain.Lukuvinkki;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LukuvinkkiDao implements Tietokanta {

    private String tietokantaOsoite;
    private boolean tiedostoOnJoOlemassa; // Tieto kovakoodatun datan lisäämiseen

    public LukuvinkkiDao(String tietokantaOsoite) {
        this.tietokantaOsoite = tietokantaOsoite;
        tiedostoOnJoOlemassa = onOlemassaTiedosto("db.db");
        luoTaulut();
        
        if (!tiedostoOnJoOlemassa) {
            KovakoodattuData data = new KovakoodattuData();
            data.lisaaKovakoodattuData(this);
        }
    }

    @Override
    public ArrayList<Lukuvinkki> haeLukuvinkit() {
        ArrayList<Lukuvinkki> lukuvinkit = new ArrayList<>();
        try (Connection conn = luoTietokantaYhteys()) {
            ResultSet result = luoResultSet(conn, "SELECT * FROM Lukuvinkki");
            while (result.next()) {
                lisaaLukuvinkkiResultSetista(result, lukuvinkit);
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
            lisaaKirjaResultSetista(result, lukuvinkit);
        } else if (tyyppi.equals("blogipostaus")) {
            lisaaBlogiResultSetista(result, lukuvinkit);
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
            String sql = "CREATE TABLE IF NOT EXISTS " + nimi + " ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT, ";
            for (int i = 0; i < attribuutit.size(); i++) {
                sql += attribuutit.get(i);
                if (i < attribuutit.size() - 1) {
                    sql += ", ";
                }
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
        int id = result.getInt("id");
        String kirjailija = result.getString("kirjoittaja");
        String otsikko = result.getString("otsikko");
        String kurssi = result.getString("kurssi");
        String kuvaus = result.getString("kuvaus");
        int julkaisuvuosi = result.getInt("julkaisuvuosi");
        String isbn = result.getString("isbn");
        Kirja kirja = new Kirja(id, otsikko, kirjailija, isbn, kuvaus, julkaisuvuosi, kurssi);
        lukuvinkit.add(kirja);
    }

    private void lisaaBlogiResultSetista(ResultSet result, ArrayList<Lukuvinkki> lukuvinkit) throws SQLException {
        int id = result.getInt("id");
        String otsikko = result.getString("otsikko");
        String kurssi = result.getString("kurssi");
        String kuvaus = result.getString("kuvaus");
        int julkaisuvuosi = result.getInt("julkaisuvuosi");
        String url = result.getString("url");
        String kirjoittaja = result.getString("kirjoittaja");
        Blogipostaus blogi = new Blogipostaus(id, url, otsikko, kuvaus, kurssi, kirjoittaja, julkaisuvuosi);
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
            conn.close();
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
            stmt.setString(7, "blogipostaus");
            stmt.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void muokkaaLukuvinkkia(Lukuvinkki vinkki) {
        try (Connection conn = luoTietokantaYhteys()) {
            String sql = "UPDATE Lukuvinkki SET "
                    + "kirjoittaja = ?, "
                    + "otsikko = ?, "
                    + "kurssi = ?, "
                    + "kuvaus = ?, "
                    + "julkaisuvuosi = ?, "
                    + "isbn = ?, "
                    + "url = ? "
                    + "WHERE id = ? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, vinkki.getKirjoittaja());
            stmt.setString(2, vinkki.getOtsikko());
            stmt.setString(3, vinkki.getKurssi());
            stmt.setString(4, vinkki.getKuvaus());
            stmt.setInt(5, vinkki.getJulkaisuVuosi());
            stmt.setString(6,"");
            stmt.setString(7,"");
            stmt.setInt(8, vinkki.getId());
            if (vinkki.getTyyppi().equals("kirja")) {
                Kirja k = (Kirja) vinkki;
                stmt.setString(6, k.getISBN());
            } else if (vinkki.getTyyppi().equals("blogi")) {
                Blogipostaus b = (Blogipostaus) vinkki;
                stmt.setString(7,b.getUrl());
            }
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    @Override
    public void poistaLukuvinkki(Lukuvinkki lukuvinkki) {
        try (Connection conn = luoTietokantaYhteys()) {
            String sql = "DELETE FROM Lukuvinkki WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, lukuvinkki.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Lukuvinkki haeLukuvinkki(int id) {
        ArrayList<Lukuvinkki> lista = new ArrayList<>();
        try (Connection conn = luoTietokantaYhteys()) {
            ResultSet result = luoResultSet(conn, "SELECT * FROM Lukuvinkki WHERE id = " + id);
            result.next();
            this.lisaaLukuvinkkiResultSetista(result, lista);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lista.get(0);
    }
    
    @Override
    public ArrayList<Lukuvinkki> haeLukuvinkitHakusananPerusteella(String hakusana, ArrayList<String> tyypit){
        hakusana = hakusana.toLowerCase();
        ArrayList<Lukuvinkki> lukuvinkit = new ArrayList<>();
//        tyypit = new ArrayList<>();
//        tyypit.add("kirja");
        try (Connection conn = luoTietokantaYhteys()) {
            String query = "SELECT * FROM Lukuvinkki WHERE "
                    + "(LOWER(kirjoittaja) LIKE '%" + hakusana + "%' OR LOWER(otsikko) LIKE '%" + hakusana + "%' "
                    + "OR LOWER(kurssi) LIKE '%" + hakusana + "%' OR LOWER(kuvaus) LIKE '%" + hakusana + "%' "
                    + "OR LOWER(url) LIKE '%" + hakusana + "%') AND (";
            for (String tyyppi : tyypit) {
                query += "tyyppi = '" + tyyppi + "' OR ";
            }
            query += " 1 = 2 );";
            //System.out.println(query);
            ResultSet result = luoResultSet(conn, query);
            while (result.next()) {
                lisaaLukuvinkkiResultSetista(result, lukuvinkit);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lukuvinkit;
    }

    private boolean onOlemassaTiedosto(String tiedostonimi) {
        File tiedosto = new File(tiedostonimi);
        return tiedosto.exists();
    }
   
}
