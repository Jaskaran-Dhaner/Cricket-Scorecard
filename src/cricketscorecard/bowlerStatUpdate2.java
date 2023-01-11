/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricketscorecard;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author sai
 */
public class bowlerStatUpdate2 {
    String totalbowls= String.valueOf(Float.parseFloat(secondInnings.curBowlerOver.getText()));
    String totalbowl[] = totalbowls.split("\\.");
    int totalbo = (Integer.parseInt(totalbowl[0])*6)+Integer.parseInt(totalbowl[1]);
    public bowlerStatUpdate2(boolean legdel,int runs,boolean wicket){
        if(legdel){
            if(runs>=1){
                secondInnings.CurrentOverRun=false;
            }
            secondInnings.bowlcount++;
            String tempBowlCount = String.valueOf(((++totalbo)/6+"."+(totalbo%6)));
            secondInnings.curBowlerOver.setText(String.valueOf(Float.parseFloat(tempBowlCount)));
        }
        secondInnings.curBowlerRun.setText(String.valueOf((Integer.parseInt(secondInnings.curBowlerRun.getText()))+runs));
        if(wicket){
        secondInnings.curBowlerWickets.setText(String.valueOf((Integer.parseInt(secondInnings.curBowlerWickets.getText())+1)));
        }
        secondInnings.curBowlerEconomy.setText(String.valueOf(((Float.parseFloat(secondInnings.curBowlerRun.getText()))/totalbo)*6));
        System.out.println(runs);
        if(secondInnings.bowlcount==6){
            if(secondInnings.StrikePlayer){
                secondInnings.StrikePlayer=false;
            }else{
                secondInnings.StrikePlayer=true;
            }
            try{
                String TeamName = matchTossJFrame.team1;
                String PlayerName = secondInnings.currentBowler.getText();
                float PlayerOvers = Float.parseFloat(secondInnings.curBowlerOver.getText());
                int PlayerBRuns = Integer.parseInt(secondInnings.curBowlerRun.getText());
                int PlayerMaiden = Integer.parseInt(secondInnings.curBowlerMaidens.getText());
                if(secondInnings.CurrentOverRun){
                    PlayerMaiden++;
                    secondInnings.curBowlerMaidens.setText(String.valueOf(PlayerMaiden));
                    System.out.println(secondInnings.CurrentOverRun);
                }
                int PlayerWicket = Integer.parseInt(secondInnings.curBowlerWickets.getText());
                float PlayerEconomy = Float.parseFloat(secondInnings.curBowlerEconomy.getText());
                Class.forName("oracle.jdbc.OracleDriver");
                java.sql.Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
                String query = "UPDATE $tableName SET PlayerOvers=?,PlayerBRuns=?,PlayerMaiden=?,PlayerWickets=?,PlayerEconomy=? WHERE PlayerName='$PlayerName'";
                query = query.replace("$tableName",TeamName);
                query = query.replace("$PlayerName",PlayerName);
                PreparedStatement st = cn.prepareStatement(query);
                st.setFloat(1,PlayerOvers);
                st.setInt(2,PlayerBRuns);
                st.setInt(3,PlayerMaiden);
                st.setInt(4, PlayerWicket);
                st.setFloat(5, PlayerEconomy);
                st.executeQuery();
                secondInnings.bowlcount= 0;
                
            }catch(Exception e){
                e.printStackTrace();
            }
            int tempf = totalbo;
            int tempt = Integer.parseInt(secondInnings.totalOvers.getText())*6;
            if(tempf != tempt){
            selectBowler2 obj = new selectBowler2();
            obj.show();
            }
            
        }
    }
    
}
