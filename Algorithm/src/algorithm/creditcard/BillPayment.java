/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.creditcard;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Tesfay
 */
public class BillPayment {
    
   static class Bill{
        
        int creditCardNum;
        int amountDue;
        String name;
        String address;

        private Bill(int i, int i0, String a, String a1) {
            this.creditCardNum = i;
            this.amountDue = i0;
            this.name = a;
            this.address = a1;
        }

        @Override
        public String toString() {
            return "Bill{" + "creditCardNum=" + creditCardNum + ", amountDue=" + amountDue + ", name=" + name + ", address=" + address + '}';
        }
    }
    
    static class Payment{
        int creditCardNum;
        int amountPaid;
        String name;

        private Payment(int i, int i0, String a) {
            this.creditCardNum = i;
            this.amountPaid = i0;
            this.name = a;
        }
    }
    
    static class UnPaidBill extends Bill{    
        int amountPaid;

        public UnPaidBill(int i, int i0, String a, String a1, int ap) {
            super(i, i0, a, a1);
            this.amountPaid = ap;
        }

        @Override
        public String toString() {
            return "UnPaidBill{" + "amountPaid=" + amountPaid + '}' + super.toString();
        }
    }
    
    public static void main(String[] args){
    
        LinkedList<Bill> bills = new LinkedList<>();
        LinkedList<Payment> payments = new LinkedList<>();
        
        bills.add(new Bill(1234, 12, "A", "A1"));
        bills.add(new Bill(1235, 13, "B", "B1"));
        bills.add(new Bill(1236, 14, "C", "C1"));
        bills.add(new Bill(1237, 15, "D", "D1"));
        
        payments.add(new Payment(1234, 12, "A"));
        payments.add(new Payment(1235, 10, "B"));
        payments.add(new Payment(1236, 14, "C"));
        payments.add(new Payment(1237, 10, "D"));       
        
       findUnPaidBills(bills, payments).stream().forEach(x -> System.out.println(x.toString()));
    }
    
   public static LinkedList<UnPaidBill> findUnPaidBills(LinkedList<Bill> bills, LinkedList<Payment> payments) {
      LinkedList<UnPaidBill> unPaidBills = new LinkedList<>();
      Iterator<Bill> itrB = bills.iterator();
        while(itrB.hasNext()){
            Bill b = itrB.next();
            Iterator<Payment> itrP = payments.iterator();
            while(itrP.hasNext()){
                Payment p = itrP.next();
                if(p.creditCardNum == b.creditCardNum && p.amountPaid < b.amountDue){
                    unPaidBills.add(new UnPaidBill(b.creditCardNum, b.amountDue, b.name, b.address, p.amountPaid));
                }
            }
        }
        return unPaidBills;
    }

}
