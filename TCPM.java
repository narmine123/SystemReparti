
import java.io.*;
import java.net.*;

public class TCPM {
    public static void main(String[] args) throws Exception {
        String sentence;
        String modifiedSentence;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Enter a message to send to the server:");
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n');
        modifiedSentence = inFromServer.readLine();

        System.out.println("From Server: " + modifiedSentence);

        clientSocket.close();
    }
}

/*
 * Avec cette modification, lorsque vous exécutez le client, il affichera
 * "Enter a message to send to the server:" dans la console, ce qui indiquera à
 * l'utilisateur qu'il doit saisir un message.
 * Une fois que l'utilisateur a saisi un message et appuyé sur Entrée,
 * le client envoie le message au serveur et affiche la réponse du serveur.
 */