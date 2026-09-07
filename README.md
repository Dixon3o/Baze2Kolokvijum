Ovaj repo je moj kolokvijum iz predmeta **Baze Podataka 2**. Služi kao lična referenca za buduće projekte koji će možda uključivati rad sa **Hibernate** i izradu GUI-a.

## Tehnologije i alati
* **Java** (Eclipse JEE)
* **Eclipse WindowBuilder** (GUI ekstenzija za rad sa Swing/AWT komandama)
* **Hibernate**
* **Relaciona baza podataka**

## Model Baze Podataka i Relacije
Ovako otprilike izgledaju tabele u bazi:
* **Cgrad i Caerodrom**: N : 1 (Jedan grad može imati vise aerodroma)
* **Caerodrom i Clet**: N : 1 (Jedan aerodrom može imati više letova)

## Funkcionalnosti
* CRUD operacije nad tabelama.
* Konfigurisan `persistence.xml` za ORM mapiranje.
* GUI napravljen pomoću WindowBuilder-a.