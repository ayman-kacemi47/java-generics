## TP sur la Généricité en Java

Ce projet est un travail pratique sur la **généricité** en Java. Il permet de gérer une collection d'objets de type `Produit` grâce à une interface générique et à son implémentation. Le programme propose un menu interactif pour effectuer différentes opérations sur les produits.

---

## Menu
![Afficher Menu](captures/afficher-menu.png)

### 1. Ajouter un nouveau produit dans la liste
![Ajouter Produit](captures/ajouter-produit.png)

### 2. Afficher la liste des produits
![Afficher Produits](captures/afficher-produits.png)
### 3. Rechercher un produit par son id
![Afficher Produit](captures/afficher-produit.png)


### 4. Supprimer un produit par id
![Suppression Produit](captures/suppresion.png)

### 5. Quitter ce programme
![Fin Programme](captures/endpng.png)

---

## Structure du Projet

- **Produit** : La classe représentant un produit.
- **IMetier** : L'interface générique pour gérer les opérations CRUD.
- **MetierProduitImpl** : L'implémentation de l'interface `IMetier`.
- **Application** : La classe principale contenant le menu interactif.

---

## Exécution

Le programme s'exécute en affichant un menu interactif où l'utilisateur peut :
1. Voir tous les produits.
2. Rechercher un produit par son ID.
3. Ajouter un produit.
4. Supprimer un produit.
5. Quitter le programme.

---
