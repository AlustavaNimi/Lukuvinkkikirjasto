# Lukuvinkkikirjasto

[![codecov](https://codecov.io/gh/AlustavaNimi/Lukuvinkkikirjasto/branch/master/graph/badge.svg)](https://codecov.io/gh/AlustavaNimi/Lukuvinkkikirjasto)

[![CircleCI](https://circleci.com/gh/AlustavaNimi/Lukuvinkkikirjasto.svg?style=svg)](https://circleci.com/gh/AlustavaNimi/Lukuvinkkikirjasto)

[Product backlog](https://docs.google.com/spreadsheets/d/1rBtfdbz3aD68T5sgYHyLOhiQsKZAhYVsElXckrt0-YY/edit?usp=sharing)

[Sprint backlog](https://github.com/AlustavaNimi/Lukuvinkkikirjasto/projects/1) ja [Sprint burndown-kaavio](https://docs.google.com/spreadsheets/d/1UURz--MI8hLlcHOOnGXXCvV4FUqv2Zm1d9TuHlCNGqk)

## Definition of Done:

### Kaikille sprinteille:
- Product owner hyväksyy user storyt
- User storyjen ominaisuudet koodattu valmiiksi
- Koodin tarkistaa ja arvioi vähintään yksi toinen tiimiläinen (myös ylläpidettävyyden osalta, mm. nimeämiskäytäntö on yhtenäinen)
- Selkeä ja perusteltu arkkitehtuuri
- Toteutetun koodin testikattavuuden tulee olla kohtuullinen (50% rivikattavuus muiden paitsi triviaalin koodin, kuten gettereiden/settereiden osalta)
- Hyväksymiskriteerit täyttyvät ts. Cucumber-testit läpäisty (alla määritelty user storyjen yhteydessä)
- Yksikkötestit läpäisty
- Yhtenäinen koodityyli varmistettu Checkstylen avulla

### Sprint 1

#### User story 1.1:
_As a user, I want to be able to add book suggestions to my reading list_

[Hyväksymiskriteerit](https://github.com/AlustavaNimi/Lukuvinkkikirjasto/blob/master/src/test/resources/main/new_book_suggestion.feature)

#### User story 1.2:
_As a user, I want to be able to view a list of my book suggestions to browse through it_
- Tähän tulee linkki .feature-tiedostoon

### Sprint 2

#### User story 1.1 and 1.2:
Same acceptance criteria as in Sprint 1

#### User story 2.1:
_As a user, I want to be able select a reading suggestion (lukuvinkki) from my reading list to view more details of this reading suggestion_
- Tähän tulee linkki .feature-tiedostoon

#### User story 2.2:
_As a user, I want to be able to edit/remove my reading suggestions_
- Tähän tulee linkki .feature-tiedostoon

#### User story 2.3:
_As a user, I want to be able to filter my reading suggestions by various categories/keywords in order to view a list of suggestions that are relevant to my filter criteria_
- Tähän tulee linkki .feature-tiedostoon

#### User story 2.4:
_As a user, I want to be able to add blogpost-type of entries to my reading suggestion library_
- Tähän tulee linkki .feature-tiedostoon


## Asennus- ja käyttöohjeet
Työpöytäkoneella pitää olla Java ja Gradle asennettuna.

Kloonaa projekti työpöytäkoneelle komennolla

	git clone git@github.com:AlustavaNimi/Lukuvinkkikirjasto.git

Aja sovellus projektin juuressa, missä on build.gradle -tiedosto komennolla

	gradle run

tai komennolla

	./gradlew run

Sovelluksessa on tekstikäyttöliittymä ja sovellukseen voi lisätä kirjavinkkejä sekä selata niitä. Sovellus ilmoittaa käytettävissä olevat komennot ajon aikana.
