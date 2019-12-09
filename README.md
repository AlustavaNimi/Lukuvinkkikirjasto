# Lukuvinkkikirjasto

[![codecov](https://codecov.io/gh/AlustavaNimi/Lukuvinkkikirjasto/branch/master/graph/badge.svg)](https://codecov.io/gh/AlustavaNimi/Lukuvinkkikirjasto)

[![CircleCI](https://circleci.com/gh/AlustavaNimi/Lukuvinkkikirjasto.svg?style=svg)](https://circleci.com/gh/AlustavaNimi/Lukuvinkkikirjasto)

[Product backlog](https://docs.google.com/spreadsheets/d/1rBtfdbz3aD68T5sgYHyLOhiQsKZAhYVsElXckrt0-YY/edit?usp=sharing)

Sprint backlogit sprinteille 1 ja 2 ovat [täällä](https://github.com/AlustavaNimi/Lukuvinkkikirjasto/projects/1).

[Sprint 3 backlog ja sprint burndown-kaaviot](https://docs.google.com/spreadsheets/d/1UURz--MI8hLlcHOOnGXXCvV4FUqv2Zm1d9TuHlCNGqk)


## Definition of Done:

### Kaikille sprinteille:
- Product owner hyväksyy user storyt
- User storyjen ominaisuudet koodattu valmiiksi
- Koodin tarkistaa ja arvioi vähintään yksi toinen tiimiläinen (myös ylläpidettävyyden osalta, mm. nimeämiskäytäntö on yhtenäinen)
- Selkeä ja perusteltu arkkitehtuuri
- Toteutetun koodin testikattavuuden tulee olla kohtuullinen ( > 50% rivikattavuus muiden paitsi triviaalin koodin, kuten gettereiden/settereiden osalta)
- Hyväksymiskriteerit (Gherkin-formaatissa) täyttyvät ts. Cucumber-testit läpäisty (alla määritelty user storyjen yhteydessä)
- Yksikkötestit läpäisty

### Sprint 1

#### User story 1.1:
_As a user, I want to be able to add book suggestions to my reading list_

[Hyväksymiskriteerit](https://github.com/AlustavaNimi/Lukuvinkkikirjasto/blob/master/src/test/resources/main/new_book_suggestion.feature)

#### User story 1.2:
_As a user, I want to be able to view a list of my book suggestions to browse through it_

[Hyväksymiskriteerit](https://github.com/AlustavaNimi/Lukuvinkkikirjasto/blob/master/src/test/resources/main/browse_reading_suggestions.feature)

### Sprint 2

#### User story 1.1 and 1.2:
Same acceptance criteria as in Sprint 1

#### User story 2.1:
_As a user, I want to be able select a reading suggestion (lukuvinkki) from my reading list to view more details of this reading suggestion_

Tähän tulee linkki .feature-tiedostoon

#### User story 2.2:
_As a user, I want to be able to remove my reading suggestions_

[Hyväksymiskriteerit](https://github.com/AlustavaNimi/Lukuvinkkikirjasto/blob/master/src/test/resources/main/delete_reading_suggestions.feature)

#### User story 2.3:
_As a user, I want to be able to edit my reading suggestions_

[Hyväksymiskriteerit](https://github.com/AlustavaNimi/Lukuvinkkikirjasto/blob/master/src/test/resources/main/edit_reading_suggestions.feature)

#### User story 2.4:
_As a user, I want to be able to filter my reading suggestions by various categories/keywords in order to view a list of suggestions that are relevant to my filter criteria_

__Päivitys:__ Jaettu user storyihin 3.1 ja 3.4.

#### User story 2.5:
_As a user, I want to be able to add blogpost-type of entries to my reading suggestion library_

Tähän tulee linkki .feature-tiedostoon

### Sprint 3

#### User story 1.1, 2.1, 2.2, 2.3, 2.5:

Same acceptance criteria as before.

#### User story 3.1:
_As a user, I want to be able to able to filter reading suggestions by entering search terms (hakusanoja)_

Tähän tulee linkki .feature-tiedostoon

#### User story 3.2:
_As a user, I want to be able to open a blogpost URL from within the app_

Tähän tulee linkki .feature-tiedostoon

#### User story 3.3:
_As a user, I want to see a list of reading suggestions on the home menu (aloitusnäkymä)_

Tähän tulee linkki .feature-tiedostoon

#### User story 3.4:
_As a user, I want an option to view only books or only blogposts_

Tähän tulee linkki .feature-tiedostoon

#### User story 3.5:
_As a user, I want to be able to mark reading suggestions that have been read already_

Tähän tulee linkki .feature-tiedostoon

## Asennus- ja käyttöohjeet
Työpöytäkoneella pitää olla Java ja Gradle asennettuna.

Kloonaa projekti työpöytäkoneelle komennolla

    git clone git@github.com:AlustavaNimi/Lukuvinkkikirjasto.git

Suorita sovellus projektin juuressa, missä on build.gradle -tiedosto komennolla `gradle run` tai komennolla `./gradlew run`.

Vaihtoehtoisesti voi suorittaa [releasen](https://github.com/AlustavaNimi/Lukuvinkkikirjasto/releases) jar-tiedoston komennolla `java -jar Lukuvinkkikirjasto.jar`.

Sovelluksessa on itsensä selittävä graafinen käyttöliittymä ja sovelluksessa voi lisätä, muokata, selata sekä poistaa kirjavinkkejä ja blogipostausvinkkejä.
