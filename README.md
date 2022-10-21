# Server
## Spis treści
* [Baza danych](#baza)
* [API](#api)
* [POST](#post)
* [UPDATE](#update)
* [DELETE](#delete)
* [GET](#get)
* [IN PROGRESS](#inprogress)
* [STATUS](#status)

## Baza danych
CREATE TABLE `files` (  
  `guId` int(11) NOT NULL,  
  `filename` varchar(250) NOT NULL,  
  `srcLang` varchar(50) NOT NULL,  
  `trgLang` varchar(50) NOT NULL,  
  `customer` varchar(250) DEFAULT NULL,  
  `specialisation` int(3) DEFAULT NULL,  
  `engine` varchar(150) DEFAULT NULL,  
  `project` varchar(100) DEFAULT NULL,  
  `translator` varchar(250) DEFAULT NULL,  
  `addedOn` date NOT NULL,  
  PRIMARY KEY (`guId`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `segments` (  
  `guId` int(11) NOT NULL,  
  `srcText` text NOT NULL,  
  `trgText` text NOT NULL,  
  `mtText` text,  
  `matchRate` double DEFAULT NULL,  
  `ed` double DEFAULT NULL,  
  `fileid` int(11) DEFAULT NULL,  
  PRIMARY KEY (`guId`),  
  KEY `fileId` (`fileid`),  
  CONSTRAINT `segments_ibfk_1` FOREIGN KEY (`fileid`) REFERENCES `files` (`guid`)  
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

##  API
W obecnym kształcie istnieją dwa kontrolery, jeden obsługujący segmenty i jeden obsługujący pliki. Napisałem też metodę testową, przyjmującą w zapytaniu plik wraz z listą segmentów do niego przynależnych. To jak w ostatecznym kształcie będzie wyglądał kontroler czy też kontrolery zależy od sposobu w jakim skryp będzie przesyłał dane do bazy.

###  POST
adresy do posta:
1. http://localhost:8080/files
2. http://localhost:8080/segments
Ad. 1: Żeby zapisać w bazie danych obiekt typu file, musimy wysłać przez API na adres "http://localhost:8080/files" zapytanie zawierającę odpowiednie dane  
  `guId` - liczba całkowita, nie może być puste  
  `filename` varchar(250) - Ciąg znaków, nie może być puste  
  `srcLang` varchar(50) Ciąg znaków, nie może być puste   
  `trgLang` varchar(50) Ciąg znaków, nie może być puste  
  `customer` varchar(250) Ciąg znaków, może być puste 
  `specialisation` int(3) Ciąg znaków, może być puste   
  `engine` varchar(150) Ciąg znaków, może być puste   
  `project` varchar(100) Ciąg znaków, może być puste   
  `translator` varchar(250) Ciąg znaków, może być puste  
  `addedOn` date NOT NULL Ciąg znaków, nie może być puste / format "yyyy-mm-dd"  
  
Przykład 1:  
{  
    "guId": 1,  
    "fileName": "test.xml",  
    "srcLang" : "EN",  
    "trgLang" : "PL",  
    "addedOn" : "2020-10-10",  
    "engine": "Engine",  
    "customer": "Customer",  
    "project": "Testowy project",  
    "translator": "Kowalski"  
}  

Przykład 2:  
{  
    "guId": 1,  
    "fileName": "test.xml",  
    "srcLang" : "EN",  
    "trgLang" : "PL",  
    "addedOn" : "2020-10-10",  
}  
! Jak widać w przykładzie wyżej wystarczy że zapytanie zawiera jedynie pola wymagane  

Przykład 3:  
{
    "guId": 6,  
    "fileName": "test.xml",  
    "srcLang" : "EN",  
    "trgLang" : "PL",  
    "addedOn" : "2020-10-10",  
    "translator": "Kowalski",  
    "nie_uwzgledni": "nie uwzględni"  
}  
! W przypadku gdy zapytanie zawiera błędne pole, będzie ono zignornowane, a rekord zapisze się w bazie danych jeżeli pozostałe pola przejdą walidacje  

Ad. 2: Żeby zapisać w bazie danych obiekt typu segment, musimy wysłać przez API na adres "http://localhost:8080/segments" zapytanie zawierającę odpowiednie dane  
  `guId` - liczba całkowita, nie może być puste,   
  `srcText` Ciąg znaków, nie może być puste ,  
  `trgText` Ciąg znaków, nie może być puste ,  
  `mtText` Ciąg znaków, może być puste ,  
  `matchRate` double liczba zmiennoprzecinkowa, może być puste,  
  `ed` double double liczba zmiennoprzecinkowa, może być puste,  
  `fileid` int(11)  liczba całkowita, <b>nie może być puste</b> / klucz obcy ustanawiający relacje z obiektem typu "file" do którego przynależy, musi się więc odnosić do istniejącego pliku w bazie danych o konkretnym 'guiId'.
  
  Przykład 1:  
{
    "guId": 1,  
    "srcText": "To jest source",  
    "trgText": "Zrodelko",  
    "mtText": 1.2,  
    "matchRate": 1,  
    "ed": 1.2,  
    "fileId": 1  
}  
! Zapytania analogicznie do obiektów typu "file", błędne pola będą zignorowane, a zapytanie musi zawierać tylko wymagane pola, pozostałe można pominąć.  
  
### UPDATE
Zapytanie działa dokładnie tak samo jak POST, jedyna różnica polega na tym że w przypadku wysyłania danych z "guId" znajdującym się już w bazie, dane te bedą zaktualizowane, a nie dodane ponownie w innym rekordzie.  
  
###  DELETE
Rekordy można także usuwać z bazy danych  
adresy:  
1. http://localhost:8080/files  
2. http://localhost:8080/segments  

Ad. 1: Pliki można usuwać wysyłając zapytanie metodą DELETE na adres http://localhost:8080/files  
Przykład 1:  
{  
    "guId": 2  
}  
Żeby usunąć plik wystarczy nam informacja o jego "guId". Zapytanie może zawierać więcej informacji, ale nie są one obowiązkowe. Nie może natomiast nie zawierać "guId", poniższe zapytanie nie zadziała:  

!!! Usunięcie pliku usuwa również wszyskie segmenty do niego przynależne

Przykład 2: nieprawidłowe zapytanie  
{  
    "fileName": "test.xml",  
    "srcLang": "EN",  
    "trgLang": "PL",  
    "customer": null,  
    "specialisation": null,  
    "engine": null,  
    "project": null,  
    "translator": "Kowalski",  
    "addedOn": "2020-10-10",  
}  

Ad. 2: Segmenty można usuwać wysyłając zapytanie metodą DELETE na adres http://localhost:8080/segments  

Przykład 1:  
{  
    "guId": 4  
}  
Żeby usunąć segment wystarczy nam informacja o jego "guId". Zapytanie może zawierać więcej informacji, ale nie są one obowiązkowe. Nie może natomiast nie zawierać "guId", poniższe zapytanie nie zadziała:  

Przykład 2 (nieprawidłowe zapytanie):  
{  
    "srcText": "To jest source",  
    "trgText": "Zrodelko",  
    "mtText": 1.2,  
    "matchRate": 1,  
    "ed": 1.2,  
    "fileId": 1  
}

### GET
Służy do pobrania wyników z bazy danych. Adresy  
1. http://localhost:8080/files  
2. http://localhost:8080/segments  

Ad. 1: Zapytanie wyświetli wszystkie obiekty typu "file" wraz z przynależnymi do niego segmentami.  
Ad. 2: Zapytanie wyświetli wszystkie obiekty typu "segment".  

### In progress
Testowo pod adresem http://localhost:8080/segments2 umożliwione jest wysyłanie wielu segmentów, w liście. Przyjąłem założenie że każdy segment wysyłany w liście należy do tego samego pliku, można to wyodrębnić ale dośc istotnie wpłynie to na wydajność.  
Przykład 1:  
[  
    {  
    "guId": 1,  
    "srcText": "To jest source",  
    "trgText": "Zrodelko",  
    "mtText": 1.2,  
    "matchRate": 1,  
    "ed": 1.2,  
    "fileId": 1  
    },  
    {  
    "guId": 2,  
    "srcText": "Source",  
    "trgText": "Target",  
    "mtText": 1.2,  
    "matchRate": 1,  
    "ed": 1.2,  
    "fileId": 1  
    },  
    {  
    "guId": 3,  
    "srcText": "Source2",  
    "trgText": "Target2",  
    "mtText": 1.2,  
    "matchRate": 1,  
    "ed": 1.2,  
    "fileId": 1  
    }  
]


### Status (co dalej)
1. W planach przygotowanie metody która tworzy zarówno pliki jak i segmenty w jednym zapytaniu.  
2. Automatyzacja zapytań z parametrami, ich tworzenie jest obecnie bardzo proste, ale doprowadzi do mnożenie się metod (w zależności od konfiguracji), mam jakiś pomysł jak to zrobić wydajniej, zobaczymy jak wyjdzie.
https://localhost.run/

