package qldt.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import qldt.Utils.persistenceUtils;

public class test {
	public static void main(String[] args) {
		persistenceUtils pu = new persistenceUtils();
		EntityManager em = pu.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
			pu.close();
		}
	}
}
