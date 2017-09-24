package no.hib.dat104.no.hib.dat104.data;

import no.hib.dat104.Cart;

import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class CartEAO implements ICartEAO {
    @PersistenceContext(name="CartPU")
    private EntityManager em;

    @Override
    public void addCart(Cart cart) {
        em.persist(cart);
    }

    @Override
    public void removeCart(Cart cart) {em.remove(cart);}


}
