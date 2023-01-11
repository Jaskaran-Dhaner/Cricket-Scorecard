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
public class BatsmenOut {
    static void BatsmenOut(boolean StrikePlayer){
        if(StrikePlayer){
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
            firstInningsJFrame.curBat1Bowls.setText("0");
            firstInningsJFrame.curBat1Runs.setText("0");
            firstInningsJFrame.curBat1fours.setText("0");
            firstInningsJFrame.curBat1sixs.setText("0");
            firstInningsJFrame.curBat1StrikeRate.setText("0.0");
            firstInningsJFrame.curBat1.setText("- - -");
            newBatsmen obj = new newBatsmen();
            obj.show();
        }else{
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
               
            }
            catch(Exception e){
                System.out.println(e);
                e.printStackTrace();
            }
            firstInningsJFrame.curBat2Bowls.setText("0");
            firstInningsJFrame.curBat2Runs.setText("0");
            firstInningsJFrame.curBat2Fours.setText("0");
            firstInningsJFrame.curBat2Sixs.setText("0");
            firstInningsJFrame.curBat2StrikeRate.setText("0.0");
            firstInningsJFrame.curBat2.setText("- - -");
            newBatsmen obj = new newBatsmen();
            obj.show();
        }
    } 
}
