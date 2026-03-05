# Tier List Backend

Ez a projekt a Tier List alkalmazás backend része, amely Spring Boot alapokon készült REST API.

## A backend feladata:

- Karakterek kezelése
- Rangok kezelése
- Szűrési feltételek feldolgozása
- Adatbázis-kezelés
- REST API biztosítása a frontend számára
A rendszer Angular frontenddel kommunikál HTTP kéréseken keresztül.

## Használt technológiák

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- REST API
- Maven
- MySQL
- MySQL Workbench

## Fő funkciók
### Karakter kezelés

- Összes karakter lekérdezése
- Karakterek szűrése különböző enum típusok alapján
- Karakterhez tartozó rang adatok kezelése

### Szűrési rendszer

A karakterek az alábbi tulajdonságok alapján szűrhetők:
- RarityType
- ElementType
- RifleType
- AttackType
- BurstType
- ManufacturerType

## Futatás
### Projekt buildelése
*mvn clean install*
### Alkalmazás indítása
*mvn spring-boot:run*

vagy IDE-ből a main osztály futtatásával.

## Alapértelmezett elérési cím
*http://localhost:8080*

## Adatbázis beállítása (MySQL)

A backend működéséhez MySQL adatbázis szükséges.

Az adatbázis inicializálásához a projektben található: **database-backup** mappában lévő SQL fájl használható.

## Projekt célja

A projekt célja egy teljes stack alkalmazás megvalósítása Angular frontend és Spring Boot backend integrációval, REST alapú kommunikációval és enum-alapú szűrési rendszerrel.

