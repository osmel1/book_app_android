
# Application Android consommant l'API Google Books

Au cours de ce TP, j'ai créé une application mobile Android en utilisant Android Studio et Java. Cette application consomme l'API de Google Books.
## Supervisé par :
* **Pr Abdelmajid Bousselham**
## Réalise Par : 
* **Oussama ElHachimi** - [osmel1](https://github.com/osmel1)

## 1. Ajout des dépendances nécessaires 


- **Retrofit** pour les appels réseau 
- **Gson** pour la conversion JSON 
- **Picasso** pour le chargement des images

## 2. Ajout des permissions internet dans le fichier AndroidManifest.xml
![image](https://github.com/osmel1/book_app_android/assets/110778429/2fa83fd5-5440-4a3d-9f87-928096180ad4)

## 3. L'interface utilisateur (UI) 
- Le layout principal de l'application est défini dans un fichier XML nommé ```activity_main.xml```. Ce fichier décrit la structure de l'interface utilisateur en utilisant des balises XML pour chaque élément de l'UI.Dans cette Activity vous trouvez une liste des livres .
- La deuxieme Activity est pour  chaque Livre lorsque vous cliquez sur le livre dans l'activty principal , pour afficher plus detailles sur livre 


## 4. Utilisation d'application

- Naviguez dans les livres (titre , image , description)
- Partagez Le livre via les autres application (exemple : Whatsapp)

## 5. Les Modèles de Données
- Modèle représentant un livre dans la réponse de l'API Google Books. `Book`
- Modèle représentant la réponse de l'API Google Books. `GoogleBooksResponse`
- Informations détaillées sur le volume du livre.`VolumeInfo`
- Modèle représentant les liens vers les images de couverture du livre.`ImageLinks`

## 6. Interface pour effectuer des appels API vers Google Books.
Une interface contenant une méthode pour rechercher des livres en fonction d'une requête, qui sera utilisée ultérieurement dans l'application principale.`GoogleBooksService`

## 7. Adapteur BookAdapter 
Adaptateur pour afficher les livres dans une Reactive list view .
## 8. Demonstration de l'application :
![image](https://github.com/osmel1/book_app_android/assets/110778429/992bf4b6-bc81-40ce-8673-f90a9b251641)
![image](https://github.com/osmel1/book_app_android/assets/110778429/8d30f9f1-8c42-4f1c-8117-5789f7ae60a9)


