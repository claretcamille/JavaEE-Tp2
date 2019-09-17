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

                                                 // Insertion prix necessaire
                                                machine.insertMoney(30); // Ici on peut utiliser Price - nbr avec nbr >= 1 pour etre sur que si on change la valeur price le test continu a changer
                                                // Verification que les montants sont differents :
                                               assertNotSame( machine.getBalance(),machine.getPrice());
                                               //Test de la non impression du ticket : 
                                               assetFalse(machine.printTicket());  
                        }
                        
                        @Test
                        //S4: Impression du ticket si le montant est sufissant
                        public void PrintTicket(){
                                                 // Insertion prix necessaire => val PRICE
                                                machine.insertMoney(PRICE);
                                                // Verification que les montants sont differents :
                                               assertNotSame( machine.getBalance(),machine.getPrice());
                                               //Test de la non impression du ticket : 
                                               assetTrue(machine.printTicket());
                        }
                        
                        @Test
                        //S5: Décrémentation prix balance
                        public void PrintTicketAndBalance(){
                            
                                                // Insertion d'un montant supperrieur 
                                                machine.insertMoney(PRICE+1);
                                                // Impression du ticket
                                                machine.printTicket();
                                                // Vérification de la décrementation 
                                                assertEquals(1,machine.getBalance()); // Il reste 1 euro
                        }
                        
                        @Test
                        //S6: Mise a jour du montant collecter lors de l'impression du ticket
                        public void updatePrice(){
                            
                                                // Mise en place d'un ticket
                                                machine.insertMoney(PRICE);
                                                machine.printTicket();
                                                // Vérification du montant collecter
                                                assertEquals(PRICE, machine.getTotal());
                                                
                                                // Si plusieur montant collecter
                                                machine.printTicket();
                                                machine.printTicket();
                                                assertEquals(PRICE*3, machine.getTotal()); // 3 tickets imprimer ==> le total est de 3 fois le prix du ticket 
                                                
                        }
                        
                        @Test
                        //S7: Rendu monnaie -> est-il correct ?
                        public void renduMonnaie(){
                                                // Si machine vide on rend 0
                                                assertEquals(0, machine.refund());
                                                //  veriffication rendu si machine non vide
                                                machine.insertMoney(PRICE);
                                                assertEquals(PRICE, machine.refund());
                                                
                        }
                        
                        @Test
                        //S8: remise a zéro de la balance
                        public void initializeBalance(){
                                                
                                                // Insertion de la monnaie -> on est sur que la balance est donc différente de 0
                                                machine.insertMoney(PRICE);
                                                // Remise a zéro de la balance 
                                                 machine.refund();
                                                 assertEquals(0, machine.getBalance());
                        }
                        
                        @Test
                        //S9: Pas de montant négatif dans la machine 
                        public void notNegatif(){
                                               try{
                                                             // Insertion montant négatif:
                                                            machine.insertMoney(-1);
                                               } catch (IllegalArgumentException e) {
                                                            assertEquals(0,machine.getBalance()); // Aucun ajout n'est fait dans la machine ==> 0
                                               }
                                                
                        }
                        
                        @Test
                        //S10: Pas de machine dont le ticket est négatif
                        public void notNegatifTicket(){
                                                try{
                                                           machine =  new TicketMachine(-1);
                                                } catch (IllegalArgumentException e) {
                                                             assertEquals(PRICE,machine.getPrice());  // On vérifie que la machine n'a pa pu changer
                                               }
                        }

}
