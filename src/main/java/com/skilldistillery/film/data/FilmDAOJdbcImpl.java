package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Film;

@Component
public class FilmDAOJdbcImpl implements FilmDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static final String user = "student";
	private static final String pass = "student";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver");
			throw new RuntimeException("Unable to load MySQL Driver class");
		}
	}

	@Override
	public Film getFilmById(int filmId){
		Film film = null;
		Connection conn;
		String sql = "SELECT * FROM film WHERE id = ?";
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();
			if (filmResult.next()) {
				film = new Film(filmResult.getInt("id"), filmResult.getString("title"), filmResult.getString("description"),
						filmResult.getInt("release_year"), determineLanguage(filmResult.getInt("language_id")),
						filmResult.getInt("rental_duration"), filmResult.getDouble("rental_rate"),
						filmResult.getInt("length"), filmResult.getDouble("replacement_cost"),
						filmResult.getString("rating"), filmResult.getString("special_features"),
						determineCategory(filmResult.getInt("id")));
//			film.setActors(findActorsByFilmId(filmResult.getInt("id")));
			}
			filmResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}
	
	private String determineLanguage(int langId) throws SQLException {
		String language = "";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		String sql = "SELECT name FROM language WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, langId);
		ResultSet langResult = stmt.executeQuery();
		if (langResult.next()) {
			language = langResult.getString("name");
		}
		langResult.close();
		stmt.close();
		conn.close();
		return language;
	}
	
	private int determineLanguageId(String language) throws SQLException {
		int languageId = 0;
		Connection conn = DriverManager.getConnection(URL, user, pass);
		String sql = "SELECT id FROM language WHERE name = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, language);
		ResultSet langResult = stmt.executeQuery();
		if (langResult.next()) {
			languageId = langResult.getInt("id");
		}
		langResult.close();
		stmt.close();
		conn.close();
		return languageId;
	}

	private String determineCategory(int filmId) throws SQLException {
		String category = "";
		Connection conn = DriverManager.getConnection(URL, user, pass);
		String sql = "SELECT category.name FROM category JOIN film_category ON category.id = film_category.category_id WHERE film_category.film_id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet catResult = stmt.executeQuery();
		if (catResult.next()) {
			category = catResult.getString("name");
		}
		catResult.close();
		stmt.close();
		conn.close();
		return category;
	}
	
	// We'll need a determineActors() method that populates an an Actor list
	// within the FindFilm methods we plan on implementing in order to call 
	// up a list of actors.
	
}
