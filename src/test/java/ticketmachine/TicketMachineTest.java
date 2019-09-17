package ticketmachine;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@Before
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de l'initialisation
	// S1 : le prix affiché correspond à l’initialisation
	public void priceIsCorrectlyInitialized() {
		// Paramètres : message si erreur, valeur attendue, valeur réelle
		assertEquals("Initialisation incorrecte du prix", PRICE, machine.getPrice());
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	public void insertMoneyChangesBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
		assertEquals("La balance n'est pas correctement mise à jour", 10 + 20, machine.getBalance()); // Les montants ont été correctement additionnés               
	}
        
                        @Test
                        //S3: Non impression du ticket si le montant est insufissant
                        public void notPrintTicket(){

                                                   
                        }
                        
                        @Test
                        //S4: Impression du ticket si le montant est sufissant
                        public void PrintTicket(){
                                                
                        }
                        
                        @Test
                        //S5: Décrémentation prix balance
                        public void PrintTicketAndBalance(){
                                                
                        }
                        
                        @Test
                        //S6: Mise a jour du montant collecter lors de l'impression du ticket
                        public void updatePrice(){
                                                
                        }
                        
                        @Test
                        //S7: Rendu monnaie -> est-il correct ?
                        public void renduMonnaie(){
                                                
                        }
                        
                        @Test
                        //S8: remise a zéro de la balance
                        public void initializeBalance(){
                                                
                        }
                        
                        @Test
                        //S9: Pas de montant négatif dans la machine 
                        public void notNegatif(){
                                                
                        }
                        
                        @Test
                        //S10: Pas de machine dont le ticket est négatif
                        public void notNegatifTicket(){
                                                
                        }

    private void assetFalse(boolean printTicket) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
