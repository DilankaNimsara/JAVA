/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesmanagement;

/**
 *
 * @author Dilanka Nimsara
 */
public class Member {

    String Name;
    int id;

    public Member() {
        Socity s1= new Socity();
    }

    void print(){
        System.out.println(Name);
        System.out.println(id);
    }
    
}

class SeniorMember{
    
}

class Socity{
    String Name;
    float MemberShipFee;
    int jid;
    int sid;
    
    String juniors[];
    String seniors[];
}




















