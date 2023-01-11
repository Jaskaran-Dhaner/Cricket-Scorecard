/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricketscorecard;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author sai
 */
public class scoreUpdate2 {
    static String matchResult;
    String totalbowls=secondInnings.overFinished.getText();
    String totalbowl[] = totalbowls.split("\\.");
    int totalbo = (Integer.parseInt(totalbowl[0])*6)+Integer.parseInt(totalbowl[1]);
    public scoreUpdate2(int run,int bowl){
       String tempRun = String.valueOf(Integer.parseInt(secondInnings.currentScore.getText())+run);
       secondInnings.currentScore.setText(tempRun);
       if(bowl==1){
            String tempBowlCount = String.valueOf(((++totalbo)/6+"."+(totalbo%6)));
            secondInnings.overFinished.setText(String.valueOf(tempBowlCount));
       }
       Float curRR = (Float.parseFloat(tempRun)/Float.parseFloat(String.valueOf(totalbo)))*6;
       secondInnings.curRunRate.setText(String.valueOf(curRR));
       Float RunsRemn = Float.parseFloat(secondInnings.targetScore.getText())-Float.parseFloat(tempRun);
       Float BowlsRemn = (Float.parseFloat(secondInnings.totalOvers.getText())*6)-Float.parseFloat(String.valueOf(totalbo));
       Float newtemp = (RunsRemn/BowlsRemn)*6;
       String tempPS = String.valueOf(newtemp);
       secondInnings.ReqRunRate.setText(tempPS);
       int tempt = Integer.parseInt(secondInnings.totalOvers.getText())*6;
       if(totalbo== tempt){
           int prnt = (Integer.parseInt(firstInningsJFrame.currentScore.getText()))-(Integer.parseInt(secondInnings.currentScore.getText()));
           matchResult = "Match Won By:"+firstInningsJFrame.battingTeamName.getText()+" by "+prnt+" runs.";
           JOptionPane.showMessageDialog(secondInnings.seocndInnings,matchResult);
           result obj = new result();
           obj.show();
       }
       if(Integer.parseInt(secondInnings.targetScore.getText())<(Integer.parseInt(secondInnings.currentScore.getText()))){
           System.out.println();
           matchResult = "Match Won By :"+secondInnings.battingTeamName.getText()+"by"+(Integer.parseInt(secondInnings.totalwickets.getText())-10)+"wickets";
           JOptionPane.showMessageDialog(secondInnings.seocndInnings,matchResult);
           try{
                String TeamName = matchTossJFrame.team2;
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
                result obj = new result();
                obj.show();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
