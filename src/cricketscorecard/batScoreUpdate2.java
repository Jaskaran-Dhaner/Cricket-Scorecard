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
public class batScoreUpdate2 {
    
     public batScoreUpdate2(boolean StrikePlayer,int runs){
        try{
                Class.forName("oracle.jdbc.OracleDriver");
                java.sql.Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
                String PlayerName,TeamName;
                PlayerName = secondInnings.curBat1.getText();
                int PlayerRuns = Integer.parseInt(secondInnings.curBat1Runs.getText());
                int PlayerBalls = Integer.parseInt(secondInnings.curBat1Bowls.getText());
                int PlayerFours = Integer.parseInt(secondInnings.curBat1fours.getText());
                int PlayerSixs =  Integer.parseInt(secondInnings.curBat1sixs.getText());
                float PlayerStrikerate = Float.parseFloat(secondInnings.curBat1StrikeRate.getText());
                TeamName = matchTossJFrame.team2;
                System.out.println(TeamName);
                
                String BatStatQuery  = "UPDATE $tablename SET PlayerRuns=? ,PlayerBalls =? ,PlayerFours=? ,PlayerSixs=? ,PlayerStrikerate=? WHERE PlayerName = '$PlayerName'";
                String Finalquery = BatStatQuery.replace("$tablename",TeamName);
                Finalquery = Finalquery.replace("$PlayerName",PlayerName);
                PreparedStatement batstat = cn.prepareStatement(Finalquery);
                batstat.setInt(1,PlayerRuns);
                batstat.setInt(2,PlayerBalls);
                batstat.setInt(3,PlayerFours);
                batstat.setInt(4,PlayerSixs);
                batstat.setFloat(5,PlayerStrikerate);
                batstat.executeQuery();
                cn.close();
            
            }
            catch(Exception e){
                System.out.println(e);
                e.printStackTrace();
            }
        
            try{
                Class.forName("oracle.jdbc.OracleDriver");
                java.sql.Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
                String PlayerName,TeamName;
                PlayerName = secondInnings.curBat2.getText();
                int PlayerRuns = Integer.parseInt(secondInnings.curBat2Runs.getText());
                int PlayerBalls = Integer.parseInt(secondInnings.curBat2Bowls.getText());
                int PlayerFours = Integer.parseInt(secondInnings.curBat2Fours.getText());
                int PlayerSixs =  Integer.parseInt(secondInnings.curBat2Sixs.getText());
                float PlayerStrikerate = Float.parseFloat(secondInnings.curBat2StrikeRate.getText());
                TeamName = matchTossJFrame.team2;
                System.out.println(TeamName);
                
                String BatStatQuery  = "UPDATE $tableName SET PlayerRuns=? ,PlayerBalls =? ,PlayerFours=? ,PlayerSixs=? ,PlayerStrikerate=? WHERE PlayerName = '$PlayerName'";
                
                String FinalQuery = BatStatQuery.replace("$tableName",TeamName);
                FinalQuery = FinalQuery.replace("$PlayerName",PlayerName);
                PreparedStatement batstat = cn.prepareStatement(FinalQuery);
                batstat.setInt(1,PlayerRuns);
                batstat.setInt(2,PlayerBalls);
                batstat.setInt(3,PlayerFours);
                batstat.setInt(4,PlayerSixs);
                batstat.setFloat(5,PlayerStrikerate);
                batstat.executeQuery();
               cn.close();
            }
            catch(Exception e){
                System.out.println(e);
                e.printStackTrace();
            }
        if(StrikePlayer){
            secondInnings.curBat1Runs.setText(String.valueOf(Integer.parseInt(secondInnings.curBat1Runs.getText())+runs));
            secondInnings.curBat1Bowls.setText(String.valueOf(Integer.parseInt(secondInnings.curBat1Bowls.getText())+1));
            if(runs==4){
                secondInnings.curBat1fours.setText(String.valueOf(Integer.parseInt(secondInnings.curBat1fours.getText())+1));
            }
            if(runs==6){
                secondInnings.curBat1sixs.setText(String.valueOf(Integer.parseInt(secondInnings.curBat1sixs.getText())+1));
            }
            secondInnings.curBat1StrikeRate.setText(String.valueOf(((Float.parseFloat(secondInnings.curBat1Runs.getText()))/Float.parseFloat(secondInnings.curBat1Bowls.getText()))*100));
            
        }
        else{
            secondInnings.curBat2Runs.setText(String.valueOf(Integer.parseInt(secondInnings.curBat2Runs.getText())+runs));
            secondInnings.curBat2Bowls.setText(String.valueOf(Integer.parseInt(secondInnings.curBat2Bowls.getText())+1));
            if(runs==4){
                secondInnings.curBat2Fours.setText(String.valueOf(Integer.parseInt(secondInnings.curBat2Fours.getText())+1));
            }
            if(runs==6){
                secondInnings.curBat2Sixs.setText(String.valueOf(Integer.parseInt(secondInnings.curBat2Sixs.getText())+1));
            }
            secondInnings.curBat2StrikeRate.setText(String.valueOf(((Float.parseFloat(secondInnings.curBat2Runs.getText()))/Float.parseFloat(secondInnings.curBat2Bowls.getText()))*100));
            
        }
    }
    
}
