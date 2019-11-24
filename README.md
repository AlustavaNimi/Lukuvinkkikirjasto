# Lukuvinkkikirjasto

[![CircleCI](https://circleci.com/gh/AlustavaNimi/Lukuvinkkikirjasto.svg?style=svg)](https://circleci.com/gh/AlustavaNimi/Lukuvinkkikirjasto)

[Product backlog](https://docs.google.com/spreadsheets/d/1rBtfdbz3aD68T5sgYHyLOhiQsKZAhYVsElXckrt0-YY/edit?usp=sharing)

[Sprint backlog](https://github.com/AlustavaNimi/Lukuvinkkikirjasto/projects/1) ja [Sprint burndown-kaavio](https://docs.google.com/spreadsheets/d/1UURz--MI8hLlcHOOnGXXCvV4FUqv2Zm1d9TuHlCNGqk)

## Definition of Done:
### Kaikille sprinteille:
- Product owner hyväksyy user storyt
- User storyjen ominaisuudet koodattu valmiiksi
- Koodin tarkistaa ja arvioi vähintään yksi toinen tiimiläinen (myös ylläpidettävyyden osalta, mm. nimeämiskäytäntö on yhtenäinen)
- Selkeä ja perusteltu arkkitehtuuri
- Hyväksymiskriteerit täyttyvät ts. Cucumber-testit läpäisty (alla määritelty)
- Sprintin user storyihin liittyvien testien rivikattavuus on vähintään 75%
- Yksikkötestit läpäisty
- Yhtenäinen koodityyli varmistettu Checkstylen avulla

### Sprint 1
#### User story: _As a user, I want to be able to add book suggestions to my reading list_
[Hyväksymiskriteerit](https://github.com/AlustavaNimi/Lukuvinkkikirjasto/blob/master/src/test/resources/main/new_book_suggestion.feature)
#### User story: _As a user, I want to be able to view my reading list to see what it contains_
- Tähän tulee linkki .feature-tiedostoon

## Asennus- ja käyttöohjeet
Työpöytäkoneella pitää olla Java ja Gradle asennettuna.

Kloonaa projekti työpöytäkoneelle komennolla

	git clone git@github.com:AlustavaNimi/Lukuvinkkikirjasto.git

Aja sovellus projektin juuressa, missä on build.gradle -tiedosto komennolla

	gradle run

Sovelluksessa on tekstikäyttöliittymä ja sovellukseen voi lisätä kirjavinkkejä sekä selata niitä. Sovellus ilmoittaa käytettävissä olevat komennot ajon aikana.
