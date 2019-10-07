

import java.util.ArrayList;
import java.util.Collections;

public class BankAccount implements Comparable<BankAccount>, Measurable {
    private float balance;
    private float rate;

    public BankAccount(float balance, float rate){
        this.balance = balance;
        this.rate = rate;
    }

    public BankAccount(float rate){
        this.balance = 0;
        this.rate = rate;
    }

    public BankAccount(){
        this.balance = 0;
        this.rate = .1f;
    }


    public void processYear(){
        float interest = this.balance * this.rate;
        this.balance = this.balance + interest;
    }

    public void processNYears(int n){

        for (int i = 0; i < n; i++) {
            processYear();
        }
    }

    public void add(float amount){
        this.balance += amount;
    }

    public void subtract(float amount){
        this.balance -= amount;
    }

    @Override
    public int compareTo(BankAccount other) {
        if(balance < other.balance) return -1;
        if(balance > other.balance) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return ""+ balance;
    }

    @Override
    public float getMeasure() {
        return balance;
    }

    public static void main(String [] args) {

        BankAccount account = new BankAccount(1000, .1f);
        BankAccount account2 = new BankAccount(.2f);
        BankAccount account3 = new BankAccount(300, .3f);

        account.processNYears(2);

        account2.add(200);
        account2.processNYears(2);
//
        System.out.println("balance after two years is: " + account.balance);
        System.out.println("Balance in account 2 is : " + account2.balance);
        System.out.println("Balance in account 3 is : " + account3.balance);
//        account3.add(200);
//        account2.subtract(100);
//        System.out.println("New balance in 3 is: " + account3.balance);
//        System.out.println("New balance in 2 is: " + account2.balance);

        int num = account.compareTo(account2);
        System.out.println(num);

        ArrayList<BankAccount> list = new ArrayList<>();
        list.add(account);
        list.add(account2);
        list.add(account3);

        Collections.sort(list);
        System.out.println(list);

//        Measurable[] accounts = new Measurable[3];
//        accounts[0] = account;
//        accounts[1] = account2;
//        accounts[2] = account3;

        ArrayList<Measurable> measList = new ArrayList<>(list);
//        measList.add(account);
//        measList.add(account2);
//        measList.add(account3);


        System.out.println(Measurable.average(list));

    }

}