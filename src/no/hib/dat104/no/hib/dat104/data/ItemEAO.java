package no.hib.dat104.no.hib.dat104.data;

import no.hib.dat104.Item;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class ItemEAO implements IItemEAO {
    @PersistenceContext(name="ItemPU")
    private EntityManager em;

    @Override
    public void addItem(Item item) {
        em.persist(item);
    }

    @Override
    public void removeItem(Item item) {em.remove(item);}


}
