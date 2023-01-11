/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricketscorecard;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author DELL
 */
public class scoreUpdate {
    String totalbowls=firstInningsJFrame.overFinished.getText();
    String totalbowl[] = totalbowls.split("\\.");
    int totalbo = (Integer.parseInt(totalbowl[0])*6)+Integer.parseInt(totalbowl[1]);
    public scoreUpdate(int run,int bowl){
       String tempRun = String.valueOf(Integer.parseInt(firstInningsJFrame.currentScore.getText())+run);
       firstInningsJFrame.currentScore.setText(tempRun);
       if(bowl==1){
            String tempBowlCount = String.valueOf(((++totalbo)/6+"."+(totalbo%6)));
            firstInningsJFrame.overFinished.setText(String.valueOf(tempBowlCount));
       }
       Float curRR = (Float.parseFloat(tempRun)/Float.parseFloat(String.valueOf(totalbo)))*6;
       firstInningsJFrame.curRunRate.setText(String.valueOf(curRR));
       Float newtemp = (curRR)*teamsName.getOvers();
       String tempPS = String.valueOf(newtemp);
       firstInningsJFrame.projScore.setText(tempPS);
       if(Float.parseFloat(firstInningsJFrame.overFinished.getText())==Float.parseFloat(firstInningsJFrame.totalOvers.getText())){
//          Call Second innings frame From here!!!!!! 
          
            try{
                Class.forName("oracle.jdbc.OracleDriver");
                java.sql.Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
                String PlayerName,TeamName;
                PlayerName = firstInningsJFrame.curBat1.getText();
                int PlayerRuns = Integer.parseInt(firstInningsJFrame.curBat1Runs.getText());
                int PlayerBalls = Integer.parseInt(firstInningsJFrame.curBat1Bowls.getText());
                int PlayerFours = Integer.parseInt(firstInningsJFrame.curBat1fours.getText());
                int PlayerSixs =  Integer.parseInt(firstInningsJFrame.curBat1sixs.getText());
                float PlayerStrikerate = Float.parseFloat(firstInningsJFrame.curBat1StrikeRate.getText());
                TeamName = matchTossJFrame.team1;
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
            
            }
            catch(Exception e){
                System.out.println(e);
                e.printStackTrace();
            }
        
            try{
                Class.forName("oracle.jdbc.OracleDriver");
                java.sql.Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
                String PlayerName,TeamName;
                PlayerName = firstInningsJFrame.curBat2.getText();
                int PlayerRuns = Integer.parseInt(firstInningsJFrame.curBat2Runs.getText());
                int PlayerBalls = Integer.parseInt(firstInningsJFrame.curBat2Bowls.getText());
                int PlayerFours = Integer.parseInt(firstInningsJFrame.curBat2Fours.getText());
                int PlayerSixs =  Integer.parseInt(firstInningsJFrame.curBat2Sixs.getText());
                float PlayerStrikerate = Float.parseFloat(firstInningsJFrame.curBat2StrikeRate.getText());
                TeamName = matchTossJFrame.team1;
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
               
            }
            catch(Exception e){
                System.out.println(e);
                e.printStackTrace();
            }
            System.out.println("Innings ended!!!!!");
            secondInnings newFrame = new secondInnings();
            newFrame.show();
        }
    }
}
     