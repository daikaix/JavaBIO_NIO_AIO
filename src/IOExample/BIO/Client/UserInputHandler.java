package IOExample.BIO.Client;

import java.io.*;

public class UserInputHandler implements Runnable{
    private ChatClient chatClient;

    public UserInputHandler(ChatClient chatClient){
        this.chatClient = chatClient;
    }


    @Override
    public void run() {
        try {
            BufferedReader consoleReader = new BufferedReader(
                    new InputStreamReader(System.in)
            );
            while (true){
                String input = consoleReader.readLine();
                chatClient.send(input);
                if (chatClient.readyToQuit(input)){
                    break;
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            chatClient.close();
        }
    }
}
