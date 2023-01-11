/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricketscorecard;

import java.sql.*;

/**
 *
 * @author sai
 */
public class BowlerStatUpdate {
    String totalbowls= String.valueOf(Float.parseFloat(firstInningsJFrame.curBowlerOver.getText()));
    String totalbowl[] = totalbowls.split("\\.");
    int totalbo = (Integer.parseInt(totalbowl[0])*6)+Integer.parseInt(totalbowl[1]);
    public BowlerStatUpdate(boolean legdel,int runs,boolean wicket){
        if(legdel){
            if(runs>=1){
                firstInningsJFrame.CurrentOverRun= false;
            }
            firstInningsJFrame.bowlcount++;
            String tempBowlCount = String.valueOf(((++totalbo)/6+"."+(totalbo%6)));
            firstInningsJFrame.curBowlerOver.setText(String.valueOf(Float.parseFloat(tempBowlCount)));
        }
        firstInningsJFrame.curBowlerRun.setText(String.valueOf((Integer.parseInt(firstInningsJFrame.curBowlerRun.getText()))+runs));
        if(wicket){
        firstInningsJFrame.curBowlerWickets.setText(String.valueOf((Integer.parseInt(firstInningsJFrame.curBowlerWickets.getText())+1)));
        }
        firstInningsJFrame.curBowlerEconomy.setText(String.valueOf(((Float.parseFloat(firstInningsJFrame.curBowlerRun.getText()))/totalbo)*6));
        System.out.println(runs);
        if(firstInningsJFrame.bowlcount==6){
            if(firstInningsJFrame.StrikePlayer){
                firstInningsJFrame.StrikePlayer=false;
            }else{
                firstInningsJFrame.StrikePlayer=true;
            }
            try{
                String TeamName = matchTossJFrame.team2;
                String PlayerName = firstInningsJFrame.currentBowler.getText();
                float PlayerOvers = Float.parseFloat(firstInningsJFrame.curBowlerOver.getText());
                int PlayerBRuns = Integer.parseInt(firstInningsJFrame.curBowlerRun.getText());
                int PlayerMaiden = Integer.parseInt(firstInningsJFrame.curBowlerMaidens.getText());
                if(firstInningsJFrame.CurrentOverRun){
                    PlayerMaiden++;
                    firstInningsJFrame.curBowlerMaidens.setText(String.valueOf(PlayerMaiden));
                    System.out.println(firstInningsJFrame.CurrentOverRun);
                }
                int PlayerWicket = Integer.parseInt(firstInningsJFrame.curBowlerWickets.getText());
                float PlayerEconomy = Float.parseFloat(firstInningsJFrame.curBowlerEconomy.getText());
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
                firstInningsJFrame.bowlcount= 0;
                
            }catch(Exception e){
                e.printStackTrace();
            }
            int tempf = totalbo;
            int tempt = Integer.parseInt(firstInningsJFrame.totalOvers.getText())*6;
            if(tempf != tempt){
            selectBowler obj = new selectBowler();
            obj.show();
            }
        }
    }
}
