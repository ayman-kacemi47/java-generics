package ma.en7.serviceImplementation;

import ma.en7.model.Produit;
import ma.en7.service.IMetier;

import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements IMetier<Produit> {
    List<Produit> produits;


    public MetierProduitImpl() {
        this.produits = new ArrayList<Produit>();
    }

    @Override
    public void add(Produit produit) {
        produits.add(produit);
    }

    @Override
    public List<Produit> getAll() {

        return produits;
    }

    @Override
    public Produit findById(int id) {

        if(produits!= null){

        for (Produit produit : produits) {
            if (produit.getId() == id) {
                return produit;
            }
        }
        }
        return null;
    }

    @Override
    public void delete(long id) {
        produits.removeIf(produit -> produit.getId() == id);
    }
}
