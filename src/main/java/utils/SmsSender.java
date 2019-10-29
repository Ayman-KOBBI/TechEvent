/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsSender {
     public static final String ACCOUNT_SID = "AC05697af2ed6364b451b305057a489d4d";
  public static final String AUTH_TOKEN = "8525b65b01da4339a55f5f7e6d6abdf8";

    public static void sendSms(){
  // Find your Account Sid and Token at twilio.com/user/account
 


    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber("+21629288735"),
        new PhoneNumber("+15715123868"), 
        "Votre Evenement Accepter verifier là").create();

    System.out.println(message.getSid());
  }
}

