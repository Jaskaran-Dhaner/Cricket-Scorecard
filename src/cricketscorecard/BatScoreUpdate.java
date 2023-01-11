/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cricketscorecard;

/**
 *
 * @author sai
 */
public class BatScoreUpdate {
    public BatScoreUpdate(boolean StrikePlayer,int runs){
        if(StrikePlayer){
            firstInningsJFrame.curBat1Runs.setText(String.valueOf(Integer.parseInt(firstInningsJFrame.curBat1Runs.getText())+runs));
            firstInningsJFrame.curBat1Bowls.setText(String.valueOf(Integer.parseInt(firstInningsJFrame.curBat1Bowls.getText())+1));
            if(runs==4){
                firstInningsJFrame.curBat1fours.setText(String.valueOf(Integer.parseInt(firstInningsJFrame.curBat1fours.getText())+1));
            }
            if(runs==6){
                firstInningsJFrame.curBat1sixs.setText(String.valueOf(Integer.parseInt(firstInningsJFrame.curBat1sixs.getText())+1));
            }
            firstInningsJFrame.curBat1StrikeRate.setText(String.valueOf(((Float.parseFloat(firstInningsJFrame.curBat1Runs.getText()))/Float.parseFloat(firstInningsJFrame.curBat1Bowls.getText()))*100));
            
        }
        else{
            firstInningsJFrame.curBat2Runs.setText(String.valueOf(Integer.parseInt(firstInningsJFrame.curBat2Runs.getText())+runs));
            firstInningsJFrame.curBat2Bowls.setText(String.valueOf(Integer.parseInt(firstInningsJFrame.curBat2Bowls.getText())+1));
            if(runs==4){
                firstInningsJFrame.curBat2Fours.setText(String.valueOf(Integer.parseInt(firstInningsJFrame.curBat2Fours.getText())+1));
            }
            if(runs==6){
                firstInningsJFrame.curBat2Sixs.setText(String.valueOf(Integer.parseInt(firstInningsJFrame.curBat2Sixs.getText())+1));
            }
            firstInningsJFrame.curBat2StrikeRate.setText(String.valueOf(((Float.parseFloat(firstInningsJFrame.curBat2Runs.getText()))/Float.parseFloat(firstInningsJFrame.curBat2Bowls.getText()))*100));
            
        }
    }
    
}
